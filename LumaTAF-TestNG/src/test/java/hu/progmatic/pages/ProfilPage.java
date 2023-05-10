package hu.progmatic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ProfilPage {
    WebDriver driver;
    WebDriverWait wait;

    By menuBy = By.id("menu-toggle");
    By profileBy = By.xpath("//*[@id='sidebar-wrapper']/ul/li[4]/a");
    By underBy = By.className("lead");
    By logoutBy = By.xpath("//*[@id='sidebar-wrapper']/ul/li[5]/a");
    By mainpicsBy = By.className("text-vertical-center");

    public ProfilPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void navigateToProfilePage() {
        WebElement menuItem = driver.findElement(menuBy);
        menuItem.click();
        WebElement profilItem = wait.until(ExpectedConditions.elementToBeClickable(profileBy));
        profilItem.click();
        WebElement underConstructionText = driver.findElement(underBy);
        Assert.assertEquals("Under construction.", underConstructionText.getText());
        System.out.println("Profile page is displayed.");
    }

    public void navigateToMenuAndLogout() {
        WebElement menuItem = driver.findElement(menuBy);
        menuItem.click();
        WebElement logoutItem = wait.until(ExpectedConditions.elementToBeClickable(logoutBy));
        logoutItem.click();
        WebElement mainpicture = driver.findElement(mainpicsBy);
        Assert.assertTrue(mainpicture.isDisplayed());
        System.out.println("Logout is successful. Main page is displayed.");
    }

}
