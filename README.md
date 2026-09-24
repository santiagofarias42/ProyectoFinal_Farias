🧪 ProyectoFinal_Farias — Test Automation E2E | OrangeHRM
Proyecto integrador del curso de Test Automation (ICARO – UNC/FCEFyN), donde automatizo un flujo completo end-to-end sobre la demo pública de OrangeHRM, aplicando buenas prácticas de la industria: Page Object Model, BDD con Cucumber y ejecución con TestNG.
🎯 Flujo automatizado
Login → Dashboard → Búsqueda de empleado (PIM) → Logout
🛠️ Stack técnico

* Java 11
* Selenium WebDriver 4.40.0 — control del navegador
* Cucumber — BDD, escenarios en lenguaje natural (Gherkin)
* TestNG — ejecución y reporte de pruebas
* WebDriverManager — gestión automática del driver del navegador
* Maven — gestión de dependencias y build

🏗️ Arquitectura
Implementado con Page Object Model (POM) y herencia:

```
BasePage (clase base con acciones y esperas reutilizables)
   ├── LoginPage
   ├── DashboardPage
   └── PIMPage

```

`BasePage` centraliza las acciones comunes (`click`, `type`, `getText`, esperas explícitas con `WebDriverWait`), evitando duplicar código en cada página y facilitando el mantenimiento si la UI cambia.
✅ Escenarios cubiertos (Gherkin)

```gherkin
Feature: Flujo completo en OrangeHRM

  Scenario: Login exitoso
  Scenario: Buscar empleado
  Scenario: Flujo completo E2E

```

📁 Estructura del proyecto

```
src/test/java/
├── pages/            → Page Objects (BasePage, LoginPage, DashboardPage, PIMPage)
├── stepdefinitions/  → Hooks + Step Definitions
└── runners/          → TestRunner (Cucumber + TestNG)
src/test/resources/
└── features/         → flujo_completo.feature

```

▶️ Cómo ejecutarlo

```bash
mvn clean test

```

o ejecutando `testng.xml` directamente desde el IDE.
📌 Aprendizajes clave

* Diseño de un framework de automatización mantenible con POM
* Escritura de escenarios BDD legibles para stakeholders no técnicos
* Manejo de esperas explícitas para interfaces dinámicas
* Integración de Cucumber + TestNG + Selenium en un mismo proyecto Maven
