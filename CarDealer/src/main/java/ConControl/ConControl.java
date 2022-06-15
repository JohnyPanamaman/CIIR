package ConControl;
import java.sql.*;

public class ConControl {
    public void DataReq(){
        try(Connection conection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cdbase", "root", "12345")){
            Statement st = conection.createStatement();
            String query = "SELECT * FROM client";
            ResultSet resultSet= st.executeQuery(query);
            System.out.println("Client ID\tName\tSurname\tPhone number\tE-Mail");
            while(resultSet.next()){
                System.out.println(resultSet.getInt("Client ID")+
                        "\t"+resultSet.getString("Name")+
                        "\t"+resultSet.getString("Surname")+
                        "\t"+resultSet.getString("Phone numberl")+
                        "\t"+resultSet.getString("E-Mail"));
            }
            st.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
