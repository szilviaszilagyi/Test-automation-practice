package hu.progmatic.booking.comtest.testcases;

import hu.progmatic.booking.comtest.pages.MainPage;
import hu.progmatic.driverfactory.DriverBaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MenuTest extends DriverBaseTest {
    MainPage mainPage;

    @BeforeMethod
    public void loadHomePage() {
        mainPage = new MainPage(driver, wait);
        mainPage.loadHomePage();
    }

    @Test(description = "T5: Navigation between pages from the main menu", groups = {"smoke", "regression"})
    public void menuOnHeaderClickOnEach() throws InterruptedException {
        mainPage = new MainPage(driver,wait);
        mainPage.clickOnFlightsInMenu();
        mainPage.clickOnFlightHotelInMenu();
        mainPage.clickOnCarRentalsInMenu();
        mainPage.clickOnAttractionsInMenu();
        mainPage.clickOnAirportTaxisInMenu();
        mainPage.clickOnMainMenuInAirportTaxisPage();
    }
}
