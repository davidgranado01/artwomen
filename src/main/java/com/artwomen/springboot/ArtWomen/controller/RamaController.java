package com.artwomen.springboot.ArtWomen.controller;

import com.artwomen.springboot.ArtWomen.entity.RamaEntity;
import com.artwomen.springboot.ArtWomen.service.RamaService;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RamaController {

    @Autowired
    private RamaService ramaService;

    @GetMapping
    public ResponseEntity<List<RamaEntity>> getAllRamas() {
        return ResponseEntity.ok(ramaService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RamaEntity> getRamaById(@PathVariable UUID id) {
        return ResponseEntity.ok(ramaService.findById(id));
    }

}
