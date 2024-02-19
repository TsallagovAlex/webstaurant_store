package actions;

import org.junit.Assert;
import pages.HomePage;
import utils.ConfigReader;
import utils.Cucumber;
import utils.Driver;
import utils.Selenium;

public class HomePageActions {
    HomePage homePage = new HomePage();

    public void goToPage(String webPageName) {
        switch (webPageName) {
            case "Home Page":
                Driver.getDriver().get(ConfigReader.readProperty("url", "src/test/resources/config/configuration.properties"));
                Cucumber.logInfo("open" + webPageName, true);
                break;
            default:
                System.out.println("Wrong name of the link was parsed");
        }


    }

    public void verifyHomePageTitle() {
        Assert.assertEquals(homePage.homePageTitle, Driver.getDriver().getTitle());
    }

    public void clickSearchButton() {
        homePage.searchButton.click();
    }

    public void sendKeys(String searchData) {
        homePage.searchTextField.sendKeys(searchData);
        clickSearchButton();
    }

    public void verifyItemDescriptionContains(String text) {
        int pageCount = 0;

        for (int i = 0; i <= homePage.pages.size(); i++) {
            pageCount++;
            for (int j = 0; j < homePage.itemDescription.size(); j++) {
                Assert.assertTrue("Item title does not match requirements on page #" + pageCount + " Item title: " +
                                homePage.itemDescription.get(j).getText(),
                        homePage.itemDescription.get(j).getText().toLowerCase().contains(text.toLowerCase()));
            }
            if (homePage.nextPage.getAttribute("aria-label").contains("go to")) {
                homePage.nextPage.click();
            }
        }
    }

    public void addToCartLastItem() {
        homePage.addToCartButton.get(homePage.addToCartButton.size() - 1).click();
    }

    public void removeItemFromCart() {
        Selenium.sleep(15000);
        homePage.cartButton.click();
        homePage.deleteCartItemButton.click();


    }

}
