package Pages.ElementsPages;

import Pages.DashboardPage;
import Pages.ElementsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Objects;

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
        driver.findElement(Home_Link).click();
    }
    public void IsHomeLinkOpen(){
        Assert.assertEquals(driver.getCurrentUrl(), HomeAndHomewd7PB_URL);
    }
    public void clickHomewd7PBLink(){
        driver.findElement(Homewd7PB_Link).click();
    }
    public void IsHomewd7PBLinkOpen(){
        Assert.assertEquals(driver.getCurrentUrl(), HomeAndHomewd7PB_URL);
    }
    public void clickCreated(){
        driver.findElement(CreatedLink).click();
    }
    public boolean CreatedAPIResponseCorrect(){
        return Objects.equals(driver.findElement(callAPILinkResponse).getText(),CreatedAPI_txt);
    }
    public void clickNoContent(){
        driver.findElement(NoContentLink).click();
    }
    public boolean NoContentAPIResponseCorrect(){
        return Objects.equals(driver.findElement(callAPILinkResponse).getText(),NoContentAPI_txt);
    }
    public void clickMoved(){
        driver.findElement(MovedLink).click();
    }
    public boolean MovedAPIResponseCorrect(){
        return Objects.equals(driver.findElement(callAPILinkResponse).getText(),MovedAPI_txt);
    }
    public void clickBadRequest(){
        driver.findElement(BadRequestLink).click();
    }
    public boolean BadRequestAPIResponseCorrect(){
        return Objects.equals(driver.findElement(callAPILinkResponse).getText(),BadRequestAPI_txt);
    }
    public void clickUnauthorized(){
        driver.findElement(UnauthorizedLink).click();
    }
    public boolean UnauthorizedAPIResponseCorrect(){
        return Objects.equals(driver.findElement(callAPILinkResponse).getText(),UnauthorizedAPI_txt);
    }
    public void clickForbidden(){
        driver.findElement(ForbiddenLink).click();
    }
    public boolean ForbiddenAPIResponseCorrect(){
        return Objects.equals(driver.findElement(callAPILinkResponse).getText(),ForbiddenAPI_txt);
    }
    public void clickNotFound(){
        driver.findElement(NotFoundLink).click();
    }
    public boolean NotFoundAPIResponseCorrect(){
        return Objects.equals(driver.findElement(callAPILinkResponse).getText(),NotFoundAPI_txt);
    }
}
