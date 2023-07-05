package screens;

import base.BasePageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.testng.log4testng.Logger;

public class RegistrationScreen extends BasePageObject {

    //private By formTitleLocator = MobileBy.AccessibilityId("");
    //private By secondForTitleLocator = MobileBy.AccessibilityId("");
    private By schoolNameFieldLocator = MobileBy.AccessibilityId("school_name_field_lible");
    private By emailFieldLocator = MobileBy.AccessibilityId("email__field_lible");
    private By passwordFieldLocator = MobileBy.AccessibilityId("password_field_lible");
    private By registerNowButtonLocator = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup");

    public RegistrationScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    //Execute Studio registration
    public VerificationScreen executeStudioRegistration(String schoolName, String email, String password){
        //log.info("Execute Studio Registration with: schoolName ["+ schoolName +"] , email [" + email + "], password [" + password + "]");
        type(schoolName, schoolNameFieldLocator);
        type(email, emailFieldLocator);
        type(password, passwordFieldLocator);
        click(registerNowButtonLocator);
        return new VerificationScreen(driver);
    }



}
