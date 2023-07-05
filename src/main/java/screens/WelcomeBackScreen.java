package screens;

import base.BasePageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class WelcomeBackScreen extends BasePageObject {

    private By emailFieldLocator = MobileBy.AccessibilityId("email_field_lible");
    private By passwordFieldLocator = MobileBy.AccessibilityId("password_field_lible");
    private By signInButtonLocator = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView");

    public WelcomeBackScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public HomeScreen executeSignIn(String email, String password){
        type(email, emailFieldLocator);
        type(password, passwordFieldLocator);
        click(signInButtonLocator);
        return new HomeScreen(driver);
    }
}
