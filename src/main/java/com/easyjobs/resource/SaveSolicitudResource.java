package com.easyjobs.resource;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SaveSolicitudResource {

    @NotNull
    @NotBlank
    @Size(max = 25)
    private String typo;

    @NotNull
    @NotBlank
    private Float monto;

    @NotNull
    @NotBlank
    @Size(max = 25)
    private String tipoPago;

    public String getTypo() {
        return typo;
    }

    public void setTypo(String typo) {
        this.typo = typo;
    }

    public Float getMonto() {
        return monto;
    }

    public void setMonto(Float monto) {
        this.monto = monto;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }
}
