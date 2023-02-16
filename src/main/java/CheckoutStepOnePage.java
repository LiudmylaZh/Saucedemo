import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutStepOnePage extends BasePage{

    public CheckoutStepOnePage(WebDriver driver) {
        super(driver);
    }

    @FindBy (id = "first-name")
    private WebElement firstName;

    @FindBy (id = "last-name")
    private WebElement lastName;

    @FindBy (id = "postal-code")
    private WebElement zipCode;

    @FindBy (id = "continue")
    private WebElement continueButton;

    public void enterFirstName (String nameValue){
        enterTextToElement(nameValue, firstName);
    }
    public void enterLastName (String lastNameValue){
        enterTextToElement(lastNameValue, lastName);
    }
    public void enterZipCode (String zipCodeValue){
        enterTextToElement(zipCodeValue, zipCode);
    }
    public void pushContinueButton () {
        clickOnTheElement(continueButton);
    }

}