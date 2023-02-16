import org.junit.Test;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class CheckoutTest extends TestBaseNew {
    @Test
    public void checkQuantityOfProducts()
    { User user = new User(userName, password);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(user);
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.resetAppState();
        inventoryPage.clickOnAddToCartBackpack();
        inventoryPage.clickOnAddToCardBikeLight();
        inventoryPage.clickOnTheCardIcon();
        CartPage cardPage = new CartPage(driver);
        cardPage.clickOnCheckoutButton();
        CheckoutStepOnePage checkoutStepOnePage = new CheckoutStepOnePage(driver);
        checkoutStepOnePage.enterFirstName("Harry");
        checkoutStepOnePage.enterLastName("Potter");
        checkoutStepOnePage.enterZipCode("12345");
        checkoutStepOnePage.pushContinueButton();
        CheckoutStepTwoPage checkoutStepTwoPage = new CheckoutStepTwoPage(driver);
        checkoutStepTwoPage.checkProductCartsQuantity(2);
        assertTrue(checkoutStepTwoPage.checkProductCartsQuantity(2));
        assertThat(checkoutStepTwoPage.getProductCarts(), hasSize(2));
    }
}
