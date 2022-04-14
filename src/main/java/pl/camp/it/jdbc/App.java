package pl.camp.it.jdbc;


import pl.camp.it.jdbc.configurations.AppConfiguration;
import pl.camp.it.jdbc.repository.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Select: ");
        System.out.println("1. Add car to database");
        System.out.println("2. View cars");
        System.out.println("3. Edit car");
        System.out.println("4. Delete car from database");
        System.out.println("5. Exit");

        switch (scanner.nextInt()) {
            case 1:
                Repository.addToDataBase();
                break;
            case 2:
                Repository.getFromDataBase();
                break;
            case 3:
                Repository.updateCar();
                break;
            case 4:
                Repository.deleteCarFromDataBase();
                break;
            case 5:
                System.exit(0);
        }
    }

}
