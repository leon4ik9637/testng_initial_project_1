package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class KijijiCaSignInPage {
    public KijijiCaSignInPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//h1")
    public WebElement signInHeading1;

    @FindBy(css = ".headline")
    public WebElement signInParagraph;

    @FindBy(id = "username")
    public WebElement emailInputBox;

    @FindBy(css = "label[for='username']")
    public WebElement emailInputLabel;

    @FindBy(css = "input[type='password']")
    public WebElement passwordInputBox;

    @FindBy(css = "label[for='password']")
    public WebElement passwordInputLabel;

    @FindBy(id = "passwordRecoveryLink")
    public WebElement forgotPasswordLink;

    @FindBy(css = ".sign-up span")
    public WebElement messageUnderSignInButton;

    @FindBy(id = "login-submit")
    public WebElement signInButton;

    @FindBy(css = "section[class='form-element errors']>div")
    public WebElement failedToLoginMessage;

    public void signIn(String email, String password){
        emailInputBox.sendKeys(email);
        passwordInputBox.sendKeys(password);
        signInButton.click();
    }

}
