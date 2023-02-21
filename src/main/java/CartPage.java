import dev.failsafe.Execution;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
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

    @Step("Checkout button is displayed")
    public boolean checkoutButtonIsDisplayed () {
        return checkoutButton.isDisplayed();
    }

    @Step("Get quantity of products")
    public boolean checkProductCartsQuantity( int expectedQuantity) {
     //assertEquals("Product carts quantity is not equal to" + expectedQuantity, productCarts.size());
     return productCarts.size() == expectedQuantity;
    }
    @Step("Cart is empty")
    public boolean cartIsEmpty (){
        boolean empty = false;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
            wait.until(ExpectedConditions.visibilityOf(productCarts.get(0)));
           productCarts.get(0).isDisplayed();
        } catch (Exception e) {
            empty = true;
        }
        return empty;
    }
    @Step("Click on checkout button")
    public void clickOnCheckoutButton () {
        clickOnTheElement(checkoutButton);
    }





}


