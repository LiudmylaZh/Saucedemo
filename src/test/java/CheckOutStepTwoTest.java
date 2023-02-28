import org.junit.Test;

import static org.junit.Assert.assertEquals;



public class CheckOutStepTwoTest extends TestBaseNew {

    @Test
    public void theSummIsCorrect () {
        User user = new User(userName, password);
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


    }
    @Test
    public void checkFinalCost (){
        User user = new User(userName, password);
        new LoginPage(driver).login(user);
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.resetAppState();
        inventoryPage.clickOnAddToCartBackpack();
        inventoryPage.clickOnAddToCardBikeLight();
        inventoryPage.clickOnTheCardIcon();
        CartPage cardPage = new CartPage(driver);
        double sumFromCart = cardPage.getSumPrisesOfAllProducts();
        cardPage.clickOnCheckoutButton();
        CheckoutStepOnePage checkoutStepOnePage = new CheckoutStepOnePage(driver);
        checkoutStepOnePage.enterFirstName("Harry");
        checkoutStepOnePage.enterLastName("Potter");
        checkoutStepOnePage.enterZipCode("12345");
        checkoutStepOnePage.pushContinueButton();
        CheckoutStepTwoPage checkoutStepTwoPage = new CheckoutStepTwoPage(driver);
        double sumFromCheckOut =  checkoutStepTwoPage.getTotalSum();
        assertEquals(sumFromCart,sumFromCheckOut, 0);
    }


}
