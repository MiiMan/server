package Database;

import java.sql.ResultSet;
import java.sql.Statement;

public class Table {
    protected final Statement statement;
    protected ResultSet resultSet;

    public Table(Statement statement) {
        this.statement = statement;
    }
}
