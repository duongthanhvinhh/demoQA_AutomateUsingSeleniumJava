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
        wait.until(ExpectedConditions.visibilityOfElementLocated(FullName_input));
        driver.findElement(FullName_input).sendKeys(fullName);
    }

    public void inputEmail(String email){
        wait.until(ExpectedConditions.visibilityOfElementLocated(Email_input));
        driver.findElement(Email_input).sendKeys(email);
    }

    public void inputCurrentAddress(String currentAddress){
        wait.until(ExpectedConditions.visibilityOfElementLocated(CurrentAddress_input));
        driver.findElement(CurrentAddress_input).sendKeys(currentAddress);
    }

    public void inputPermanentAddress(String permanentAddress){
        wait.until(ExpectedConditions.visibilityOfElementLocated(PermanentAddress_input));
        driver.findElement(PermanentAddress_input).sendKeys(permanentAddress);
    }
    public void clickSubmit(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(Submit_btn));
        driver.findElement(Submit_btn).click();
    }
    public boolean FullNameDisplayed(){
        if (driver.getPageSource().contains("Name:")){
            return true;
        }else return false;
    }
    public String FullNameValueAdded(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(FullName_result));
        Assert.assertTrue(driver.findElement(FullName_result).isDisplayed());
        return driver.findElement(FullName_result).getText();
    }

    public boolean EmailDisplayed(){
        if (driver.getPageSource().contains("Email:")){
            return true;
        }else return false;
    }
    public String EmailValueAdded(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(Email_result));
        Assert.assertTrue(driver.findElement(Email_result).isDisplayed());
        return driver.findElement(Email_result).getText();
    }
    public boolean CurrentAddressDisplayed(){
        if (driver.getPageSource().contains("Current Address :")){
            return true;
        }else return false;
    }
    public String CurrentAddressValueAdded(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(CurrentAddress_result));
        Assert.assertTrue(driver.findElement(CurrentAddress_result).isDisplayed());
        return driver.findElement(CurrentAddress_result).getText();
    }
    public boolean PermanentAddressDisplayed(){
            if (driver.getPageSource().contains("Permananet Address :")){
                return true;
            }else return false;
    }
    public String PermanentAddressValueAdded(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(PermanentAddress_result));
        Assert.assertTrue(driver.findElement(PermanentAddress_result).isDisplayed());
        return driver.findElement(PermanentAddress_result).getText();
    }

}

