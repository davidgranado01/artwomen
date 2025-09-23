package com.artwomen.springboot.ArtWomen.component;

import com.artwomen.springboot.ArtWomen.entity.RamaEntity;
import com.artwomen.springboot.ArtWomen.entity.RolEntity;
import com.artwomen.springboot.ArtWomen.entity.UserEntity;
import com.artwomen.springboot.ArtWomen.repositories.RamaRepository;
import com.artwomen.springboot.ArtWomen.repositories.RolRepository;
import com.artwomen.springboot.ArtWomen.repositories.UserRepository;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader {

    private final UserRepository userRepository;
    private final RolRepository rolRepository;
    private final PasswordEncoder passwordEncoder;

    private final RamaRepository ramaRepository;

    public DataLoader(UserRepository userRepository, RolRepository rolRepository, PasswordEncoder passwordEncoder, RamaRepository ramaRepository) {
        this.userRepository = userRepository;
        this.rolRepository = rolRepository;
        this.passwordEncoder = passwordEncoder;
        this.ramaRepository = ramaRepository;
    }

    @PostConstruct
    public void init() {

        if (rolRepository.count() == 0) {
            // Crear los objetos de rol
            RolEntity rolNormal = new RolEntity("normal", "Usuario registrado con los privilegios básicos de creación");
            RolEntity rolMecenas = new RolEntity("mecenas", "Usuario que además tiene los privilegios de edición");
            RolEntity rolAdmin = new RolEntity("administrador",
                    "Usuario que tiene todos los privilegios: creación, edición y borrado de datos");
            RolEntity rolSuperAdmin = new RolEntity("superadmin",
                    "Usuario que tiene todos los privilegios: creación, edición, borrado y eliminación de privilegios");

            // Crear la lista con los roles
            List<RolEntity> listaRoles = Arrays.asList(rolNormal, rolMecenas, rolAdmin, rolSuperAdmin);

            // Guardar todos los roles usando el repositorio
            rolRepository.saveAll(listaRoles);
        }

        RolEntity rolSuperadmin = rolRepository.findByNombre("superadmin");



        if (userRepository.count() == 0) {

            if (rolSuperadmin == null) {
                throw new RuntimeException("No se encontró el rol 'superadmin'");
            }

            UserEntity superadmin = new UserEntity("Admin", "Admin", "admin", passwordEncoder.encode("1234"),
                    "admin@admin.com", new Date());
            superadmin.setRol(rolSuperadmin);
            userRepository.save(superadmin);
        } else {
            System.out.println("Ya existen usuarios, no se crea el superadmin.");
        }

        if (ramaRepository.count() == 0) {
            RamaEntity pintura = new RamaEntity("Pintura");
            RamaEntity escultura = new RamaEntity("Escultura");
            RamaEntity arquitectura = new RamaEntity("Arquitectura");
            RamaEntity literatura = new RamaEntity("Literatura");
            RamaEntity musica = new RamaEntity("Música");

            List<RamaEntity> listaRamas = Arrays.asList(pintura, escultura, arquitectura, literatura, musica);

            ramaRepository.saveAll(listaRamas);
        }
    }

}
