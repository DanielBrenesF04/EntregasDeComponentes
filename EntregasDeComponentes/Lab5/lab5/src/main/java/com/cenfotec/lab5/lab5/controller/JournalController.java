package com.cenfotec.lab5.lab5.controller;

import com.cenfotec.lab5.lab5.domain.Journal;
import com.cenfotec.lab5.lab5.service.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.naming.Binding;
import java.sql.Date;
import java.time.Instant;

@Controller
public class JournalController {
    @Autowired
    JournalService journalService;
    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("journal", journalService.getAll());
        return "index";


    }

/*    @RequestMapping(value = "/agregarEntrada", method = RequestMethod.GET)
    public String navegarPaginaInsertar(Model model){
        model.addAttribute(new Journal());
        return "agregarEntrada";
    }

    @RequestMapping(value = "/agregarEntrada", method = RequestMethod.POST)
    public String accionPaginaInsertar(Journal journal, BindingResult result, Model model){
        journal.setCreated(Date.from(Instant.now()));
        journalService.saveJournal(journal);
        return "index";
    }*/
}
