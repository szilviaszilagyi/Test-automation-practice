package hu.progmatic.booking.comtest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AccommodationDetailPage {
    WebDriver driver;
    WebDriverWait wait;

    By numberOfRoomsDropdownBy = By.id("hprt_nos_select_bbasic_");
    By iLLReserveButtonBy = By.className("hprt-reservation-cta");
    By roomSelectedConfirmatinMessageBy = By.xpath("//*[contains(text(), 'Great choice')]");

    public AccommodationDetailPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void selectFirstRoomsNumberAndReserve(String roomNumber) throws InterruptedException {
        JavascriptExecutor j = (JavascriptExecutor) driver;
        if (j.executeScript("return document.readyState").toString().equals("complete")) {
            System.out.println("Page has loaded");
        }
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1400)");
        Thread.sleep(3000);
        WebElement roomNumberDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(numberOfRoomsDropdownBy));
        roomNumberDropdown.click();
        Select selectRoomDropdown = new Select(roomNumberDropdown);
        selectRoomDropdown.selectByValue(roomNumber);
        roomNumberDropdown.click();
        WebElement iLLReserveButton = wait.until(ExpectedConditions.elementToBeClickable(iLLReserveButtonBy));
        iLLReserveButton.click();
        WebElement roomSelectedConfirmation = driver.findElement(roomSelectedConfirmatinMessageBy);
        Assert.assertTrue(roomSelectedConfirmation.isDisplayed());
    }
}
