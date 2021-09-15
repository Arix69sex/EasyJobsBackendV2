package com.easyjobs.domain.service;

import com.easyjobs.domain.model.Cuenta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;


public interface CuentaService {

    Page<Cuenta> getAllCuentas (Pageable pageable);

    Page<Cuenta> getAllCuentasByTipo (Pageable pageable, String tipo);

    Cuenta getCuentaById (Long cuentaId);

    Cuenta getCuentaByEmail (String email);

    Cuenta getCuentaByUsername (String username);

    Cuenta createCuenta (Cuenta cuenta);

    Cuenta updateCuenta (Long cuentaId, Cuenta cuentaRequest);

    ResponseEntity<?> deleteCuenta(Long cuentaId);
}
