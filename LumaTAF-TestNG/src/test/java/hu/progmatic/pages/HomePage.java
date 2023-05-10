package hu.progmatic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;
    By headerBy = By.id("top");
    By makeAppointmentButtonBy = By.id("btn-make-appointment");

    public HomePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void loadHomePage() {
        driver.get("https://katalon-demo-cura.herokuapp.com");
        WebElement headerElement = driver.findElement(headerBy);
        Assert.assertTrue(headerElement.isDisplayed());
        System.out.println("Homepage loaded properly.");
    }

    public void clickMakeAppointmentButton(){
        WebElement makeAppointmentButton = wait.until(ExpectedConditions.elementToBeClickable(makeAppointmentButtonBy));
        makeAppointmentButton.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/profile.php#login");
        System.out.println("The login page loaded.");
    }



}
