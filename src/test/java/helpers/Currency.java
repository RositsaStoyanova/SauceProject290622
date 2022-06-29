package helpers;

import org.openqa.selenium.WebElement;


public class Currency {

        public static double reformatPrice(WebElement price) {
            return Double.parseDouble(price.getText().substring(1).trim());
        }
    }

