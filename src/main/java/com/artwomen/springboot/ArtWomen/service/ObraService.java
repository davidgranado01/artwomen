package com.artwomen.springboot.ArtWomen.service;

import com.artwomen.springboot.ArtWomen.entity.ObraEntity;
import com.artwomen.springboot.ArtWomen.repositories.ObraRepository;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ObraService {

    private final ObraRepository obraRepository;


    public ObraService(ObraRepository obraRepository) {
        this.obraRepository = obraRepository;
    }

    public List<ObraEntity> findAll() {
        return obraRepository.findAll();
    }

    public ObraEntity findById(UUID id) {
        return obraRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Obra no encontrada"));
    }
}
