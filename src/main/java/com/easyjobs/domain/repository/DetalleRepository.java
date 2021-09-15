package com.easyjobs.domain.repository;

import com.easyjobs.domain.model.Detalle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DetalleRepository extends JpaRepository<Detalle, Long> {
    Page<Detalle> findAllByHistorialId (Long historialId, Pageable pageable);

    Optional<Detalle> findBySolicitudId (Long solicitudId);
}
