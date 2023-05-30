package scripts;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.KijijiCaSignInPage;
import utilities.Waiter;

public class KijijiCaScripts extends Base{
    /*
    Test Case 1: Validate Cars.com Sign in page form
    Given user navigates to "https://www.kijiji.ca/"
    When user clicks on "Sign in" link
    Then user should be navigated to "Sign in" page
    And user should be able to see heading1 as "Sign in"
    And user should be able to see paragraph under "Sign in" header as "You can sign in using your Kijiji.ca account."
    And user should be able to see Email input box with "Email" label and enabled
    And user should be able to see Password input box with "Password" label and enabled
    And user should be able to see a link as "ForgotPassword?"
    And user should be able to see a "Don’t have a Kijiji account?" Text
    And user should be able to see "Sign in" button with its text and be displayed and enabled
     */

    @Test(priority = 1, description = "Validate Kijiji.ca Sign in page form")
    public void ValidateCarsComSignInPageForm(){
        driver.get("https://www.kijiji.ca/");
        kijijiCaLandingPage.signInLink.click();
        Waiter.pause(5);
        Assert.assertEquals(driver.getTitle(), "Kijiji - Buy, Sell, and Save with Canada's #1 Local Classifieds", "User could not navigate to sign in page");

        Assert.assertTrue(kijijiCaSignInPage.signInHeading1.isDisplayed());
        Assert.assertEquals(kijijiCaSignInPage.signInHeading1.getText(), "Sign in");

        Assert.assertTrue(kijijiCaSignInPage.signInParagraph.isDisplayed());
        Assert.assertEquals(kijijiCaSignInPage.signInParagraph.getText(), "You can sign in using your Kijiji.ca account.");

        Assert.assertTrue(kijijiCaSignInPage.emailInputBox.isDisplayed());
        Assert.assertTrue(kijijiCaSignInPage.emailInputBox.isEnabled());
        softAssert.assertTrue(kijijiCaSignInPage.emailInputLabel.isDisplayed());
        softAssert.assertEquals(kijijiCaSignInPage.emailInputLabel.getText(), "Email Address");

        Assert.assertTrue(kijijiCaSignInPage.passwordInputBox.isDisplayed());
        Assert.assertTrue(kijijiCaSignInPage.passwordInputBox.isEnabled());
        softAssert.assertTrue(kijijiCaSignInPage.passwordInputLabel.isDisplayed());
        softAssert.assertEquals(kijijiCaSignInPage.passwordInputLabel.getText(), "Password");

        Assert.assertTrue(kijijiCaSignInPage.forgotPasswordLink.isDisplayed());
        Assert.assertEquals(kijijiCaSignInPage.forgotPasswordLink.getText(), "Forgot Password?");

        Assert.assertTrue(kijijiCaSignInPage.messageUnderSignInButton.isDisplayed());
        Assert.assertEquals(kijijiCaSignInPage.messageUnderSignInButton.getText(), "Don’t have a Kijiji account?");

        Waiter.pause(5);

        Assert.assertTrue(kijijiCaSignInPage.signInButton.isDisplayed());
        Assert.assertTrue(kijijiCaSignInPage.signInButton.isEnabled());
        Assert.assertEquals(kijijiCaSignInPage.signInButton.getText(), "Sign in");


        /*
        Test Case 1: Validate user cannot sign in to Kijiji.ca with invalid credentials
        Given user navigates to "https://www.kijiji.ca/"
        When user clicks on "Sign in" link
        Then user should be navigated to "Sign in" page
        When user enters johndoe@gmail.com to the Email input box
        And user enters abcd1234 to the Password input box
        And user clicks on the Sign in button
        Then user should not be logged in and displayed an error message as
        "Authentication attempt has failed, likely due to invalid credentials. Please verify and try again."
         */

    }
    @Test(priority = 2, description = "Validate user cannot sign in to Kijiji.ca with invalid credentials")
    public void ValidateUserCannotSignInToKijijiCaWithInvalidCredentials(){
        driver.get("https://www.kijiji.ca/");
        kijijiCaLandingPage.signInLink.click();
        Waiter.pause(5);
        Assert.assertEquals(driver.getTitle(), "Kijiji - Buy, Sell, and Save with Canada's #1 Local Classifieds", "User could not navigate to sign in page");

        kijijiCaSignInPage.signIn("johndoe@gmail.com", "abcd1234");

        softAssert.assertTrue(kijijiCaSignInPage.failedToLoginMessage.isDisplayed());
        softAssert.assertEquals(kijijiCaSignInPage.failedToLoginMessage.getText(), "Authentication attempt has failed, likely due to invalid credentials. Please verify and try again.");
    }

}
