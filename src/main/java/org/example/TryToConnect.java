package org.example;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TryToConnect {
    public static Statement statement;
    public static Connection connection;
    static {
        try {
            connection = DriverManager.getConnection(Constants.URL, Constants.USER_NAME, Constants.PASSWROD);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    static {
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        String orderFrst = "INSERT INTO {tn} ({frst}, {sec}, {thrd}) values ('Anna',36,'sdfsdf@mail.ru')"
                .replace("{tn}", Constants.NAME_OF_TABLE)
                .replace("{frst}", Constants.NAMES_OF_COLUMNS[0])
                .replace("{sec}", Constants.NAMES_OF_COLUMNS[1])
                .replace("{thrd}", Constants.NAMES_OF_COLUMNS[2]);
        String orderSec = "UPDATE {tn} SET name='Vladimir' WHERE id=7"
                .replace("{tn}", Constants.NAME_OF_TABLE);
        statement.execute(orderFrst);
//        statement.execute(orderSec);
    }
}
