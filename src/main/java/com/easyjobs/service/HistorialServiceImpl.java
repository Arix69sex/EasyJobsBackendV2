package com.easyjobs.service;

import com.easyjobs.domain.model.Historial;
import com.easyjobs.domain.repository.HistorialRepository;
import com.easyjobs.domain.service.HistorialService;
import com.easyjobs.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class HistorialServiceImpl implements HistorialService {

    @Autowired
    private HistorialRepository historialRepository;

    @Override
    public Page<Historial> getAllHitoriales (Pageable pageable){
        return historialRepository.findAll(pageable);
    }

    @Override
    public Historial getHistorialById (Long historialId){
        return historialRepository.findById(historialId)
                .orElseThrow(() -> new ResourceNotFoundException("Historial", "Id", historialId));
    }

    @Override
    public Page<Historial> getAllHitorialesByCategoria (String categoria, Pageable pageable){
        return historialRepository.findAllByCategoria(categoria, pageable);
    }

    @Override
    public Historial createHistorial (Historial historial){
        return historialRepository.save(historial);
    }

    @Override
    public Historial updateHistorial(Long historialId, Historial historialRequest){
        Historial historial = historialRepository.findById(historialId)
                .orElseThrow(()->new ResourceNotFoundException("Historial","Id",historialId));
        historial.setCategoria(historialRequest.getCategoria());
        return historialRepository.save(historial);
    }

    @Override
    public ResponseEntity<?> deleteHistorial(Long historialId){
        Historial historial = historialRepository.findById(historialId)
                .orElseThrow(()->new ResourceNotFoundException("Historial","Id",historialId));
        historialRepository.delete(historial);
        return ResponseEntity.ok().build();
    }
}
