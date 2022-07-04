package stepDefinitions;

import POMs.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import helpers.Context;
import helpers.DriverHelper;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;



public class ProductPageSteps {

    public static class ProductsPageSteps {
        private final WebDriver driver;
        private final Context context;

        public ProductsPageSteps() {
            driver=DriverHelper.getDriver ();
            this.context=new Context ();
        }

        @Given("the logged client is on the products page")
        public void userProductPage() {
            Context.driver= driver;
            context.loginPagePOM = new LoginPagePOM (Context.driver);
            Context.productsPagePOM= new ProductsPagePOM (Context.driver);
            context.loginPagePOM.load();
            context.loginPagePOM.loginForm ("standard_user", "secret_sauce");
            Context.productsPagePOM.isLoaded();
//            driver.close();
        }

        @And("the client adds the following items to the cart:")
        public void theUserAddsTheFollowingItemsToTheCart(DataTable dataTable) throws InterruptedException {
            Map<String, String> items = dataTable.asMaps().get(0);
            for (String key : items.keySet()) {
                String itemName = items.get(key);
                if (itemName != null && !itemName.trim().equals("")) {
                    Context.productsPagePOM.selectAddToCartButton(itemName);
                }
            }
            context.items = items;
//            driver.close();
        }

        @And("the client navigates to the Checkout Page")
        public void checkoutPage() {
            context.shopPagePOM.navigateToCart();
            CartPOM cartPOM = new CartPOM(Context.driver);
            cartPOM.clickCheckoutButton();
            CheckoutPersonalInfo checkoutPersonalInfo = new CheckoutPersonalInfo(Context.driver);
            checkoutPersonalInfo.populateRequiredFields();
            checkoutPersonalInfo.clickContinueButton();
//            driver.close ();
        }

        @Then("all items are successfully added")
        public void all_items_are_successfully_added() {
            CheckoutPOM checkoutPOM = new CheckoutPOM(Context.driver);
            Map < String, String > productExpect=context.productsTitles;
            for (String key : productExpect.keySet ( )) {
                String productTitle=productExpect.get ( key );
                if (!productTitle.equals ( "" )) {
                    Assert.assertTrue ( String.format ( "Product with title %s is not added to the cart" , productTitle ) ,
                            CheckoutPOM.doesItemExist ( productTitle ) );
//                    driver.close();

                }
            }
        }
        @Given("Client click on filter icon")
        public void theUserSelectsSort() {
            ProductsPagePOM.clickOnFilterIcon ();

        }


        @And("Select {string} from the dropdown")
        public void theUserSelectsSort(String sortType) {
            ProductsPagePOM.selectSortingType (sortType);

        }


        @Then("Item {string} should be in ascending order")
        public void check_ascending_order(String type) {

            List < WebElement > actualListWebElements;
            ArrayList actualListText=new ArrayList ();
            ArrayList tempListText=new ArrayList ();

            switch (type) {

                case "names":
                    actualListWebElements=ProductsPagePOM.getAllItemNames ();

                    for (WebElement a : actualListWebElements) {
                        actualListText.add (a.getText ());
                    }

                    tempListText.addAll (actualListText);
                    Collections.sort (tempListText);

                    Assert.assertEquals (actualListText , tempListText);
                    break;

                case "prices":
                    actualListWebElements=ProductsPagePOM.getAllItemPrices ();

                    for (WebElement a : actualListWebElements) {
                        actualListText.add (a.getText ());
                    }
                    tempListText.addAll (actualListText);
                    List < Double > tempListDouble;
                    List < Double > actualListDouble;

                    actualListDouble=ProductsPagePOM.covertListIntoDouble (tempListText);
                    tempListDouble=ProductsPagePOM.covertListIntoDouble (tempListText);

                    Collections.sort (tempListText);
                    Assert.assertEquals (actualListDouble , tempListDouble);
                    break;

                default:
                    return;
            }

        }

        @And("Item {string} should be in descending order")
        public void check_descending_order(String type) {
            List < WebElement > actualListWebElements=new ArrayList ();
            List < String > actualListText=new ArrayList ();
            List < String > tempListText=new ArrayList ();

            switch (type) {
                case "names":

                    actualListWebElements=ProductsPagePOM.getAllItemNames ();
                    for (WebElement a : actualListWebElements) {
                        actualListText.add (a.getText ());
                    }

                    tempListText.addAll (actualListText);
                    Collections.sort (tempListText , Collections.reverseOrder ());

                    Assert.assertEquals (actualListText , tempListText);
                    break;

                case "prices":

                    actualListWebElements=ProductsPagePOM.getAllItemPrices ();

                    for (WebElement a : actualListWebElements) {
                        actualListText.add (a.getText ());
                    }

                    tempListText.addAll (actualListText);
                    List < Double > tempListDouble=new ArrayList ();
                    List < Double > actualListDouble=new ArrayList ();

                    actualListDouble=ProductsPagePOM.covertListIntoDouble (tempListText);
                    tempListDouble=ProductsPagePOM.covertListIntoDouble (tempListText);

                    Collections.sort (tempListDouble , Collections.reverseOrder ());
                    Assert.assertTrue (actualListDouble.equals (tempListDouble));
                    break;

                default:
                    return;

            }

        }
    }
}

