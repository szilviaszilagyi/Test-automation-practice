package hu.progmatic.booking.comtest.testcases;

import hu.progmatic.booking.comtest.pages.*;
import hu.progmatic.driverfactory.DriverBaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EndToEndTest extends DriverBaseTest {
    MainPage mainPage;
    SearchResultsPage searchResultsPage;
    AccommodationDetailPage accommodationDetailPage;
    ConfirmReservationPage confirmReservationPage;
    EnterDetailsPage enterDetailsPage;

    @BeforeMethod
    public void loadedMainPage() {
        mainPage = new MainPage(driver, wait);
        mainPage.loadHomePage();
    }

    @Test(description = "T35: Search exact destination - Reservation process - Pay with wrong card data", groups = {"smoke", "regression", "demo"})
    public void endToEndBookingWithoutSignInTest() throws InterruptedException {
        mainPage = new MainPage(driver, wait);
        searchResultsPage = new SearchResultsPage(driver, wait);
        accommodationDetailPage = new AccommodationDetailPage(driver, wait);
        confirmReservationPage = new ConfirmReservationPage(driver, wait);
        enterDetailsPage = new EnterDetailsPage(driver, wait);
        mainPage.addDestination("Hard Rock Hotel Bali, Kuta, Bali, Indonesia");
        mainPage.openSearchboxDatesContainer();
        mainPage.addCheckInAndCheckOutDateFor20MarchTo24March();
        mainPage.clickMainSearchButton();
        searchResultsPage.clickFirstItemFromTheAccommodationList("Hard Rock Hotel Bali");
        accommodationDetailPage.selectFirstRoomsNumberAndReserve("1");
        enterDetailsPage.enterTheDetailsOnBookingPage("Teszt", "Lajos", "teszt@tesztlab.hu",
                "301234567");
        confirmReservationPage.enterThePaymentData();
    }
}
