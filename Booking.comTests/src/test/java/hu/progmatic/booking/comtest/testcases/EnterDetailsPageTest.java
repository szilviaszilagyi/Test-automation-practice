package hu.progmatic.booking.comtest.testcases;

import hu.progmatic.booking.comtest.pages.AccommodationDetailPage;
import hu.progmatic.booking.comtest.pages.EnterDetailsPage;
import hu.progmatic.booking.comtest.pages.MainPage;
import hu.progmatic.booking.comtest.pages.SearchResultsPage;
import hu.progmatic.driverfactory.DriverBaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EnterDetailsPageTest extends DriverBaseTest {
    MainPage mainPage;
    SearchResultsPage searchResultsPage;
    AccommodationDetailPage accommodationDetailPage;
    EnterDetailsPage enterDetailsPage;

    @BeforeMethod
    public void loadedMainPage() {
        mainPage = new MainPage(driver, wait);
        mainPage.loadHomePage();
    }

    @Test(description = "T20: Enter the details on booking page at a selected accommodation", groups = {"smoke", "regression"})
    public void fillOutTheFormFromDetailsPageTest() throws InterruptedException {
        mainPage = new MainPage(driver, wait);
        searchResultsPage = new SearchResultsPage(driver, wait);
        accommodationDetailPage = new AccommodationDetailPage(driver, wait);
        enterDetailsPage = new EnterDetailsPage(driver, wait);
        mainPage.addDestination("Hard Rock Hotel Bali, Kuta, Bali, Indonesia");
        mainPage.openSearchboxDatesContainer();
        mainPage.addCheckInAndCheckOutDateFor20MarchTo24March();
        mainPage.clickMainSearchButton();
        searchResultsPage.clickFirstItemFromTheAccommodationList("Hard Rock Hotel Bali");
        accommodationDetailPage.selectFirstRoomsNumberAndReserve("1");
        enterDetailsPage.enterTheDetailsOnBookingPage("Teszt", "Lajos", "teszt@tesztlab.hu",
                "301234567");
    }
}
