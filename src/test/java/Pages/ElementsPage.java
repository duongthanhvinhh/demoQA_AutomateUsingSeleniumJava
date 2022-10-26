package Pages;

import com.aventstack.extentreports.gherkin.model.But;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static Common.extentReport.ExtentTestManager.reporterLog;

public class ElementsPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private DashboardPage dashboardPage;

    public ElementsPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        dashboardPage = new DashboardPage(driver);
    }

    By TextBox_btn = By.xpath("//span[normalize-space()='Text Box']");
    By CheckBox_btn = By.xpath("//span[normalize-space()='Check Box']");
    By RadioButton_btn = By.xpath("//span[normalize-space()='Radio Button']");
    By WebTables_btn = By.xpath("//span[normalize-space()='Web Tables']");
    By Buttons_btn = By.xpath("//span[normalize-space()='Buttons']");
    By Links_btn = By.xpath("//span[normalize-space()='Links']");
    By BrokenLinks_Images_btn = By.xpath("//span[normalize-space()='Broken Links - Images']");
    By UploadAndDownload_btn = By.xpath("//span[normalize-space()='Upload and Download']");
    By DynamicProperties_btn = By.xpath("//span[normalize-space()='Dynamic Properties']");

    public void clickTextBox(){
        reporterLog("Wait for TextBox Button displayed");
        wait.until(ExpectedConditions.visibilityOfElementLocated(TextBox_btn));
        reporterLog("Click TextBox Button");
        driver.findElement(TextBox_btn).click();
    }
    public void accessTextBoxSuccessfully(){
        reporterLog("Verify access TextBox successfully");
        Assert.assertEquals(driver.getCurrentUrl(),"https://demoqa.com/text-box");
    }
    public void clickCheckBox(){
        reporterLog("Wait for CheckBox Button displayed");
        wait.until(ExpectedConditions.visibilityOfElementLocated(CheckBox_btn));
        reporterLog("Click CheckBox Button");
        driver.findElement(CheckBox_btn).click();
    }
    public void accessCheckBoxSuccessfully(){
        reporterLog("Verify access CheckBox successfully");
        Assert.assertEquals(driver.getCurrentUrl(),"https://demoqa.com/checkbox");
    }
    public void clickRadioButton(){
        reporterLog("Wait for Radio Button displayed");
        wait.until(ExpectedConditions.visibilityOfElementLocated(RadioButton_btn));
        reporterLog("Click Radio Button");
        driver.findElement(RadioButton_btn).click();
    }
    public void accessRadioButtonSuccessfully(){
        reporterLog("Verify access RadioButton successfully");
        Assert.assertEquals(driver.getCurrentUrl(),"https://demoqa.com/radio-button");
    }
    public void clickWebTables(){
        reporterLog("Wait for WebTables Button displayed");
        wait.until(ExpectedConditions.visibilityOfElementLocated(WebTables_btn));
        reporterLog("Click WebTables Button");
        driver.findElement(WebTables_btn).click();
    }
    public void accessWebTablesSuccessfully(){
        reporterLog("Verify access WebTables successfully");
        Assert.assertEquals(driver.getCurrentUrl(),"https://demoqa.com/webtables");
    }
    public void clickButtons(){
        reporterLog("Wait for Buttons Button displayed");
        wait.until(ExpectedConditions.visibilityOfElementLocated(Buttons_btn));
        reporterLog("Click Buttons Button");
        driver.findElement(Buttons_btn).click();
    }

    public void accessButtonsSuccessfully(){
        reporterLog("Verify access Buttons successfully");
        Assert.assertEquals(driver.getCurrentUrl(),"https://demoqa.com/buttons");
    }
    public void clickLinks(){
        reporterLog("Wait for Links Button displayed");
        wait.until(ExpectedConditions.visibilityOfElementLocated(Links_btn));
        reporterLog("Click Links Button");
        driver.findElement(Links_btn).click();
    }
    public void accessLinksSuccessfully(){
        reporterLog("Verify access Links successfully");
        Assert.assertEquals(driver.getCurrentUrl(),"https://demoqa.com/links");
    }
    public void clickBrokenLinks_Images(){
        reporterLog("Wait for BrokenLinksImages Button displayed");
        wait.until(ExpectedConditions.visibilityOfElementLocated(BrokenLinks_Images_btn));
        reporterLog("Click BrokenLinks Images successfully");
        driver.findElement(BrokenLinks_Images_btn).click();
    }
    public void accessBrokenLinksImagesSuccessfully(){
        reporterLog("Verify access BrokenLinksImages successfully");
        Assert.assertEquals(driver.getCurrentUrl(),"https://demoqa.com/broken");
    }
    public void clickUploadAndDownload() {
        reporterLog("Wait for UploadDownLoad Button displayed");
        wait.until(ExpectedConditions.visibilityOfElementLocated(UploadAndDownload_btn));
        reporterLog("Click UploadDownload Button");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", driver.findElement(UploadAndDownload_btn));
//        driver.findElement(UploadAndDownload_btn).click();
    }
    public void accessUploadAndDownloadSuccessfully(){
        reporterLog("Verify access UploadDownload successfully");
        Assert.assertEquals(driver.getCurrentUrl(),"https://demoqa.com/upload-download");
    }
    public void clickDynamicProperties(){
        reporterLog("Wait for DynamicProperties Button displayed");
        wait.until(ExpectedConditions.elementToBeClickable(DynamicProperties_btn));
        reporterLog("Click DynamicProperties");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", driver.findElement(DynamicProperties_btn));

//        driver.findElement(DynamicProperties_btn).click();
    }
    public void accessDynamicsPropertiesSuccessfully(){
        reporterLog("Verify access Properties successfully");
        Assert.assertEquals(driver.getCurrentUrl(),"https://demoqa.com/dynamic-properties");
    }
}
