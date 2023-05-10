package hu.progmatic.testcases;

import hu.progmatic.driverfactory.DriverBaseTest;
import hu.progmatic.pages.AppointmentPage;
import hu.progmatic.pages.HomePage;
import hu.progmatic.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AppointmentPageTests extends DriverBaseTest {
    LoginPage loginPage;
    HomePage homePage;
    AppointmentPage appointmentPage;

    @BeforeMethod
    public void loadedAppointmentPage() {
        homePage = new HomePage(driver, wait);
        loginPage = new LoginPage(driver, wait);
        homePage.loadHomePage();
        homePage.clickMakeAppointmentButton();
        loginPage.loginWitDemoUsernameAndPwd("John Doe", "ThisIsNotAPassword");
    }
    @Test(description = "Create an appointment and check if the confirmation is done." ,groups = "regression")
    public void createAnAppointmentTests(){
        appointmentPage = new AppointmentPage(driver, wait);
        appointmentPage.makeAnAppointment("Hongkong CURA Healthcare Center", "04/03/2023", "Lorem " +
                "ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse tincidunt dui odio. Nam diam nisl, sagittis et " +
                "elementum quis, rutrum nec augue. Donec id felis ut est venenatis posuere. Morbi euismod turpis iaculis " +
                "neque lacinia bibendum quis eget est.");
    }


}
