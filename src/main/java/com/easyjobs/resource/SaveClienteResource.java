package com.easyjobs.resource;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SaveClienteResource {

    @NotNull
    @NotBlank
    @Size(max = 25)
    private String nombre;

    @NotNull
    @NotBlank
    @Size(max = 25)
    private String apellido;

    @NotNull
    @NotBlank
    @Size(max = 25)
    private String telefono;

    @NotNull
    @NotBlank
    @Size(max = 25)
    private String metodoPago;

    @NotNull
    @NotBlank
    @Size(max = 50)
    private String distrito;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }
}
