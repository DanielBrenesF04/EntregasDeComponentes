package com.cenfotec.lab5.lab5.controller;

import com.cenfotec.lab5.lab5.domain.Persona;
import com.cenfotec.lab5.lab5.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.Instant;
import java.util.Date;

@Controller
public class PersonaControler {

    @Autowired
    PersonaService personaService;

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("Persona", personaService.getAll());
        return "index";
    }

    @RequestMapping(value = "/agregarEntrada", method = RequestMethod.GET)
    public String navegarPaginaInsertar(Model model){
        model.addAttribute(new Persona());
        return "agregarEntrada";
    }

    @RequestMapping(value = "/agregarEntrada", method = RequestMethod.POST)
    public String accionPaginaInsertar(Persona persona, BindingResult result, Model model){
        persona.setCreated(Date.from(Instant.now()));
        personaService.savePersona(persona);
        return "agregarEntrada";
    }

    @RequestMapping(value = "/borrarEntrada", method = RequestMethod.DELETE)
    public String accionPaginaBorrar(Persona journal){
        personaService.deletePersona(journal);
        return "agregarEntrada";
    }
}