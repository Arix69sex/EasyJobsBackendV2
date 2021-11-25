Feature: solicitud feature

  Scenario: A cliente requests a tecnico
    Given A cliente wants to request a tecnico
    When the cliente clicks the request button
    Then a Solicitud between the cliente and the tecnico is created