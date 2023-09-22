import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// questa classe è una factory per le connessioni al database
public class ConnectionFactory {

    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/andiamoateatro", "root",
                    "mrobot4a");
        }
        return connection;
    }

    public static void closeConnection() throws SQLException {
        connection.close();
    }

}
