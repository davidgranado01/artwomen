package com.artwomen.springboot.ArtWomen.repositories;

import com.artwomen.springboot.ArtWomen.entity.ObraEntity;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ObraRepository extends JpaRepository<ObraEntity, UUID> {

    Optional<ObraEntity> findById(UUID id);

    @Query("SELECT o.rama.nombreRama FROM ObraEntity o WHERE o.id = :obraId")
    String findRamaNombreByObraId(@Param("obraId") UUID obraId);

}
