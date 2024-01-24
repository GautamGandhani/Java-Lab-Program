/*
Develop a Java program to create an abstract class named Shape that contains two
integers and an empty method named printArea( ). Provide three classes named
Rectangle, Triangle and Circle such that each one of the classes extends the class
Shape. Each one of the classes contain only the method printArea( ) that prints the
area of the given shape.
*/

import java.util.Scanner;

abstract class Shape {
    int side1;
    int side2;

    Shape(int side1, int side2) {
        this.side1 = side1;
        this.side2 = side2;
    }

    public abstract void printArea();
}

class Rectangle extends Shape {
    Rectangle(int side1, int side2) {
        super(side1, side2);
    }

    public void printArea() {
        int area = side1 * side2;
        System.out.println("Area of Rectangle: " + area);
    }
}

class Triangle extends Shape {
    Triangle(int side1, int side2) {
        super(side1, side2);
    }

    public void printArea() {
        double area = 0.5 * side1 * side2;
        System.out.println("Area of Triangle: " + area);
    }
}

class Circle extends Shape {
    Circle(int radius) {
        super(radius, 0);
    }

    public void printArea() {
        double area = Math.PI * side1 * side1;
        System.out.println("Area of Circle: " + area);
    }
}

public class ProgramShape{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter length and width for Rectangle: ");
        int lengthRect = scanner.nextInt();
        int widthRect = scanner.nextInt();
        Rectangle rectangle = new Rectangle(lengthRect, widthRect);
        rectangle.printArea();

        System.out.print("Enter base and height for Triangle: ");
        int baseTri = scanner.nextInt();
        int heightTri = scanner.nextInt();
        Triangle triangle = new Triangle(baseTri, heightTri);
        triangle.printArea();

        System.out.print("Enter radius for Circle: ");
        int radiusCircle = scanner.nextInt();
        Circle circle = new Circle(radiusCircle);
        circle.printArea();

        scanner.close();
    }
}
