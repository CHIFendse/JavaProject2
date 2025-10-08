package Base;

import java.util.Scanner;
public class StartProgram {
    public static void st(){
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("1. Первая задача");
            System.out.println("2. Вторая задача");
            System.out.println("3. Третья задача");
            System.out.println("4. Четвертая задача");
            System.out.println("5. Выход");

            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    task_n1.Task_n1.start();
                    break;
                case 2:
                    task_n2.Task_n2.start();
                    break;
                case 3:
                    task_n3.Task_n3.start();
                    break;
                case 4:
                    //task4
                    break;
                case 5:
                    System.out.println("Вы вышли из системы.");
                    System.exit(0);
                default:
                    System.out.println("Эта цифра не подходит!");
                    st();
            }
        } catch (Exception e) {
            System.out.println("Введите одну из предложенных цифр!");
            st();
        }
    }
    public static void main(String[] args){
        st();
    }
}

