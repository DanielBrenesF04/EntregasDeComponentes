package com.cenfotec.graphql.graphql.mutation;

import com.cenfotec.graphql.graphql.entities.Hijo;
import com.cenfotec.graphql.graphql.services.HijoService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class HijoMutation implements GraphQLMutationResolver {

    @Autowired
    private HijoService hijoService;

    public Hijo createHijo(String nombre, String tUsaurio, String alergias, int idPadre,String liborsLeidos,int cLeidos) {
        return this.hijoService.createHijo(nombre,tUsaurio,alergias,idPadre,liborsLeidos,cLeidos);
    }
    public Hijo updateHijo(int id,String nombre, String tUsaurio, String alergias, int idPadre,String liborsLeidos,int cLeidos) {
        Optional<Hijo> hijo = this.hijoService.getHijo(id);

        if (hijo.isPresent()) {
            Hijo HijoEntity = hijo.get();
            if (nombre!=null)
                HijoEntity.setNombre(nombre);
            if (tUsaurio!=null)
                HijoEntity.settUsaurio(tUsaurio);
            if (alergias!=null)
                HijoEntity.setAlergias(alergias);
            if (alergias!=null)
                HijoEntity.setAlergias(alergias);
            if (idPadre<=0)
                HijoEntity.setAlergias(alergias);
            if (liborsLeidos!=null)
                HijoEntity.setLiborsLeidos(liborsLeidos);
            hijoService.saveHijo(HijoEntity);
            return HijoEntity;
        }
        return null;
    }
    public Hijo deleteHijo(int id){
        Optional<Hijo> Hijo = this.hijoService.getHijo(id);
        if (Hijo.isPresent()) {
            Hijo HijoEntity = Hijo.get();
            hijoService.deleteHijo(HijoEntity);
            return HijoEntity;
        }
        return null;
    }

    public Hijo agregarLibro(int id,String liborsLeidos) {
        Optional<Hijo> hijo = this.hijoService.getHijo(id);

        if (hijo.isPresent()) {
            Hijo HijoEntity = hijo.get();
            String yaLeidos = HijoEntity.getLiborsLeidos();
            int temp = HijoEntity.getcLeidos();
            if (liborsLeidos!=null)
                HijoEntity.setLiborsLeidos(yaLeidos+", "+liborsLeidos);
            HijoEntity.setcLeidos(temp+1);
            hijoService.saveLeido(HijoEntity);
            return HijoEntity;
        }
        return null;
    }

}
