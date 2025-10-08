package task_n2;

import java.util.Scanner;

public class ArrayPI {
    static StringBuilder sb1 = new StringBuilder();
    static StringBuilder sb2 = new StringBuilder();
    static int mat1[][] = new int[7][7];
    static int mat2[][] = new int[7][7];
    static int cntFlag=0;
    public static void filling(){
        Scanner scan = new Scanner(System.in);
        //Создание первой матрицы
        try {
            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 7; j++) {
                    System.out.println("Введите число для " + (i + 1) + "-ой строки первой матрицы: ");
                    mat1[i][j] = scan.nextInt();
                }
            }
            cntFlag+=1;
        } catch (Exception e) {
            System.out.println("Вы ввели не цифру!");
            cntFlag=0;
            Task_n2.start();
        }
        //Вывод в консоль и конвертация в String для Excel
        System.out.println("Ваша первая матрица:");
        sb1.append("{");
        for (int[] i:mat1){
            sb1.append("{");
            for (int j: i){
                System.out.print(j+" ");
                sb1.append(j+"");
            }
            sb1.append("}");
            System.out.println();
        }
        sb1.append("}");
        System.out.println();
        //Создание второй матрицы
        try {
            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 7; j++) {
                    System.out.println("Введите число для " + (i + 1) + "-ой строки первой матрицы: ");
                    mat2[i][j] = scan.nextInt();
                }
            }
            cntFlag+=1;
        } catch (Exception e) {
            System.out.println("Вы ввели не цифру!");
            cntFlag=0;
            Task_n2.start();
        }
        //Вывод в консоль и конвертация в String для Excel
        System.out.println("Ваша вторая матрица:");
        sb2.append("{");
        for (int[] i:mat2){
            sb2.append("{");
            for (int j: i){
                System.out.print(j+" ");
                sb2.append(j+"");
            } sb2.append("}");
            System.out.println();
        } sb2.append("}");
    PostgreSQL2.DataWriteDown(sb1.toString(),sb2.toString());
    }
}
