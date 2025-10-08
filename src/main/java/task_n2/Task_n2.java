package task_n2;

import Base.Excel;
import java.util.Scanner;

public class Task_n2 {
    public static void start(){
        Scanner sc1 = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("1. Вывести все таблицы из PostgreSQL.");
            System.out.println("2. Создать таблицу в PostgreSQL.");
            System.out.println("3. Ввести две матрицы с клавиатуры и каждую из них сохранить в PostgreSQL");
            System.out.println("4. Перемножить матрицы, сохранить перемноженную матрицу");
            System.out.println("5. Сохранить все данные в Excel");

            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    PostgreSQL2.showAllTables();
                    start();
                    break;
                case 2:
                    PostgreSQL2.createTable1();
                    start();
                    break;
                case 3:
                    ArrayPI.filling();
                    start();
                    break;
                case 4:
                    Matrix.multiplication();
                    start();
                    break;
                case 5:
                    System.out.println("Введите название таблицы:");
                    String table = sc1.nextLine();
                    try {
                        Excel.ExportToExcel(table);
                    } catch (Exception e) {
                        System.out.println("Ошибка записи, что-то не так.");
                    }
                    start();
                    break;
                default:
                    System.out.println("Эта цифра не подходит!");
                    start();
            }
        } catch (Exception e) {
            System.out.println("Введите одну из предложенных цифр!");
            start();
        }
    }
}
