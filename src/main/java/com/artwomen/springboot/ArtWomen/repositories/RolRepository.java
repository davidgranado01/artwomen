package com.artwomen.springboot.ArtWomen.repositories;

import com.artwomen.springboot.ArtWomen.entity.RolEntity;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository  extends JpaRepository<RolEntity, UUID> {

    Optional<RolEntity> findById(UUID id);

    RolEntity findByNombre(String nombre);
}
