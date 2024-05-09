package libraryManagementSystem.controller;

import libraryManagementSystem.entities.Books;
import libraryManagementSystem.model.BooksDAOImpl;

import java.sql.SQLException;
import java.util.ArrayList;

public class BookController {
    BooksDAOImpl booksDAOImpl = new BooksDAOImpl();

    public BookController() throws SQLException {
    }
    public ArrayList<Books> getAllBooks() throws SQLException{
        ArrayList<Books> booksList = booksDAOImpl.getAllBooks();
        return booksList;
    }
    public Books getBookById(int id) throws SQLException {
        Books book = booksDAOImpl.getBookById(id);
        booksDAOImpl.getBookById(book.getId());
        return book;
    }
    public void addBook(Books book) throws SQLException {
        booksDAOImpl.addBook(book);
    }
    public void updateBook(Books book) throws SQLException{
        booksDAOImpl.updateBook(book);
    }
    public void deleteBook(int id) throws SQLException {
        Books book = booksDAOImpl.getBookById(id);
        booksDAOImpl.deleteBook(book);
    }
}
