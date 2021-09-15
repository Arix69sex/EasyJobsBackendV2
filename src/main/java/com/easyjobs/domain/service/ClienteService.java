package com.easyjobs.domain.service;

import com.easyjobs.domain.model.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface ClienteService {

    Page<Cliente> getAllClientes (Pageable pageable);

    Cliente getClienteById (Long clienteId);

    Cliente getClienteByCuentaId (Long cuentaId);

    Cliente createCliente (Long cuentaId, Cliente cliente);

    Cliente updateCliente (Long cuentaId, Long clienteId, Cliente clienteRequest);

    ResponseEntity<?> deleteCliente(Long cuentaId, Long clienteId);

}
