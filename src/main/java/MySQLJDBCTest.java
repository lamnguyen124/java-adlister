import com.mysql.cj.api.mysqla.result.Resultset;
import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//import java.sql.Driver;

public class MySQLJDBCTest {
    public static void connect() throws SQLException {
        DriverManager.registerDriver(new Driver());
        Connection connection = DriverManager.getConnection(
                Config.getUrl(),
                Config.getUsername(),
                Config.getPassword()
        );
    }

    public static void main(String[] args) {
        try {
            Connection connection = connect();
            System.out.println("Connection Successful");
            Statement statement = connection.createStatement();
            String queryString = "SELECT * FROM quotes;";
            Resultset results = statement.execute(queryString);
            if (results != null) {
                System.out.println("Statement executed successfully");
                while (results.next()) {
                    System.out.println("id: " + results.getLong("id"));
                    System.out.println(results.getString("content"));
                }
                System.out.println("no more results");
            } else

                System.out.println("Statement exploded");

            }
        }
    }
}
