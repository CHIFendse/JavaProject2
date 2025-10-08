package task_n3;

import java.util.Scanner;
import java.util.Arrays;

public class ArrayPI {

    static int[] arr = new int[35];
    static boolean flag = false;

    public static void mas() {Scanner sc = new Scanner(System.in);
        try {
            for (int i = 0; i < 35; i++) {
                System.out.println("Введите " + (i+1) + " число массива: ");
                arr[i] = sc.nextInt();
                flag = true;
            }
            System.out.println(Arrays.toString(arr));
            PostgreSQL3.DataWriteDown(Arrays.toString(arr));
        } catch (Exception e) {
            System.out.println("Вы ввели не цифру!");
            flag=false;
            mas();
        }
    }
}
