package com.easyjobs.unit;

import com.easyjobs.domain.model.Detalle;
import com.easyjobs.domain.model.Historial;
import com.easyjobs.domain.model.Solicitud;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DetalleService {

    @Test
    @DisplayName("When Create a Detalle with Valid Solicitud And Historial Then Returns Repective Detalle")
    public void whenCreateDetalleWithValidSolicitudGetADetalle(){
        Detalle detalle = new Detalle();
        Solicitud solicitud = new Solicitud();
        Historial historial = new Historial();

        solicitud.setId(1l);
        historial.setId(1l);

        detalle.setSolicitud(solicitud);
        detalle.setHistorial(historial);

        Assertions.assertEquals(solicitud, detalle.getSolicitud());
        Assertions.assertEquals(historial, detalle.getHistorial());
    }

    @Test
    @DisplayName("When Create a Detalle with Valid Description Then Returns Repective Detalle")
    public void whenCreateDetalleWithValidDescriptionGetADetalle(){
        Detalle detalle = new Detalle();
        String description = "Test description";

        detalle.setDescripcion(description);

        Assertions.assertEquals(description, detalle.getDescripcion());
    }

    @Test
    @DisplayName("When Create a Detalle with Valid Valoracion Then Returns Repective Detalle")
    public void whenCreateDetalleWithValidValoracionGetADetalle(){
        Detalle detalle = new Detalle();
        String valoracion = "4.7";

        detalle.setValoracion(valoracion);

        Assertions.assertEquals(valoracion, detalle.getValoracion());
    }
}
