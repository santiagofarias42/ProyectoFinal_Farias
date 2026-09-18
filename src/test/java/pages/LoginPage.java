package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    private By campoUsuario = By.name("username");
    private By campoPassword = By.name("password");
    private By botonLogin = By.cssSelector("button[type='submit']");
    private By mensajeError = By.className("oxd-alert-content-text");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void goTo() {
        driver.get("https://opensource-demo.orangehrmlive.com/");
    }

    public void enterUserName(String usuario) {
        type(campoUsuario, usuario);
    }

    public void enterPassword(String password) {
        type(campoPassword, password);
    }

    public void loginAs(String usuario, String password) {
        enterUserName(usuario);
        enterPassword(password);
        click(botonLogin);
    }

    // Verifica si estamos en la página de login (esperando a que cargue)
    public boolean isOnLoginPage() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(campoUsuario));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isErrorDisplayed() {
        return isElementVisible(mensajeError);
    }
}