package TestCases.ElementsPagesTest;

import Common.BaseSetup;
import Pages.DashboardPage;
import Pages.ElementsPage;
import Pages.ElementsPages.BrokenLinksImagesPage;
import Pages.ElementsPages.ButtonsPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class BrokenLinksImagesTest extends BaseSetup {
    private DashboardPage dashboardPage;
    private BrokenLinksImagesPage brokenLinksImagesPage;
    private ElementsPage elementsPage;

    @BeforeClass
    public void setupTest(){
        driver = new BaseSetup().setDriver("chrome");
        navigatetoURL("https://demoqa.com/");
        dashboardPage = new DashboardPage(driver);
        elementsPage = new ElementsPage(driver);
        brokenLinksImagesPage = new BrokenLinksImagesPage(driver);
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

    public void TC_001(){

    }

}
