package Pages.ElementsPages;

import Pages.DashboardPage;
import Pages.ElementsPage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class UploadDownloadPage {

    private WebDriverWait wait;
    private WebDriver driver;
    private DashboardPage dashboardPage;
    private ElementsPage elementsPage;
    public UploadDownloadPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        dashboardPage = new DashboardPage(driver);
        elementsPage = new ElementsPage(driver);
    }
    By Download_btn = By.id("downloadButton");
    By UploadFile_btn = By.id("uploadFile");
    By UploadedFilePath = By.id("uploadedFilePath");
    public void clickUploadFileAndVerifyUploadSuccess(String filePath,String fileName){
        wait.until(ExpectedConditions.visibilityOfElementLocated(UploadFile_btn));
        driver.findElement(UploadFile_btn).sendKeys(filePath+fileName);
        Assert.assertEquals(driver.findElement(UploadedFilePath).getText(),"C:\\fakepath\\"+ fileName);
    }

    public void clickDownloadFileAndVerifyDownloadSuccess(String filePath,String fileName){
        wait.until(ExpectedConditions.visibilityOfElementLocated(Download_btn));
        driver.findElement(Download_btn).click();
        File fileDownloaded = new File(filePath + fileName);
        Assert.assertTrue(fileDownloaded.exists());
        if (fileDownloaded.exists()){
            try {
                FileUtils.delete(fileDownloaded);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
