package com.easyjobs.unit;

import com.easyjobs.domain.model.Detalle;
import com.easyjobs.domain.model.Historial;
import com.easyjobs.domain.model.Solicitud;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HistorialTest {

    @Test
    @DisplayName("When Create a Detalle with Valid Categoria Then Returns Repective Historial")
    public void whenCreateDetalleWithValidSolicitudGetADetalle(){
        Historial historial = new Historial();
        String categoria = "Test categoria";

        historial.setCategoria(categoria);

        Assertions.assertEquals(categoria, historial.getCategoria());
    }
}
