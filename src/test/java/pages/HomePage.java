package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomePage {
    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    public String homePageTitle = "WebstaurantStore: Restaurant Supplies & Foodservice Equipment";

    @FindBy(id = "searchval")
    public WebElement searchTextField;

    @FindBy(css = "button[value='Search']")
    public WebElement searchButton;

    @FindBy(xpath = "//*[@id=\"ProductBoxContainer\"]/div[1]/a/span")
    public List<WebElement> itemDescription;

    @FindBy(xpath = "//li[@class=\"inline-block leading-4 align-top rounded-r-md\"]/a")
    public WebElement nextPage;

    @FindBy(xpath = "//li[@class=\"inline-block leading-4 align-top\"]/a")
    public List<WebElement> pages;

    @FindBy(name = "addToCartButton")
    public List<WebElement> addToCartButton;

    @FindBy(css = "a[data-testid='cart-button']>span")
    public WebElement cartButton;

    @FindBy(xpath = "//*[@id=\"main\"]/div[1]/div/div[2]/ul/li[2]/div/div[6]/button")
    public WebElement deleteCartItemButton;

    @FindBy(xpath = "//*[@id=\"main\"]/div[1]/div/div[2]/ul/li[2]/div/div[2]/span/a")
    public WebElement deleteCartItemButton11;


}
