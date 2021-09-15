package com.easyjobs.domain.repository;

import com.easyjobs.domain.model.Cuenta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CuentaRepository extends JpaRepository<Cuenta, Long> {
    Optional<Cuenta> findByUsername (String username);
    Optional<Cuenta>  findByEmail (String email);
    Page<Cuenta> findAllByTipoCuenta (String tipo, Pageable pageable);
}
