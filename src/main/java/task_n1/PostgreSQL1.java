package task_n1;

import java.sql.*;
import java.util.Scanner;

public class PostgreSQL1 {
    protected static Scanner scanner = new Scanner(System.in);
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
            String tableName = PostgreSQL1.scanner.nextLine().replaceAll("\\s+", "");
            Statement stmt = con.createStatement();
            String tab = "CREATE TABLE IF NOT EXISTS " + tableName + " (Result VARCHAR(255))";
            stmt.executeUpdate(tab);
            System.out.println("Таблица '" + tableName + "' успешно создана!");
            stmt.close();
            con.close();


        } catch (SQLException e) {
            System.out.println("Ошибка при создании таблицы: " + e.getMessage());
        }
    }
    public static void DataWriteDown(String data) {
        System.out.print("Введите имя таблицы для записи: ");
        Object table = PostgreSQL1.scanner.nextLine();

        try {
            con = DriverManager.getConnection(postgreSQLURL, "postgres", "86424822");
            String tab1 = "INSERT INTO " + table + " (Result) VALUES (?)";
            PreparedStatement stmt1 = con.prepareStatement(tab1);
            stmt1.setString(1, data);
            stmt1.executeUpdate();
            System.out.println("Успешная запись!");
            stmt1.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Ошибка при добавлении данных: " + e.getMessage());
        }
    }
}
