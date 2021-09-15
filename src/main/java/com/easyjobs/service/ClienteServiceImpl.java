package com.easyjobs.service;

import com.easyjobs.domain.model.Cliente;
import com.easyjobs.domain.repository.ClienteRepository;
import com.easyjobs.domain.repository.CuentaRepository;
import com.easyjobs.domain.service.ClienteService;
import com.easyjobs.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private CuentaRepository cuentaRepository;

    @Override
    public Page<Cliente> getAllClientes (Pageable pageable){
        return clienteRepository.findAll(pageable);
    }

    @Override
    public Cliente getClienteById (Long clienteId){
        return clienteRepository.findById(clienteId)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente", "Id", clienteId));
    }

    @Override
    public Cliente getClienteByCuentaId (Long cuentaId){
        return clienteRepository.findByCuentaId(cuentaId)
                .orElseThrow(() -> new ResourceNotFoundException("Cuenta", "Id", cuentaId));

    }

    @Override
    public Cliente createCliente (Long cuentaId, Cliente cliente){
        return cuentaRepository.findById(cuentaId).map(cuenta -> {
            cliente.setCuenta(cuenta);
            return clienteRepository.save(cliente);
        }).orElseThrow(() -> new ResourceNotFoundException(
                "Cuenta", "Id", cuentaId));
    }

    @Override
    public Cliente updateCliente (Long cuentaId, Long clienteId, Cliente clienteRequest){
        if (!cuentaRepository.existsById(cuentaId))
            throw new ResourceNotFoundException("Cuenta", "Id", cuentaId);
        return clienteRepository.findById(clienteId).map(cliente -> {
            cliente.setNombre(clienteRequest.getNombre());
            cliente.setApellido(clienteRequest.getApellido());
            cliente.setTelefono(clienteRequest.getTelefono());
            cliente.setDistrito(clienteRequest.getDistrito());
            cliente.setMetodoPago(clienteRequest.getMetodoPago());
            return clienteRepository.save(cliente);
        }).orElseThrow(() -> new ResourceNotFoundException("Cliente", "Id", clienteId));

    }

    @Override
    public ResponseEntity<?> deleteCliente(Long cuentaId, Long clienteId){
        if (!cuentaRepository.existsById(cuentaId))
            throw new ResourceNotFoundException("Cuenta", "Id", cuentaId);
        return clienteRepository.findById(clienteId).map(cliente -> {
            clienteRepository.delete(cliente);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Cliente", "Id", clienteId));

    }
}
