package test;

import base.TestUtilities;
import org.testng.annotations.Test;
import screens.RegistrationScreen;

public class RegistrationTest extends TestUtilities {

    @Test
    public void studioRegistration(){
        //log.info("Starting the new studio registration");
        RegistrationScreen registrationScreen = new RegistrationScreen(driver);
        registrationScreen.executeStudioRegistration("AT_School", "towo" + userEmail + "@mailinator.com", "Qwerty123");

    }
}
