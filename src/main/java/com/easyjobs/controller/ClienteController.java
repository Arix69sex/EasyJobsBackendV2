package com.easyjobs.controller;

import com.easyjobs.domain.model.Cliente;
import com.easyjobs.domain.service.ClienteService;
import com.easyjobs.resource.ClienteResource;
import com.easyjobs.resource.SaveClienteResource;
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
public class ClienteController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private ClienteService clienteService;

    @Operation(summary = "Get all Clientes", description = "Get all Clientes", tags = {"clientes"})
    @GetMapping("/cuentas/clientes")
    public Page<ClienteResource> getAllClientes(Pageable pageable){
        Page<Cliente> clientePage = clienteService.getAllClientes(pageable);
        List<ClienteResource> resources = clientePage.getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @Operation(summary = "Get Cliente by CuentaId", description = "Get Cliente by CuentaId", tags = {"clientes"})
    @GetMapping("/cuentas/{cuentaId}/clientes")
    public ClienteResource getClienteByCuentaId(@PathVariable Long cuentaId, Pageable pageable){
        return convertToResource(clienteService.getClienteByCuentaId(cuentaId));
    }

    @Operation(summary = "Get Cliente by its Id", description = "Get Cliente its Id", tags = {"clientes"})
    @GetMapping("/clientes/{clienteId}")
    public ClienteResource getClienteById(@PathVariable Long clienteId){
        return convertToResource(clienteService.getClienteById(clienteId));
    }

    @Operation(summary = "Create Cliente", description = "Create a new Cliente", tags = {"clientes"})
    @PostMapping("/cuentas/{cuentaId}/clientes")
    public ClienteResource createService(@PathVariable Long cuentaId, @Valid @RequestBody SaveClienteResource resource){
        Cliente cliente = convertToEntity(resource);
        return convertToResource(clienteService.createCliente(cuentaId,cliente));
    }

    @Operation(summary = "Update a Cliente", description = "Update an existing Cliente with given CuentaId", tags = {"clientes"})
    @PutMapping("/clientes/{userId}/tecnicos")
    public ClienteResource updateCliente(@PathVariable Long cuentaId, @Valid @RequestBody SaveClienteResource resource) {
        Cliente cliente = convertToEntity(resource);
        return convertToResource(clienteService.updateCliente(cuentaId, cliente.getId(), cliente));
    }

    @Operation(summary = "Delete a Service", description = "Delete an existing Service with given Id", tags = {"clientes"})
    @DeleteMapping("/clientes/{cuentaId}/service/{serviceId}")
    public ResponseEntity<?> deleteCliente(@PathVariable Long cuentaId, @PathVariable Long clienteId) {
        return clienteService.deleteCliente(cuentaId, clienteId);
    }

    private Cliente convertToEntity(SaveClienteResource resource) {
        return mapper.map(resource, Cliente.class);
    }

    private ClienteResource convertToResource(Cliente entity){
        return mapper.map(entity, ClienteResource.class);
    }

}
