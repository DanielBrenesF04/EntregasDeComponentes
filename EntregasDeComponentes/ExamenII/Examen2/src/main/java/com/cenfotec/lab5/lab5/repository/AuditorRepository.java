package com.cenfotec.lab5.lab5.repository;

import com.cenfotec.lab5.lab5.domain.Auditor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditorRepository extends JpaRepository<Auditor, Long> {

}
