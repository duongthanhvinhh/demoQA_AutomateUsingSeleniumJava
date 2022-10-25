package TestCases.ElementsPagesTest;

import Common.BaseSetup;
import Pages.DashboardPage;
import Pages.ElementsPage;
import Pages.ElementsPages.RadioButtonPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RadioButtonTest extends BaseSetup {
    private DashboardPage dashboardPage;
    private RadioButtonPage radioButtonPage;
    private ElementsPage elementsPage;

    @BeforeClass
    public void setupTest(){
        driver = new BaseSetup().setDriver("chrome");
        navigatetoURL("https://demoqa.com/");
        dashboardPage = new DashboardPage(driver);
        elementsPage = new ElementsPage(driver);
        radioButtonPage = new RadioButtonPage(driver);
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
    @Test(description = "Select Yes, Impressive and verify both of them selected respectively. Then select No, verify the text still shows Impressive, because No can not be selected.")
    public void TC_001() throws InterruptedException {
        dashboardPage.clickElements_btn();
        elementsPage.clickRadioButton();
        elementsPage.accessRadioButtonSuccessfully();
        radioButtonPage.clickYes();
        radioButtonPage.IsYesSelected();
        radioButtonPage.clickImpressive();
        radioButtonPage.IsImpressiveSelected();
        radioButtonPage.NoCannotSelected();
    }
}
