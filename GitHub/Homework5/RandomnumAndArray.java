import java.util.Arrays;
import java.util.Random;

public class RandomnumAndArray {

        public static void main(String[] args) {

            System.out.println(randomNum());
        }

        public static String randomNum() {
            Random num = new Random();
            int[] arr = new int[10];

            for (int i = 0; i < arr.length; i++) {
                arr[i] = num.nextInt((10 - 1) + 1) ;

            }
            return Arrays.toString(arr);
        }

    }

