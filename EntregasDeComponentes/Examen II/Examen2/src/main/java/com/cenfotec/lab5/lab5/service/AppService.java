package com.cenfotec.lab5.lab5.service;

import com.cenfotec.lab5.lab5.domain.Auditor;
import com.cenfotec.lab5.lab5.domain.Cliente;
import com.cenfotec.lab5.lab5.domain.Pcontacto;
import com.cenfotec.lab5.lab5.domain.RTrabajo;
import com.cenfotec.lab5.lab5.repository.AuditorRepository;
import com.cenfotec.lab5.lab5.repository.ClienteRepository;
import com.cenfotec.lab5.lab5.repository.RTrabajoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AppService {
    @Autowired
    ClienteRepository clienteRepository;
    @Autowired
    AuditorRepository auditorRepository;
    @Autowired
    RTrabajoRepository rTrabajoRepository;


    public void saveAuditor(Auditor auditor){
        auditorRepository.save(auditor);
    }

    public void saveCliente(Cliente cliente){
        Pcontacto nuevo = new Pcontacto();
        nuevo.setNombre("Cualquiera " + Instant.now().getEpochSecond());
        List<Pcontacto> pcontacto = new ArrayList<>();
        pcontacto.add(nuevo);
        cliente.setPcontactos(pcontacto);
        clienteRepository.save(cliente);
    }

    public void saveRtrabajo(RTrabajo rtrabajo){
        rTrabajoRepository.save(rtrabajo);
    }
//Auditores
    public List<Auditor> getAllAuditor(){
        return auditorRepository.findAll();
    }
    public Optional<Auditor> getByIdAuditor(int id){return auditorRepository.findById(Long.valueOf(id));};
    public void updateAuditor(Auditor auditor) {
        auditorRepository.save(auditor);}
    public void deletePersona(int id){
        auditorRepository.deleteById(Long.valueOf(id));}
//Clientes
    public List<Cliente> getAllCliente(){return clienteRepository.findAll();}
    public Optional<Cliente> getByIdCliente(int id) {
        return clienteRepository.findById(Long.valueOf(id));
    }
    public void updateCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }
    public  void deleteCliente(int id) {
        clienteRepository.deleteById(Long.valueOf(id));
    }
//Rtrabajo
public List<RTrabajo> getAllRTrabajo(){return rTrabajoRepository.findAll();}
    public Optional<RTrabajo> getByIdTrabajo(int id) {
        return rTrabajoRepository.findById(Long.valueOf(id));
    }
    public void updateTrabajo(RTrabajo rTrabajo) {
        rTrabajoRepository.save(rTrabajo);
    }
    public  void deleteTrabajo(int id) {
        rTrabajoRepository.deleteById(Long.valueOf(id));
    }




}
