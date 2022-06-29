package helpers;

import POMs.CartPOM;
import POMs.CheckoutPOM;
import POMs.LoginPagePOM;
import POMs.ProductsPagePOM;
import org.openqa.selenium.WebDriver;

import java.util.Map;


public class Context {
    public LoginPagePOM loginPagePOM;
    public static WebDriver driver;
    public static ProductsPagePOM productsPagePOM;
    public Map< String, String> productsTitles;
    public CartPOM cartPOM;
    public Map < String, String > items;
    public ProductsPagePOM shopPagePOM;
    public CheckoutPOM checkoutPOM;
}