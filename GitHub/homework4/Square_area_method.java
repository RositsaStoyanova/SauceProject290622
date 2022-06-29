import java.util.Scanner;

public class Square_area_method {
        public static void main(String[] args) {
            Scanner sc= new Scanner (System.in);

            System.out.println("Enter the side:");
            int a= (int) sc.nextInt ();

            System.out.println ("Square area is " + square(a));
        }

        public static int square(int a) {
            return a * a;
        }
    }


