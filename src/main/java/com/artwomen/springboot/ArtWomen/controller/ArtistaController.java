package com.artwomen.springboot.ArtWomen.controller;

import com.artwomen.springboot.ArtWomen.entity.ArtistaEntity;
import com.artwomen.springboot.ArtWomen.service.ArtistaService;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ArtistaController {

    @Autowired
    private ArtistaService artistaService;

    @GetMapping("/artistas")
    public String mostrarArtistas(Model model) {
        List<ArtistaEntity> artistas = artistaService.encontrarArtistas();
        System.out.println("Artistas encontrados: " + artistas.size());
        model.addAttribute("artistas", artistas);
        return "artistas";
    }

    @GetMapping("/artista/{nombreCompleto}")
    public String mostrarDetalleArtista(@PathVariable String nombreCompleto, Model model) {
        ArtistaEntity artista = artistaService.buscarPorNombreCompleto(nombreCompleto);

        if (artista == null) {
            return "redirect:/artistas";
        }

        model.addAttribute("artista", artista);
        return "artista"; // nombre del HTML en templates/
    }


}
