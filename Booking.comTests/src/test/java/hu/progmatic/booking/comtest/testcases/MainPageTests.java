package hu.progmatic.booking.comtest.testcases;

import hu.progmatic.booking.comtest.pages.MainPage;
import hu.progmatic.driverfactory.DriverBaseTest;
import org.testng.annotations.Test;

public class MainPageTests extends DriverBaseTest {
    MainPage mainPage;

    @Test(description = "T34: Main page is loaded", groups = {"smoke", "regression"})
    public void loadMainPageTest() {
        mainPage = new MainPage(driver, wait);
        mainPage.loadHomePage();
    }

    @Test(description = "T8: Number of 'Children' field boundary values", groups = {"smoke", "regression"})
    public void childrenNumbersModifying() {
        mainPage = new MainPage(driver, wait);
        mainPage.loadHomePage();
        mainPage.modificationOfTheNumberOfChildrenField();
    }

    @Test(description = "T2: Number of 'Adults' field boundary values", groups = {"smoke", "regression", "demo"})
    public void numberOfAdultsBoundaryValuesTest() {
        mainPage = new MainPage(driver, wait);
        mainPage.loadHomePage();
        mainPage.numberOfAdultsFieldBoundaryValues();
    }

    @Test(description = "T10: On the main page we check te modification of the numbers of Rooms between -1 and 32", groups = {"smoke", "regression", "demo"})
    public void modificationOfNumberOfRoomsFieldTest() {
        mainPage = new MainPage(driver, wait);
        mainPage.loadHomePage();
        mainPage.modifyingNumberOfRooms();
    }
}
