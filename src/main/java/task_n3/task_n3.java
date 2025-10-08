package task_n3;

import Base.Excel;
import java.util.Scanner;
import java.util.Arrays;

public class Task_n3 {

    public static void start () {
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        try {
            System.out.println("            --- ВЫБОР ЗАДАЧИ ---");
            System.out.println("1. Вывести все таблицы из базы данных PostgreSQL.");
            System.out.println("  2. Создать таблицу в базе данных PostgreSQL.");
            System.out.println("         3. Ввести одномерный массив.");
            System.out.println("          4. Отсортировать массив.");
            System.out.println("       5. Сохранить результаты в Excel.");
            System.out.println(("-------------------------------------------------"));

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    PostgreSQL3.showAllTables();
                    start();
                    break;
                case 2:
                    PostgreSQL3.createTable1();
                    start();
                    break;
                case 3:
                    ArrayPI.mas();
                    start();
                    break;
                case 4:
                    Sort.PuzirVoz();
                    Sort.PuzirYb();
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
        }
        catch (Exception e) {
            System.out.println("Введите одну из предложенных цифр!");
            start();
        }
    }
}
