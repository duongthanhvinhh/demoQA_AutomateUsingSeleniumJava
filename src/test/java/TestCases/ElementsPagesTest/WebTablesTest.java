package TestCases.ElementsPagesTest;

import Common.BaseSetup;
import Pages.DashboardPage;
import Pages.ElementsPage;
import Pages.ElementsPages.WebTablesPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class WebTablesTest extends BaseSetup {
    private DashboardPage dashboardPage;
    private WebTablesPage webTablesPage;
    private ElementsPage elementsPage;
    @BeforeClass
    public void setupTest(){
        driver = new BaseSetup().setDriver("chrome");
        navigatetoURL("https://demoqa.com/");
        dashboardPage = new DashboardPage(driver);
        elementsPage = new ElementsPage(driver);
        webTablesPage = new WebTablesPage(driver);
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
}
