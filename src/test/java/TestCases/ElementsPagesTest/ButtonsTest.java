package TestCases.ElementsPagesTest;

import Common.BaseSetup;
import Pages.DashboardPage;
import Pages.ElementsPage;
import Pages.ElementsPages.ButtonsPage;
import Pages.ElementsPages.RadioButtonPage;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ButtonsTest extends BaseSetup {

    private DashboardPage dashboardPage;
    private ButtonsPage buttonsPage;
    private ElementsPage elementsPage;

    @BeforeClass
    public void setupTest(){
        driver = new BaseSetup().setDriver("chrome");
        navigatetoURL("https://demoqa.com/");
        dashboardPage = new DashboardPage(driver);
        elementsPage = new ElementsPage(driver);
        buttonsPage = new ButtonsPage(driver);
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
    @Test(description = "Click 3 buttons 'Double Click Me', 'Right Click Me', and 'Click Me' respectively and verify all of them selected ")
    public void TC_001_Click_3Buttons_respectively() throws InterruptedException {
        dashboardPage.clickElements_btn();
        elementsPage.clickButtons();
        elementsPage.accessButtonsSuccessfully();
        buttonsPage.clickDoubleClick();
        buttonsPage.IsDoubleClickSelected();
        buttonsPage.clickRightClick();
        buttonsPage.IsRightClickSelected();
        buttonsPage.clickClickMe();
        buttonsPage.IsClickMeSelected();
    }
    @Test
    public void TC_002_Click_DoubleClick(){
        buttonsPage.clickDoubleClick();
        buttonsPage.IsDoubleClickSelected();
    }
    @Test
    public void TC_003_Click_RightClick(){
        buttonsPage.clickRightClick();
        buttonsPage.IsRightClickSelected();
    }
    @Test
    public void TC_004_Click_ClickMe(){
        buttonsPage.clickClickMe();
        buttonsPage.IsClickMeSelected();
    }
}
