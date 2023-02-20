package Helpers;



import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class DriverFactory {

    //Please refer to your Appium server port/URL , AVD and apk path
    private static String driverURL = "http://localhost" ;
    private static String driverPort = "4723" ;
    private static String deviceName = "Pixel_XL_API_30" ;
    private static String UDID = "emulator-5554" ;
    private static String APP = "your apk path here" ;



    public static URL getAppiumServerURL(){
        try {
            return new URL(String.format("%s:%s/wd/hub", driverURL, driverPort));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static AppiumDriver getDriver() {

       long implicitWaitTime = 10 ;
        URL local = getAppiumServerURL();
        AppiumDriver<MobileElement> driver = null;

        //Capabilities
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13.2");
        capabilities.setCapability(MobileCapabilityType.APP, APP);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        capabilities.setCapability(MobileCapabilityType.UDID, UDID);
        capabilities.setCapability(AndroidMobileCapabilityType.AVD, deviceName);
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 999999);


        try {
            driver = new AndroidDriver<MobileElement>(local, capabilities);

        } catch (Exception e) {
            if (e.getCause() instanceof ConnectException) {
                return getDriver();
            }
            System.out.println(e.getMessage());
        }

        driver.manage().timeouts().implicitlyWait(implicitWaitTime, TimeUnit.MILLISECONDS);
        return driver;
    }

}