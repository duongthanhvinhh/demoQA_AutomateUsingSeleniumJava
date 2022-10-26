package Pages.ElementsPages;

import Common.BaseSetup;
import Pages.DashboardPage;
import Pages.ElementsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static Common.extentReport.ExtentTestManager.reporterLog;

public class TextBoxPage {
    private WebDriverWait wait;
    private WebDriver driver;
    private DashboardPage dashboardPage;
    private ElementsPage elementsPage;
    public TextBoxPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        dashboardPage = new DashboardPage(driver);
        elementsPage = new ElementsPage(driver);
    }
    By FullName_input = By.id("userName");
    By Email_input = By.id("userEmail");
    By CurrentAddress_input = By.id("currentAddress");
    By PermanentAddress_input = By.id("permanentAddress");
    By Submit_btn = By.id("submit");
    By FullName_result = By.id("name");
    By Email_result = By.id("email");
    By CurrentAddress_result = By.xpath("//p[@id='currentAddress']");
    By PermanentAddress_result = By.xpath("//p[@id='permanentAddress']");

    public void inputFullName(String fullName){
        reporterLog("Wait for fullName input field displayed");
        wait.until(ExpectedConditions.visibilityOfElementLocated(FullName_input));
        reporterLog("Input "+ fullName + " to fullName input field");
        driver.findElement(FullName_input).sendKeys(fullName);
    }

    public void inputEmail(String email){
        reporterLog("Wait for email input field displayed");
        wait.until(ExpectedConditions.visibilityOfElementLocated(Email_input));
        reporterLog("Input " + email + " ");
        driver.findElement(Email_input).sendKeys(email);
    }

    public void inputCurrentAddress(String currentAddress){
        reporterLog("Wait for currentAddress input field displayed");
        wait.until(ExpectedConditions.visibilityOfElementLocated(CurrentAddress_input));
        reporterLog("Input " + currentAddress + " to currentAddress input field");
        driver.findElement(CurrentAddress_input).sendKeys(currentAddress);
    }

    public void inputPermanentAddress(String permanentAddress){
        reporterLog("Wait for PermanentAddress input field displayed");
        wait.until(ExpectedConditions.visibilityOfElementLocated(PermanentAddress_input));
        reporterLog("Input " + permanentAddress + " to PermanentAddress input field");
        driver.findElement(PermanentAddress_input).sendKeys(permanentAddress);
    }
    public void clickSubmit(){
        reporterLog("Wait for Submit button displayed");
        wait.until(ExpectedConditions.visibilityOfElementLocated(Submit_btn));
        reporterLog("Click submit button");
        driver.findElement(Submit_btn).click();
    }
    public boolean FullNameDisplayed(){
        if (driver.getPageSource().contains("Name:")){
            return true;
        }else return false;
    }
    public String FullNameValueAdded(){
        reporterLog("Wait for fullName Result displayed");
        wait.until(ExpectedConditions.visibilityOfElementLocated(FullName_result));
        reporterLog("Verify fullName Result displayed");
        Assert.assertTrue(driver.findElement(FullName_result).isDisplayed());
        return driver.findElement(FullName_result).getText();
    }

    public boolean EmailDisplayed(){
        if (driver.getPageSource().contains("Email:")){
            return true;
        }else return false;
    }
    public String EmailValueAdded(){
        reporterLog("Wait for Email Result displayed");
        wait.until(ExpectedConditions.visibilityOfElementLocated(Email_result));
        reporterLog("Verify Email Result displayed");
        Assert.assertTrue(driver.findElement(Email_result).isDisplayed());
        return driver.findElement(Email_result).getText();
    }
    public boolean CurrentAddressDisplayed(){
        if (driver.getPageSource().contains("Current Address :")){
            return true;
        }else return false;
    }
    public String CurrentAddressValueAdded(){
        reporterLog("Wait for Current Address Result displayed");
        wait.until(ExpectedConditions.visibilityOfElementLocated(CurrentAddress_result));
        reporterLog("Verify Current Address Result displayed");
        Assert.assertTrue(driver.findElement(CurrentAddress_result).isDisplayed());
        return driver.findElement(CurrentAddress_result).getText();
    }
    public boolean PermanentAddressDisplayed(){
            if (driver.getPageSource().contains("Permananet Address :")){
                return true;
            }else return false;
    }
    public String PermanentAddressValueAdded(){
        reporterLog("Wait for Permanent Address Result displayed");
        wait.until(ExpectedConditions.visibilityOfElementLocated(PermanentAddress_result));
        reporterLog("Verify Permanent Address Result is displayed");
        Assert.assertTrue(driver.findElement(PermanentAddress_result).isDisplayed());
        return driver.findElement(PermanentAddress_result).getText();
    }
}

