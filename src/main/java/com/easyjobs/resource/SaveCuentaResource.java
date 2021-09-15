package com.easyjobs.resource;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SaveCuentaResource {

    @Size(max = 25)
    private String TipoCuenta;

    @NotNull
    @NotBlank
    @Size(max = 50)
    private String Email;

    @NotNull
    @NotBlank
    @Size(max = 25)
    private String Password;

    @NotNull
    @NotBlank
    @Size(max = 25)
    private String Username;

    public String getTipoCuenta() {
        return TipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        TipoCuenta = tipoCuenta;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }
}
