package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import org.testng.log4testng.Logger;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public AppiumDriverLocalService service;
    public Logger log;
    public AppiumDriver<MobileElement> driver;

    private By buildLocator = MobileBy.xpath("//android.view.View[@content-desc='Expo Go']");
    private By registrationButton = By.id("Yura test");
    @BeforeMethod
    public void setUpAppiumService() throws MalformedURLException {

        //Environment settings
        Map<String, String> env = new HashMap<String, String>(System.getenv());
        env.put("ANDROID_HOME", "/Users/yuramyronov/Library/Android/sdk");
        env.put("JAVA_HOME", "/Users/yuramyronov/Library/Java/JavaVirtualMachines/openjdk-19.0.2/Contents/Home");

        //Launch the Appium service
        service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .withEnvironment(env));
        service.start();

        //Device and app capabilities
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("platformVersion", "13");
        desiredCapabilities.setCapability("deviceName", "Pixel 4a");
        desiredCapabilities.setCapability("noReset", "True");
        desiredCapabilities.setCapability("automationName", "UiAutomator2");
        desiredCapabilities.setCapability("appPackage", "com.android.chrome");
        desiredCapabilities.setCapability("appActivity", "org.chromium.chrome.browser.ChromeTabbedActivity");

        //Set the app capabilities to the driver
        driver = new AndroidDriver<MobileElement>(desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Launch the app by Expo
        driver.get("http://192.168.0.102:19000/_expo/loading");
        MobileElement mobileElement = driver.findElement(buildLocator);
        mobileElement.click();

    }
    protected void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //Teat Down the appiun service and driver
       @AfterMethod
       public void tearDown(){
        driver.quit();
        service.stop();
        }

    }
