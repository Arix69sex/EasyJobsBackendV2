package com.easyjobs.domain.repository;

import com.easyjobs.domain.model.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TecnicoRepository extends JpaRepository<Tecnico, Long> {
    Optional<Tecnico> findByCuentaId (Long cuentaId);
    Optional<Tecnico> findByDni (Long dni);
}
