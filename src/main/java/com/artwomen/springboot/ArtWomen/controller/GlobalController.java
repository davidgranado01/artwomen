package com.artwomen.springboot.ArtWomen.controller;

import com.artwomen.springboot.ArtWomen.entity.UserEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpSession;

@ControllerAdvice
public class GlobalController {

    @ModelAttribute
    public void addUserToModel(Model model, HttpSession session) {
        UserEntity usuario = (UserEntity) session.getAttribute("usuarioLogueado");

        if (usuario != null) {
            model.addAttribute("usuarioLogueado", true);
            model.addAttribute("nombreUsuario", usuario.getNombreUsuario()); // o getUsername(), según tu clase
        } else {
            model.addAttribute("usuarioLogueado", false);
        }
    }

}
