package com.hroac.springbootweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/params")
public class EjemploParamsController {

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("tituloParamIdx", "Enviar parámetro");

        return"params/index";
    }

    @GetMapping("string")
    public String param(@RequestParam(required = false) String texto, Model model) {

        model.addAttribute("tituloParam", "Recibir parámetro");
        model.addAttribute("result", "El texto enviado es: " + texto);

        return "/params/ver";
    }

    @GetMapping("/mix-params")
    public String param(@RequestParam String saludo,@RequestParam Integer numero,Model model){
        model.addAttribute("resultado","El saludo enviado es: '"+saludo+ "' y el número es '" +numero+ "'");
        return"params/ver";
    }

    @GetMapping("/mix-params-servlet")
    public String param(HttpServletRequest request, Model model){

        String saludo = request.getParameter("saludo");

        int numero;

        try {
            numero = Integer.parseInt(request.getParameter("numero"));
        } catch (NumberFormatException e) {
            numero = 0;
        }

        model.addAttribute("resultado","El saludo enviado es: '"+saludo+ "' y el número es '" +numero+ "'");
        return"params/ver";
    }

}
