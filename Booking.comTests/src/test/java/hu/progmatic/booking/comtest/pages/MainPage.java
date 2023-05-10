package hu.progmatic.booking.comtest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class MainPage {
    WebDriver driver;
    WebDriverWait wait;
    By acceptCookieButtonBy = By.id("onetrust-accept-btn-handler");
    By searchPanelBy = By.id(":Ra9:");
    By adultsChildrenRoomDropdownBy = By.cssSelector("span[data-testid='searchbox-form-button-icon']");
    By numberOfChildrenBy = By.xpath("/html/body/div[2]/div[2]/div/div/form/div[1]/div[3]/div/div/div/div/div[2]/div[2]/span");
    By plusButtonBy = By.xpath("/html/body/div[2]/div[2]/div/div/form/div[1]/div[3]/div/div/div/div/div[2]/div[2]/button[2]");
    By minusButtonBy = By.xpath("/html/body/div[2]/div[2]/div/div/form/div[1]/div[3]/div/div/div/div/div[2]/div[2]/button[1]");
    By adultsMinusButtonBy = By.xpath("/html/body/div[2]/div[2]/div/div/form/div[1]/div[3]/div/div/div/div/div[1]/div[2]/button[1]");
    By adultsNumberBy = By.xpath("/html/body/div[2]/div[2]/div/div/form/div[1]/div[3]/div/div/div/div/div[1]/div[2]/span");
    By adultsPlusButtonBy = By.xpath("/html/body/div[2]/div[2]/div/div/form/div[1]/div[3]/div/div/div/div/div[1]/div[2]/button[2]");
    By minusButtonForRoomsBy = By.xpath("//*[@id='indexsearch']/div[2]/div/div/form/div[1]/div[3]/div/div/div/div/div[3]/div[2]/button[1]");
    By numberOfRoomsBy = By.xpath("//*[@id='indexsearch']/div[2]/div/div/form/div[1]/div[3]/div/div/div/div/div[3]/div[2]/span");
    By plusButtonForRoomsBy = By.xpath("//*[@id=\"indexsearch\"]/div[2]/div/div/form/div[1]/div[3]/div/div/div/div/div[3]/div[2]/button[2]");
    By destinationFieldBy = By.className("ce45093752");
    By searchboxDatesContainerBy = By.className("ed2ff9f661");
    By checkInDateFor10MayBy = By.cssSelector("span[data-date='2023-05-10']");
    By searchPanelCheckInDateFieldBy = By.cssSelector("button[data-testid='date-display-field-start']");
    By searchPanelCheckOutDateFieldBy = By.cssSelector("button[data-testid='date-display-field-end']");
    By checkOutDateFor13MayBy = By.cssSelector("span[data-date='2023-05-13']");
    By mainSearchButtonBy = By.xpath("//*[@class='e57ffa4eb5' and text()='Search']");
    By datePickerCalendarBy = By.cssSelector("[data-testid='searchbox-datepicker-calendar']");
    By searchResultsPageSearchLabelBy = By.className("c8305f6688");
    By flightsMenuBy = By.id("flights");
    By flightHotelMenuBy = By.xpath("//a[contains(@href,'lastminute.com')]");
    By acceptCookieButtonOnLastMinutePageBy = By.xpath("//*[@id='iubenda-cs-banner']/div/div/div/div[3]/div[2]/button[2]");
    By carRentalsMenuBy = By.xpath("//a[contains(@href,'cars')]");
    By attractionsMenuFromCarRentalsBy = By.xpath("//a[contains(@href,'attractions')]");
    By airportTaxisMenuBy = By.id("airport_taxis");
    By mainPageMenuOnAirportTaxisPageBy = By.xpath("//*[@id='b2taxiPage']/header/nav[2]/ul/li[1]/a/span[2]");

    public MainPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void loadHomePage() {
        driver.get("https://www.booking.com/index.en-gb.html?label=gen173nr-1BCAEoggI46AdIM1gEaGeIAQGYAQm4ARfIAQzYAQHoAQGIAgGoAgO4Asfe858GwAIB0gIkNDU4ZTRjZjctNTQ5My00YWY1LTg2YzItN2FmZWE0ZGM5NmI12AIF4AIB&sid=044e1f4da1234233021c7be5b886adc7&keep_landing=1&sb_price_type=total&");
        WebElement acceptCookieButton = wait.until(ExpectedConditions.elementToBeClickable(acceptCookieButtonBy));
        acceptCookieButton.click();
        WebElement searchPanel = driver.findElement(searchPanelBy);
        searchPanel.getAttribute("placeholder");
        Assert.assertEquals(searchPanel.getAttribute("placeholder"), "Where are you going?");
        System.out.println("Main page is loaded.");
    }

    public void modificationOfTheNumberOfChildrenField() {
        WebElement adultsChildrenRoomDropdown = driver.findElement(adultsChildrenRoomDropdownBy);
        adultsChildrenRoomDropdown.click();
        WebElement childrenMinusButton = driver.findElement(minusButtonBy);
        childrenMinusButton.click();
        WebElement numberOfChilden = driver.findElement(numberOfChildrenBy);
        Assert.assertEquals("0", numberOfChilden.getText());
        Assert.assertFalse(childrenMinusButton.isEnabled());

        WebElement childrenPlusButton = driver.findElement(plusButtonBy);
        childrenPlusButton.click();
        Assert.assertEquals("1", numberOfChilden.getText());

        childrenMinusButton.click();
        Assert.assertEquals("0", numberOfChilden.getText());
        Assert.assertFalse(childrenMinusButton.isEnabled());

        for (int i = 0; i < 10; i++) {
            childrenPlusButton.click();
        }
        Assert.assertEquals("10", numberOfChilden.getText());
        Assert.assertFalse(childrenPlusButton.isEnabled());

        childrenPlusButton.click();
        Assert.assertEquals("10", numberOfChilden.getText());
        Assert.assertFalse(childrenPlusButton.isEnabled());

        childrenMinusButton.click();
        Assert.assertEquals("9", numberOfChilden.getText());
        System.out.println("Number of Children field boundary values tested.");
    }

    public void numberOfAdultsFieldBoundaryValues() {
        WebElement adultsChildrenRoomsPanel = driver.findElement(adultsChildrenRoomDropdownBy);
        adultsChildrenRoomsPanel.click();
        WebElement adultsMinusButton = driver.findElement(adultsMinusButtonBy);
        adultsMinusButton.click();
        WebElement adultsNumber = driver.findElement(adultsNumberBy);
        Assert.assertEquals("1", adultsNumber.getText());
        Assert.assertFalse(adultsMinusButton.isEnabled());

        adultsMinusButton.click();
        Assert.assertEquals("1", adultsNumber.getText());
        Assert.assertFalse(adultsMinusButton.isEnabled());

        WebElement adultsPlusButton = driver.findElement(adultsPlusButtonBy);
        adultsPlusButton.click();
        Assert.assertEquals("2", adultsNumber.getText());

        for (int i = 2; i < 30; i++) {
            adultsPlusButton.click();
        }
        Assert.assertEquals("30", adultsNumber.getText());
        Assert.assertFalse(adultsPlusButton.isEnabled());

        adultsPlusButton.click();
        Assert.assertEquals("30", adultsNumber.getText());
        Assert.assertFalse(adultsPlusButton.isEnabled());

        adultsMinusButton.click();
        Assert.assertEquals("29", adultsNumber.getText());
        System.out.println("Number of Adults field boundary values tested.");
    }

    public void modifyingNumberOfRooms() {
        WebElement adultsChildrenRoomPanel = driver.findElement(adultsChildrenRoomDropdownBy);
        adultsChildrenRoomPanel.click();
        WebElement minusButtonForRooms = driver.findElement(minusButtonForRoomsBy);
        minusButtonForRooms.click();
        WebElement numberOfRoomsSpan = driver.findElement(numberOfRoomsBy);
        Assert.assertEquals("1", numberOfRoomsSpan.getText());
        Assert.assertFalse(minusButtonForRooms.isEnabled());

        WebElement plusButtonForRooms = driver.findElement(plusButtonForRoomsBy);
        plusButtonForRooms.click();
        Assert.assertEquals("2", numberOfRoomsSpan.getText());

        minusButtonForRooms.click();
        Assert.assertEquals("1", numberOfRoomsSpan.getText());
        Assert.assertFalse(minusButtonForRooms.isEnabled());

        for (int i = 0; i < 30; i++) {
            plusButtonForRooms.click();
        }
        Assert.assertEquals("30", numberOfRoomsSpan.getText());
        Assert.assertFalse(plusButtonForRooms.isEnabled());

        plusButtonForRooms.click();
        Assert.assertEquals("30", numberOfRoomsSpan.getText());
        Assert.assertFalse(plusButtonForRooms.isEnabled());

        minusButtonForRooms.click();
        Assert.assertEquals("29", numberOfRoomsSpan.getText());
        System.out.println("The number of rooms test is finished.");
    }

    public void addDestination(String destinationName) {
        WebElement destination = driver.findElement(destinationFieldBy);
        destination.sendKeys(destinationName);
        Assert.assertEquals(destination.getAttribute("value"), destinationName);
        System.out.println("Destination is added.");
    }

    public void openSearchboxDatesContainer() {
        WebElement searchboxDatesContainer = driver.findElement(searchboxDatesContainerBy);
        searchboxDatesContainer.click();
        WebElement datepickerCalendar = driver.findElement(datePickerCalendarBy);
        Assert.assertTrue(datepickerCalendar.isDisplayed());
        System.out.println("Searchbox opened.");
    }

    public void addCheckInAndCheckOutDateFor20MarchTo24March() {
        WebElement checkInDateField = driver.findElement(checkInDateFor10MayBy);
        checkInDateField.click();
        WebElement checkOutDateField = driver.findElement(checkOutDateFor13MayBy);
        checkOutDateField.click();
        WebElement checkInDateFieldFilled20March = driver.findElement(searchPanelCheckInDateFieldBy);
        Assert.assertEquals(checkInDateFieldFilled20March.getText(), "Wed 10 May");
        WebElement checkOutDateFieldFilled24March = driver.findElement(searchPanelCheckOutDateFieldBy);
        Assert.assertEquals(checkOutDateFieldFilled24March.getText(), "Sat 13 May");
        System.out.println("Check in and check out date added.");
    }

    public void clickMainSearchButton() {
        WebElement mainSearchButton = driver.findElement(mainSearchButtonBy);
        mainSearchButton.click();
        WebElement searchResultPageSearchButton = driver.findElement(searchResultsPageSearchLabelBy);
        Assert.assertTrue(searchResultPageSearchButton.isDisplayed());
        System.out.println("Search button is clicked.");
    }

    public void clickOnFlightsInMenu() throws InterruptedException {
        WebElement flightsMenu = driver.findElement(flightsMenuBy);
        flightsMenu.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.booking.com/flights/"));
        System.out.println("Flights page is loaded.");
    }

    public void clickOnFlightHotelInMenu() {
        WebElement flightHotelMenu = driver.findElement(flightHotelMenuBy);
        flightHotelMenu.click();
        WebElement acceptCookieButton = wait.until(ExpectedConditions.elementToBeClickable(acceptCookieButtonOnLastMinutePageBy));
        acceptCookieButton.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("https://booking-hu.lastminute.com/"));
        System.out.println("Flight + Hotel page is loaded.");

        driver.navigate().back();
        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.booking.com/flights/"));
        System.out.println("Flights page is loaded again.");
    }

    public void clickOnCarRentalsInMenu() throws InterruptedException {
        WebElement carRentalsMenu = driver.findElement(carRentalsMenuBy);
        carRentalsMenu.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.booking.com/cars/"));
        System.out.println("Car rentals page is loaded.");
    }

    public void clickOnAttractionsInMenu() throws InterruptedException {
        WebElement attractionsMenu = driver.findElement(attractionsMenuFromCarRentalsBy);
        attractionsMenu.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.booking.com/attractions/"));
        System.out.println("Attractions page is loaded.");
    }

    public void clickOnAirportTaxisInMenu() throws InterruptedException {
        WebElement airportTaxisMenu = driver.findElement(airportTaxisMenuBy);
        airportTaxisMenu.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.booking.com/taxi/"));
        System.out.println("Airport taxis page is loaded.");
    }

    public void clickOnMainMenuInAirportTaxisPage() throws InterruptedException {
        WebElement mainMenuInAirportTaxisPage = driver.findElement(mainPageMenuOnAirportTaxisPageBy);
        mainMenuInAirportTaxisPage.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.booking.com/"));
        System.out.println("Main page is loaded");
    }
}
