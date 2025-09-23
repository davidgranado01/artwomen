package com.artwomen.springboot.ArtWomen.repositories;

import com.artwomen.springboot.ArtWomen.entity.ArtistaEntity;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistaRepository extends JpaRepository<ArtistaEntity, UUID> {

    ArtistaEntity findByNombreArtista(String nombreArtista);

    ArtistaEntity findByApellidosArtista(String apellidosArtista);

    ArtistaEntity findByNombreArtistaAndApellidosArtista(String nombreArtista, String apellidosArtista);


    List<ArtistaEntity> findByVisibleTrue();

    Optional<ArtistaEntity> findById(UUID id);

}
