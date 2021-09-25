package com.easyjobs.controller;

import com.easyjobs.domain.model.Cuenta;
import com.easyjobs.domain.model.Detalle;
import com.easyjobs.domain.model.Historial;
import com.easyjobs.domain.model.Solicitud;
import com.easyjobs.domain.service.DetalleService;
import com.easyjobs.resource.*;
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
public class DetalleController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private DetalleService detalleService;

    @Operation(summary = "Get All Detalles", description = "Get All Detalles", tags = {"detalles"})
    @GetMapping("/detalles")
    public Page<DetalleResource> getAllDetalles(Pageable pageable){
        Page<Detalle> detallePage = detalleService.getAllDetalles(pageable);
        List<DetalleResource> resources = detallePage.getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @Operation(summary = "Get Detalle by Id", description = "Get Detalle by its Id", tags = {"detalles"})
    @GetMapping("/detalles/{detalleId}")
    public DetalleResource GetDetalleById(@PathVariable Long detalleId){
        return convertToResource(detalleService.getDetalleById(detalleId));
    }

    @Operation(summary = "Get Detalle by SolicitudId", description = "Get Detalle by its SolicitudId", tags = {"detalles"})
    @GetMapping("/solicitudes/{solicitudId}/detalles")
    public DetalleResource GetDetalleBySolicitudId(@PathVariable Long solicitudId){
        return convertToResource(detalleService.getDetalleBySolicitudId(solicitudId));
    }

    @Operation(summary = "Get All Detalles by HistorialId", description = "Get All Detalles by its HistorialId", tags = {"detalles"})
    @GetMapping("/historiales/{historialId}/detalles")
    public Page<DetalleResource> GetAllDetallesByHistorialId(@PathVariable Long historialId, Pageable pageable){
        Page<Detalle> detallePage = detalleService.getAllDetallesByHistorialId(historialId, pageable);
        List<DetalleResource> resources = detallePage.getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @Operation(summary = "Create Detalle", description = "Create a new Detalle", tags = {"detalles"})
    @PostMapping("/detalles")
    public DetalleResource createDetalle(Long solicitudId, Long historialId, @Valid @RequestBody SaveDetalleResource resource){
        Detalle detalle = convertToEntity(resource);
        return convertToResource(detalleService.createDetalle(solicitudId, historialId, detalle));
    }

    @Operation(summary = "Update Detalle", description = "Update an existing Detalle with given Id", tags = {"detalles"})
    @PutMapping("/detalles/{cuentaId}")
    public DetalleResource updateDetalle(@PathVariable Long detalleId, Long solicitudId, Long historialId, @RequestBody SaveDetalleResource resource) {
        Detalle detalle = convertToEntity(resource);
        return convertToResource(detalleService.updateDetalle(solicitudId,historialId,detalleId,detalle));
    }

    @Operation(summary = "Delete Detalle", description = "Delete an existing Detalle using its id", tags = {"detalles"})
    @DeleteMapping("/detalles/{detalleId}")
    public ResponseEntity<?> deleteDetalle(@PathVariable Long detalleId){
        return detalleService.deleteDetalle(detalleId);
    }



    private Detalle convertToEntity(SaveDetalleResource resource) {
        return mapper.map(resource, Detalle.class);
    }

    private DetalleResource convertToResource(Detalle entity){ return mapper.map(entity, DetalleResource.class);}
}
