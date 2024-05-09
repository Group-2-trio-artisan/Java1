package libraryManagementSystem.model;

import libraryManagementSystem.entities.Books;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class BooksDAOImpl implements BooksDAO {


    private final Connection conn = MySQLConnectionDB.getMyConnection();
    PreparedStatement pstm = null;
    private final String SQL_CREATE_BOOK = "insert into books values(?,?,?,?,?,?,?)";
    private final String SQL_GET_BY_ID= "select * from books where id = ?";
    private final String SQL_GET_All_BOOK= "select * from books";
    private final String SQL_DELETE_BOOK = "delete from books where id = ?";
    private final String SQL_UPDATE_BOOK = "update books set title = ?, author = ?, genre = ?, price = ?, entry_date = ? , status = ? where id = ?";


    public BooksDAOImpl() throws SQLException {
    }


    @Override
    public void addBook(Books book) throws SQLException {
        pstm = conn.prepareStatement(SQL_CREATE_BOOK);
        pstm.setInt(1, book.getId());
        pstm.setString(2, book.getTitle());
        pstm.setString(3, book.getAuthor());
        pstm.setString(4, book.getGenre());
        pstm.setDouble(5, book.getPrice());
        pstm.setDate(6, book.getEntry_date(new Timestamp(new Date().getTime())));
        pstm.setString(7, book.getStatus());
        pstm.executeUpdate();
        System.out.println("Added Book Successfully");
    }

    @Override
    public void updateBook(Books book) throws SQLException {
        pstm = conn.prepareStatement(SQL_UPDATE_BOOK);
        pstm.setString(1, book.getTitle());
        pstm.setString(2, book.getAuthor());
        pstm.setString(3, book.getGenre());
        pstm.setDouble(4, book.getPrice());
        pstm.setDate(5, book.getEntry_date(new Timestamp(new Date().getTime())));
        pstm.setString(6, book.getStatus());
        pstm.setInt(7, book.getId());
        pstm.executeUpdate();
        System.out.println("Updated Book Successfully");
    }

    @Override
    public void deleteBook(Books book) throws SQLException {
        pstm = conn.prepareStatement(SQL_DELETE_BOOK);
        pstm.setInt(1, book.getId());
        pstm.executeUpdate();
        System.out.println("Deleted Book Successfully");
    }


    @Override
    public ArrayList<Books> getAllBooks() throws SQLException {
        ArrayList<Books> books = new ArrayList<>();
        try (PreparedStatement pstm = conn.prepareStatement(SQL_GET_All_BOOK);
             ResultSet rs = pstm.executeQuery()) {
            while (rs.next()) {
                Books book = new Books();
                book.setId(rs.getInt("id"));
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setGenre(rs.getString("genre"));
                book.setPrice(rs.getDouble("price"));
                book.setEntry_date(rs.getDate("entry_date"));
                books.add(book);
            }
        }
        return books;
    }

    @Override
        public Books getBookById(int id) throws SQLException {
            pstm = conn.prepareStatement(SQL_GET_BY_ID);
            pstm.setInt(1, id);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    Books book = new Books();
                    book.setId(rs.getInt("id"));
                    book.setTitle(rs.getString("title"));
                    book.setAuthor(rs.getString("author"));
                    book.setGenre(rs.getString("genre"));
                    book.setPrice(rs.getDouble("price"));
                    book.setEntry_date(rs.getDate("entry_date"));
                    book.setStatus(rs.getString("status"));
                    return book;
                }
            }
        return null;
    }
}
