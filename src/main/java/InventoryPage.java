import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


import static java.lang.Integer.parseInt;
import static junit.framework.TestCase.assertEquals;
import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class InventoryPage extends BasePage {


    @FindBy(css = "[class=\"inventory_list\"]")
    private WebElement inventoryList;

    @FindBy(css = "[class=\"inventory_item\"]")
    private List<WebElement> productsCards;

    @FindBy(css = "[class=\"inventory_item_name\"]")
    private List<WebElement> productsName;

    @FindBy(xpath = "//a[@href='https://twitter.com/saucelabs']")
    private WebElement twitterIconLink;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement sideBarOpenIcon;

    @FindBy(id = "inventory_sidebar_link")
    private List<WebElement> itemsName;

    @FindBy(id = "about_sidebar_link")
    private WebElement about;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logout;

    @FindBy(id = "reset_sidebar_link")
    private WebElement reset;


    @FindBy(id = "react-burger-cross-btn")
    WebElement closeSidebar;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement addBackpackToCardButton;

    @FindBy(id = "shopping_cart_container")
    private WebElement cartIcon;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    private WebElement addBikeLightToCartButton;

    @FindBy (xpath = "//*[@id=\"inventory_container\"]/div/div[1]/div[2]/div[2]/div/text()[2]")
    private WebElement priceOfSauceLabsBackpack;

    @FindBy (xpath = "//*[@id=\"inventory_container\"]/div/div[2]/div[2]/div[2]/div/text()[2]")
    private WebElement priceOfSauceLabsBikeLight;



    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public void inventoryListShouldBeDisplyed() {
        assertTrue(inventoryList.isDisplayed());
    }

    public void checkOfProductsAreDisplayed() {
        for (WebElement product :
                productsCards) {
            assertTrue(product.isDisplayed());

        }
    }

    public void checkAmountOfProducts(int expectedAmount) {
        assertEquals("Amount of products is not " + expectedAmount, productsCards.size(), expectedAmount);

    }


    public void checkProductsNameIsDisplayed() {
        for (WebElement title :
                productsName) {
            assertTrue(title.isDisplayed());
        }

    }

    public void checkProductsNameIsNoEmpty() {
        for (WebElement title :
                productsName) {
            assertFalse(title.getText().isEmpty());
        }

    }

    public void checkTwitterIconLink() {
        assertTrue(twitterIconLink.isDisplayed());

    }

    public void clickOnTheSideBarOpenIcon() {

        clickOnTheElement(sideBarOpenIcon);

    }

    public boolean allItemsIsDisplayed() {
        return allElementsOfCollectionAreDisplay(productsName);
    }

    public void aboutIsDisplayed() {
        assertTrue(about.isDisplayed());
        //assertThat(about.isDisplayed(),is(true));
        //assertThat(about.getAttribute("href"), startsWith("https://"));
        //assertThat(about.getText(), allOf("https://"), contains("saucedemo"));
    }


    public void logoutIsDisplayed() {
        assertTrue(logout.isDisplayed());
    }

    public void resetIsDisplayed() {
        assertTrue(reset.isDisplayed());
    }

    public void closeSidebar() {
        closeSidebar.click();
    }

    public void allItemsIsNotDisplay() {
        assertFalse(about.isDisplayed());
    }

    public void clickOnAddToCartBackpack() {
        clickOnTheElement(addBackpackToCardButton);

    }

    public void clickOnTheCardIcon() {
        clickOnTheElement(cartIcon);

    }

    public void clickOnTheResetAppAState() {
        clickOnTheElement(reset);
    }

    public void clickOnTheCloseSideBarIcon() {
        clickOnTheElement(closeSidebar);

    }

    public void resetAppState() {
        clickOnTheSideBarOpenIcon();
        clickOnTheResetAppAState();
        clickOnTheCloseSideBarIcon();
        refreshPage();
    }

    public void clickOnAddToCardBikeLight() {
        clickOnTheElement(addBikeLightToCartButton);
    }

    public double sumOfPriseOnInventoryPage(double sumPriseOnInventoryPage) {
        double sumOfTwoItems = (Double.parseDouble(priceOfSauceLabsBikeLight.getText()) +
                Double.parseDouble(priceOfSauceLabsBackpack.getText()));
        return sumPriseOnInventoryPage;

    }
}










