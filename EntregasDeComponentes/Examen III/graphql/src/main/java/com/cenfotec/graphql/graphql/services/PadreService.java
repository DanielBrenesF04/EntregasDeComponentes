package com.cenfotec.graphql.graphql.services;

import com.cenfotec.graphql.graphql.entities.Padre;
import com.cenfotec.graphql.graphql.repositories.PadreRepository;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class PadreService{
    @Autowired
    PadreRepository padreRepository;


    public List<Padre> getAllPadres(int count) {return this.padreRepository.findAll().stream().limit(count).collect(Collectors.toList());}

    public List<Padre> getAllPadresNombre(int count) {return this.padreRepository.findAll().stream().limit(count).collect(Collectors.toList());}

    public Optional<Padre> getPadre(int id) {
        return this.padreRepository.findById(id);
    }


    public Padre createPadre(String nombre,String cedula,String direccion, String Tprimario,String Tsecundario){
        Padre padre = new Padre();
        padre.setNombre(nombre);
        padre.setCedula(cedula);
        padre.setDireccion(direccion);
        padre.setTprimario(Tprimario);
        padre.setTsecundario(Tsecundario);

        return this.padreRepository.save(padre);
    }

    public void savePadre(Padre padreEntity) {
        this.padreRepository.save(padreEntity);
    }

    public void deletePadre(Padre padreEntity) {
        this.padreRepository.delete(padreEntity);
    }

}
