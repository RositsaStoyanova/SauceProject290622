

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;


public class duplicatedNumbersArray {
    public static void main(String[] args) {
        System.out.println ("The entered elements are: " + elements ());

    }

    public static String elements() {
        Scanner input = new Scanner (System.in);
        System.out.println ("Enter three elements:");
        String[] arr = new String[3];

        for (int i = 0; i < arr.length; ++i) {
            arr[i] = input.next ();
        }
        for (int i = 0; i < arr.length; ++i) {
            for (int j = i + 1; j < arr.length; ++j) {

                if (Objects.equals (arr[i], arr[j]))
                    System.out.println ("duplicated number is " + arr[j]);
            }
        }
        return Arrays.toString (arr);
        }


    }





