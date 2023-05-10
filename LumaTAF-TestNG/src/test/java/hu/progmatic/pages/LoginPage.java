package hu.progmatic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    By usernameBy = By.id("txt-username");
    By passwordBy = By.id("txt-password");
    By loginButtonBy = By.id("btn-login");
    By errorMsgBy = By.className("text-danger");


    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void loginWithInvalidUsernameAndPwd(String username, String password) {
        WebElement usernameInput = driver.findElement(usernameBy);
        usernameInput.sendKeys(username);
        WebElement passwordInput = driver.findElement(passwordBy);
        passwordInput.sendKeys(password);
        WebElement loginButton = driver.findElement(loginButtonBy);
        loginButton.click();
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMsgBy));
        Assert.assertEquals("Login failed! Please ensure the username and password are valid.", errorMessage.getText());
        System.out.println("The error message is displayed.");
    }

    public void loginWitDemoUsernameAndPwd(String username, String password) {
        WebElement usernameInput = driver.findElement(usernameBy);
        usernameInput.sendKeys(username);
        WebElement passwordInput = driver.findElement(passwordBy);
        passwordInput.sendKeys(password);
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(loginButtonBy));
        loginButton.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/#appointment");
        System.out.println("The appointment page is displayed.");
    }


}
