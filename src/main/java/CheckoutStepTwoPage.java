
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.xml.xpath.XPath;
import java.util.List;

@Getter
public class CheckoutStepTwoPage extends BasePage {
    public CheckoutStepTwoPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(className = "cart_item_label")
    private List<WebElement> productCarts;

  @FindBy (className = "summary_subtotal_label")
  private WebElement total;




    public boolean checkProductCartsQuantity(int expectedQuantity) {
        //assertEquals("Product carts quantity is not equal to" + expectedQuantity, productCarts.size());
        System.out.println(productCarts.size());
        return productCarts.size() == expectedQuantity;
    }

    public double getTotalSum () {
      return Double.parseDouble(total.getText().replace("Item total: $", ""));
    }
}

