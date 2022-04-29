package com.cenfotec.graphql.graphql.repositories;

import com.cenfotec.graphql.graphql.entities.Padre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PadreRepository extends JpaRepository<Padre, Integer> {
}
