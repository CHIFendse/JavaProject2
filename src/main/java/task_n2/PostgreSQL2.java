package task_n2;

import task_n1.PostgreSQL1;

import java.sql.*;
import java.util.Scanner;

public class PostgreSQL2 {
    final protected static Scanner scanner = new Scanner(System.in);
    protected static String postgreSQLURL = "jdbc:postgresql://localhost:5432/postgres";
    protected static Connection con;

    public static void showAllTables() {
        try {
            con = DriverManager.getConnection(postgreSQLURL, "CHIFendse", "CHIFendse");
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
            con = DriverManager.getConnection(postgreSQLURL, "CHIFendse", "CHIFendse");
            System.out.println("--- СОЗДАНИЕ НОВОЙ ТАБЛИЦЫ ---");
            System.out.print("Введите имя таблицы: ");
            String tableName = scanner.nextLine();
            Statement stmt = con.createStatement();
            String tab = "CREATE TABLE IF NOT EXISTS " + tableName + " (Matrix1 VARCHAR(255), Matrix2 VARCHAR(255), Result VARCHAR(255))";
            stmt.executeUpdate(tab);
            System.out.println("Таблица '" + tableName + "' успешно создана!");
            stmt.close();
            con.close();


        } catch (SQLException e) {
            System.out.println("Такое имя не подходит!");
        }
    }
    public static void DataWriteDown(String data1, String data2) {
        System.out.print("Введите имя таблицы для записи: ");
        Object table = scanner.nextLine();

        try {
            con = DriverManager.getConnection(postgreSQLURL, "CHIFendse", "CHIFendse");
            String tab1 = "INSERT INTO " + table + " (matrix1, matrix2) VALUES (?, ?)";
            PreparedStatement stmt1 = con.prepareStatement(tab1);
            stmt1.setString(1, data1);
            stmt1.setString(2, data2);
            stmt1.executeUpdate();
            System.out.println("Успешная запись!");
            stmt1.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Ошибка при добавлении данных: " + e.getMessage());
        }
    }
    public static void updateData(String data1, String data2, String data3) {
        System.out.print("Введите имя таблицы для записи: ");
        Object table = scanner.nextLine();
        try {
            con = DriverManager.getConnection(postgreSQLURL, "CHIFendse", "CHIFendse");
            PreparedStatement stmt1 = con.prepareStatement("UPDATE " + table + " SET Result = ? WHERE matrix1 = ? AND matrix2 = ?");
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
