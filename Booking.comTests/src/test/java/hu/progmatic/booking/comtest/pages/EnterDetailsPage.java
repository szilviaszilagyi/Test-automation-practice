package hu.progmatic.booking.comtest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class EnterDetailsPage {
    WebDriver driver;
    WebDriverWait wait;

    By firstnameInputBy = By.id("firstname");
    By lastnameInputBy = By.id("lastname");
    By emailAddressInputBy = By.id("email");
    By confirmEmailInputBy = By.id("email_confirm");
    By telephoneInputBy = By.id("phone");
    By nextFinalDetailsButtonBy = By.className("submit_holder_button");
    By alreadyDoneCloseButtonBy = By.className("modal-mask-closeBtn");

    public EnterDetailsPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void enterTheDetailsOnBookingPage(String firstname, String lastname, String email, String phonenum) {
        WebElement firstnameInput = driver.findElement(firstnameInputBy);
        firstnameInput.sendKeys(firstname);
        WebElement lastnameInput = driver.findElement(lastnameInputBy);
        lastnameInput.sendKeys(lastname);
        WebElement emailAddressInput = driver.findElement(emailAddressInputBy);
        emailAddressInput.sendKeys(email);
        WebElement confirmEmailInput = driver.findElement(confirmEmailInputBy);
        confirmEmailInput.sendKeys(email);
        WebElement telephoneInput = driver.findElement(telephoneInputBy);
        telephoneInput.sendKeys(phonenum);
        WebElement nextFinalDetailsButton = driver.findElement(nextFinalDetailsButtonBy);
        nextFinalDetailsButton.click();
        WebElement alreadyDoneCloseButton = wait.until(ExpectedConditions.elementToBeClickable(alreadyDoneCloseButtonBy));
        alreadyDoneCloseButton.click();
        Assert.assertEquals("https://secure.booking.com/tpi_book.html", driver.getCurrentUrl());
        System.out.println("Booking details form is filled out and final details page is displayed.");
    }
}
