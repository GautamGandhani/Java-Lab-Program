/*
Create a class Book which contains four members: name, author, price, num_pages.
Include a constructor to set the values for the members. Include methods to set and
get the details of the objects. Include a toString( ) method that could display the
complete details of the book. Develop a Java program to create n book objects.
*/



import java.util.Scanner;

class Book {
    String name;
    String author;
    double price;
    int numPages;

    Book(String name, String author, double price, int numPages) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.numPages = numPages;
    }

    
    public String toString() {
        return "Book Details:\n" +
                "Name: " + name + "\n" +
                "Author: " + author + "\n" +
                "Price: " + price + "\n" +
                "Number of Pages: " + numPages + "\n";
    }
}

public class ProgramBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of books: ");
        int numBooks = scanner.nextInt();
        Book[] books = new Book[numBooks];

        for (int i = 0; i < numBooks; i++) {
            scanner.nextLine();
            System.out.println("\nEnter details for Book " + (i + 1) + ":");
            System.out.print("Enter Book Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Author Name: ");
            String author = scanner.nextLine();
            System.out.print("Enter Price: ");
            double price = scanner.nextDouble();
            System.out.print("Enter Number of Pages: ");
            int numPages = scanner.nextInt();
            books[i] = new Book(name, author, price, numPages);
        }

        System.out.println("\nDetails of Books:");
        for (int i = 0; i < numBooks; i++) {
            System.out.println(books[i]);
        }

        scanner.close();
    }
}

