package org.example;

import ConControl.ConControl;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        System.out.println("I'am a GAY!");
        ConControl CC=new ConControl();
        CC.getClient(1);                                        //Getting request to DB
        CC.addClient("Antony","Nuprey","298047042","logic@bk.ru");  //add a new client
        CC.uppdateClient(1,"294235264");          //uppdating client info(PhoneNumber)
        CC.deleteClient("Nuprey");                     //Removing client using Surname field
    }
}