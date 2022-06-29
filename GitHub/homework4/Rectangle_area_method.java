import java.util.Scanner;

public class Rectangle_area_method {
    public static void main(String[] args) {
        Scanner sc= new Scanner (System.in);

        System.out.println("Enter the side a:");
        int a= (int) sc.nextDouble();
        System.out.println("Enter the side b:");
        int b= (int) sc.nextDouble();
        System.out.println ("Square area is " + rectangle(a,b));
    }

    public static int rectangle(int a, int b) {
        return a * b;
    }
}
