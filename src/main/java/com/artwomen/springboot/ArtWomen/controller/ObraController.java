package com.artwomen.springboot.ArtWomen.controller;

import com.artwomen.springboot.ArtWomen.entity.ObraEntity;
import com.artwomen.springboot.ArtWomen.service.ObraService;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ObraController {

    private ObraService obraService;

    @GetMapping("/obra/{id}")
    public String getObra(@PathVariable UUID id, Model model) {
        Optional<ObraEntity> obraOpt = Optional.ofNullable(obraService.findById(id));
        if (obraOpt.isPresent()) {
            ObraEntity obra = obraOpt.get();
            model.addAttribute("obra", obra);
            model.addAttribute("rama", obra.getRama());
            model.addAttribute("artista", obra.getArtista());
            return "obra"; 
        }
        return "error/404";
    }

}
