/*
Develop a Java program that prints all real solutions to the quadratic equation
ax 2 +bx+c = 0. Read in a, b, c and use the quadratic formula. If the discriminate b 2 -4ac
is negative, display a message stating that there are no real solutions.
*/


import java.util.Scanner;

class QuadraticRootCalculator {
    public static void calculateRoots(double a, double b, double c) {
        double discriminant = b * b - 4 * a * c;

        if (discriminant == 0) {
            double root = -b / (2 * a);
            System.out.println("Equal roots:");
            System.out.println("Root 1: " + root);
            System.out.println("Root 2: " + root);
        } else if (discriminant > 0) {
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println("Distinct real solutions:");
            System.out.println("Root 1: " + root1);
            System.out.println("Root 2: " + root2);
        } else {
            double realPart = -b / (2 * a);
            double imaginaryPart = Math.sqrt(-discriminant) / (2 * a);
            System.out.println("Complex solutions:");
            System.out.println("Root 1: " + realPart + " + " + imaginaryPart + "i");
            System.out.println("Root 2: " + realPart + " - " + imaginaryPart + "i");
        }
    }
}

public class ProgramQuadraticEquation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter coefficient a: ");
        double a = scanner.nextDouble();

        System.out.print("Enter coefficient b: ");
        double b = scanner.nextDouble();

        System.out.print("Enter coefficient c: ");
        double c = scanner.nextDouble();

        scanner.close();

        QuadraticRootCalculator.calculateRoots(a, b, c);
    }
}

