package com.cenfotec.graphql.graphql.services;

import com.cenfotec.graphql.graphql.entities.Hijo;
import com.cenfotec.graphql.graphql.repositories.HijoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HijoService {

    @Autowired
    HijoRepository hijoRepository;



    public List<Hijo> getAllHijos(int count) {
        return this.hijoRepository.findAll().stream().limit(count).collect(Collectors.toList());
    }

    public Optional<Hijo> getHijo(int id) {
        return this.hijoRepository.findById(id);
    }

    public Hijo createHijo(String nombre,String tUsuario,String alergias,int idPadre,String librosLeidos, int cLeidos){
        Hijo hijo = new Hijo();
        hijo.setNombre(nombre);
        hijo.settUsaurio(tUsuario);
        hijo.setAlergias(alergias);
        hijo.setIdPadre(idPadre);
        hijo.setLiborsLeidos(librosLeidos);
        hijo.setcLeidos(cLeidos);
        return this.hijoRepository.save(hijo);
    }

    public void saveHijo(Hijo HijoEntity) {
        this.hijoRepository.save(HijoEntity);
    }

    public void deleteHijo(Hijo HijoEntity) {
        this.hijoRepository.delete(HijoEntity);
    }


    public void saveLeido(Hijo HijoEntity){this.hijoRepository.save(HijoEntity);}

    //
}
