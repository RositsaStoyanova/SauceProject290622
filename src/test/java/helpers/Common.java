package helpers;

import org.openqa.selenium.WebDriver;

public class Common {
    public static boolean checkUrl(WebDriver driver, String expectedUrl, int timeoutInSeconds) {
        String currentUrl = " ";
        boolean isLoaded = false;

        for (int i = 0; i < timeoutInSeconds; i++) {
            currentUrl = driver.getCurrentUrl();
            if (currentUrl.equals(expectedUrl)) {
                isLoaded = true;
                break;
            } else {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return isLoaded;
    }

    public static boolean checkUrl(WebDriver driver, String expectedUrl){
        return checkUrl(driver, expectedUrl, 5);
    }

}
