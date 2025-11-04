package Controlador;
import Modelo.QueryResult;

import java.sql.*;

public class SQLManager {
    private static Connection connection;
    private String dbType;

    public SQLManager(String dbType, String server, String user, int port, String password, String database, boolean useSSL) {
        this.dbType = dbType.toLowerCase();
        String url = buildConnectionUrl(server, port, database, useSSL);
        
        if(!connectDB(url, user, password)) {
            return;
        }
        System.out.println("Connected to " + dbType.toUpperCase() + " succesfully");
    }

    public SQLManager(String dbType, String server, String user, int port, String password, String database) {
        this(dbType, server, user, port, password, database, false);
    }

    public SQLManager(String server, String user, int port, String password, String database) {
        this("mariadb", server, user, port, password, database, false);
    }

    private String buildConnectionUrl(String server, int port, String database, boolean useSSL) {
        switch (dbType) {
            case "mariadb":
            case "mysql":
                String sslParam = useSSL ? "?useSSL=true" : "";
                return "jdbc:mariadb://" + server + ":" + port + "/" + database + sslParam;

            case "derby":
                String sslDerby = useSSL ? ";ssl=basic" : "";
                return "jdbc:derby://" + server + ":" + port + "/" + database + sslDerby;

            default:
                throw new IllegalArgumentException("Invalid database type: " + dbType);
        }
    }

    private String getDriverClassName() {
        switch (dbType) {
            case "mariadb":
            case "mysql":
                return "org.mariadb.jdbc.Driver";
            
            case "derby":
                return "org.apache.derby.client.ClientAutoloadedDriver";
            
            default:
                throw new IllegalArgumentException("Unsupported database type: " + dbType);
        }
    }

    public boolean connectDB(String url, String user, String pass) {
        // Load driver
        try {
            String driverClass = getDriverClassName();
            Class.forName(driverClass);
        } catch (ClassNotFoundException e) {
            System.out.println("Driver " + dbType.toUpperCase() + " couldn't be found: " + e.getMessage());
            return false;
        }

        try {
            String password;

            if (dbType.equals("derby")) {
                password = (pass == null || pass.isEmpty()) ? null : pass;
                if (password == null && user != null && !user.isEmpty()) {
                    connection = DriverManager.getConnection(url);
                } else {
                    connection = DriverManager.getConnection(url, user, password);
                }
            } else {
                password = (pass == null) ? "" : pass;
                connection = DriverManager.getConnection(url, user, password);
            }
            
            return true;
        } catch (SQLException e) {
            System.out.println("Error while connecting to DB: " + e.getMessage());
        }
        return false;
    }
    
    public Connection getConnection() {
        return connection;
    }

    public QueryResult executeQuery(String query) {
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();
            QueryResult result = new QueryResult(rs, rsmd, stmt);
            return result;
        } catch (SQLException e) {
            System.out.println("Error while executing query: " + e.getMessage());
            return null;
        }
    }

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Connection closed successfully");
            }
        } catch (SQLException e) {
            System.out.println("Error while closing connection: " + e.getMessage());
        }
    }
}
