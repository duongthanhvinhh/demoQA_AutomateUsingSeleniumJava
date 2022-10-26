package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Common.extentReport.ExtentTestManager.reporterLog;

public class DashboardPage {
    private WebDriver driver;
    private WebDriverWait wait;
    public DashboardPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

//    By Elements_btn = By.xpath("//*[name()='path' and contains(@d,'M16 132h41')]");
    By Elements_btn = By.xpath("//h5[normalize-space()='Elements']");
    By Forms_btn = By.xpath("//div[@class='home-body']//div[2]//div[1]//div[2]//*[name()='svg']");
    By Alerts_Frame_Windows_btn = By.xpath("//div[3]//div[1]//div[2]//*[name()='svg']");
    By Widgets_btn = By.xpath("//div[4]//div[1]//div[2]//*[name()='svg']");
    By Interactions_btn = By.xpath("//*[name()='path' and contains(@d,'M880 112H1')]");
    By BookStoreApp_btn = By.xpath("//*[name()='path' and contains(@d,'M169 57v43')]");

    public void clickElements_btn(){
        reporterLog("Wait for Elements Button displayed");
        wait.until(ExpectedConditions.visibilityOfElementLocated(Elements_btn));
        reporterLog("Click Elements Button");
        driver.findElement(Elements_btn).click();
    }

    public void clickForms_btn(){
        reporterLog("Wait for Forms Button displayed");
        wait.until(ExpectedConditions.visibilityOfElementLocated(Forms_btn));
        reporterLog("Click Forms Button");
        driver.findElement(Forms_btn).click();
    }
    public void clickAlerts_Frame_Windows_btn(){
        reporterLog("Wait for AlertsFrameWindow Button displayed");
        wait.until(ExpectedConditions.visibilityOfElementLocated(Alerts_Frame_Windows_btn));
        reporterLog("Click AlertsFrameWindow Button");
        driver.findElement(Alerts_Frame_Windows_btn).click();
    }

    public void clickWidgets_btn(){
        reporterLog("Wait for Widgets Button displayed");
        wait.until(ExpectedConditions.visibilityOfElementLocated(Widgets_btn));
        reporterLog("Click Widgets Button");
        driver.findElement(Widgets_btn).click();
    }
    public void clickInteractions_btn(){
        reporterLog("Wait for Interactions Button displayed");
        wait.until(ExpectedConditions.visibilityOfElementLocated(Interactions_btn));
        reporterLog("Click Interactions Button");
        driver.findElement(Interactions_btn).click();
    }
    public void clickBookStoreApp_btn(){
        reporterLog("Wait for BookStoreApp Button displayed");
        wait.until(ExpectedConditions.visibilityOfElementLocated(BookStoreApp_btn));
        reporterLog("Click BookStoreApp Button");
        driver.findElement(BookStoreApp_btn).click();
    }
}
