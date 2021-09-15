package com.easyjobs.service;

import com.easyjobs.domain.model.Detalle;
import com.easyjobs.domain.repository.DetalleRepository;
import com.easyjobs.domain.repository.HistorialRepository;
import com.easyjobs.domain.repository.SolicitudRepository;
import com.easyjobs.domain.service.DetalleService;
import com.easyjobs.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DetalleServiceImpl implements DetalleService {

    @Autowired
    private DetalleRepository detalleRepository;

    @Autowired
    private SolicitudRepository solicitudRepository;

    @Autowired
    private HistorialRepository historialRepository;

    @Override
    public Page<Detalle> getAllDetalles (Pageable pageable){
        return detalleRepository.findAll(pageable);
    }

    @Override
    public Detalle getDetalleById (Long detalleId){
        return detalleRepository.findById(detalleId)
                .orElseThrow(()-> new ResourceNotFoundException("Detalle","Id", detalleId));
    }

    @Override
    public Detalle getDetalleBySolicitudId (Long solicitudId){
        return detalleRepository.findBySolicitudId(solicitudId)
                .orElseThrow(()-> new ResourceNotFoundException("Detalle","Id", solicitudId));
    }

    @Override
    public Page<Detalle> getAllDetallesByHistorialId (Long historialId, Pageable pageable){
        return detalleRepository.findAllByHistorialId(historialId,pageable);
    }

    @Override
    public Detalle createDetalle (Long solicitudId, Long historialId, Detalle detalle){
        return solicitudRepository.findById(solicitudId).map(solicitud -> {
            detalle.setSolicitud(solicitud);
            historialRepository.findById(historialId).map(historial -> {
                detalle.setHistorial(historial);
                return detalleRepository.save(detalle);
            }).orElseThrow(() -> new ResourceNotFoundException(
                    "Historial", "Id", historialId));
            return detalleRepository.save(detalle);
        }).orElseThrow(() -> new ResourceNotFoundException(
                "Solicitud", "Id", solicitudId));
    }

    @Override
    public Detalle updateDetalle (Long solicitudId, Long historialId, Long detalleId, Detalle detalleRequest){
        if (!solicitudRepository.existsById(solicitudId))
            throw new ResourceNotFoundException("Solicitud", "Id", solicitudId);
        if (!historialRepository.existsById(historialId))
            throw new ResourceNotFoundException("Historial", "Id", historialId);
        return detalleRepository.findById(detalleId).map(detalle -> {
            detalle.setDescripcion(detalleRequest.getDescripcion());
            detalle.setValoracion(detalleRequest.getValoracion());
            return detalleRepository.save(detalle);
        }).orElseThrow(() -> new ResourceNotFoundException("Detalle", "Id", detalleId));
    }

    @Override
    public ResponseEntity<?> deleteDetalle(Long detalleId) {
        return detalleRepository.findById(detalleId).map(detalle -> {
            detalleRepository.delete(detalle);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Detalle", "Id", detalleId));
    }
}
