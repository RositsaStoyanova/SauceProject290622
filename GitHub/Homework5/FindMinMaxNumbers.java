public class FindMinMaxNumbers {
    public static void main(String[] args) {
        int[] num = {5, 7, 2, 4, 9, 6};
        System.out.println ("Min number from array is " + findMin (num));
        System.out.println ("Max number from array is " + findMax (num));
    }

    public static int findMin(int[] num) {

        int min = num[0];

        for (int i = 1; i < num.length; i++) {
            if (num[i] < min) {
                min = num[i];
            }
        }
        return min;
    }

    public static int findMax(int[] num) {

        int max = num[0];

        for (int i = 1; i < num.length; i++) {
            if (num[i] > max) {
                max = num[i];
            }
        }
        return max;
    }
}