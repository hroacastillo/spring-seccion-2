package com.hroac.springbootweb.controller;

import com.hroac.springbootweb.model.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/app")
public class IndexController {

    @Value("${texto.indexcontroller.index.titulo}")
    private String textoIndex;

    @Value("${texto.indexcontroller.perfil.titulo}")
    private String textoPerfil;

    @Value("${texto.indexcontroller.listar.titulo}")
    private String textoListar;

    @GetMapping(value = {"/index", "/", "/home"})
    public String index(Model model) {

        model.addAttribute("tituloIndex", textoIndex);

        return "index";
    }

    @GetMapping(value = "/perfil")
    public String perfil(Model model) {
        Usuario usuario = new Usuario();
        usuario.setNombre("Hector");
        usuario.setApellido("Roa");

        model.addAttribute("tituloPerfil", textoPerfil);
        model.addAttribute("usuario", usuario);
        return "perfil";
    }

    @GetMapping("/listar")
    public String listar(Model model){

        model.addAttribute("tituloListar", textoListar);

        return"listar";
    }

    @ModelAttribute("usuarios")
    public List<Usuario> poblarUsuarios(){
        return Arrays.asList(
                new Usuario("Hector", "Roa", "hroa.castillo@gmail.com"),
                new Usuario("Gonzalo", "Roa", "roasgo@hotmail.com"),
                new Usuario("Patricia", "Castillo", "pmcastillos@hotmail.com"),
                new Usuario("Willy", "Roa", "wroae@hotmail.com")
        );
    }
}
