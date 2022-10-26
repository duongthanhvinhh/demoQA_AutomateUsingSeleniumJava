package Pages.ElementsPages;
import Pages.DashboardPage;
import Pages.ElementsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

import static Common.extentReport.ExtentTestManager.reporterLog;

public class ButtonsPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private DashboardPage dashboardPage;
    private ElementsPage elementsPage;
    private Actions act;
    public ButtonsPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        dashboardPage = new DashboardPage(driver);
        elementsPage = new ElementsPage(driver);
        act = new Actions(driver);
    }
    By doubleClick_btn = By.id("doubleClickBtn");
    By rightClick_btn = By.id("rightClickBtn");
    By clickMe_btn = By.xpath("(//button[normalize-space()='Click Me'])[1]");
    By doubleClick_txt = By.id("doubleClickMessage");
    By rightClick_txt = By.id("rightClickMessage");
    By clickMe_txt = By.id("dynamicClickMessage");
    String doubleClickMessage = "You have done a double click";
    String rightClickMessage = "You have done a right click";
    String clickMeMessage = "You have done a dynamic click";
    public void clickDoubleClick(){
        reporterLog("Double click doubleClick Button");
        act.doubleClick(driver.findElement(doubleClick_btn)).perform();
    }
    public void IsDoubleClickSelected(){
        reporterLog("Verify doubleClick Button is double_clicked");
        Assert.assertEquals(driver.findElement(doubleClick_txt).getText(),doubleClickMessage);
    }
    public void clickRightClick(){
        reporterLog("Right click rightClick Button");
        act.contextClick(driver.findElement(rightClick_btn)).perform();
    }
    public void IsRightClickSelected(){
        reporterLog("Verify RightClick Button is right_clicked");
        Assert.assertEquals(driver.findElement(rightClick_txt).getText(),rightClickMessage);
    }
    public void clickClickMe(){
        reporterLog("Click clickMe Button");
        driver.findElement(clickMe_btn).click();
    }
    public void IsClickMeSelected(){
        reporterLog("Verify ClickMe Button is clicked");
        Assert.assertEquals(driver.findElement(clickMe_txt).getText(),clickMeMessage);
    }
}
