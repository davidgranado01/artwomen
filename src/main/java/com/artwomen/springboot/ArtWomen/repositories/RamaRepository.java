package com.artwomen.springboot.ArtWomen.repositories;

import com.artwomen.springboot.ArtWomen.entity.RamaEntity;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RamaRepository extends JpaRepository<RamaEntity, UUID> {

    RamaEntity findByNombreRama(String nombreRama);

    Optional<RamaEntity> findById(UUID id);

}
