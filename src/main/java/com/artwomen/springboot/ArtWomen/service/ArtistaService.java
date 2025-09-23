package com.artwomen.springboot.ArtWomen.service;

import com.artwomen.springboot.ArtWomen.entity.ArtistaEntity;
import com.artwomen.springboot.ArtWomen.repositories.ArtistaRepository;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class ArtistaService {

    private final ArtistaRepository artistaRepository;

    public ArtistaService(ArtistaRepository artistaRepository) {
        this.artistaRepository = artistaRepository;
    }

    public List<ArtistaEntity> encontrarArtistas() {
        return artistaRepository.findByVisibleTrue();
    }

    public ArtistaEntity buscarPorNombreCompleto(String nombreCompleto) {
        String[] partes = nombreCompleto.split("_");
        if (partes.length < 2) return null;

        String nombre = partes[0];
        String apellidos = String.join(" ", Arrays.copyOfRange(partes, 1, partes.length));
        return artistaRepository.findByNombreArtistaAndApellidosArtista(nombre, apellidos);
    }
}
