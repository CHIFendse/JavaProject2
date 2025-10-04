package task_n1;

import  java.util.Scanner;

public class task_n1 {
    protected static Scanner sc = new Scanner(System.in);

    public static void router(String[] args) {

        while (true) {
            try {
                Menu();

                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        Reverse();
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                }
            }
            catch (Exception e) {
                System.out.println("Ошибка ввода. попробуйте еще раз");
                break;
            }
        }
    }

    private static void Menu() {
        System.out.println("1. Вывести все таблицы из MySQL/PostgreSQL");
        System.out.println("2. Создать таблицу в MySQL/PostgreSQL");
        System.out.println("3. Изменить порядок символов строки на обратный, результат сохранить в MySQL/PostgreSQL с последующим выводом в консоль");
        System.out.println("4. Добавить одну строку в другую, результат сохранить в MySQL/PostgreSQL с последующим выводом в консоль.");
        System.out.println("5. Сохранить все данные (вышеполученные результаты) из MySQL/PostgreSQL в Excel и вывести на экран.");
    }

    private static  void Reverse() {
        System.out.println("Введите строку");
        String s = sc.nextLine();
        String reversed_s = "";
        for (int i = 0; i < s.length(); i++){
            reversed_s = s.charAt(i) + reversed_s;
        }
        System.out.println(reversed_s);
        // сохранить в бд
    }
}