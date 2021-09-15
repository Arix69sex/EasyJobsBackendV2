package com.easyjobs.domain.repository;

import com.easyjobs.domain.model.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findByCuentaId (Long cuentaId);
    Page<Cliente> findByNombre(String nombre, Pageable pageable);
    Page<Cliente> findByApellido(String apellido, Pageable pageable);
    Page<Cliente> findByDistrito(String distrito, Pageable pageable);
}
