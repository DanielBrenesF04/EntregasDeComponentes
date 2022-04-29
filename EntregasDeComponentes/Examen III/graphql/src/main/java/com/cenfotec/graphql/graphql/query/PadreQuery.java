package com.cenfotec.graphql.graphql.query;

import com.cenfotec.graphql.graphql.entities.FilterField;
import com.cenfotec.graphql.graphql.entities.Padre;
import com.cenfotec.graphql.graphql.services.PadreService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PadreQuery implements GraphQLQueryResolver {
    @Autowired
    private PadreService padreService;

    public List<Padre> getPadres(int count) {
        return this.padreService.getAllPadres(count);
    }
    public Optional<Padre> getPadre(int id) {
        return this.padreService.getPadre(id);
    }




}
