package com.easyjobs.controller;

import com.easyjobs.domain.model.Solicitud;
import com.easyjobs.domain.service.SolicitudService;
import com.easyjobs.resource.SaveSolicitudResource;
import com.easyjobs.resource.SolicitudResource;
import io.swagger.v3.oas.annotations.Operation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class SolicitudController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private SolicitudService solicitudService;

    @Operation(summary = "Get all Solicitudes", description = "Get all Solicitudes", tags = {"solicitudes"})
    @GetMapping("/solicitudes")
    public Page<SolicitudResource> getAllSolicitudes(Pageable pageable){
        Page<Solicitud> solicitudPage = solicitudService.getAllSolicitudes(pageable);
        List<SolicitudResource> resources = solicitudPage.getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @Operation(summary = "Get All Solicitudes by ClienteId", description = "Get All Solicitudes by ClienteId", tags = {"solicitudes"})
    @GetMapping("/clientes/{clienteId}/solicitudes")
    public Page<SolicitudResource> getAllSolicitudesByClienteId(@PathVariable Long clienteId, Pageable pageable){
        Page<Solicitud> solicitudPage = solicitudService.getAllSolicitudesByClienteId(clienteId, pageable);
        List<SolicitudResource> resources = solicitudPage.getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @Operation(summary = "Get All Solicitudes by TecnicoId", description = "Get All Solicitudes by TecnicoId", tags = {"solicitudes"})
    @GetMapping("/tecnicos/{tecnicoId}/solicitudes")
    public Page<SolicitudResource> getAllSolicitudesByTecnicoId(@PathVariable Long tecnicoId, Pageable pageable){
        Page<Solicitud> solicitudPage = solicitudService.getAllSolicitudesByClienteId(tecnicoId, pageable);
        List<SolicitudResource> resources = solicitudPage.getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @Operation(summary = "Get All Solicitudes by Tipo", description = "Get All Solicitudes by Tipo", tags = {"solicitudes"})
    @GetMapping("/solicitudes/{tipo}")
    public Page<SolicitudResource> getAllSolicitudesByTipo(@PathVariable String tipo, Pageable pageable){
        Page<Solicitud> solicitudPage = solicitudService.getAllSolicitudesByTipo(tipo, pageable);
        List<SolicitudResource> resources = solicitudPage.getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @Operation(summary = "Get Solicitud by its Id", description = "Get Solicitud by its Id", tags = {"solicitudes"})
    @GetMapping("/solicitudes/{solicitudId}")
    public SolicitudResource getSolicitudById(@PathVariable Long solicitudId){
        return convertToResource(solicitudService.getSolicitudById(solicitudId));
    }

    @Operation(summary = "Create Solicitud", description = "Create a new Solicitud", tags = {"solicitudes"})
    @PostMapping("/solicitudes/{solicitudId}")
    public SolicitudResource createSolicitud(@PathVariable Long solicitudId, Long clienteId, Long tecnicoId, @Valid @RequestBody SaveSolicitudResource resource){
        Solicitud solicitud = convertToEntity(resource);
        return convertToResource(solicitudService.createSolicitud(clienteId,tecnicoId,solicitud));
    }

    @Operation(summary = "Update a Solicitud", description = "Update an existing Solicitud", tags = {"solicitudes"})
    @PutMapping("/solicitudes/{solicitud}")
    public SolicitudResource updateSolicitud(@PathVariable Long solicitudId, Long clienteId, Long tecnicoId, @Valid @RequestBody SaveSolicitudResource resource) {
        Solicitud solicitud = convertToEntity(resource);
        return convertToResource(solicitudService.updateSolicitud(clienteId, tecnicoId, solicitudId, solicitud));
    }

    @Operation(summary = "Delete a Solicitud", description = "Delete an existing Solicitud with given Id", tags = {"solicitudes"})
    @DeleteMapping("/solicitudes/{solicitudId}")
    public ResponseEntity<?> deleteSolicitud(@PathVariable Long solicitudId, Long clienteId, Long tecnicoId) {
        return solicitudService.deleteSolicitud(solicitudId, clienteId, tecnicoId);
    }

    private Solicitud convertToEntity(SaveSolicitudResource resource) {
        return mapper.map(resource, Solicitud.class);
    }

    private SolicitudResource convertToResource(Solicitud entity){ return mapper.map(entity, SolicitudResource.class);}
}
