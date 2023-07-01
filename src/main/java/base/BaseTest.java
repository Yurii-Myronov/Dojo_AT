package base;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public AppiumDriverLocalService service;
    public AndroidDriver<MobileElement> driver;

    @BeforeMethod
    public void setUpAppiumService() throws MalformedURLException {

        Map<String, String> env = new HashMap<String, String>(System.getenv());
        env.put("ANDROID_HOME", "/Users/yuramyronov/Library/Android/sdk");
        env.put("JAVA_HOME", "/Users/yuramyronov/Library/Java/JavaVirtualMachines/openjdk-19.0.2/Contents/Home");

        service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .withEnvironment(env));
        service.start();

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("platformVersion", "13");
        desiredCapabilities.setCapability("deviceName", "Pixel 4a");
        desiredCapabilities.setCapability("noReset", "True");
        desiredCapabilities.setCapability("automationName", "UiAutomator2");
        desiredCapabilities.setCapability("appPackage", "com.dojosoftware.dojo");
        desiredCapabilities.setCapability("appActivity", "com.dojosoftware.dojo.MainActivity");

        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
        @AfterMethod
        public void tearDown(){
            driver.quit();
            service.stop();
        }

    }
