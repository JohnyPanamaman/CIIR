package ConControl;
import jdk.jshell.spi.ExecutionControl;

import java.sql.*;

public class ConControl {
    public void getClient(int id) throws SQLException {
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cdbase", "root", "12345")){
            Statement st = connection.createStatement();
            String query = "SELECT * FROM client";
            ResultSet resultSet= st.executeQuery(query);
            System.out.println("Client ID\tName\tSurname\tPhone\tE-Mail");
            while(resultSet.next()){
                if (resultSet.getInt("ClientID") == id)
                    System.out.println(resultSet.getInt("ClientID")+
                            "\t"+resultSet.getString("Name")+
                            "\t"+resultSet.getString("Surname")+
                            "\t"+resultSet.getString("Phone")+
                            "\t"+resultSet.getString("EMail"));
            }
            st.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void addClient(String ClientName, String ClientSurname, String ClientPhoneNum, String ClientEMail) throws SQLException {
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cdbase", "root", "12345")){
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO client(Name, Surname, Phone, EMail) VALUES ('"
                    + ClientName + "', '"
                    + ClientSurname+"', '"
                    + ClientPhoneNum+ "', '"
                    +ClientEMail +"');");
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void uppdateClient(int id, String ClientPhoneNum) throws SQLException {
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cdbase", "root", "12345")){
            Statement statement = connection.createStatement();
            String updSql = "update client set Phone ='" + ClientPhoneNum + "' WHERE ClientID = '" + id + "';";
            statement.executeUpdate(updSql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void deleteClient(String ClientSurname) throws SQLException {
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cdbase", "root", "12345")){
            Statement statement = connection.createStatement();
            String updSql = "delete from client WHERE Surname = '" + ClientSurname + "';";
            statement.executeUpdate(updSql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

