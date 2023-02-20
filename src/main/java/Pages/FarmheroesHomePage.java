package Pages;


import Helpers.KingDriverActions;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;

import java.awt.*;

public class FarmheroesHomePage extends CorePage {

    //coordinates for the Pixel_XL_API_30 device
    public static final Point welcomeBtnPoint = new Point(700,1730);
    public static final Point playBtnPoint = new Point(700,1900);

    public static final Point pageMarker = welcomeBtnPoint;


    public FarmheroesHomePage(KingDriverActions actions) {
        super(actions,pageMarker);
    }

    public FarmheroesHomePage(KingDriverActions actions, By markers ) {
        super(actions,pageMarker);
    }

    //accept the welcome button is presented
    public FarmheroesHomePage acceptPopup () {
        try {
           actions.sleep(23000);
           actions.clickByCoordinates(welcomeBtnPoint);

        }
        catch (Exception e) {
            System.out.println("No cookie popup was found");
            System.out.println(e);
        }
        return  this;
    }

    public GamePage goToGamePage () {

        try {
            actions.sleep(13000);
            actions.clickByCoordinates(playBtnPoint);

        }
        catch (Exception e) {
            System.out.println("Could not start game");
            System.out.println(e);
        }
        return new GamePage(actions);
    }




}
