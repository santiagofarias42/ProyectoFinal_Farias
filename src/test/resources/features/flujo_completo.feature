Feature: Flujo completo en OrangeHRM

  Scenario: Login exitoso
    Given que estoy en la página de login de OrangeHRM
    When ingreso credenciales válidas
    Then debería ver el Dashboard

  Scenario: Buscar empleado
    Given que inicié sesión en OrangeHRM
    When navego al módulo PIM
    And busco al empleado "John"
    Then debería ver resultados de la búsqueda

  Scenario: Flujo completo E2E
    Given que inicié sesión en OrangeHRM
    When navego al módulo PIM
    And busco al empleado "John"
    And cierro sesión
    Then debería volver a la página de login