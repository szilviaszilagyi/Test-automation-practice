package hu.progmatic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AppointmentPage {
    WebDriver driver;
    WebDriverWait wait;
    By facilityBy = By.id("combo_facility");
    By applyReadmissionBy = By.id("chk_hospotal_readmission");
    By healthCareProgBy = By.id("radio_program_medicaid");
    By visitDateBy = By.id("txt_visit_date");
    By commentBY = By.id("txt_comment");
    By appointmentButtonBy = By.id("btn-book-appointment");

    By confirmationBy = By.className("text-center");


    public AppointmentPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }


    public void makeAnAppointment(String facility, String visitDate, String comment) {
        Select hongkongCuraCenter = new Select(driver.findElement(facilityBy));
        hongkongCuraCenter.selectByVisibleText(facility);
        WebElement applyHospitalReadmissionCheckbox = wait.until(ExpectedConditions.elementToBeClickable(applyReadmissionBy));
        applyHospitalReadmissionCheckbox.click();
        WebElement healthProgramMedicaidRadio = driver.findElement(healthCareProgBy);
        healthProgramMedicaidRadio.click();
        WebElement visitDateInput = driver.findElement(visitDateBy);
        visitDateInput.sendKeys(visitDate);
        WebElement commentInput = driver.findElement(commentBY);
        commentInput.sendKeys(comment);
        WebElement bookAppointmentButton = wait.until(ExpectedConditions.elementToBeClickable(appointmentButtonBy));
        bookAppointmentButton.click();
        WebElement appointmentConfirmation = driver.findElement(confirmationBy);
        Assert.assertTrue(appointmentConfirmation.isDisplayed());
        System.out.println("Confirmation message is displayed.");
    }


}
