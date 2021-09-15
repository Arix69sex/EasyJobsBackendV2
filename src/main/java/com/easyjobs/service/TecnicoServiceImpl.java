package com.easyjobs.service;

import com.easyjobs.domain.model.Tecnico;
import com.easyjobs.domain.repository.CuentaRepository;
import com.easyjobs.domain.repository.TecnicoRepository;
import com.easyjobs.domain.service.TecnicoService;
import com.easyjobs.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TecnicoServiceImpl implements TecnicoService {

    @Autowired
    private TecnicoRepository tecnicoRepository;

    @Autowired
    private CuentaRepository cuentaRepository;

    @Override
    public Page<Tecnico> getAllTecnicos (Pageable pageable){
        return tecnicoRepository.findAll(pageable);
    }

    @Override
    public Tecnico getTecnicoById (Long tecnicoId){
        return tecnicoRepository.findById(tecnicoId)
                .orElseThrow(() -> new ResourceNotFoundException("Tecnico", "Id", tecnicoId));
    }

    @Override
    public Tecnico getTecnicoByCuentaId (Long cuentaId){
        return tecnicoRepository.findByCuentaId(cuentaId)
                .orElseThrow(() -> new ResourceNotFoundException("Cuenta", "Id", cuentaId));

    }

    @Override
    public Tecnico getTecnicoByDni (Long Dni){
        return tecnicoRepository.findByDni(Dni)
                .orElseThrow(() -> new ResourceNotFoundException("Tecnico", "Dni", Dni));

    }

    @Override
    public Tecnico createTecnico (Long cuentaId, Tecnico tecnico){
        return cuentaRepository.findById(cuentaId).map(cuenta -> {
            tecnico.setCuenta(cuenta);
            return tecnicoRepository.save(tecnico);
        }).orElseThrow(() -> new ResourceNotFoundException(
                "Cuenta", "Id", cuentaId));
    }

    @Override
    public Tecnico updateTecnico (Long cuentaId, Long tecnicoId, Tecnico tecnicoRequest){
        if (!cuentaRepository.existsById(cuentaId))
            throw new ResourceNotFoundException("Cuenta", "Id", cuentaId);
        return tecnicoRepository.findById(tecnicoId).map(tecnico -> {
            tecnico.setNombre(tecnicoRequest.getNombre());
            tecnico.setApellido(tecnicoRequest.getApellido());
            tecnico.setCiudad(tecnicoRequest.getCiudad());
            tecnico.setCV(tecnicoRequest.getCV());
            tecnico.setTelefono(tecnicoRequest.getTelefono());
            return tecnicoRepository.save(tecnico);
        }).orElseThrow(() -> new ResourceNotFoundException("Tecnico", "Id", tecnicoId));

    }

    @Override
    public ResponseEntity<?> deleteTecnico(Long cuentaId, Long tecnicoId){
        if (!cuentaRepository.existsById(cuentaId))
            throw new ResourceNotFoundException("Cuenta", "Id", cuentaId);
        return tecnicoRepository.findById(tecnicoId).map(tecnico -> {
            tecnicoRepository.delete(tecnico);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Tecnico", "Id", tecnicoId));

    }
}
