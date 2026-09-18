package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {

    // Este WebDriver va a ser compartido por todos los Steps
    public static WebDriver driver;

    @Before
    public void setUp() {
        // WebDriverManager detecta tu Chrome y descarga el driver correcto automáticamente
        WebDriverManager.chromedriver().setup();

        // Se ejecuta ANTES de cada escenario: abre el navegador
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        // Se ejecuta DESPUÉS de cada escenario: cierra el navegador
        if (driver != null) {
            driver.quit();
        }
    }
}