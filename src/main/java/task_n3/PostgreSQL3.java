package task_n3;

import task_n2.Task_n2;

import java.sql.*;
import java.util.Scanner;

public class PostgreSQL3 {
    final protected static Scanner scanner = new Scanner(System.in);
    protected static String postgreSQLURL = "jdbc:postgresql://localhost:5432/postgres";
    protected static Connection con;
    protected static String zap = "'.,?1234567890!@#$%^&*(){}[]+=-_;:``~№|";

    public static void showAllTables() {
        try {
            con = DriverManager.getConnection(postgreSQLURL, "postgres", "86424822");
            DatabaseMetaData metaData = con.getMetaData();
            ResultSet tables = metaData.getTables(null, null, "%", new String[]{"TABLE"});

            System.out.println("--- ТАБЛИЦЫ В БАЗЕ ДАННЫХ ---");
            boolean hasTables = false;

            while (tables.next()) {
                hasTables = true;
                String tableName = tables.getString("TABLE_NAME");

                System.out.println("Таблица: " + tableName);

            }

            if (!hasTables) {
                System.out.println("В базе данных нет таблиц.");
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Ошибка при получении списка таблиц: " + e.getMessage());
        }
    }
    public static void createTable1() {
        try {
            con = DriverManager.getConnection(postgreSQLURL, "postgres", "86424822");
            System.out.println("--- СОЗДАНИЕ НОВОЙ ТАБЛИЦЫ ---");
            System.out.print("Введите имя таблицы: ");
            String tableName = scanner.nextLine();
            Statement stmt = con.createStatement();
            String tab = "CREATE TABLE IF NOT EXISTS " + tableName + " (arr VARCHAR(255), arr1 VARCHAR(255), arr2 VARCHAR(255))";
            stmt.executeUpdate(tab);
            System.out.println("Таблица '" + tableName + "' успешно создана!");
            stmt.close();
            con.close();


        } catch (SQLException e) {
            System.out.println("Такое имя не подходит!");
            createTable1();
        }
    }
    public static void DataWriteDown(String data1) {
        System.out.print("Введите имя таблицы для записи: ");
        Object table = scanner.nextLine();

        try {
            con = DriverManager.getConnection(postgreSQLURL, "postgres", "86424822");
            String tab1 = "INSERT INTO " + table + " (arr) VALUES (?)";
            PreparedStatement stmt1 = con.prepareStatement(tab1);
            stmt1.setString(1, data1);
            stmt1.executeUpdate();
            System.out.println("Успешная запись!");
            stmt1.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Такой таблицы не существует");
        }
    }
    public static void updateData(String data1, String data2, String data3) {
        System.out.print("Введите имя таблицы для записи: ");
        Object table = scanner.nextLine();
        try {
            con = DriverManager.getConnection(postgreSQLURL, "postgres", "86424822");
            PreparedStatement stmt1 = con.prepareStatement("UPDATE " + table + " SET arr = ? WHERE arr1 = ? AND arr2 = ?");
            stmt1.setString(1, data3);
            stmt1.setString(2, data1);
            stmt1.setString(3, data2);
            stmt1.executeUpdate();
            System.out.println("Успешная запись!");
            stmt1.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Ошибка при добавлении данных: " + e.getMessage());
            Task_n2.start(); 
        }
    }
}
