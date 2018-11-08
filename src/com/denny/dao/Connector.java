package com.denny.dao;

import java.sql.*;

public class Connector {
    private static Connection connection;

    public static Connection setupConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/users?" +
                    "useUnicode=true&useJDBCCompliantTimezoneShift=" +
                    "true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "kanaDa34123");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(connection == null) {
            throw new RuntimeException("impossiblo to connect database");
        }
        return connection;
    }

    /*public static boolean isUserOk(String user, String password, Connection connection) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("select * from user where username = ? and password = ?");
        statement.setString(1, user);
        statement.setString(2, password);
        ResultSet resultSet = statement.executeQuery();

        if(resultSet.next()){
            return true;
        } else {
            return false;
        }
    }*/
}
