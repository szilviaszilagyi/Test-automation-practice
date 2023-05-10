package hu.progmatic.booking.comtest.testcases;

import hu.progmatic.booking.comtest.pages.MainPage;
import hu.progmatic.booking.comtest.pages.SearchResultsPage;
import hu.progmatic.driverfactory.DriverBaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchResultsPageTests extends DriverBaseTest {

    MainPage mainPage;
    SearchResultsPage searchResultsPage;

    @BeforeMethod
    public void loadedMainPage() {
        mainPage = new MainPage(driver, wait);
        mainPage.loadHomePage();
    }

    @Test(description = "T29: Searched details copying from main page to search page form", groups = {"smoke", "regression"})
    public void searchHotelNameCopyingFromMainPageToSearchPageForm() {
        mainPage = new MainPage(driver, wait);
        searchResultsPage = new SearchResultsPage(driver, wait);
        mainPage.addDestination("Hard Rock Hotel Bali, Kuta, Bali, Indonesia");
        mainPage.openSearchboxDatesContainer();
        mainPage.addCheckInAndCheckOutDateFor20MarchTo24March();
        mainPage.clickMainSearchButton();
        searchResultsPage.checkTheHotelName ("Hard Rock Hotel Bali");
    }
}
