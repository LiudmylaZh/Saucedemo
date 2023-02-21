import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CartPageTest extends TestBaseNew {
    @Test
    public void cartPageIsOpen () {
        User user = new User(userName, password);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(user);
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.resetAppState();
        inventoryPage.clickOnAddToCartBackpack();
        inventoryPage.clickOnTheCardIcon();
        CartPage cardPage = new CartPage(driver);
        assertTrue(cardPage.checkoutButtonIsDisplayed());
    }

    @Test
    public void addSeveralItems () {
        User user = new User(userName, password);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(user);
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.resetAppState();
        inventoryPage.clickOnAddToCartBackpack();
        inventoryPage.clickOnAddToCardBikeLight();
        inventoryPage.clickOnTheCardIcon();
        CartPage cardPage = new CartPage(driver);
        assertTrue(cardPage.checkProductCartsQuantity(2));

    }
    @Test
    public void cartIsEmpty(){
        User user = new User(userName, password);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(user);
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.resetAppState();
        inventoryPage.clickOnTheCardIcon();
        CartPage cartPage = new CartPage(driver);
        assertTrue(cartPage.cartIsEmpty());
    }




}
