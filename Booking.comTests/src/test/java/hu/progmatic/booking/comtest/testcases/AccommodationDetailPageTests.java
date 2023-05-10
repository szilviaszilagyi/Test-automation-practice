package hu.progmatic.booking.comtest.testcases;

import hu.progmatic.booking.comtest.pages.AccommodationDetailPage;
import hu.progmatic.booking.comtest.pages.MainPage;
import hu.progmatic.booking.comtest.pages.SearchResultsPage;
import hu.progmatic.driverfactory.DriverBaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AccommodationDetailPageTests extends DriverBaseTest {
    MainPage mainPage;
    SearchResultsPage searchResultsPage;
    AccommodationDetailPage accommodationDetailPage;

    @BeforeMethod
    public void loadedMainPage() {
        mainPage = new MainPage(driver, wait);
        mainPage.loadHomePage();
    }

    @Test (description = "T18: The accommodation list with prices appear for booking.", groups = {"smoke", "regression"})
    public void accommodationListWithPricesAppearForBookingTest() throws InterruptedException {
        mainPage = new MainPage(driver,wait);
        searchResultsPage = new SearchResultsPage(driver,wait);
        accommodationDetailPage = new AccommodationDetailPage(driver, wait);
        mainPage.addDestination("Hard Rock Hotel Bali, Kuta, Bali, Indonesia");
        mainPage.openSearchboxDatesContainer();
        mainPage.addCheckInAndCheckOutDateFor20MarchTo24March();
        mainPage.clickMainSearchButton();
        searchResultsPage.clickFirstItemFromTheAccommodationList("Hard Rock Hotel Bali");
        accommodationDetailPage.selectFirstRoomsNumberAndReserve("1");
    }
}
