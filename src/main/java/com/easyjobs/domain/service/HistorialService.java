package com.easyjobs.domain.service;

import com.easyjobs.domain.model.Historial;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface HistorialService {

    Page<Historial> getAllHitoriales (Pageable pageable);

    Historial getHistorialById (Long historialId);

    Page<Historial> getAllHitorialesByCategoria (String categoria, Pageable pageable);

    Historial createHistorial (Historial historial);

    Historial updateHistorial(Long historialId, Historial historialRequest);

    ResponseEntity<?> deleteHistorial(Long historialId);

}
