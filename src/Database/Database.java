package Database;

import org.sqlite.JDBC;

import java.sql.*;

public class Database {

    private final Connection connection;
    public Student student;
    public Teacher teacher;

    public Database(String path) throws SQLException {
        DriverManager.registerDriver(new JDBC());
        connection = DriverManager.getConnection("jdbc:sqlite:" + path);

        student = new Student(connection.createStatement());
        teacher = new Teacher(connection.createStatement());
    }
}
