Feature: historial feature

  Scenario: A cliente wants to look up all hes requested services
    Given a cliente has requested sevices in the past
    When the cliente goes to the history view
    Then he will be able to see all the requested services in the history