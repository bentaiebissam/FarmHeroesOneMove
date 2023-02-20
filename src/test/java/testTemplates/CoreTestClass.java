package testTemplates;

import Helpers.DriverFactory;
import Helpers.KingDriverActions;
import org.testng.annotations.*;

public class CoreTestClass {

     protected KingDriverActions actions;

     @BeforeSuite
    public void beforeTestSuite() {
        System.out.println("LOG: Starting Test Suit");
    }

    @BeforeClass
    public void createKindredActions() {
        System.out.println("Starting appium driver");
        actions = new KingDriverActions(DriverFactory.getDriver()) ;
        //Initiate the driver and the driver helpers
        //TODO: refer to a non hard coded link


        }

    @AfterMethod
    public void closeApplication() {
        System.out.println("LOG: Closing App");
        actions.closeApp();
    }

    @AfterClass
    public void quitDriver() {
        System.out.println("LOG: Closing Appium Driver");
        actions.quitDriver();
    }

   @AfterSuite
    public void reviewResults() {
       //TODO: Handle results visulaisation/distribution to cucunber
    }


}


