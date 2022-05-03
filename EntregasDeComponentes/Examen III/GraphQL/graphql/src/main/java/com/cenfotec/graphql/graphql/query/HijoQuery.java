package com.cenfotec.graphql.graphql.query;

import com.cenfotec.graphql.graphql.entities.Hijo;
import com.cenfotec.graphql.graphql.services.HijoService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class HijoQuery implements GraphQLQueryResolver {
    @Autowired
    private HijoService hijoService;


    public List<Hijo> getHijos(int count) {
        return this.hijoService.getAllHijos(count);
    }
    public Optional<Hijo> getHijo(int id) {
        return this.hijoService.getHijo(id);
    }

    //niños y libro

}
