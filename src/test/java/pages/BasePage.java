package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    // Constructor: se ejecuta cuando creamos una BasePage (o una que hereda de ella)
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // Hace click en un elemento, esperando primero a que sea clickeable
    public void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    // Escribe texto en un campo, esperando primero a que sea visible
    public void type(By locator, String texto) {
        WebElement elemento = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        elemento.clear();
        elemento.sendKeys(texto);
    }

    // Obtiene el texto de un elemento
    public String getText(By locator) {
        WebElement elemento = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return elemento.getText();
    }

    // Verifica si un elemento está visible en pantalla
    public boolean isElementVisible(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Espera hasta que la URL actual contenga un texto determinado
    public void waitForUrlContains(String textoUrl) {
        wait.until(ExpectedConditions.urlContains(textoUrl));
    }

    // Espera hasta que un elemento desaparezca de la pantalla
    public void waitForElementToDisappear(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
}