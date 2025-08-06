package Bank.Management.System;

import java.sql.*;

public class Conn {

    Connection connection;
    Statement statement;
    public Conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql:///bankmanagement", "root", "adarsh@2003");
            statement = connection.createStatement();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
