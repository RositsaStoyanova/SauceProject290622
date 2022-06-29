import java.util.Scanner;

public class studentAttendance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double classes_held = Double.parseDouble (scanner.nextLine ());
        double classes_attended =Double.parseDouble(scanner.nextLine ());
        double result = classes_attended/classes_held;

        if (result>0.75) {
            System.out.printf ("Student is %.2f of class attended and is allowed to sit in exam",result);
        } else {
            System.out.printf ("Student is %.2f of class attended and is not allowed to sit in exam",result);
        }
    }
}
