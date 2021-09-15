package com.easyjobs.domain.service;

import com.easyjobs.domain.model.Tecnico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface TecnicoService {

    Page<Tecnico> getAllTecnicos (Pageable pageable);

    Tecnico getTecnicoById (Long tecnicoId);

    Tecnico getTecnicoByDni (Long dni);

    Tecnico getTecnicoByCuentaId (Long cuentaId);

    Tecnico createTecnico (Long cuentaId, Tecnico tecnico);

    Tecnico updateTecnico (Long cuentaId, Long tecnicoId, Tecnico tecnicoRequest);

    ResponseEntity<?> deleteTecnico(Long cuentaId, Long tecnicoId);

}
