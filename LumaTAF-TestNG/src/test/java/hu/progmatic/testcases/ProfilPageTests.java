package hu.progmatic.testcases;

import hu.progmatic.driverfactory.DriverBaseTest;
import hu.progmatic.pages.AppointmentPage;
import hu.progmatic.pages.HomePage;
import hu.progmatic.pages.LoginPage;
import hu.progmatic.pages.ProfilPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProfilPageTests extends DriverBaseTest {
    LoginPage loginPage;
    HomePage homePage;
    ProfilPage profilPage;

    @BeforeMethod
    public void login(){
        homePage = new HomePage(driver, wait);
        loginPage = new LoginPage(driver, wait);
        homePage.loadHomePage();
        homePage.clickMakeAppointmentButton();
        loginPage.loginWitDemoUsernameAndPwd("John Doe", "ThisIsNotAPassword");
    }


    @Test(description = "After login navigate with 'Menu' to the Profile page and check that it is displayed.", groups = "regression")
    public void navigateWithMenuToProfilePage(){
        profilPage = new ProfilPage(driver, wait);
        profilPage.navigateToProfilePage();
    }

    @Test(description = "Logout with menu. And check that the main page is displayed", groups = "regression")
    public void logoutWithUsingMenu(){
        profilPage = new ProfilPage(driver, wait);
        profilPage.navigateToMenuAndLogout();
    }


}
