package com.cenfotec.graphql.graphql.query;

import com.cenfotec.graphql.graphql.entities.Libro;
import com.cenfotec.graphql.graphql.services.LibroService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class LibroQuery implements GraphQLQueryResolver {
    @Autowired
    private LibroService libroService;

    public List<Libro> getLibros(int count) {return this.libroService.getAllLibros(count);}
    public Optional<Libro> getLibro(int id) {return this.libroService.getLibro(id);}
}
