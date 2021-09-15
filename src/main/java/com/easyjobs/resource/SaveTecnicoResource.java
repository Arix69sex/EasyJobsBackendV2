package com.easyjobs.resource;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SaveTecnicoResource {

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
    private Long dni;

    @NotNull
    @NotBlank
    @Size(max = 250)
    private String CV;

    @NotNull
    @NotBlank
    @Size(max = 15)
    private String telefono;

    @NotNull
    @NotBlank
    @Size(max = 25)
    private String ciudad;

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

    public Long getDni() {
        return dni;
    }

    public void setDni(Long dni) {
        this.dni = dni;
    }

    public String getCV() {
        return CV;
    }

    public void setCV(String CV) {
        this.CV = CV;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
}
