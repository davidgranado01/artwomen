package com.artwomen.springboot.ArtWomen.controller;

import com.artwomen.springboot.ArtWomen.entity.RolEntity;
import com.artwomen.springboot.ArtWomen.service.RolService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RolController {

    @Autowired
    private RolService rolService;

    @GetMapping("/listaRoles")
    public List<RolEntity> gettAllRoles() {

        return rolService.listar();
    }

}
