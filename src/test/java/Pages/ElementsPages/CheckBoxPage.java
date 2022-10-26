package Pages.ElementsPages;

import Pages.DashboardPage;
import Pages.ElementsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Objects;

import static Common.extentReport.ExtentTestManager.reporterLog;

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

    By HomeBox = By.xpath("//span[@class='rct-checkbox']//*[name()='svg']");
    By expandHomeBox = By.xpath("//button[@title='Toggle']//*[name()='svg']");
    By HomeBoxResultElement = By.xpath("//div[@id='result']//span[2]");
    String HomeBoxMessage = "home";

    By expandDocumentBox = By.xpath("//ol/child::li[2]/descendant::button");
    By OfficeBox = By.xpath("//input[@id='tree-node-office']//following-sibling::span[@class='rct-checkbox']");
    By OfficeBoxMessageElement = By.xpath("//div[@id='result']/span[2]");
    String OfficeBoxMessage = "office";

    public void checkHomeBox(){
        reporterLog("Wait for HomeBox displayed");
        wait.until(ExpectedConditions.visibilityOfElementLocated(HomeBox));
        reporterLog("Click HomeBox Button");
        driver.findElement(HomeBox).click();
    }
    public void IsHomeBoxChecked(){
//        if (driver.findElement(HomeBoxResultElement).getText()=="home"&&driver.findElement(HomeBox).isSelected()){
//            return true;
//        }else return false;
        reporterLog("Verify HomeBoxResult element is displayed");
        Assert.assertTrue(driver.findElement(HomeBoxResultElement).isDisplayed());
        reporterLog("Verify HomeBox text output is correct");
        Assert.assertTrue(driver.findElement(HomeBoxResultElement).getText().equals("home"));
    }

    public void clickExpandHomeBox(){
        reporterLog("Click expand HomeBox");
        driver.findElement(expandHomeBox).click();
    }
    public void clickExpandDocumentBox(){
        reporterLog("Click expand DocumentBox");
        driver.findElement(expandDocumentBox).click();
    }
    public void checkOfficeBox(){
        reporterLog("Wait for OfficeBox displayed");
        wait.until(ExpectedConditions.visibilityOfElementLocated(OfficeBox));
        reporterLog("Click OfficeBox Button");
        driver.findElement(OfficeBox).click();
    }
    public void IsOfficeBoxChecked(){
        reporterLog("Verify OfficeBox Message is displayed");
        Assert.assertTrue(driver.findElement(OfficeBoxMessageElement).isDisplayed());
        reporterLog("Verify OfficeBox Message is correct");
        Assert.assertTrue(driver.findElement(OfficeBoxMessageElement).getText().equals(OfficeBoxMessage));
    }
}
