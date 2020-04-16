package Database;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Test extends Table {

    public Test(Statement statement) {
        super(statement);
    }

    public String[] get(String username) {
        ArrayList<String> tests = new ArrayList<>();
        try {
            resultSet = statement.executeQuery("SELECT * FROM 'tests' WHERE author = '" + username + "'");

            while (resultSet.next()) {
                tests.add(resultSet.getString("id"));
            }
            return tests.toArray(new String[tests.size()]);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public String getFilename(String id) {
        try {
            resultSet = statement.executeQuery("SELECT * FROM 'tests' WHERE id = '" + id + "'");
            return resultSet.getString("filename");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean add(String username, String password, String filename) {
        try {
            resultSet = statement.executeQuery("SELECT * FROM 'teachers' WHERE username = '" + username + "'");

            if (resultSet.getString("password").equals(password)) {
                try {
                    statement.execute(
                            "INSERT INTO 'tests' ('author', 'filename') VALUES ('"
                                    + username + "','" + filename + "'); ");

                    return true;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
