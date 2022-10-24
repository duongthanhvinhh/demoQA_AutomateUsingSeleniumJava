package TestCases.ElementsPagesTest;

import Common.BaseSetup;
import Pages.DashboardPage;
import Pages.ElementsPage;
import Pages.ElementsPages.TextBoxPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class TextBoxTest extends BaseSetup {
    private DashboardPage dashboardPage;
    private TextBoxPage textBoxPage;
    private ElementsPage elementsPage;
    /*
    Access https://demoqa.com before class, then run the first TC with action "click 'Elements Button in Dashboard Page',
    after that, for every TC We only need to refresh browser to clear text. Do not need to click Elements again"
     */
    @BeforeClass
    public void setupTest(){
        driver = new BaseSetup().setDriver("chrome");
        navigatetoURL("https://demoqa.com/");
        dashboardPage = new DashboardPage(driver);
        elementsPage = new ElementsPage(driver);
        textBoxPage = new TextBoxPage(driver);
        dashboardPage.clickElements_btn();
        elementsPage.clickTextBox();
        elementsPage.accessTextBoxSuccessfully();
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
    @Test(description = "Verify can add submit a TextBox with full valid informations")
    public void TC_001_Submit_TextBox_with_fullInformation_Successfully(){
        textBoxPage.inputFullName("VinhTester");
        textBoxPage.inputEmail("vinhdtvt1999@gmail.com");
        textBoxPage.inputCurrentAddress("Ho Chi Minh city");
        textBoxPage.inputPermanentAddress("Quang Ngai city");
        textBoxPage.clickSubmit();
        Assert.assertEquals(textBoxPage.FullNameValueAdded(),"Name:VinhTester");
        Assert.assertEquals(textBoxPage.EmailValueAdded(),"Email:vinhdtvt1999@gmail.com");
        Assert.assertEquals(textBoxPage.CurrentAddressValueAdded(),"Current Address :Ho Chi Minh city");
        Assert.assertEquals(textBoxPage.PermanentAddressValueAdded(),"Permananet Address :Quang Ngai city");
    }
    @Test(description = "Verify nothing happen when click submit without any information")
    public void TC_002_Submit_TextBox_without_anyInformation_Successfully(){
        elementsPage.clickTextBox();
        textBoxPage.clickSubmit();
        Assert.assertFalse(textBoxPage.FullNameDisplayed());
        Assert.assertFalse(textBoxPage.EmailDisplayed());
        Assert.assertFalse(textBoxPage.CurrentAddressDisplayed());
        Assert.assertFalse(textBoxPage.PermanentAddressDisplayed());
    }
    @Test(description = "Verify can not submit a TextBox with  invalid email format - Missing @ character")
    public void TC_003_Cannot_Submit_TextBox_with_invalidEmailFormat(){
        elementsPage.clickTextBox();
        textBoxPage.inputFullName("VinhTester");
        textBoxPage.inputEmail("vinhdtvt1999gmail.com");
        textBoxPage.inputCurrentAddress("Ho Chi Minh city");
        textBoxPage.inputPermanentAddress("Quang Ngai city");
        textBoxPage.clickSubmit();
        Assert.assertFalse(textBoxPage.FullNameDisplayed());
        Assert.assertFalse(textBoxPage.EmailDisplayed());
        Assert.assertFalse(textBoxPage.CurrentAddressDisplayed());
        Assert.assertFalse(textBoxPage.PermanentAddressDisplayed());
    }
    @Test(description = "Verify can add a TextBox without FullName")
    public void TC_004_Submit_TextBox_without_FullName_Successfully(){
        elementsPage.clickTextBox();
        textBoxPage.inputEmail("vinhdtvt1999@gmail.com");
        textBoxPage.inputCurrentAddress("Ho Chi Minh city");
        textBoxPage.inputPermanentAddress("Quang Ngai city");
        textBoxPage.clickSubmit();
        Assert.assertFalse(textBoxPage.FullNameDisplayed());
        Assert.assertEquals(textBoxPage.EmailValueAdded(),"Email:vinhdtvt1999@gmail.com");
        Assert.assertEquals(textBoxPage.CurrentAddressValueAdded(),"Current Address :Ho Chi Minh city");
        Assert.assertEquals(textBoxPage.PermanentAddressValueAdded(),"Permananet Address :Quang Ngai city");
    }
}
