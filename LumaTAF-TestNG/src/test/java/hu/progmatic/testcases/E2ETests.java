package hu.progmatic.testcases;

import hu.progmatic.driverfactory.DriverBaseTest;
import hu.progmatic.pages.AppointmentPage;
import hu.progmatic.pages.HomePage;
import hu.progmatic.pages.LoginPage;
import hu.progmatic.pages.ProfilPage;
import org.testng.annotations.Test;

public class E2ETests extends DriverBaseTest {
    LoginPage loginPage;
    HomePage homePage;
    AppointmentPage appointmentPage;
    ProfilPage profilPage;

    @Test(description = "Load the homepage, click the 'Make Appointment' button and login with demo username and password and create an " +
            "appointment and log out.", groups = {"regression", "smoke"})
    public void createAnAppointmentWithDemoUserE2ETest(){
        homePage = new HomePage(driver, wait);
        loginPage = new LoginPage(driver, wait);
        appointmentPage = new AppointmentPage(driver, wait);
        profilPage = new ProfilPage(driver,wait);
        homePage.loadHomePage();
        homePage.clickMakeAppointmentButton();
        loginPage.loginWitDemoUsernameAndPwd("John Doe", "ThisIsNotAPassword");
        appointmentPage.makeAnAppointment("Hongkong CURA Healthcare Center", "04/03/2023", "Lorem ipsum");
        profilPage.navigateToMenuAndLogout();
    }


}
