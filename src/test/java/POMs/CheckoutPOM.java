package POMs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import java.util.List;


public class CheckoutPOM {
    private final String url="https://www.saucedemo.com/checkout-step-two.html";

    @FindBy(how=How.CSS, using=".title")
    private WebElement pageTitle;

    @FindBy(how=How.CSS, using=".cart_item")
    private static List < WebElement > checkoutItems;


    public CheckoutPOM(WebDriver driver) {
        PageFactory.initElements (driver , this);
    }

    public static boolean doesItemExist(String itemName) {
        boolean result=false;

        for (WebElement webElement : checkoutItems) {
            if (webElement.getText ().equalsIgnoreCase (itemName)) {
                result=true;
                break;
            }
        }

        return result;
    }

}

