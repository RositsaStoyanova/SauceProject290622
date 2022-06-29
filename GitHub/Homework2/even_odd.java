import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class even_odd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int randomNum= ThreadLocalRandom.current().nextInt(1,100+1);
        if (randomNum%2==0){
            System.out.println(randomNum + " is even");
        } else{
            System.out.println(randomNum + " is odd");
        }
    }
}
