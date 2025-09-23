package com.artwomen.springboot.ArtWomen.service;


import com.artwomen.springboot.ArtWomen.entity.RolEntity;
import com.artwomen.springboot.ArtWomen.entity.UserEntity;
import com.artwomen.springboot.ArtWomen.exceptions.EmailExistsException;
import com.artwomen.springboot.ArtWomen.exceptions.UserExistsException;
import com.artwomen.springboot.ArtWomen.repositories.RolRepository;
import com.artwomen.springboot.ArtWomen.repositories.UserRepository;
import java.util.Date;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RolRepository rolRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, RolRepository rolRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.rolRepository = rolRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void createUser(UserEntity user) {

        if (userRepository.findByCorreoUsuario(user.getCorreoUsuario()) != null) {
            throw new EmailExistsException("El correo electrónico ya está en uso.");
        }

        if (userRepository.findByNickUsuario(user.getNickUsuario()) != null) {
            throw new UserExistsException("El nombre de usuario ya está en uso.");
        }

        RolEntity rolNormal = rolRepository.findByNombre("normal");
        if (rolNormal == null) {
            throw new RuntimeException("El rol 'normal' no existe en la base de datos");
        }

        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);

        userEntity.setContrasenhaUsuario(
                passwordEncoder.encode(user.getContrasenhaUsuario())
        );

        userEntity.setRol(rolNormal);
        userEntity.setFechaCreacion(new Date());

        userRepository.save(userEntity);
    }

    public UserEntity iniciarSesion(UserEntity user) {

        UserEntity usuarioExistente = userRepository.findByNickUsuario(user.getNickUsuario());

        if (usuarioExistente == null) {
            throw new UserExistsException("El nombre de usuario no existe. Por favor, escríbalo de nuevo.");
        }

        if (!passwordEncoder.matches(user.getContrasenhaUsuario(), usuarioExistente.getContrasenhaUsuario())) {
            throw new BadCredentialsException("La contraseña es incorrecta. Inténtelo de nuevo.");
        }

        return usuarioExistente;
    }
}