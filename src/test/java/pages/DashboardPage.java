package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DashboardPage extends BasePage {

    // Ubicaciones de los elementos del Dashboard
    private By linkPIM = By.linkText("PIM");
    private By dropdownUsuario = By.className("oxd-userdropdown-tab");
    private By linkLogout = By.linkText("Logout");
    private By tituloHeader = By.cssSelector("h6.oxd-topbar-header-breadcrumb-module");

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    // Navega al módulo PIM
    public void goToPIM() {
        click(linkPIM);
    }

    // Hace logout: primero abre el menú del usuario, después hace click en "Logout"
    public void logout() {
        click(dropdownUsuario);
        click(linkLogout);
    }

    // Verifica si estamos en el Dashboard (esperando a que el título aparezca)
    public boolean isOnDashboard() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(tituloHeader));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Obtiene el texto del header (título de la sección actual)
    public String getHeaderText() {
        return getText(tituloHeader);
    }
}