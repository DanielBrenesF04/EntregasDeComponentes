package com.cenfotec.graphql.graphql.mutation;

import com.cenfotec.graphql.graphql.entities.Padre;
import com.cenfotec.graphql.graphql.services.PadreService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PadreMutation implements GraphQLMutationResolver {

    @Autowired
    private PadreService padreService;

    //////Padres

    public Padre createPadre(String nombre, String cedula, String direcion, String Tprimario, String Tsecundario){
        return this.padreService.createPadre(nombre,cedula,direcion,Tprimario,Tsecundario);
    }

    public Padre updatePadre(int id, String nombre, String cedula, String direcion, String Tprimario, String Tsecundario) {
        Optional<Padre> padre = this.padreService.getPadre(id);
        if (padre.isPresent()) {
            Padre padreEntity = padre.get();
            if (nombre!=null)
                padreEntity.setNombre(nombre);
            if (cedula!=null)
                padreEntity.setCedula(cedula);
            if (direcion!=null)
                padreEntity.setDireccion(direcion);
            if (Tprimario!=null)
                padreEntity.setTprimario(Tprimario);
            if (Tsecundario!=null)
                padreEntity.setTsecundario(Tsecundario);
            padreService.savePadre(padreEntity);
            return padreEntity;
        }
        return null;
    }

    public Padre deletePadre(int id){
        Optional<Padre> padre = this.padreService.getPadre(id);
        if (padre.isPresent()) {
            Padre padreEntity = padre.get();
            padreService.deletePadre(padreEntity);
            return padreEntity;
        }
        return null;
    }

}
