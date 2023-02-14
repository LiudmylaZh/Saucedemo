import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CartPageTest extends TestBaseNew {
    @Test
    public void cartPageIsOpen () {
        User user = new User(userName, password);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(user);
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.clickOnTheSideBarOpenIcon();
        inventoryPage.clickOnTheResetAppAState();
        inventoryPage.clickOnTheCloseSideBarIcon();
        inventoryPage.refreshPage();
        inventoryPage.clickOnAddToCartBackpack();
        inventoryPage.clickOnTheCardIcon();
        CartPage cardPage = new CartPage(driver);
        assertTrue(cardPage.checkoutButtonIsDisplayed());
    }




}
