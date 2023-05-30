package scripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import pages.KijijiCaLandingPage;
import pages.KijijiCaSignInPage;
import utilities.Driver;

public class Base {

    WebDriver driver;
    SoftAssert softAssert;
    KijijiCaLandingPage kijijiCaLandingPage;
    KijijiCaSignInPage kijijiCaSignInPage;

    @BeforeMethod
    public void setup(){
        driver = Driver.getDriver();
        softAssert = new SoftAssert();
        kijijiCaLandingPage = new KijijiCaLandingPage();
        kijijiCaSignInPage = new KijijiCaSignInPage();
    }

    @AfterMethod
    public void tearDown(){
        //TODO if there is a failure, take screenshot and attach it to the report
        softAssert.assertAll();
        Driver.quitDriver();
    }
}
