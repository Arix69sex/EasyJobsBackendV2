package com.easyjobs.resource;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SaveDetalleResource {

    @NotNull
    @NotBlank
    @Size(max = 100)
    private String descripcion;

    @NotNull
    @NotBlank
    @Size(max = 25)
    private String valoracion;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getValoracion() {
        return valoracion;
    }

    public void setValoracion(String valoracion) {
        this.valoracion = valoracion;
    }
}
