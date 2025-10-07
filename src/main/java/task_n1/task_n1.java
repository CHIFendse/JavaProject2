package task_n1;

import  java.util.Scanner;

public class task_n1 {
    protected static Scanner sc = new Scanner(System.in);
    protected static Scanner sc0 = new Scanner(System.in);
    protected static Scanner sc1 = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            try {
                System.out.println("1. Вывести все таблицы из PostgreSQL.");
                System.out.println("2. Создать таблицу в PostgreSQL.");
                System.out.println("3. Изменить порядок символов строки на обратный, результат сохранить в PostgreSQL с последующим выводом в консоль.");
                System.out.println("4. Добавить одну строку в другую, результат сохранить в PostgreSQL с последующим выводом в консоль.");
                System.out.println("5. Сохранить все данные (вышеполученные результаты) из PostgreSQL в Excel и вывести на экран.");

                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        PostgreSQL1.showAllTables();
                        break;
                    case 2:
                        PostgreSQL1.createTable1();
                        break;
                    case 3:
                        Reverse();
                        break;
                    case 4:
                        Add();
                        break;
                    case 5:
                        System.out.println("Введите название таблицы:");
                        String table = sc1.nextLine();
                        try {

                            Excel1.ExportToExcel(table);

                        } catch (Exception e) {
                            System.out.println("vi dolboeb. Ошибка записи.");

                        }
                        break;
                    default:
                        System.out.println("Неверный выбор. Попробуйте снова.");
                        break;
                }
            }
            catch (Exception e) {
                System.out.println("Ошибка ввода. попробуйте еще раз.");
                break;
            }
        }
    }

    private static  void Reverse() {
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
        System.out.println("Введите 1 строку: ");
        String s1 = sc.next();
        System.out.println("Введите 2 строку: ");
        String s2 = sc.next();
        String s3 = s1 + s2;
        System.out.println(s3);
        PostgreSQL1.DataWriteDown(s3);
    }
}