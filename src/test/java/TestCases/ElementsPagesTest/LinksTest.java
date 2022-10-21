package TestCases.ElementsPagesTest;

import Common.BaseSetup;
import Pages.DashboardPage;
import Pages.ElementsPage;
import Pages.ElementsPages.ButtonsPage;
import Pages.ElementsPages.LinksPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LinksTest extends BaseSetup {
    private DashboardPage dashboardPage;
    private LinksPage linksPage;
    private ElementsPage elementsPage;

    @BeforeClass
    public void setupTest(){
        driver = new BaseSetup().setDriver("chrome");
        navigatetoURL("https://demoqa.com/");
        dashboardPage = new DashboardPage(driver);
        elementsPage = new ElementsPage(driver);
        linksPage = new LinksPage(driver);
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
    public void TC_001(){
        dashboardPage.clickElements_btn();
        elementsPage.clickLinks();
        elementsPage.accessLinksSuccessfully();
        linksPage.clickHomeLink();
        linksPage.IsHomeLinkOpen();
        linksPage.clickHomewd7PBLink();
        linksPage.IsHomewd7PBLinkOpen();
    }
}
