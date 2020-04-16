package Database;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.io.Closeable;
import java.sql.*;

public class Database implements Closeable {

    private Connection connection;
    public Student student;
    public Teacher teacher;
    public Test test;

    public Database(String path) throws SQLException, PropertyVetoException {

        ComboPooledDataSource ds = new ComboPooledDataSource();

        ds.setDriverClass("org.sqlite.JDBC");
        ds.setJdbcUrl("jdbc:sqlite:" + path);

        connection = ds.getConnection();

        student = new Student(connection.createStatement());
        teacher = new Teacher(connection.createStatement());
        test = new Test(connection.createStatement());

    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
