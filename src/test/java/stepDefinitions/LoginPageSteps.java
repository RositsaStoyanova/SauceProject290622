package stepDefinitions;

import POMs.LoginPagePOM;
import POMs.ProductsPagePOM;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.Context;
import helpers.DriverHelper;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;



    public class LoginPageSteps {
        private final WebDriver driver;
        private final Context context;

        public LoginPageSteps() {
            driver=DriverHelper.getDriver ();
            this.context=new Context ();
        }


        @Given("the client is on the login page")
        public void redirectToTheLoginPage() {
            LoginPagePOM loginPagePOM = new LoginPagePOM(driver);
            context.loginPagePOM = loginPagePOM;
            loginPagePOM.load();
            loginPagePOM.isLoaded();
            Context.driver= driver;
        }


        @And("enters: {string} and {string}")
        public void entersUsernameAndPassword(String username , String password) {
            context.loginPagePOM.loginForm (username , password);
            driver.close ();
        }


        @And("System should display {string} Error Message")
        public void display_error_message(String errorMsg) {
            Assert.assertEquals(String.format("The Error message is %s, but should be %s.",
                            context.loginPagePOM.getAlertMessage(), errorMsg),
                    errorMsg,context.loginPagePOM.getAlertMessage());
        }


        @Then("the user is  successfully logged")
        public void successfullyLogin() {
            ProductsPagePOM productsPagePOM = new ProductsPagePOM(Context.driver);
            Assert.assertEquals("The page title is not the expected one",
                    "Products".toLowerCase(), productsPagePOM.getPageTitle().toLowerCase());
            driver.close ();
        }

        @When("provides username: {string} and password: {string}}")
        public void clientEntersUsernameAndPassword(String username , String password) {
            context.loginPagePOM.loginForm (username, password);
            driver.close ();
        }


        @And("then should be relocated to product page")
        public void thenShouldBeRelocatedToProductPage() {
            ProductsPagePOM shopPagePOM = new ProductsPagePOM(Context.driver);
            Assert.assertEquals("The page title is not the expected one",
                    "Products".toLowerCase(), shopPagePOM.getPageTitle().toLowerCase());
            driver.close ();
        }


        @When("provides username: {string} and password: {string}")
        public void providesUsernameAndPassword(String username , String password) {
            context.loginPagePOM.loginForm ("standard_user", "secret_sauce");
            driver.close ();
        }
    }
