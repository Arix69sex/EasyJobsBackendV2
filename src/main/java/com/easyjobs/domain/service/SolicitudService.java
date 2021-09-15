package com.easyjobs.domain.service;

import com.easyjobs.domain.model.Solicitud;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;


public interface SolicitudService {

    Page<Solicitud> getAllSolicitudes (Pageable pageable);

    Solicitud getSolicitudById (Long solicitudId);

    Page<Solicitud> getAllSolicitudesByClienteId (Long clienteId, Pageable pageable);

    Page<Solicitud> getAllSolicitudesByTecnicoId (Long tecnicoId, Pageable pageable);

    Page<Solicitud> getAllSolicitudesByTipo (String tipo, Pageable pageable);

    Solicitud createSolicitud (Long clienteId, Long tecnicoId, Solicitud solicitud);

    Solicitud updateSolicitud (Long clienteId, Long tecnicoId, Long solicitudId, Solicitud solicitudRequest);

    ResponseEntity<?> deleteSolicitud(Long clienteId, Long tecnicoId, Long solicitudId);
}
