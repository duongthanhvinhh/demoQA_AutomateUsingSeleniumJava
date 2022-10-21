package Pages;

import com.aventstack.extentreports.gherkin.model.But;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

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
        driver.findElement(TextBox_btn).click();
    }
    public void accessTextBoxSuccessfully(){
        Assert.assertEquals(driver.getCurrentUrl(),"https://demoqa.com/text-box");
    }
    public void clickCheckBox(){
        driver.findElement(CheckBox_btn).click();
    }
    public void accessCheckBoxSuccessfully(){
        Assert.assertEquals(driver.getCurrentUrl(),"https://demoqa.com/checkbox");
    }
    public void clickRadioButton(){
        driver.findElement(RadioButton_btn).click();
    }
    public void accessRadioButtonSuccessfully(){
        Assert.assertEquals(driver.getCurrentUrl(),"https://demoqa.com/radio-button");
    }
    public void clickWebTables(){
        driver.findElement(WebTables_btn).click();
    }
    public void accessWebTablesSuccessfully(){
        Assert.assertEquals(driver.getCurrentUrl(),"https://demoqa.com/webtables");
    }
    public void clickButtons(){
        driver.findElement(Buttons_btn).click();
    }

    public void accessButtonsSuccessfully(){
        Assert.assertEquals(driver.getCurrentUrl(),"https://demoqa.com/buttons");
    }
    public void clickLinks(){
        driver.findElement(Links_btn).click();
    }
    public void accessLinksSuccessfully(){
        Assert.assertEquals(driver.getCurrentUrl(),"https://demoqa.com/links");
    }
    public void clickBrokenLinks_Images(){
        driver.findElement(BrokenLinks_Images_btn).click();
    }
    public void accessBrokenLinksImagesSuccessfully(){
        Assert.assertEquals(driver.getCurrentUrl(),"https://demoqa.com/broken");
    }
    public void clickUploadAndDownload(){
        driver.findElement(UploadAndDownload_btn).click();
    }
    public void accessUploadAndDownloadSuccessfully(){
        Assert.assertEquals(driver.getCurrentUrl(),"https://demoqa.com/upload-download");
    }
    public void clickDynamicProperties(){
        driver.findElement(DynamicProperties_btn).click();
    }
    public void accessDynamicsPropertiesSuccessfully(){
        Assert.assertEquals(driver.getCurrentUrl(),"https://demoqa.com/dynamic-properties");
    }
}
