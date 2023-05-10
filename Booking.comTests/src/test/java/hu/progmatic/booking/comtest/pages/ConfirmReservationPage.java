package hu.progmatic.booking.comtest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ConfirmReservationPage {
    WebDriver driver;
    WebDriverWait wait;
    By completeBookingButtonBy = By.xpath("//*[@id='bookStage3Inc']/div[6]/div[1]/div/button");

    public ConfirmReservationPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void enterThePaymentData() throws InterruptedException {
        Thread.sleep(500);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)");
        WebElement completeBookingButton = driver.findElement(completeBookingButtonBy);
        completeBookingButton.click();
        Assert.assertTrue(driver.getPageSource().contains("This card number isn't valid"));
        Assert.assertTrue(driver.getPageSource().contains("Your card must have a valid expiry date"));
        Assert.assertTrue(driver.getPageSource().contains("Enter your 3 or 4-digit security code"));
        System.out.println("The accommodation confirmation page tested, with wrong card number.");
    }
}
