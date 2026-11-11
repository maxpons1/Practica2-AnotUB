Feature: US3 - Llistar tasques disponibles per expertesa

  Scenario: L'anotadora satisfà l'expertesa per diversos conjunts de dades
    Given l'usuari "maria" està registrat com a anotadora amb expertesa "CAT"
    And hi ha una tasca "T1" que requereix expertesa "CAT"
    And hi ha una tasca "T2" que requereix expertesa "CAT"
    And hi ha una tasca "T3" que requereix expertesa "MAT"
    When l'usuari "maria" demana veure les tasques disponibles
    Then el sistema li mostra les tasques "T1" i "T2"
    And el sistema no li mostra la tasca "T3"