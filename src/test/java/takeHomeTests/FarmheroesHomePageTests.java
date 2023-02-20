package takeHomeTests;

import Pages.FarmheroesHomePage;
import Pages.GamePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import testTemplates.CoreTestClass;

public class FarmheroesHomePageTests extends CoreTestClass {



    //Below test makes one move based on cropsie coordinate and button coordinates for Pixel_XL_API_30
    @Test
    public void kingChallange(){
        Boolean interviw =new FarmheroesHomePage(actions)
                .acceptPopup()
                .goToGamePage()
                .oneMove();

        Assert.assertTrue(interviw, "Could not make one move");
    }



}