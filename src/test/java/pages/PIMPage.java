package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PIMPage extends BasePage {

    // Ubicaciones de los elementos de la pantalla PIM
    private By campoBusquedaNombre = By.cssSelector("input[placeholder='Type for hints...']");
    private By botonBuscar = By.cssSelector("button[type='submit']");
    private By filasResultados = By.cssSelector(".oxd-table-card");
    private By mensajeSinResultados = By.className("oxd-text--span");
    private By tituloPIM = By.xpath("//h6[text()='PIM']");

    public PIMPage(WebDriver driver) {
        super(driver);
    }

    // Busca un empleado escribiendo su nombre y presionando el botón de buscar
    public void searchEmployeeByName(String nombre) {
        type(campoBusquedaNombre, nombre);
        click(botonBuscar);
    }

    // Verifica si la búsqueda trajo resultados (esperando a que aparezcan)
    public boolean hasResults() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(filasResultados));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Verifica si se muestra el mensaje de "no hay registros"
    public boolean isNoRecordsDisplayed() {
        return isElementVisible(mensajeSinResultados);
    }

    // Verifica si estamos en la pantalla de PIM
    public boolean isOnPIMPage() {
        return isElementVisible(tituloPIM);
    }
}