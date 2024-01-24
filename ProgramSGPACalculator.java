/* Develop a Java program to create a class Student with members usn, name, an array
credits and an array marks. Include methods to accept and display details and a
method to calculate SGPA of a student. */

import java.util.Scanner;

class Student {
    private String usn;
    private String name;
    private int[] credits;
    private int[] marks;

    public Student(String usn, String name, int[] credits, int[] marks) {
        this.usn = usn;
        this.name = name;
        this.credits = credits;
        this.marks = marks;
    }

    public void acceptDetails() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter USN: ");
        this.usn = scanner.nextLine();

        System.out.print("Enter Name: ");
        this.name = scanner.nextLine();

        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();

        this.credits = new int[numSubjects];
        this.marks = new int[numSubjects];

        System.out.println("Enter details for each subject:");
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter credits for subject " + (i + 1) + ": ");
            this.credits[i] = scanner.nextInt();

            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            this.marks[i] = scanner.nextInt();
        }

        scanner.close();
    }

    public void displayDetails() {
        System.out.println("USN: " + this.usn);
        System.out.println("Name: " + this.name);
        System.out.println("Subject-wise details:");

        for (int i = 0; i < credits.length; i++) {
            System.out.println("Subject " + (i + 1) + ": Credits=" + this.credits[i] + ", Marks=" + this.marks[i]);
        }
    }

    public double calculateSGPA() {
        int totalCredits = 0;
        double weightedSum = 0;

        for (int i = 0; i < credits.length; i++) {
            totalCredits += this.credits[i];
            weightedSum += calculateGradePoints(this.marks[i]) * this.credits[i];
        }

        return weightedSum / totalCredits;
    }

    private int calculateGradePoints(int marks) {
        if (marks >= 90) {
            return 10;
        } else if (marks >= 80) {
            return 9;
        } else if (marks >= 70) {
            return 8;
        } else if (marks >= 60) {
            return 7;
        } else if (marks >= 50) {
            return 6;
        } else if (marks >= 40) {
            return 5;
        } else {
            return 0;
        }
    }
}

public class ProgramSGPACalculator {
    public static void main(String[] args) {
        Student student = new Student("", "", null, null);
        student.acceptDetails();
        System.out.println("\nStudent Details:");
        student.displayDetails();
        double sgpa = student.calculateSGPA();
        System.out.println("\nSGPA: " + sgpa);
    }
}
