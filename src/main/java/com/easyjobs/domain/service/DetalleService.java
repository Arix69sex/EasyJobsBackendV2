package com.easyjobs.domain.service;

import com.easyjobs.domain.model.Detalle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface DetalleService {

    Page<Detalle> getAllDetalles (Pageable pageable);

    Detalle getDetalleById (Long detalleId);

    Detalle getDetalleBySolicitudId (Long solicitudId);

    Page<Detalle> getAllDetallesByHistorialId (Long historialId, Pageable pageable);

    Detalle createDetalle (Long solicitudId, Long historialId, Detalle detalle);

    Detalle updateDetalle (Long solicitudId, Long historialId, Long detalleId, Detalle detalleRequest);

    ResponseEntity<?> deleteDetalle(Long detalleId);
}
