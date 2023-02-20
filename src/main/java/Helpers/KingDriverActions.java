package Helpers;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

import org.openqa.selenium.*;

import java.util.List;

public class KingDriverActions {

    protected AppiumDriver driver;
    protected TouchAction touchAction;



    //Provides a set of actions usable throughout the project
    public KingDriverActions(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        this.touchAction = new TouchAction(driver);
    }


    public KingDriverActions click(By locator) {
        WebElement element = driver.findElement(locator);
        sleep(1000);
        element.click();
        return this;
    }

    public KingDriverActions clickElementsByContainsText(String text) {
        sleep(1000);
        List<WebElement> elements = driver.findElementsByXPath("//*[contains(text(), '" + text + "')]");
        int size = elements.size();

        while (size > 0) {
            WebElement element = elements.get(size - 1);
            touchAction.tap(PointOption.point(element.getLocation()));
            size--;
        }
        return this;
    }

    public KingDriverActions tapElementByContainsText(String text) {
        sleep(1000);
        WebElement element = driver.findElementByXPath("//*[contains(text(), '" + text + "')]");
        touchAction.tap(PointOption.point(element.getLocation()));
        return this;
    }


    public KingDriverActions tap(By locator) {
        WebElement element = driver.findElement(locator);
        sleep(200);
        touchAction.tap(TapOptions.tapOptions().withElement((ElementOption) element)).perform();
        return this;
    }


    public KingDriverActions sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (Exception ignore) {
        }
        return this;
    }
    //Will be used to swap cropsies given their coordinates
    public KingDriverActions swipeTwoCropsies(Point crop1, Point crop2) {
        try {
            TouchAction touchAction = new TouchAction(driver);
            touchAction.press(PointOption.point(crop1)).moveTo(PointOption.point(crop2)).release().perform();

        } catch (Exception ignore) {
            System.out.println("There was an issue swaping the cropsies");
        }
        return (KingDriverActions) this;
    }
    //Used to click on elements given their coordinates
    public KingDriverActions clickByCoordinates(Point button) {
        try {
            TouchAction touchAction = new TouchAction(driver);
            touchAction.tap(PointOption.point(button)).perform();
        } catch (Exception ignore) {
            System.out.println("There was an issue clicking the button by coordinates");
        }
        return (KingDriverActions) this;
    }

    public KingDriverActions closeApp() {
        driver.closeApp();
        return this;
    }

    public KingDriverActions quitDriver() {
        driver.quit();
        return this;
    }

    public Boolean isEelementDisplayed(By locator) {
        WebElement element = driver.findElement(locator);
        return (element.isDisplayed());
    }


}


