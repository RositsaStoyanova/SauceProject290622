package POMs;

import helpers.Currency;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ProductsPagePOM extends LoadableComponent {
    private static WebDriver driver;
    private final String url = "https://www.saucedemo.com/inventory.html";

    @FindBy(how = How.CSS, using = ".title")
    private WebElement pageTitle;

    @FindBy(how = How.CSS, using = ".inventory_item")
    private List<WebElement> productsList;

    @FindBy(how = How.ID, using = "shopping_cart_container")
    private WebElement navigateToCartButton;

    @FindBy(how = How.CSS, using = ".product_sort_container")
    private static WebElement sortingDropdown;

    @FindBy(how = How.CSS, using = ".inventory_item_price")
    private static List<WebElement> productPricesList;
    @FindBy(how = How.CSS, using = ".inventory_item_name")
    private static List<WebElement> productNamesList;


    public ProductsPagePOM(WebDriver driver) {
        ProductsPagePOM.driver= driver;
        PageFactory.initElements(driver, this);
    }
    public static void clickOnFilterIcon(){
        driver.findElement((By) sortingDropdown).click();
    }
    public String getPageTitle() {
        return pageTitle.getText();
    }

    public void selectAddToCartButton(String itemName) throws InterruptedException {
        WebElement result = null;
        for (WebElement product : productsList) {
            WebElement productName = product.findElement(By.cssSelector(".inventory_item_name"));
            if (productName.getText().equalsIgnoreCase(itemName)) {
                result = product.findElement(By.cssSelector(".btn"));
            }
        }
        Assert.assertNotNull(String.format("There is no item with name %s", itemName), result);
        result.click();
        Thread.sleep(2000);
    }

    @Override
    public void load() {
        driver.get(this.url);
    }

    @Override
    public void isLoaded() throws Error {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(pageTitle));
    }

    public void navigateToCart() {
        navigateToCartButton.click();
    }

    public static void selectSortingType(String sortType) {
        Select select = new Select(sortingDropdown);
        select.selectByVisibleText(sortType);
    }
    public static List getAllItemNames(){
        return driver.findElements((By) productNamesList);
    }

    public static List getAllItemPrices(){
        return driver.findElements((By) productPricesList);
    }



public void check_ascending_order(String type) {
    List actualListWebElements;
    List<String> actualListText = new ArrayList <> ();
    List<String> tempListText = new ArrayList <> ();

    switch (type) {

        case "names":
            actualListWebElements = getAllItemNames();

            for (Object a : actualListWebElements) {
                actualListText.add(String.valueOf (Double.valueOf ((String) a)));
            }

            tempListText.addAll(actualListText);
            Collections.sort(tempListText);

            Assert.assertEquals (actualListText , tempListText);
            break;

        case "prices":
            actualListWebElements = getAllItemPrices();

            for (Object a : actualListWebElements) {
                actualListWebElements.add(String.valueOf (Double.valueOf ((String) a)));
            }
            tempListText.addAll(actualListWebElements);
            List<Double> tempListDouble = new ArrayList <> ();
            List<Double> actualListDouble = new ArrayList <> ();

            actualListDouble = covertListIntoDouble(tempListText);
            tempListDouble = covertListIntoDouble(tempListText);

            Collections.sort(tempListText);
            Assert.assertEquals (actualListDouble , tempListDouble);
            break;

        default:
            return;
    }

}
    public static List<Double> covertListIntoDouble(List < String > list){
        List<String> sList = new ArrayList <> ();
        List<Double> dList = new ArrayList <> ();

        for(String a : list){
            sList.add(a.replace("$",""));
        }

        for(String a : sList){
            dList.add(Double.parseDouble(a));
        }

        return dList;
    }

    public void check_descending_order(String type) {
        List<WebElement> actualListWebElements;
        List<String> actualListText = new ArrayList <> ();
        List<String> tempListText = new ArrayList <> ();

        switch (type) {
            case "names":

                actualListWebElements = getAllItemNames();
                for (WebElement a : actualListWebElements) {
                    actualListText.add(a.getText());
                }

                tempListText.addAll(actualListText);
                tempListText.sort (Collections.reverseOrder ());

                Assert.assertEquals (actualListText , tempListText);
                break;

            case "prices":

                actualListWebElements = getAllItemPrices();

                for (WebElement a : actualListWebElements) {
                    actualListText.add(a.getText());
                }

                tempListText.addAll(actualListText);
                List<Double> tempListDouble;
                List<Double> actualListDouble;

                actualListDouble = covertListIntoDouble(tempListText);
                tempListDouble = covertListIntoDouble(tempListText);

                tempListDouble.sort (Collections.reverseOrder ());
                Assert.assertEquals (actualListDouble , tempListDouble);
                break;

            default:
                return;

        }



    }


//    public static void sortProducts() throws InterruptedException {
//
//
//        List < WebElement > beforeFilterPrice=driver.findElements ( By.className ( "inventory_item_price" ) );
//        List < Double > beforeFilterPriceList=new ArrayList <> ();
//        for (WebElement p : beforeFilterPrice) {
//            beforeFilterPriceList.add ( Double.valueOf ( p.getText ().replace ( "$" , "" ) ) );
//        }
//
//        Select dropdown=new Select ( (WebElement) driver.findElements ( By.className ( "product_sort_container" ) ) );
//        dropdown.selectByVisibleText ( "Price(low to high)" );
//
//        List < WebElement > afterFilterPrice=driver.findElements ( (By.className ( "inventory_item_price" )) );
//        List < Double > afterFilterPriceList=new ArrayList <> ();
//        for (WebElement p : afterFilterPrice) {
//            afterFilterPriceList.add ( Double.valueOf ( p.getText ().replace ( "$" , "" ) ) );
//        }
//
//        Assert.assertEquals ( beforeFilterPriceList , afterFilterPriceList );
//        Thread.sleep ( 3000 );
//
//
//    }


}