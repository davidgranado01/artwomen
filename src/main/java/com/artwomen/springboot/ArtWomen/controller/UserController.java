package com.artwomen.springboot.ArtWomen.controller;

import com.artwomen.springboot.ArtWomen.entity.UserEntity;
import com.artwomen.springboot.ArtWomen.service.UserService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/crear-cuenta")
    public String crearUsuario(@ModelAttribute UserEntity user, RedirectAttributes redirectAttrs) {
        try {
            userService.createUser(user);
            redirectAttrs.addFlashAttribute("success", "Usuario creado con éxito.");
            return "redirect:/cuenta.html";  // o a donde quieras después del registro
        } catch (Exception e) {
            e.printStackTrace();
            redirectAttrs.addFlashAttribute("error", "Error al crear usuario");
            return "redirect:/crear-cuenta.html";
        }
    }

    @PostMapping("/acceso-cuenta")
    public String accesoCuenta (@ModelAttribute UserEntity user, RedirectAttributes redirectAttrs, HttpSession session) {
        try {
            UserEntity usuarioValidado = userService.iniciarSesion(user); // obtenemos el usuario real
            session.setAttribute("usuarioLogueado", usuarioValidado); // guardamos el real, no el del formulario
            redirectAttrs.addFlashAttribute("success", "Usuario logueado con éxito.");
            return "redirect:/";
        } catch (Exception e) {
            e.printStackTrace();
            redirectAttrs.addFlashAttribute("error", "Error al iniciar sesión");
            return "redirect:/cuenta";
        }
    }

    @GetMapping("/current")
    public ResponseEntity<UserEntity> getCurrentUser(HttpSession session) {
        UserEntity usuario = (UserEntity) session.getAttribute("usuarioLogueado");
        if (usuario != null) {
            UserEntity userEntity = new UserEntity();
            BeanUtils.copyProperties(usuario, userEntity);
            return ResponseEntity.ok(userEntity);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @GetMapping("/cuenta")
    public String mostrarLogin(HttpSession session, Model model) {
        UserEntity usuario = (UserEntity) session.getAttribute("usuarioLogueado");
        boolean usuarioLogueado = usuario != null;
        model.addAttribute("usuarioLogueado", usuarioLogueado);
        model.addAttribute("nombreUsuario", usuarioLogueado ? usuario.getNickUsuario() : "");
        return "cuenta";  // nombre de tu template cuenta.html
    }

    @GetMapping("/cerrar-sesion")
    public String cerrarSesion(HttpSession session) {
        session.invalidate();  // Destruye la sesión
        return "redirect:/";  // Redirige a la página principal (ajusta la URL)
    }
}
