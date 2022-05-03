package com.cenfotec.lab5.lab5.controller;

import com.cenfotec.lab5.lab5.domain.Auditor;
import com.cenfotec.lab5.lab5.domain.Cliente;
import com.cenfotec.lab5.lab5.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class AppControler {

    @Autowired
    AppService appService;

    @RequestMapping("/")
    public String index(Model model){
        return "index";
    }

    @RequestMapping(value = "MenuAuditor.html")
    public String menuAuditores(Model model){
        model.addAttribute("Auditor", appService.getAllAuditor());
        return "MenuAuditor";
    }
    @RequestMapping(value = "/agregarEntradaA", method = RequestMethod.GET)
    public String navegarPaginaInsertarAuditor(Model model){
        model.addAttribute(new Auditor());
        return "agregarEntradaA";
    }

    @RequestMapping(value = "/agregarEntradaA", method = RequestMethod.POST)
    public String accionPaginaInsertar(Auditor auditor, BindingResult result, Model model){
        auditor.setEstado("Activo");
        appService.saveAuditor(auditor);
        return "exito";
    }

    @RequestMapping(value = "/editarA/{id}")
    public String irAEditarAuditor(Model model, @PathVariable int id) {
        Optional<Auditor> AuditorToEdit = appService.getByIdAuditor(id);
        if (AuditorToEdit.isPresent()){
            model.addAttribute("AuditorToEdit", AuditorToEdit);
            return "editFormA";
        } else {
            return "notFound";
        }
    }

    @RequestMapping(value = "/editarA/{id}", method = RequestMethod.POST)
    public String guardarCambiosAuditor(Auditor auditor, BindingResult result, Model model,
                                 @PathVariable int id) {
        appService.updateAuditor(auditor);
        return "exito";
    }

    @RequestMapping(value = "/borrarA/{id}")
    public String inhabilitarAuditor(Auditor auditor, Model model, @PathVariable int id) {
        Optional<Auditor> AuditorAinhabilitar = appService.getByIdAuditor(id);
        if (AuditorAinhabilitar.isPresent()){
            model.addAttribute("AuditorAinhabilitar", AuditorAinhabilitar);
            return "inhabilitarform";
        } else {
            return "notFound";
        }
    }

    @RequestMapping(value = "/borrarA/{id}", method = RequestMethod.POST)
    public String inhabilitarAuditorCambios(Auditor auditor, BindingResult result, Model model,
                                        @PathVariable int id) {
        auditor.setEstado("Inactivo");
        appService.updateAuditor(auditor);
        return "exito";
    }

    //Cliente


    @RequestMapping("MenuCliente.html")
    public String indexCliente(Model model){
        List<Cliente> listB = appService.getAllCliente();
        model.addAttribute("cliente", appService.getAllCliente());
        return "MenuCliente";
    }

    @RequestMapping(value = "/agregarEntradaC", method = RequestMethod.GET)
    public String navegarPaginaInsertar(Model model){
        model.addAttribute(new Cliente());
        return "agregarEntradaC";
    }

    @RequestMapping(value = "/agregarEntradaC", method = RequestMethod.POST)
    public String accionPaginaInsertar(Cliente cliente, BindingResult result, Model model){
        appService.saveCliente(cliente);
        return "exito";
    }

    @RequestMapping(value = "/editarC/{id}")
    public String irAEditar(Model model, @PathVariable int id) {
        Optional<Cliente> clienteToEdit = appService.getByIdCliente(id);
        if (clienteToEdit.isPresent()){
            model.addAttribute("clienteToEdit", clienteToEdit);
            return "editFormC";
        } else {
            return "notFound";
        }
    }

    @RequestMapping(value = "/editarC/{id}", method = RequestMethod.POST)
    public String guardarCambios(Cliente cliente, BindingResult result,Model model,
                                 @PathVariable int id) {
        //podria ir en el service.
        appService.updateCliente(cliente);
        return "exito";
    }

    @RequestMapping(value = "/borrarC/{id}")
    public String borrar(Model model, @PathVariable int id) {
        appService.deleteCliente(id);
        return "exito";
    }

    @RequestMapping(value = "MenuRtrabajo.html")
    public String menuRtrabajo(Model model){
        model.addAttribute("Rtrabajo", appService.getAllRTrabajo());
        return "MenuRtrabajo";
    }
}