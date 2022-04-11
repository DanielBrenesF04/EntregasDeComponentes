package com.cenfotec.lab5.lab5.repository;

import com.cenfotec.lab5.lab5.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Cliente findClienteById(Long id);
}
