package hu.progmatic.exampletests;

import hu.progmatic.driverfactory.DriverBaseTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class GoogleHomeTest extends DriverBaseTest {

    @Test(description = "Open google.hu")
    @Ignore
    public void openGoogleHomeScreenTest() {
        driver.get("https://google.hu");
    }

    @Test(description = "Open google.de")
    @Ignore
    public void openGoogleHomeScreen2Test() {
        driver.get("https://google.de");
    }
}
