package Pages.ElementsPages;

import Pages.DashboardPage;
import Pages.ElementsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckBoxPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private DashboardPage dashboardPage;
    private ElementsPage elementsPage;
    public CheckBoxPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        dashboardPage = new DashboardPage(driver);
        elementsPage = new ElementsPage(driver);
    }
}
