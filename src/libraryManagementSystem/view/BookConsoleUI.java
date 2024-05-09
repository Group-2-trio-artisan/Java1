package libraryManagementSystem.view;

import libraryManagementSystem.controller.BookController;
import libraryManagementSystem.entities.Books;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class BookConsoleUI {
    BookController bookController = new BookController();
    private Scanner sc;

    public BookConsoleUI() throws SQLException {
        this.sc = new Scanner(System.in);
    }
    private int menu(){
        System.out.println("=====Book Management System Menu=====");
        System.out.println("1. Add Book");
        System.out.println("2. Delete Book");
        System.out.println("3. Edit Book");
        System.out.println("4. View All Book");
        System.out.println("5. Search Book");
        System.out.println("0. Exit");
        int choice = Integer.parseInt(this.sc.nextLine());
        return choice;
    }
    public void GetAllBookUI() throws SQLException {
        ArrayList<Books> books = bookController.getAllBooks();
        books.forEach((book)-> {
            System.out.println("===All Book===");
            System.out.println(book.getId());
            System.out.println(book.getTitle());
            System.out.println(book.getAuthor());
            System.out.println(book.getEntry_date(new Timestamp(new Date().getTime())));
            System.out.println(book.getStatus());

        });
    }
    public void AddBookUI() throws SQLException {
        System.out.println("Enter Book ID");
        int bookId = Integer.parseInt(this.sc.nextLine());
        System.out.println("Enter Book Title");
        String bookTitle = this.sc.nextLine();
        System.out.println("Enter Book Author");
        String bookAuthor = this.sc.nextLine();
        System.out.println("Enter Book Genre");
        String bookGenre = this.sc.nextLine();
        System.out.println("Enter Book Price");
        double bookPrice = Double.parseDouble(this.sc.nextLine());
        System.out.println("Enter Book Status");
        String bookStatus = this.sc.nextLine();
        Books book = new Books(bookId, bookTitle, bookAuthor, bookGenre, bookPrice, new java.sql.Date(new Date().getTime()), bookStatus);
        bookController.addBook(book);
    }
    public void DeleteBookUI() throws SQLException {
        System.out.println("Enter Book ID to delete");
        int bookId = Integer.parseInt(this.sc.nextLine());
        bookController.deleteBook(bookId);
    }
    public void UpdateBookUI() throws SQLException {
        System.out.println("Enter Book ID to edit");
        int bookId = Integer.parseInt(this.sc.nextLine());
        Books book = bookController.getBookById(bookId);
        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        System.out.println("Enter new Book Title: ");
        String bookTitle = this.sc.nextLine();
        if (!bookTitle.isEmpty()) {
            book.setTitle(bookTitle);
        }

        System.out.println("Enter new Book Author: ");
        String bookAuthor = this.sc.nextLine();
        if (!bookAuthor.isEmpty()) {
            book.setAuthor(bookAuthor);
        }
        System.out.println("Enter new Book Genre: ");
        String bookGenre = this.sc.nextLine();
        if (!bookGenre.isEmpty()) {
            book.setGenre(bookGenre);
        }

        System.out.println("Enter new Book Price: ");
        String bookPriceStr = this.sc.nextLine();
        if (!bookPriceStr.isEmpty()) {
            double bookPrice = Double.parseDouble(bookPriceStr);
            book.setPrice(bookPrice);
        }

        System.out.println("Enter new Book Status: ");
        String bookStatus = this.sc.nextLine();
        if (!bookStatus.isEmpty()) {
            book.setStatus(bookStatus);
        }

        bookController.updateBook(book);
    }
    public void SearchBookUI() throws SQLException {
        System.out.print("Enter Book ID to search: ");
        int bookId = Integer.parseInt(this.sc.nextLine());
        Books book = bookController.getBookById(bookId);
        if (book!= null) {
            System.out.println("===Book Found===");
            System.out.println("ID: " + book.getId());
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("Genre: " + book.getGenre());
            System.out.println("Price: " + book.getPrice());
            System.out.println("Entry Date: " + book.getEntry_date(new Timestamp(new Date().getTime())));
            System.out.println("Status: " + book.getStatus());
        } else {
            System.out.println("Book not found.");
        }
    }

    public void start() throws SQLException {
        while (true){
            int choice = this.menu();
            switch (choice) {
                case 1:
                    AddBookUI();
                    break;
                case 2:
                    DeleteBookUI();
                    break;
                case 3:
                    UpdateBookUI();
                    break;
                case 4:
                    GetAllBookUI();
                    break;
                case 5:
                    SearchBookUI();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    throw new AssertionError();
            }
        }
    }
}
