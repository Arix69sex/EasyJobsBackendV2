package com.easyjobs.domain.repository;

import com.easyjobs.domain.model.Solicitud;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitudRepository extends JpaRepository<Solicitud, Long> {
    Page<Solicitud> findAllByClienteId (Long clienteId, Pageable pageable);
    Page<Solicitud> findAllByTecnicoId (Long tecnicoId, Pageable pageable);
    Page<Solicitud> findAllByClienteIdAndTecnicoId (Long clienteId,Long tecnicoId, Pageable pageable);
    Page<Solicitud> findAllByTipo (String tipo, Pageable pageable);
}
