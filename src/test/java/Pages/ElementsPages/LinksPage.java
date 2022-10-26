package Pages.ElementsPages;

import Pages.DashboardPage;
import Pages.ElementsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Objects;

import static Common.extentReport.ExtentTestManager.reporterLog;

public class LinksPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private DashboardPage dashboardPage;
    private ElementsPage elementsPage;
    public LinksPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        dashboardPage = new DashboardPage(driver);
        elementsPage = new ElementsPage(driver);
    }
    By Home_Link = By.id("simpleLink");
    By Homewd7PB_Link = By.id("dynamicLink");
    String HomeAndHomewd7PB_URL = "https://demoqa.com/links";

    By CreatedLink = By.id("created");
    By NoContentLink = By.id("no-content");
    By MovedLink = By.id("moved");
    By BadRequestLink = By.id("bad-request");
    By UnauthorizedLink = By.id("unauthorized");
    By ForbiddenLink = By.id("forbidden");
    By NotFoundLink = By.id("invalid-url");

    String CreatedAPI_txt = "Link has responded with staus 201 and status text Created";
    String NoContentAPI_txt = "Link has responded with staus 204 and status text No Content";
    String MovedAPI_txt = "Link has responded with staus 301 and status text Moved Permanently";
    String BadRequestAPI_txt = "Link has responded with staus 400 and status text Bad Request";
    String UnauthorizedAPI_txt = "Link has responded with staus 401 and status text Unauthorized";
    String ForbiddenAPI_txt = "Link has responded with staus 403 and status text Forbidden";
    String NotFoundAPI_txt = "Link has responded with staus 404 and status text Not Found";

    By callAPILinkResponse = By.id("linkResponse");
    public void clickHomeLink(){
        reporterLog("Click HomeLink");
        driver.findElement(Home_Link).click();
    }
    public void IsHomeLinkOpen(){
        reporterLog("Verify HomeLink is clicked");
        Assert.assertEquals(driver.getCurrentUrl(), HomeAndHomewd7PB_URL);
    }
    public void clickHomewd7PBLink(){
        reporterLog("Click Homewd7PBLink");
        driver.findElement(Homewd7PB_Link).click();
    }
    public void IsHomewd7PBLinkOpen(){
        reporterLog("Verify Homewd7PBLink is clicked");
        Assert.assertEquals(driver.getCurrentUrl(), HomeAndHomewd7PB_URL);
    }
    public void clickCreated(){
        reporterLog("Click CreatedLink");
        driver.findElement(CreatedLink).click();
    }
    public void CreatedAPIResponseCorrect(){
        reporterLog("Verify Returned CreatedAPIResponseCorrect");
        Assert.assertEquals(driver.findElement(callAPILinkResponse),CreatedAPI_txt);
    }
    public void clickNoContent(){
        reporterLog("Click NoContent");
        driver.findElement(NoContentLink).click();
    }
    public void NoContentAPIResponseCorrect(){
        reporterLog("Verify Returned NoContentAPIResponseCorrect");
        Assert.assertEquals(driver.findElement(callAPILinkResponse),NoContentAPI_txt);
    }
    public void clickMoved(){
        reporterLog("Click MovedLink");
        driver.findElement(MovedLink).click();
    }
    public void MovedAPIResponseCorrect(){
        reporterLog("Verify Returned MovedAPIResponseCorrect");
        Assert.assertEquals(driver.findElement(callAPILinkResponse),MovedAPI_txt);
    }
    public void clickBadRequest(){
        reporterLog("Click BadRequest");
        driver.findElement(BadRequestLink).click();
    }
    public void BadRequestAPIResponseCorrect(){
        reporterLog("Verify Returned BadRequestAPIResponseCorrect");
        Assert.assertEquals(driver.findElement(callAPILinkResponse),BadRequestAPI_txt);
    }
    public void clickUnauthorized(){
        reporterLog("Click UnauthorizedLink");
        driver.findElement(UnauthorizedLink).click();
    }
    public void UnauthorizedAPIResponseCorrect(){
        reporterLog("Verify Returned UnauthorizedAPIResponseCorrect");
        Assert.assertEquals(driver.findElement(callAPILinkResponse),UnauthorizedAPI_txt);
    }
    public void clickForbidden(){
        reporterLog("Click ForbidenLink");
        driver.findElement(ForbiddenLink).click();
    }
    public void ForbiddenAPIResponseCorrect(){
        reporterLog("Verify Returned ForbiddenAPIResponseCorrect");
        Assert.assertEquals(driver.findElement(callAPILinkResponse),ForbiddenAPI_txt);
    }
    public void clickNotFound(){
        reporterLog("Click NotFoundLink");
        driver.findElement(NotFoundLink).click();
    }
    public void NotFoundAPIResponseCorrect(){
        reporterLog("Verify Returned NotFoundAPIResponseCorrect");
        Assert.assertEquals(driver.findElement(callAPILinkResponse),NotFoundAPI_txt);
    }
}
