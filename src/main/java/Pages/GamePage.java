package Pages;

import Helpers.KingDriverActions;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;


public class GamePage extends CorePage {

    public static final Point apple = new Point (1150,1715);
    public static final Point strawberry = new Point (1150,1525);


    public static final Point pageMarker = apple ;

    public GamePage(KingDriverActions actions, Point pageMarker) {
        super(actions,pageMarker);
    }

   public GamePage(KingDriverActions actions) {
        super(actions,pageMarker);
    }

    //swaps the apple and the strawberry
    public Boolean oneMove() {

        try {
            actions.sleep(9000);
            actions.swipeTwoCropsies(apple,strawberry);
        }
        catch (Exception e) {
            System.out.println("Error swapping the apple and the strawberry ");
            return false;
        }
        return true;
    }




}
