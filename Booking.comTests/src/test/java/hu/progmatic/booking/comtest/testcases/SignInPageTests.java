package hu.progmatic.booking.comtest.testcases;

import hu.progmatic.booking.comtest.pages.MainPage;
import hu.progmatic.booking.comtest.pages.SignInPage;
import hu.progmatic.driverfactory.DriverBaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class SignInPageTests extends DriverBaseTest {
    SignInPage signInPage;
    MainPage mainPage;
    List<String> email = Arrays.asList("testlab.projektgmail.com","testlab.projekt@gmailcom","12345678","34!!/%+'@AAPK.hu");

    @BeforeMethod
    public void loadedMainPage() {
        mainPage = new MainPage(driver, wait);
        mainPage.loadHomePage();
    }

    @Test(description = "T9: Login with valid email and password", groups = {"smoke", "regression"})
    public void LoginValidEmailAndPwdTest() throws InterruptedException {
        signInPage = new SignInPage(driver, wait);
        signInPage.signInWithValidEmailAndPassword("testlab.projekt@gmail.com", "Progmatic_TestLab_Projekt1");
    }

    @Test(description = "T7: Login with valid email and empty password", groups = {"smoke", "regression"})
    public void loginWithValidEmailAndEmptyPasswordTest() throws InterruptedException {
        signInPage = new SignInPage(driver, wait);
        signInPage.loginWithValidEmailAndEmptyPassword("testlab.projekt@gmail.com");
    }

    @Test(description = "T3: Login with invalid email", groups = {"smoke", "regression"})
    public void loginWithInvaildEmailTest() {
        signInPage = new SignInPage(driver, wait);
        signInPage.singInWithInvalidEmail(email);
    }

    @Test(description = "T6: Login with empty email", groups = {"smoke", "regression"})
    public void loginWithEmptyEmail(){
        signInPage = new SignInPage(driver,wait);
        signInPage.signInWithEmptyEmail();
    }

    @Test(description = "T4: Login with valid e-mail and invalid password", groups = {"smoke", "regression"})
    public void loginWithValidEmailAndInvalidPassword() {
        signInPage = new SignInPage(driver, wait);
        signInPage.signInWithValidEmailAndInvalidPassword("testlab.projekt@gmail.com", "progmatic_testlab");
    }
}
