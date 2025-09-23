package com.artwomen.springboot.ArtWomen.repositories;

import com.artwomen.springboot.ArtWomen.entity.UserEntity;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {

    UserEntity findByNickUsuario(String nickUsuario);

    UserEntity findByCorreoUsuario(String correoUsuario);

    Optional<UserEntity> findById(UUID id);

}
