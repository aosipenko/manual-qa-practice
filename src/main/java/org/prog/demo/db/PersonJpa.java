package org.prog.demo.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonJpa extends JpaRepository<PersonTable, Long> {
}
