package Modelo;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryResult {
    public ResultSet resultSet;
    public ResultSetMetaData resultSetMetaData;
    public Statement statement;

    public QueryResult(ResultSet resultSet, ResultSetMetaData resultSetMetaData, Statement statement) {
        this.resultSet = resultSet;
        this.resultSetMetaData = resultSetMetaData;
        this.statement = statement;
    }

    public void close() {
        try {
            if (resultSet != null && !resultSet.isClosed()) {
                resultSet.close();
            }
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }
        } catch (SQLException e) {
            System.out.println("Error while closing QueryResult: " + e.getMessage());
        }
    }
}
