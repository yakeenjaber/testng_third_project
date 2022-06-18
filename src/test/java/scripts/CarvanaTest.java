package scripts;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CarvanaSearchCarsPage;

public class CarvanaTest extends Base{

    //TEST CASE 1
    //Given user is on "https://www.carvana.com/"
    //Then validate title equals to "Carvana | Buy & Finance Used Cars Online | At Home Delivery"
    //And validate url equals to "https://www.carvana.com/"

    @Test(priority = 1, description = "Validate Carvana home page title and url")
    public void testCarvanaHomePageTitleAndUrl(){
        driver.get("https://www.carvana.com/");

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.carvana.com/");
        Assert.assertEquals(driver.getTitle(),"Carvana | Buy & Finance Used Cars Online | At Home Delivery");
    }

    //TEST CASE 2
    //Given user is on "https://www.carvana.com/"
    //Then validate the logo of the “Carvana” is displayed
    @Test(priority = 2, description = "Validate the Carvana logo")
    public void testCarvanaLogo(){
        driver.get("https://www.carvana.com/");
        Assert.assertTrue(carvanaHomePage.carvanaLogo.isDisplayed());
    }

    //TEST CASE 3
    //Given user is on "https://www.carvana.com/"
    //Then validate the navigation section items below are displayed
    //|HOW IT WORKS      |
    //|ABOUT CARVANA     |
    //|SUPPORT & CONTACT |
    @Test(priority = 3, description = "Validate the main navigation section items")
    public void testMainNavigationItems() {
        driver.get("https://www.carvana.com/");
        String[] expectedMainNavigationSectionText = {"HOW IT WORKS", "ABOUT CARVANA", "SUPPORT & CONTACT"};
        for (int i = 0; i < carvanaHomePage.mainNavigationItems.size(); i++) {
            Assert.assertTrue(carvanaHomePage.mainNavigationItems.get(i).isDisplayed());
            Assert.assertEquals(carvanaHomePage.mainNavigationItems.get(i).getText(), expectedMainNavigationSectionText[i]);
        }
    }


    //TEST CASE 4
    //Given user is on "https://www.carvana.com/"
    //When user clicks on “SIGN IN” button
    //Then user should be navigated to “Sign in” modal
    //When user enters email as “johndoe@gmail.com”
    //And user enters password as "abcd1234"
    //And user clicks on "SIGN IN" button
    //Then user should see error message as "Email address and/or password combination is incorrect
    //Please try again or reset your password."

    @Test(priority = 4, description = "Validate the sign in error message")
    public void testSignInErrorMessage(){
        driver.get("https://www.carvana.com/");
        carvanaHomePage.signInButton.click();
        carvanaHomePage.emailSignInInput.sendKeys("johndoe@gmail.com");
        carvanaHomePage.passwordSignInInput.sendKeys("abcd1234");
        carvanaHomePage.modalSignInButton.click();
        Assert.assertEquals(carvanaHomePage.signInErrorMessage.getText(), "Email address and/or password combination is incorrect\n" +
                "Please try again or reset your password.");
    }


    //TEST CASE 5
    //Given user is on "https://www.carvana.com/"
    //When user clicks on "SEARCH CARS" link
    //Then user should be routed to "https://www.carvana.com/cars"
    //And user should see filter options
    //|PAYMENT & PRICE      |
    //|MAKE & MODEL      |
    //|BODY TYPE |
    //|YEAR & MILEAGE      |
    //|FEATURES      |
    //|MORE FILTERS |
    @Test(priority = 5, description = "Validate the search filter options and search button")
    public void testSearchFilterAndSearchButton(){
        driver.get("https://www.carvana.com/");
        carvanaHomePage.searchCarsButton.click();
        String[] expectedSearchCarFilters = {"PAYMENT & PRICE", "MAKE & MODEL", "BODY TYPE", "YEAR & MILEAGE", "FEATURES", "MORE FILTERS"};
        for (int i = 0; i < carvanaSearchCarsPage.filterOptions.size(); i++) {
            Assert.assertTrue(carvanaSearchCarsPage.filterOptions.get(i).isDisplayed());
            Assert.assertEquals(carvanaSearchCarsPage.filterOptions.get(i).getText(), expectedSearchCarFilters[i]);
        }
    }


    //TEST CASE 6
    //Given user is on "https://www.carvana.com/"
    //When user clicks on "SEARCH CARS" link
    //Then user should be routed to "https://www.carvana.com/cars"
    //When user enters "mercedes-benz" to the search input box
    //And user clicks on "GO" button in the search input box
    //Then user should see "mercedes-benz" in the url
    //And validate each result tile
    //1. an image
    //2. add to favorite button
    //3. tile body
    //ALSO VALIDATE EACH TILE BODY:
    //Make sure each tile body has below information
    //1. Inventory type - text should be displayed and should not be null
    //2. Year-Make-Model information - text should be displayed and should not be null
    //3. Trim-Mileage information - text should be displayed and should not be null
    //4. Price - Make sure that each price is more than zero
    //5. Monthly Payment information - text should be displayed and should not be null
    //6. Down Payment information - text should be displayed and should not be null
    //7. Delivery chip must be displayed as “Free Shipping”

    @Test(priority = 6, description = "Validate the search result tiles")
    public void testSearchResultTiles(){
        driver.get("https://www.carvana.com/");
        carvanaHomePage.searchCarsButton.click();
        carvanaSearchCarsPage.searchBarInput.sendKeys("mercedes-benz");
        carvanaSearchCarsPage.goButton.click();
        //Assert.assertTrue(driver.getCurrentUrl().contains("mercedes-benz"));

        for (int i = 0; i < carvanaMercedesBenzPage.resultTilePictures.size(); i++) {
            Assert.assertTrue(carvanaMercedesBenzPage.resultTilePictures.get(i).isDisplayed());
            Assert.assertTrue(carvanaMercedesBenzPage.resultTileFavButton.get(i).isDisplayed());
            Assert.assertTrue(carvanaMercedesBenzPage.resultTileInventoryType.get(i).isDisplayed());
            Assert.assertTrue(carvanaMercedesBenzPage.resultTileYearMakeModel.get(i).isDisplayed());
            Assert.assertTrue(carvanaMercedesBenzPage.resultTileTrimMileage.get(i).isDisplayed());
            Assert.assertTrue(Integer.parseInt(carvanaMercedesBenzPage.resultTilePrice.get(i).getText().replace("$", "").replace(",", "")) > 0);
            Assert.assertTrue(carvanaMercedesBenzPage.resultTileMonthlyPayment.get(i).isDisplayed());
            Assert.assertTrue(carvanaMercedesBenzPage.resultTileDownPayment.get(i).isDisplayed());
            Assert.assertTrue(carvanaMercedesBenzPage.resultTileInventoryType.get(i).isDisplayed());

        }
    }
}
