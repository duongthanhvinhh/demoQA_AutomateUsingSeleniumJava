package Pages.ElementsPages;

import Pages.DashboardPage;
import Pages.ElementsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static Common.BaseSetup.sleep;
import static Common.extentReport.ExtentTestManager.reporterLog;

public class DynamicPropertiesPage {

    private WebDriverWait wait;
    private WebDriver driver;
    private DashboardPage dashboardPage;
    private ElementsPage elementsPage;
    public DynamicPropertiesPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        dashboardPage = new DashboardPage(driver);
        elementsPage = new ElementsPage(driver);
    }
    By enableAfter_btn = By.id("enableAfter");
    By colorChange_btn = By.id("colorChange");
    String originalColor = "rgba(255, 255, 255, 1)";
    String finalColor = "rgba(220, 53, 69, 1)";
    By visibleAfter = By.id("visibleAfter");
    public void verifyEnableAfter5S_button(){
        reporterLog("Set wait explicit to 4 seconds");
        wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        reporterLog("Wait for 4s, make sure enableAfter5S button still not enable");
        Assert.assertFalse(driver.findElement(enableAfter_btn).isEnabled());
        sleep(5000);
        reporterLog("Check if enableAfter 5s button displayed after 5s");
        Assert.assertTrue(driver.findElement(enableAfter_btn).isEnabled());
//        reporterLog("Set wait explicit to 5 seconds");
//        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//        reporterLog("Wait in 5s for enableAfter5S button enable");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(enableAfter_btn));
//        reporterLog("Verify EnableAfter5s button is displayed when the time still not reach 5s");
////        Assert.assertTrue(driver.findElement(enableAfter_btn).isDisplayed());
//        Assert.assertTrue(driver.findElement(enableAfter_btn).isEnabled());
    }

    public String getColorTextOfButtonColorChange() {
        return driver.findElement(colorChange_btn).getCssValue("color");
//        System.out.println(driver.findElement(colorChange_btn).getCssValue("color"));
    }
    public void verifyOriginalColorCorrect(){
        Assert.assertEquals(getColorTextOfButtonColorChange(),originalColor);
    }
    public void verifyfinalColorCorrect(){
        sleep(7000);
        Assert.assertEquals(getColorTextOfButtonColorChange(),finalColor);
    }
}
