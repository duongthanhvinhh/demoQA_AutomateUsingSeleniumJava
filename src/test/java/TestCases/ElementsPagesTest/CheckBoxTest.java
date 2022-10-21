package TestCases.ElementsPagesTest;
import Common.BaseSetup;
import Pages.DashboardPage;
import Pages.ElementsPage;
import Pages.ElementsPages.ButtonsPage;
import Pages.ElementsPages.CheckBoxPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class CheckBoxTest extends BaseSetup {
    private DashboardPage dashboardPage;
    private CheckBoxPage checkBoxPage;
    private ElementsPage elementsPage;
    @BeforeClass
    public void setupTest(){
        driver = new BaseSetup().setDriver("chrome");
        navigatetoURL("https://demoqa.com/");
        dashboardPage = new DashboardPage(driver);
        elementsPage = new ElementsPage(driver);
        checkBoxPage = new CheckBoxPage(driver);
        dashboardPage.clickElements_btn();
        elementsPage.clickCheckBox();
        elementsPage.accessCheckBoxSuccessfully();
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
    public void TC_0001_Check_HomeBox_And_Verify_HomeBox_Checked(){
        checkBoxPage.checkHomeBox();
        checkBoxPage.IsHomeBoxChecked();
    }
    @Test
    public void TC_0002_CheckOfficeBox_And_Verify_OfficeBox_Checked(){
        checkBoxPage.clickExpandHomeBox();
        checkBoxPage.clickExpandDocumentBox();
        checkBoxPage.checkOfficeBox();
        checkBoxPage.IsOfficeBoxChecked();
    }
}
