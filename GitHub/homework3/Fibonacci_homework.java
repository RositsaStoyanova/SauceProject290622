import java.util.Scanner;

public class Fibonacci_homework {
            public static void main(String[] args) {

            int count, number1 = 0, number2 = 1;
            System.out.println("How may numbers you want:");
            Scanner scanner = new Scanner(System.in);
            count = scanner.nextInt();
            scanner.close();
            System.out.print("Fibonacci Series of "+count+" numbers:");

            int i=1;
            while(i<=count)
            {
                System.out.print(number1+" ");
                int PrevTwoSum = number1 + number2;
                number1 = number2;
                number2 = PrevTwoSum;
                i++;
            }
        }
    }

