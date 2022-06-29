import java.util.concurrent.ThreadLocalRandom;

public class HomeWork1 {
    public static void main(String[] args) {

        int randomNum= ThreadLocalRandom.current().nextInt(1,10+1);
        if (randomNum > 5)
            System.out.println(randomNum);
    }
}
