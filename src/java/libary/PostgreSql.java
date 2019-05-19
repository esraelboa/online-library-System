package libary;

import java.sql.*;

public class PostgreSql {

    private static final String driverName = "org.postgresql.Driver";
    private static final String hostname = "jdbc:postgresql://localhost:5432/library";
    private static final String username = "esra";
    private static final String password = "12345";

    public static Connection getConnection() throws Exception {
        Connection c = null;
        Class.forName(driverName);
        c = DriverManager.getConnection(hostname, username, password);
        if (c != null) {
            System.out.println("Opened database successfully");
            return c;
        } else {
            throw new Exception();
        }
    }

}
