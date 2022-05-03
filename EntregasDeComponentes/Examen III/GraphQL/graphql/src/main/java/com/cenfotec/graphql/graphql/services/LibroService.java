package com.cenfotec.graphql.graphql.services;

import com.cenfotec.graphql.graphql.entities.Libro;

import com.cenfotec.graphql.graphql.repositories.LibroRepository;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LibroService implements GraphQLQueryResolver {


    @Autowired
    LibroRepository libroRepository;

    public List<Libro> getAllLibros(int count) {return this.libroRepository.findAll().stream().limit(count).collect(Collectors.toList());}

    public Optional<Libro> getLibro(int id) {
        return this.libroRepository.findById(id);
    }

    public Libro createLibro(String nombre,String autor, String descripcion, final String launchDate){
        Libro padre = new Libro();
        padre.setNombre(nombre);
        padre.setEstado("Activo");
        padre.setAutor(autor);
        padre.setDescripcion(descripcion);
        padre.setLaunchDate(LocalDate.parse(launchDate));
        return this.libroRepository.save(padre);
    }

    public void saveLibro(Libro padreEntity) {
        this.libroRepository.save(padreEntity);
    }



    public void deleteLibro(Libro padreEntity) {
        this.libroRepository.delete(padreEntity);
    }
}
