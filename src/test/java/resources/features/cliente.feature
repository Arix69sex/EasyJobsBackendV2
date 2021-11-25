Feature: cliente feature

  Scenario: A Cliente account is created
    Given a cliente inserts valid attributes
    When the cliente  clicks the submit button
    Then a new Cliente account is created