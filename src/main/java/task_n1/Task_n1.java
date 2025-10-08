package task_n1;

import  java.util.Scanner;
import Base.Excel;

public class Task_n1 {
    public static void start(){
        Scanner sc1 = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("1. Вывести все таблицы из PostgreSQL.");
            System.out.println("2. Создать таблицу в PostgreSQL.");
            System.out.println("3. Изменить порядок символов строки на обратный");
            System.out.println("4. Добавить одну строку в другую");
            System.out.println("5. Сохранить все данные в Excel");

            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    PostgreSQL1.showAllTables();
                    start();
                    break;
                case 2:
                    PostgreSQL1.createTable1();
                    start();
                    break;
                case 3:
                    Reverse();
                    start();
                    break;
                case 4:
                    Add();
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


    private static void Reverse() {
        Scanner sc0 = new Scanner(System.in);
        System.out.println("Введите строку: ");
        String s = sc0.nextLine();
        String reversed_s = "";
        for (int i = 0; i < s.length(); i++){
            reversed_s = s.charAt(i) + reversed_s;
        }
        System.out.println(reversed_s);
        PostgreSQL1.DataWriteDown(reversed_s);
    }
    private  static void Add() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите 1 строку: ");
        String s1 = sc.next();
        System.out.println("Введите 2 строку: ");
        String s2 = sc.next();
        String s3 = s1 + s2;
        System.out.println(s3);
        PostgreSQL1.DataWriteDown(s3);
    }
}
