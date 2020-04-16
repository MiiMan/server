package Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Student extends Table{

    public Student(Statement statement) {
        super(statement);
    }

    public boolean hashExists(String mailhash) {
        try {
            resultSet = statement.executeQuery(
                    "SELECT * FROM 'students' WHERE mail_hash = '" + mailhash + "'");
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean add(String firstname, String secondname, String schoolclass, String hash) {
        try {
            statement.execute(
                    "INSERT INTO 'students' ('first_name', 'second_name', 'class', 'mail_hash') VALUES ('"
                            + firstname + "','" + secondname + "','" + schoolclass + "','" + hash + "'); ");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public String[] get(String mailhash) {
        try {
            resultSet = statement.executeQuery("SELECT * FROM 'students' WHERE mail_hash = '" + mailhash + "'");
            return new String[] {
                    resultSet.getString("first_name"),
                    resultSet.getString("second_name"),
                    resultSet.getString("class")};
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new String[] {};
    }


}
