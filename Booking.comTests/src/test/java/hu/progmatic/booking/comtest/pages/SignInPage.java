package hu.progmatic.booking.comtest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class SignInPage {
    WebDriver driver;
    WebDriverWait wait;
    By singInButtonBy = By.className("bb0b3e18ca");
    By emailAddressInputBy = By.className("ZMH9h0HCYH9GGNxHnXGJ");
    By continueWithEmailButtonBy = By.cssSelector("button[type='submit'][class='Iiab0gVMeWOd4XcyJGA3 wPxWIS_rJCpwAWksE0s3 Ut3prtt_wDsi7NM_83Jc TuDOVH9WFSdot9jLyXlw EJWUAldA4O1mP0SSFXPm whxYYRnvyHGyGqxO4ici']");
    By passwordInputBy = By.id("password");
    By signInButton2By = By.cssSelector("button[type='submit']");
    By validEmailEmptyPasswordErrorMessageBy = By.id("password-note");
    By errorMessageBy = By.id("username-note");
    By invalidPwdErrorMessageBy = By.id("password-note");

    public SignInPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void signInWithValidEmailAndPassword(String email, String password) {
        WebElement signInButton = driver.findElement(singInButtonBy);
        signInButton.click();
        WebElement emailAddressInput = driver.findElement(emailAddressInputBy);
        emailAddressInput.sendKeys(email);
        WebElement continueWithEmailButton = wait.until(ExpectedConditions.elementToBeClickable(continueWithEmailButtonBy));
        continueWithEmailButton.click();
        WebElement passwordInput = driver.findElement(passwordInputBy);
        passwordInput.sendKeys(password);
        WebElement signInButton2 = wait.until(ExpectedConditions.visibilityOfElementLocated(signInButton2By));
        Assert.assertTrue(signInButton2.isDisplayed());
        System.out.println("Sing in test finished successfully.");
    }

    public void loginWithValidEmailAndEmptyPassword(String email) throws InterruptedException {
        WebElement singInButton = driver.findElement(singInButtonBy);
        singInButton.click();
        WebElement emailAddressInput = driver.findElement(emailAddressInputBy);
        emailAddressInput.sendKeys(email);
        WebElement continueWithEmailButton = wait.until(ExpectedConditions.elementToBeClickable(continueWithEmailButtonBy));
        continueWithEmailButton.click();
        Thread.sleep(500);
        WebElement singInButton2 = wait.until(ExpectedConditions.elementToBeClickable(signInButton2By));
        singInButton2.click();
        WebElement validEmailEmptyPasswordErrorMessage = driver.findElement(validEmailEmptyPasswordErrorMessageBy);
        Assert.assertEquals("Please enter your Booking.com password", validEmailEmptyPasswordErrorMessage.getText());
        System.out.println("Login with valid email and empty password test finished.");
    }

    public void singInWithInvalidEmail(List<String> email) {
        WebElement signInButton = driver.findElement(singInButtonBy);
        signInButton.click();
        WebElement emailAddressInput = driver.findElement(emailAddressInputBy);
        emailAddressInput.sendKeys(email.get(0));
        WebElement continueWithEmailButton = wait.until(ExpectedConditions.elementToBeClickable(continueWithEmailButtonBy));
        continueWithEmailButton.click();
        WebElement errorMessage = driver.findElement(errorMessageBy);
        Assert.assertEquals("Please check if the email address you've entered is correct.", errorMessage.getText());

        emailAddressInput.clear();
        emailAddressInput.sendKeys(email.get(1));
        continueWithEmailButton.click();
        Assert.assertEquals("Please check if the email address you've entered is correct.", errorMessage.getText());

        emailAddressInput.clear();
        emailAddressInput.sendKeys(email.get(2));
        continueWithEmailButton.click();
        Assert.assertEquals("Please check if the email address you've entered is correct.", errorMessage.getText());

        emailAddressInput.clear();
        emailAddressInput.sendKeys(email.get(3));
        continueWithEmailButton.click();
        Assert.assertEquals("Please check if the email address you've entered is correct.", errorMessage.getText());
        System.out.println("The error messages is displayed.");
    }

    public void signInWithEmptyEmail(){
        WebElement singInButton = driver.findElement(singInButtonBy);
        singInButton.click();
        WebElement continueWithEmailButton = wait.until(ExpectedConditions.elementToBeClickable(continueWithEmailButtonBy));
        continueWithEmailButton.click();
        WebElement emptyEmailErrorMessage = driver.findElement(errorMessageBy);
        Assert.assertEquals("Please enter your email address", emptyEmailErrorMessage.getText());
        System.out.println("Empty e-mail error message is displayed.");
    }

    public void signInWithValidEmailAndInvalidPassword(String email, String password) {
        WebElement signInButton = driver.findElement(singInButtonBy);
        signInButton.click();
        WebElement emailAddressInput = driver.findElement(emailAddressInputBy);
        emailAddressInput.sendKeys(email);
        WebElement continueWithEmailButton = wait.until(ExpectedConditions.elementToBeClickable(continueWithEmailButtonBy));
        continueWithEmailButton.click();
        WebElement passwordInput = driver.findElement(passwordInputBy);
        passwordInput.sendKeys(password);
        WebElement signInButton2 = wait.until(ExpectedConditions.elementToBeClickable(signInButton2By));
        Assert.assertTrue(signInButton2.isDisplayed());
        System.out.println("Sign in button is displayed.");
    }
}
