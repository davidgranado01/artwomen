package com.artwomen.springboot.ArtWomen.service;

import com.artwomen.springboot.ArtWomen.entity.RamaEntity;
import com.artwomen.springboot.ArtWomen.repositories.RamaRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RamaService {

    @Autowired
    private RamaRepository ramaRepository;

    public List<RamaEntity> listar() {

        return ramaRepository.findAll();
    }

    public RamaEntity findById(UUID id) {
        return ramaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("La rama no encontrada"));
    }

}
