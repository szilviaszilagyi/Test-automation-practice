package hu.progmatic.testcases;

import hu.progmatic.driverfactory.DriverBaseTest;
import hu.progmatic.pages.HomePage;
import hu.progmatic.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTests extends DriverBaseTest {
    LoginPage loginPage;
    HomePage homePage;

    @BeforeMethod
    public void loadedLoginPage() {
        homePage = new HomePage(driver, wait);
        homePage.loadHomePage();
        homePage.clickMakeAppointmentButton();
    }

    @Test(description = "Try to login with invalid username and password and check if the correct error message is displayed.", groups = "regression")
    public void loginWithWrongUsernameAndPasswordTest() {
        loginPage = new LoginPage(driver, wait);
        loginPage.loginWithInvalidUsernameAndPwd("Jean Doe", "MyPasswordIsUnicorn");
    }

    @Test(description = "Try to login with demo username and password and check if the appointment page is displayed.", groups = "regression")
    public void loginWithValidUsernameAndPasswordTest() {
        loginPage = new LoginPage(driver, wait);
        loginPage.loginWitDemoUsernameAndPwd("John Doe", "ThisIsNotAPassword");
    }


}
