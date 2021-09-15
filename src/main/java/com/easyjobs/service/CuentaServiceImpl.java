package com.easyjobs.service;

import com.easyjobs.domain.model.Cuenta;
import com.easyjobs.domain.repository.CuentaRepository;
import com.easyjobs.domain.service.CuentaService;
import com.easyjobs.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class CuentaServiceImpl implements CuentaService {

    @Autowired
    private CuentaRepository cuentaRepository;

    @Override
    public Page<Cuenta> getAllCuentas (Pageable pageable){
        return cuentaRepository.findAll(pageable);
    }

    @Override
    public Page<Cuenta> getAllCuentasByTipo (Pageable pageable, String tipo){
        return cuentaRepository.findAllByTipoCuenta(tipo, pageable);
    }

    @Override
    public Cuenta getCuentaById (Long cuentaId)
    {
        return cuentaRepository.findById(cuentaId)
                .orElseThrow(()->new ResourceNotFoundException("Cuenta","Id", cuentaId));

    }

    @Override
    public Cuenta getCuentaByEmail (String email){
        return cuentaRepository.findByEmail(email)
                .orElseThrow(()->new ResourceNotFoundException("Cuenta","Email", email));

    }

    @Override
    public Cuenta getCuentaByUsername (String username){
        return cuentaRepository.findByUsername(username)
                .orElseThrow(()->new ResourceNotFoundException("Cuenta","Username", username));

    }

    @Override
    public Cuenta createCuenta (Cuenta cuenta){
        return cuentaRepository.save(cuenta);
    }

    @Override
    public Cuenta updateCuenta (Long cuentaId, Cuenta cuentaRequest){
        Cuenta cuenta = cuentaRepository.findById(cuentaId)
                .orElseThrow(()->new ResourceNotFoundException("Cuenta","Id",cuentaId));
        cuenta.setEmail(cuentaRequest.getEmail());
        cuenta.setUsername(cuentaRequest.getUsername());
        cuenta.setPassword(cuentaRequest.getPassword());
        cuenta.setTipoCuenta(cuentaRequest.getTipoCuenta());
        return cuentaRepository.save(cuenta);
    }

    @Override
    public ResponseEntity<?> deleteCuenta(Long cuentaId){
        Cuenta cuenta = cuentaRepository.findById(cuentaId)
                .orElseThrow(()->new ResourceNotFoundException("Cuenta","Id", cuentaId));
        cuentaRepository.delete(cuenta);
        return ResponseEntity.ok().build();
    }
}
