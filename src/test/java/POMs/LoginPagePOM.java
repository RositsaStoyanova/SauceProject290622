package POMs;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPagePOM extends LoadableComponent {

    private final WebDriver driver;

    @FindBy(how = How.ID, using = "user-name")
    private WebElement usernameField;

    @FindBy(how = How.ID, using = "password")
    private WebElement passwordField;

    @FindBy(how = How.ID, using = "login-button")
    private WebElement loginButton;

    @FindBy(how = How.CSS, using = ".login_logo")
    private WebElement loginLogo;

    @FindBy(how = How.CSS, using = ".error-message-container > h3:nth-child(1)")
    private WebElement errorMessage;


    public LoginPagePOM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void loginForm(String username, String password){
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public String getAlertMessage() {
        return errorMessage.getText();
    }


    @Override
    public void load() {
        driver.get("https://www.saucedemo.com/");
    }

    @Override
    public void isLoaded() throws Error {
        Wait<WebDriver> wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(loginLogo));
    }
}
