package Vista;

import Controlador.EnvLoader;
import Controlador.SQLManager;
import Modelo.QueryResult;

import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.Map;

public class App {
    private static App app;
    private static SQLManager sqlManager;

    private static Map<String,String> dotenv;

    public App() {

    }

    public static void main(String[] args) {
        dotenv = EnvLoader.loadDotenv(Paths.get(".env"));
        String dbType = dotenv.getOrDefault("DB_TYPE", "mariadb");
        
        sqlManager = new SQLManager(
            dbType,
            dotenv.get("DB_SERVER"), 
            dotenv.get("DB_USER"), 
            Integer.parseInt(dotenv.get("DB_PORT")), 
            dotenv.get("DB_PASS"), 
            dotenv.get("DB_DATABASE")
        );

        app = new App();

        try {
            QueryResult queryR = sqlManager.executeQuery("SELECT * FROM EMPLEADO");
            int numCols = queryR.resultSetMetaData.getColumnCount();
            while(queryR.resultSet.next()) {
                for (int i = 1; i <= numCols; i++) {
                    System.out.println(queryR.resultSet.getString(i) + " ");
                }
                System.out.println("");
            }
            queryR.close();
        } catch (SQLException e) {
            System.out.println("SQL query exception: " + e.getMessage());
        }
    }
}
