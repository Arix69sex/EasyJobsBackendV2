package com.easyjobs.service;

import com.easyjobs.domain.model.Solicitud;
import com.easyjobs.domain.repository.ClienteRepository;
import com.easyjobs.domain.repository.SolicitudRepository;
import com.easyjobs.domain.repository.TecnicoRepository;
import com.easyjobs.domain.service.SolicitudService;
import com.easyjobs.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SolicitudServiceImpl implements SolicitudService {

    @Autowired
    private SolicitudRepository solicitudRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private TecnicoRepository tecnicoRepository;

    @Override
    public Page<Solicitud> getAllSolicitudes (Pageable pageable){
        return solicitudRepository.findAll(pageable);
    }

    @Override
    public Solicitud getSolicitudById (Long solicitudId){
        return solicitudRepository.findById(solicitudId)
                .orElseThrow(()-> new ResourceNotFoundException("Solicitud", "Id", solicitudId));
    }

    @Override
    public Page<Solicitud> getAllSolicitudesByClienteId (Long clienteId, Pageable pageable){
        return solicitudRepository.findAllByClienteId(clienteId, pageable);
    }

    @Override
    public Page<Solicitud> getAllSolicitudesByTecnicoId (Long tecnicoId, Pageable pageable){
        return solicitudRepository.findAllByTecnicoId(tecnicoId, pageable);
    }

    @Override
    public Page<Solicitud> getAllSolicitudesByTipo (String tipo, Pageable pageable){
        return solicitudRepository.findAllByTipo(tipo, pageable);
    }

    @Override
    public Solicitud createSolicitud (Long clienteId, Long tecnicoId, Solicitud solicitud){
        return clienteRepository.findById(clienteId).map(cliente -> {
            solicitud.setCliente(cliente);
            tecnicoRepository.findById(tecnicoId).map(tecnico -> {
                solicitud.setTecnico(tecnico);
                return solicitudRepository.save(solicitud);
            }).orElseThrow(() -> new ResourceNotFoundException(
                    "Tecnico", "Id", tecnicoId));
            return solicitudRepository.save(solicitud);
        }).orElseThrow(() -> new ResourceNotFoundException(
                "Cliente", "Id", clienteId));
    }

    @Override
    public Solicitud updateSolicitud (Long clienteId, Long tecnicoId, Long solicitudId, Solicitud solicitudRequest){
        if (!clienteRepository.existsById(clienteId))
            throw new ResourceNotFoundException("Cliente", "Id", clienteId);
        if (!tecnicoRepository.existsById(tecnicoId))
            throw new ResourceNotFoundException("Tecnico", "Id", tecnicoId);
        return solicitudRepository.findById(solicitudId).map(solicitud -> {
            solicitud.setMonto(solicitudRequest.getMonto());
            solicitud.setTipoPago(solicitudRequest.getTipoPago());
            solicitud.setTipo(solicitudRequest.getTipo());
            return solicitudRepository.save(solicitud);
        }).orElseThrow(() -> new ResourceNotFoundException("Solicitud", "Id", solicitudId));

    }

    @Override
    public ResponseEntity<?> deleteSolicitud(Long clienteId, Long tecnicoId, Long solicitudId){
        if (!clienteRepository.existsById(clienteId))
            throw new ResourceNotFoundException("Cliente", "Id", clienteId);
        if (!tecnicoRepository.existsById(tecnicoId))
            throw new ResourceNotFoundException("Tecnico", "Id", tecnicoId);
        return solicitudRepository.findById(solicitudId).map(solicitud -> {
            solicitudRepository.delete(solicitud);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Solicitud", "Id", solicitudId));

    }

}
