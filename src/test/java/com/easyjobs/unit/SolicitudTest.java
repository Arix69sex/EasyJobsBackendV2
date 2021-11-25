package com.easyjobs.unit;

import com.easyjobs.domain.model.Cliente;
import com.easyjobs.domain.model.Solicitud;
import com.easyjobs.domain.model.Tecnico;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SolicitudTest {

    @Test
    @DisplayName("When Create a Solicitud with Valid Amount type Then Returns Repective Solicitud")
    public void whenCreateSolicitudWithValidAmountGetASolicitud(){
        Solicitud solicitud = new Solicitud();
        solicitud.setMonto(80.f);

        Assertions.assertEquals(80.0f, solicitud.getMonto());
    }

    @Test
    @DisplayName("When Create a Solicitud with Valid Type Then Returns Repective Solicitud")
    public void whenCreateSolicitudWithValidTipoGetASolicitud(){
        Solicitud solicitud = new Solicitud();
        solicitud.setTipo("Gafitero");

        Assertions.assertEquals("Gafitero", solicitud.getTipo());
    }

    @Test
    @DisplayName("When Create a Solicitud with Valid Payment Type Then Returns Repective Solicitud")
    public void whenCreateSolicitudWithValidTipoPagoGetASolicitud(){
        Solicitud solicitud = new Solicitud();
        solicitud.setTipoPago("Credit");

        Assertions.assertEquals("Credit", solicitud.getTipoPago());
    }

    @Test
    @DisplayName("When Create a Solicitud with Valid Cliente and Tecnico Then Returns Repective Solicitud")
    public void whenCreateSolicitudWithValidClienteAndTecnicoGetASolicitud(){
        Solicitud solicitud = new Solicitud();
        Cliente cliente = new Cliente();
        Tecnico tecnico = new Tecnico();

        cliente.setId(1L);
        tecnico.setId(1L);
        solicitud.setTecnico(tecnico);
        solicitud.setCliente(cliente);

        Assertions.assertEquals(cliente, solicitud.getCliente());
        Assertions.assertEquals(tecnico, solicitud.getTecnico());
    }
}
