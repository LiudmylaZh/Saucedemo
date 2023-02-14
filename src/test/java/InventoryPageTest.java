import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class InventoryPageTest extends TestBaseNew {
    @Test
    public void amountOfProducts() {
        User user = new User(userName, password);
        new LoginPage(driver).login(user);
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.checkOfProductsAreDisplayed();
        inventoryPage.checkAmountOfProducts(6);

    }

    @Test
    public void amountOfProductsName() {
        User user = new User(userName, password);
        new LoginPage(driver).login(user);
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.checkProductsNameIsDisplayed();
        inventoryPage.checkProductsNameIsNoEmpty();

    }

    @Test
    public void socialNetWorkLinks () {
        User user = new User(userName, password);
        new LoginPage(driver).login(user);
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.checkTwitterIconLink();

    }

    @Test
    public void sideBar() {
        User user = new User(userName, password);
        new LoginPage(driver).login(user);
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.clickOnTheSideBarOpenIcon();
        assertTrue (inventoryPage.allItemsIsDisplayed());
        inventoryPage.aboutIsDisplayed();
        inventoryPage.logoutIsDisplayed();
        inventoryPage.resetIsDisplayed();
    }

    @Test
    public void sideBarIsClosed () {
        User user = new User(userName, password);
        new LoginPage(driver).login(user);
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.clickOnTheSideBarOpenIcon();
        inventoryPage.closeSidebar();
        assertTrue(inventoryPage.allItemsIsDisplayed());
        inventoryPage.allItemsIsNotDisplay();



    }

}
