package hu.progmatic.booking.comtest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;

public class SearchResultsPage {
    WebDriver driver;
    WebDriverWait wait;

    By firstAccommodationBy = By.cssSelector("[data-testid='title']");
    By hotelNameSearchResultBy =By.className("ce45093752");

    public SearchResultsPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void clickFirstItemFromTheAccommodationList(String expectedTitle) throws InterruptedException {
        WebElement firstItemOfTheAccommodationList = driver.findElements(firstAccommodationBy).get(0);
        Assert.assertEquals(firstItemOfTheAccommodationList.getText(), expectedTitle);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,100)");
        firstItemOfTheAccommodationList.click();
        ArrayList<String> tabs = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        Thread.sleep(3000);
        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.booking.com/hotel/id/hard-rock-bali"));
        System.out.println("First item of the accommodation list is clicked.");
    }
    public void checkTheHotelName(String hotelName){
        WebElement hotelNameSearchResult = driver.findElement(hotelNameSearchResultBy);
        Assert.assertEquals(hotelNameSearchResult.getAttribute("value"), hotelName);
    }
}
