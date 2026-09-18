package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.LoginPage;
import pages.DashboardPage;
import pages.PIMPage;

public class FlujoPrincipalSteps {

    @Given("que estoy en la página de login de OrangeHRM")
    public void que_estoy_en_la_pagina_de_login() {
        LoginPage loginPage = new LoginPage(Hooks.driver);
        loginPage.goTo();
    }

    @When("ingreso credenciales válidas")
    public void ingreso_credenciales_validas() {
        LoginPage loginPage = new LoginPage(Hooks.driver);
        loginPage.loginAs("Admin", "admin123");
    }

    @Then("debería ver el Dashboard")
    public void deberia_ver_el_dashboard() {
        DashboardPage dashboardPage = new DashboardPage(Hooks.driver);
        dashboardPage.waitForUrlContains("dashboard");
        Assert.assertTrue(dashboardPage.isOnDashboard());
    }

    @Given("que inicié sesión en OrangeHRM")
    public void que_inicie_sesion_en_orangehrm() {
        LoginPage loginPage = new LoginPage(Hooks.driver);
        loginPage.goTo();
        loginPage.loginAs("Admin", "admin123");
    }

    @When("navego al módulo PIM")
    public void navego_al_modulo_pim() {
        DashboardPage dashboardPage = new DashboardPage(Hooks.driver);
        dashboardPage.goToPIM();
    }

    @When("busco al empleado {string}")
    public void busco_al_empleado(String nombre) {
        PIMPage pimPage = new PIMPage(Hooks.driver);
        pimPage.searchEmployeeByName(nombre);
    }

    @Then("debería ver resultados de la búsqueda")
    public void deberia_ver_resultados_de_la_busqueda() {
        PIMPage pimPage = new PIMPage(Hooks.driver);
        Assert.assertTrue(pimPage.hasResults());
    }

    @When("cierro sesión")
    public void cierro_sesion() {
        DashboardPage dashboardPage = new DashboardPage(Hooks.driver);
        dashboardPage.logout();
    }

    @Then("debería volver a la página de login")
    public void deberia_volver_a_la_pagina_de_login() {
        LoginPage loginPage = new LoginPage(Hooks.driver);
        Assert.assertTrue(loginPage.isOnLoginPage());
    }
}