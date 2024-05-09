package libraryManagementSystem;

import libraryManagementSystem.view.BookConsoleUI;

import java.sql.SQLException;

public class Application {
    public static void main(String[] args) throws SQLException {
        BookConsoleUI bookConsoleUI = new BookConsoleUI();
        bookConsoleUI.start();
    }
}
