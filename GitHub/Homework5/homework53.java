package com.company;

import java.util.Arrays;
import java.util.Scanner;


    public class homework53 {


        public static void main(String[] args) {
            System.out.println("The entered elements are: " + elements());
        }

        public static String elements() {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter three elements:");
            String[] arr = new String[3];

            for(int i = 0; i < arr.length; ++i) {
                arr[i] = input.next();
            }

            return Arrays.toString(arr);
        }
    }


