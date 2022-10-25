package TestCases.ElementsPagesTest;
import Common.BaseSetup;
import Pages.DashboardPage;
import Pages.ElementsPage;
import Pages.ElementsPages.DynamicPropertiesPage;
import Pages.ElementsPages.LinksPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class DynamicPropertiesTest extends BaseSetup {
    private DashboardPage dashboardPage;
    private DynamicPropertiesPage dynamicPropertiesPage;
    private ElementsPage elementsPage;
    @BeforeClass
    public void setupTest(){
        driver = new BaseSetup().setDriver("chrome");
        navigatetoURL("https://demoqa.com/");
        dashboardPage = new DashboardPage(driver);
        elementsPage = new ElementsPage(driver);
        dynamicPropertiesPage = new DynamicPropertiesPage(driver);
        dashboardPage.clickElements_btn();
        elementsPage.clickDynamicProperties();
        elementsPage.accessDynamicsPropertiesSuccessfully();
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
    public void TC_001_verify_Original_Color_Of_Text_is_White(){
        dynamicPropertiesPage.verifyOriginalColorCorrect();
    }
    @Test
    public void TC_002_verify_Final_Color_Of_Text_is_Red(){
        dynamicPropertiesPage.verifyfinalColorCorrect();
    }
    @Test
    public void TC_003_verify_EnabledAfter5SButton(){
        dynamicPropertiesPage.verifyEnableAfter5S_button();
    }
}
