package com.cenfotec.graphql.graphql.repositories;

import com.cenfotec.graphql.graphql.entities.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Integer> {
}
