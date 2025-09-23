package com.artwomen.springboot.ArtWomen.service;

import com.artwomen.springboot.ArtWomen.entity.RolEntity;
import com.artwomen.springboot.ArtWomen.repositories.RolRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolService {

    @Autowired
    private RolRepository rolRepository;

    public List<RolEntity> listar() {

        return rolRepository.findAll();
    }

}
