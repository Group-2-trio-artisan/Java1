package libraryManagementSystem.model;

import libraryManagementSystem.entities.Books;

import java.awt.print.Book;
import java.sql.SQLException;
import java.util.ArrayList;

public interface BooksDAO {
    public void addBook(Books book) throws SQLException;
    public void updateBook(Books book) throws SQLException;
    public void deleteBook(Books book) throws SQLException;



    public ArrayList<Books> getAllBooks() throws SQLException;
    public Books getBookById(int id) throws SQLException;
}
