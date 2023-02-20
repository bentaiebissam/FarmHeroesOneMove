package Pages;

import Helpers.KingDriverActions;
import org.openqa.selenium.Point;



public abstract class CorePage {

    protected KingDriverActions actions;
    //Used to make sure the page is loaded
    protected Point pageMarker;

    protected CorePage(KingDriverActions actions, Point marker) {
        this.actions = actions;
        this.pageMarker = marker;
    }





}
