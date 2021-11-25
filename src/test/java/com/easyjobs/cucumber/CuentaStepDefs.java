package com.easyjobs.cucumber;

import com.easyjobs.domain.model.Cuenta;
import com.easyjobs.domain.repository.CuentaRepository;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class CuentaStepDefs {

    @Given("a user inserts valid attributes")
    public void a_user_inserts_valid_attributes() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("the user click the submit button")
    public void the_user_click_the_submit_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("a new cuenta is created")
    public void a_new_cuenta_is_created() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

  /*
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CuentaRepository cuentaRepository;

    @Autowired
    private ModelMapper modelMapper;

    private Cuenta cuenta;

    private final String url = "http://localhost:8080";

    @Before
    public void setup()
    {
        restTemplate = new RestTemplate();
        cuenta = new Cuenta();
    }

    @Given("a user inserts valid attributes")
    public void aUserInsertsValidAttributes() {
        String email = "fake@gmail.com";
        String password = "fake1231pass";
        String tipoCliente = "cliente";
        String username = "juanG";

        this.cuenta.setId(1L);
        this.cuenta.setEmail(email);
        this.cuenta.setTipoCuenta(tipoCliente);
        this.cuenta.setUsername(username);
        restTemplate.postForEntity(url + "/cuentas", cuenta, Cuenta.class);

    }

    @When("the user click the submit button")
    public void theUserClickTheSubmitButton() {
    }

    @Then("a new cuenta is created")
    public void aNewCuentaIsCreated() {
        Assertions.assertEquals(this.restTemplate.getForEntity( url +  "/cuentas", Cuenta.class), cuenta);
    }
    */
}
