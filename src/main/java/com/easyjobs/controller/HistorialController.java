package com.easyjobs.controller;

import com.easyjobs.domain.model.Cuenta;
import com.easyjobs.domain.model.Historial;
import com.easyjobs.domain.model.Solicitud;
import com.easyjobs.domain.repository.HistorialRepository;
import com.easyjobs.domain.service.HistorialService;
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
public class HistorialController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private HistorialService historialService;

    @Operation(summary = "Get All Historiales", description = "Get All Historiales", tags = {"historiales"})
    @GetMapping("/historiales")
    public Page<HistorialResource> getAllHistoriales(Pageable pageable){
        Page<Historial> historialPage = historialService.getAllHitoriales(pageable);
        List<HistorialResource> resources = historialPage.getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @Operation(summary = "Get Historial by Id", description = "Get Historial by Id", tags = {"historiales"})
    @GetMapping("/historiales/{historialId}")
    public HistorialResource GetHistorialById(@PathVariable Long historialId){
        return convertToResource(historialService.getHistorialById(historialId));
    }

    @Operation(summary = "Get All Historiales by Categoria", description = "Get All Historiales by Categoria", tags = {"historiales"})
    @GetMapping("/historiales/{categoria}")
    public Page<HistorialResource> getAllHistoriales(@PathVariable String categoria, Pageable pageable){
        Page<Historial> historialPage = historialService.getAllHitorialesByCategoria(categoria, pageable);
        List<HistorialResource> resources = historialPage.getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @Operation(summary = "Create Historial", description = "Create a new Historial", tags = {"historiales"})
    @PostMapping("/historiales")
    public HistorialResource createHistorial(@Valid @RequestBody SaveHistorialResource resource){
        Historial historial = convertToEntity(resource);
        return convertToResource(historialService.createHistorial(historial));
    }

    @Operation(summary = "Update Historial", description = "Update an existing Historial with given Id", tags = {"historiales"})
    @PutMapping("/historial/{historialId}")
    public HistorialResource updateHistorial(@PathVariable Long historialId, @RequestBody SaveHistorialResource resource) {
        Historial historial = convertToEntity(resource);
        return convertToResource(historialService.updateHistorial(historialId,historial));
    }

    @Operation(summary = "Delete Historial", description = "Delete an existing Historial using its id", tags = {"historiales"})
    @DeleteMapping("/historiales/{historialId}")
    public ResponseEntity<?> deleteHistorial(@PathVariable Long historialId){
        return historialService.deleteHistorial(historialId);
    }

    private Historial convertToEntity(SaveHistorialResource resource) {
        return mapper.map(resource, Historial.class);
    }

    private HistorialResource convertToResource(Historial entity){ return mapper.map(entity, HistorialResource.class);}
}
