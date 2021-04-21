package ScanningAndPrinting;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerCatchingErrors {

    private String errorMessageNotANumber = "Error! You entered not a number, try again.";

    public double inputSum() {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        double sum;


            try {
                sum = sc.nextDouble();
            } catch (NumberFormatException e) {
                System.out.print(errorMessageNotANumber);
                java.util.Scanner sc2 = new java.util.Scanner(System.in);
                sum = sc2.nextDouble();
            } catch (InputMismatchException e) {
                System.out.print(errorMessageNotANumber);
                java.util.Scanner sc2 = new java.util.Scanner(System.in);
                sum = sc2.nextDouble();
            }
        return sum;
    }

    public int inputNumber() {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        int skaicius = 0;

        try {
            skaicius = sc.nextInt();
        } catch (NumberFormatException e) {
            System.out.print(errorMessageNotANumber);
            java.util.Scanner sc2 = new java.util.Scanner(System.in);
            skaicius = sc2.nextInt();
        } catch (InputMismatchException e) {
            System.out.print(errorMessageNotANumber);
            java.util.Scanner sc3 = new java.util.Scanner(System.in);
            skaicius = sc3.nextInt();
        }
        return skaicius;
    }


    public String inputText() {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        String tekstas = sc.nextLine();

        return tekstas;
    }

    public boolean ivestasBoolean() {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        boolean ivestasB;

        try {
            ivestasB = sc.nextBoolean();

        } catch (InputMismatchException e) {
            System.out.print("Error! Enter [true] or [false].");
            java.util.Scanner sc2 = new java.util.Scanner(System.in);
            ivestasB = sc2.nextBoolean();
        }
        return ivestasB;
    }


}
