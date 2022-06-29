package coinflip;

import java.util.Random;

    public class coin {

        Random randomNum = new Random();

        public String flip() {
            int result = randomNum.nextInt(2);
            if (result == 0) {
                return "You flipped Heads!";
            }
            return "You flipped Tails!";
        }
    }

