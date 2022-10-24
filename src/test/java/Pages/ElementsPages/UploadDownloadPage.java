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

import static Common.BaseSetup.sleep;
import static Common.extentReport.ExtentTestManager.reporterLog;

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
        reporterLog("Wait for UploadFile button displayed");
        wait.until(ExpectedConditions.visibilityOfElementLocated(UploadFile_btn));
        reporterLog("Send filePath "+ filePath+fileName + "to upload the file");
        driver.findElement(UploadFile_btn).sendKeys(filePath+fileName);
        reporterLog("Verify File uploaded successfully");
        Assert.assertEquals(driver.findElement(UploadedFilePath).getText(),"C:\\fakepath\\"+ fileName);
    }

    public void clickDownloadFileAndVerifyDownloadSuccess(String filePath,String fileName){
        reporterLog("Wait for Download button displayed");
        wait.until(ExpectedConditions.visibilityOfElementLocated(Download_btn));
        reporterLog("Click Download button");
        driver.findElement(Download_btn).click();
        sleep(1000);
        File fileDownloaded = new File(filePath + fileName);
        reporterLog("Check if file downloaded exists, if yes Remove the file");
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
