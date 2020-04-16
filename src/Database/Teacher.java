package Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Teacher extends Table{

    private int passwordLenght = 6;

    public Teacher(Statement statement) {
        super(statement);
    }

    public void setPasswordLenght(int lenght) {
        passwordLenght = lenght;
    }

    public boolean add(String username, String password) {
        if (password.length() > passwordLenght) {
            try {
                statement.execute(
                        "INSERT INTO 'teachers' ('username', 'password') VALUES ('"
                                + username + "','" + password + "'); ");

                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public String get(String username) {
        try {
            resultSet = statement.executeQuery("SELECT * FROM 'teachers' WHERE username = '" + username + "'");
            return resultSet.getString("password");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

}
