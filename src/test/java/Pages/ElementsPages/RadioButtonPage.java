package Pages.ElementsPages;

import Pages.DashboardPage;
import Pages.ElementsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
public class RadioButtonPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private DashboardPage dashboardPage;
    private ElementsPage elementsPage;
    public RadioButtonPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        dashboardPage = new DashboardPage(driver);
        elementsPage = new ElementsPage(driver);
    }
    By Yes_btn = By.xpath("//label[normalize-space()='Yes']");
    By Impressive_btn = By.xpath("//label[normalize-space()='Impressive']");
    By NO_btn = By.xpath("//label[normalize-space()='No']");
    By Radio_TextOutput = By.xpath("//span[@class='text-success']");
    public void clickYes(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(Yes_btn));
        driver.findElement(Yes_btn).click();
    }
    public boolean IsYesSelected(){
        Assert.assertEquals(driver.findElement(Radio_TextOutput).getText(),"Yes");
        return driver.findElement(Yes_btn).isSelected();
    }
    public void clickImpressive(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(Impressive_btn));
        driver.findElement(Impressive_btn).click();
    }
    public boolean IsImpressiveSelected(){
        Assert.assertEquals(driver.findElement(Radio_TextOutput).getText(),"Impressive");
        return driver.findElement(Impressive_btn).isSelected();
    }
    public void NoCannotSelected(){
        driver.findElement(NO_btn).click();
        Assert.assertEquals(driver.findElement(Radio_TextOutput).getText(),"Impressive");
    }
}
