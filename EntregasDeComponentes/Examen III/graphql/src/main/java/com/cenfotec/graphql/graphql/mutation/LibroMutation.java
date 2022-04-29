package com.cenfotec.graphql.graphql.mutation;

import com.cenfotec.graphql.graphql.entities.Libro;
import com.cenfotec.graphql.graphql.services.LibroService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Optional;

@Component
public class LibroMutation implements GraphQLMutationResolver {
@Autowired
    private LibroService libroService;

public Libro crearLibro(String nombre,String autor,String descipcion,String launchDate){
    return this.libroService.createLibro(nombre,autor,descipcion,launchDate);
}
public Libro updateLibro(int id,String nombre,String autor,String descipcion,String launchDate) {
    Optional<Libro> libro = this.libroService.getLibro(id);
    if (libro.isPresent()) {
        Libro libroEntity = libro.get();
        if (nombre != null)
            libroEntity.setNombre(nombre);
        if (autor != null)
            libroEntity.setAutor(autor);
        if (descipcion != null)
            libroEntity.setDescripcion(descipcion);
        if (launchDate != null)
            libroEntity.setLaunchDate(LocalDate.parse(launchDate));

        libroService.saveLibro(libroEntity);
        return libroEntity;

    }

    return null;


}
public Libro deactivarLibro(int id){
    Optional<Libro> libro = this.libroService.getLibro(id);

    if (libro.isPresent()){
        Libro libroEntity = libro.get();
        String estado = libroEntity.getEstado();
        if(estado == "Activo"){
            libroEntity.setEstado("Inactivo");
            libroService.saveLibro(libroEntity);
            return libroEntity;
        }
        else if (estado =="Inactivo"){
            libroEntity.setEstado("Activo");
            libroService.saveLibro(libroEntity);
            return libroEntity;
        }
    }
    return null;
}

}
