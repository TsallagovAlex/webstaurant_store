package step_def;

import actions.HomePageActions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.Selenium;

public class HomePageSteps {
    HomePageActions homePageActions = new HomePageActions();

    @Given("User goes to {string}")
    public void user_goes_to(String webPageName) {
        homePageActions.goToPage(webPageName);
        Selenium.waitForPageToLoad();
    }

    @When("Search for {string}")
    public void searchForStainlessWorkTable() {

    }

    @Then("verify user landed on correct page")
    public void verifyUserLandedOnCorrectPage() {
        homePageActions.verifyHomePageTitle();
    }

    @When("Search {string}")
    public void searchStainlessWorkTable(String searchData) {
        homePageActions.sendKeys(searchData);
    }

    @Then("Check the search result ensuring every product has the word {string} in its title")
    public void checkTheSearchResultEnsuringEveryProductHasTheWordTableInItsTitle(String searchResultTitle) {
        homePageActions.verifyItemDescriptionContains(searchResultTitle);
    }

    @When("Add the last of found items to Cart")
    public void addTheLastOfFoundItemsToCart() {
        homePageActions.addToCartLastItem();
    }

    @And("Empty Cart")
    public void emptyCart() {
    homePageActions.removeItemFromCart();
    }
}
