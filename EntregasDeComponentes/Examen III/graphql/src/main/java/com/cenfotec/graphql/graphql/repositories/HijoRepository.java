package com.cenfotec.graphql.graphql.repositories;

import com.cenfotec.graphql.graphql.entities.Hijo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HijoRepository extends JpaRepository<Hijo, Integer> {
}
