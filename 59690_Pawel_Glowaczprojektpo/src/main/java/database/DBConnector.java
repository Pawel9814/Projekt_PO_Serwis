package database;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DBConnector {

    private static DBConnector DBConnectorSingleton = null;
    private static Properties properties;
    private InputStream inputStream;
    private static String serverURL;
    private static String serverUser;
    private static String serverPassword;

    private static Connection connection;
    private static Statement statement;
    private ResultSet resultSet;

    private DBConnector() throws SQLException {
        try {
            loadConfig();
            loadServer();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
    public static synchronized DBConnector connect() throws SQLException {
        if (DBConnectorSingleton == null) {
            DBConnectorSingleton = new DBConnector();
            return DBConnectorSingleton;
        }
        return DBConnectorSingleton;
    }
    //sql question
    public ResultSet createResultSet(String query) throws SQLException {
        resultSet = statement.executeQuery(query);
        return resultSet;
    }
    //sql insert
    public void insertRecord(String query) throws SQLException{
        statement.getConnection().createStatement();
        statement.executeUpdate(query);
    }

    public static boolean isOnline() throws SQLException {

        if(connection != null) {
            return true;
        }
        else
            return false;
    }
    private void loadConfig() throws IOException {
        properties = new Properties();
        String propFileName = "config.properties";

        inputStream = this.getClass().getClassLoader().getResourceAsStream(propFileName);
        if (inputStream != null) {
            properties.load(inputStream);
            inputStream.close();
        } else {
            throw new FileNotFoundException("property file not found");
        }
        serverURL = properties.getProperty("serverURL");
        serverUser = properties.getProperty("user");
        serverPassword = properties.getProperty("password");
    }
    public static void loadServer() throws SQLException {
        try {
            //getConnection(driver://server + TimeZone setting (otherwise might cause SQLException error), user, password)
            connection = DriverManager.getConnection(
                    "jdbc:mysql://"+serverURL,
                    serverUser, serverPassword);
            statement = connection.createStatement();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
}