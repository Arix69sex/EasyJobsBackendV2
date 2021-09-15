package com.easyjobs.domain.repository;

import com.easyjobs.domain.model.Historial;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistorialRepository extends JpaRepository<Historial, Long> {
    Page<Historial> findAllByCategoria (String categoria, Pageable pageable);
}
