package pl.camp.it.jdbc.repository;

import pl.camp.it.jdbc.App;
import pl.camp.it.jdbc.configurations.AppConfiguration;
import pl.camp.it.jdbc.model.Car;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Repository {

    static Scanner scanner = new Scanner(System.in);

    public static void addToDataBase() {
        System.out.println("Enter model");
        String model = scanner.nextLine();

        System.out.println("Enter brand");
        String brand = scanner.nextLine();

        System.out.println("Enter color");
        String color = scanner.nextLine();

        System.out.println("Enter pieces");
        int pieces = scanner.nextInt();

        System.out.println("Enter owner id");
        int owner_id = scanner.nextInt();

        String SQL = "INSERT INTO tcar (model, brand, color, pieces, owner_id) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement =  AppConfiguration.connection().prepareStatement(SQL);
            preparedStatement.setString(1, model);
            preparedStatement.setString(2, brand);
            preparedStatement.setString(3, color);
            preparedStatement.setInt(4, pieces);
            preparedStatement.setInt(5, owner_id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void getFromDataBase() {
        List<Car> carList = new ArrayList<>();
        String SQL = "SELECT * FROM tcar";
        try {
            PreparedStatement preparedStatement = AppConfiguration.connection().prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                carList.add(new Car(resultSet.getString("model"),
                        resultSet.getString("brand"),
                        resultSet.getString("color"),
                        resultSet.getInt("pieces"),
                        resultSet.getInt("owner_id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println(carList);
    }

    public static void updateCar() {
        String SQL = "UPDATE tcar SET model=?, brand=?, color=?, pieces=?, owner_id=? WHERE id=?";

        System.out.println("Enter id: ");
        int id = scanner.nextInt();

        System.out.println("edit model");
        String model = scanner.nextLine();

        System.out.println("edit brand");
        String brand = scanner.nextLine();

        System.out.println("edit color");
        String color = scanner.nextLine();

        System.out.println("edit pieces");
        int pieces = scanner.nextInt();

        System.out.println("edit owner id");
        int owner_id = scanner.nextInt();

        try {
            PreparedStatement preparedStatement = AppConfiguration.connection().prepareStatement(SQL);

            preparedStatement.setString(1, model);
            preparedStatement.setString(2, brand);
            preparedStatement.setString(3, color);
            preparedStatement.setInt(4, pieces);
            preparedStatement.setInt(5, owner_id);
            preparedStatement.setInt(6, id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void deleteCarFromDataBase() {
        String SQL = "DELETE FROM tcar WHERE id=?";

        System.out.println("Enter id: ");
        int id = scanner.nextInt();
        try {
            PreparedStatement preparedStatement = AppConfiguration.connection().prepareStatement(SQL);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
