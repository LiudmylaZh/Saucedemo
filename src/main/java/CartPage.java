import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;



public class CartPage extends BasePage{

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (id = "checkout")
    public WebElement checkoutButton;

     @FindBy (className = "cart_item_label")
    private List <WebElement> productCarts;




    @FindBy (className = "inventory_item_name")
    private List <WebElement> productNames;

    public boolean checkoutButtonIsDisplayed () {
        return checkoutButton.isDisplayed();
    }

    public boolean checkProductCartsQuantity( int expectedQuantity) {
     //assertEquals("Product carts quantity is not equal to" + expectedQuantity, productCarts.size());
     return productCarts.size() == expectedQuantity;
    }

    public void clickOnCheckoutButton () {
        clickOnTheElement(checkoutButton);
    }





}


