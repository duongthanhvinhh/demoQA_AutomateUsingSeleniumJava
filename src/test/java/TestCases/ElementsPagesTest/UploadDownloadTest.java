package TestCases.ElementsPagesTest;

import Common.BaseSetup;
import Pages.DashboardPage;
import Pages.ElementsPage;
import Pages.ElementsPages.LinksPage;
import Pages.ElementsPages.UploadDownloadPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UploadDownloadTest extends BaseSetup {

    private DashboardPage dashboardPage;
    private UploadDownloadPage uploadDownloadPage;
    private ElementsPage elementsPage;

    @BeforeClass
    public void setupTest(){
        driver = new BaseSetup().setDriver("chrome");
        navigatetoURL("https://demoqa.com/");
        dashboardPage = new DashboardPage(driver);
        elementsPage = new ElementsPage(driver);
        uploadDownloadPage = new UploadDownloadPage(driver);
        dashboardPage.clickElements_btn();
        elementsPage.clickUploadAndDownload();
        elementsPage.accessUploadAndDownloadSuccessfully();
    }
    @AfterMethod
    public void refreshWindow(){
        driver.navigate().refresh();
    }
    @AfterClass
    public void closeBrowser(){
        driver.close();
        driver.quit();
    }

    @Test
    public void TC_001_UploadFileSuccessfully(){
        uploadDownloadPage.clickUploadFileAndVerifyUploadSuccess("C:\\Users\\dtvinh\\Downloads1\\","mas3.txt");
    }

    @Test
    public void TC_002_DownloadFileSuccessfully(){
        uploadDownloadPage.clickDownloadFileAndVerifyDownloadSuccess("C:\\Users\\dtvinh\\Downloads\\","sampleFile.jpeg");
    }
}
