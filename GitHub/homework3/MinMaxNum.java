import java.util.Scanner;

public class MinMaxNum {

        public static void main(String[] args) {

            Scanner input = new Scanner(System.in);
            System.out.println("How many numbers you would like to  enter: ");
            int numbers = input.nextInt();

            System.out.println("Enter the numbers: ");

            int minNum = Integer.MAX_VALUE;
            int maxNum = Integer.MIN_VALUE;

            for (int i = 1; i <= numbers; i++) {
                int num = input.nextInt();

                if (num < minNum){
                    minNum = num;
                }
                if (num > maxNum){
                    maxNum = num;
                }
            }

            input.close();

            System.out.println("Min = " + minNum);
            System.out.println("Max = " + maxNum);
        }
    }

