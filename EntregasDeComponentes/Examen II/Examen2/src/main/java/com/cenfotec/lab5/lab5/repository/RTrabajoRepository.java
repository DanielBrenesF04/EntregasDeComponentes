package com.cenfotec.lab5.lab5.repository;


import com.cenfotec.lab5.lab5.domain.RTrabajo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RTrabajoRepository extends JpaRepository<RTrabajo, Long> {
}