package test;

import base.TestUtilities;
import org.testng.annotations.Test;
import screens.RegistrationScreen;
import screens.WelcomeBackScreen;

public class SignInTest extends TestUtilities {

    @Test
    public void signIn(){
        RegistrationScreen registrationScreen = new RegistrationScreen(driver);
        WelcomeBackScreen welcomeBackScreen = registrationScreen.goToWelcomeBackScreen();
        welcomeBackScreen.executeSignIn("testerpetterson+6@gmail.com", "Qwerty123");
    }
}
