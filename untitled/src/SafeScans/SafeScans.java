package SafeScans;

import java.util.Scanner;

public class SafeScans {
    private static Scanner sc = new Scanner(System.in);

    public static String scanLine(){
        return sc.nextLine();
    }
    public static int scanInt(){
        return scanInt(Integer.MAX_VALUE);
    }
    public static int scanInt(int max){
        while (true) {
            try {
                int n = Integer.parseInt(sc.nextLine());
                if (n > 0 && n <= max)
                    return n;
            }
            catch (Exception e) { }
            System.out.println("Некоректно введено! Попробуйте ще раз: ");
        }
    }

    public static double scanDouble(double max){
        while (true) {
            try {
                double n = Double.parseDouble(sc.nextLine());
                if (n > 0 && n <= max)
                    return n;
            }
            catch (Exception e) { }
            System.out.println("Некоректно введено! Попробуйте ще раз: ");
        }
    }

}
