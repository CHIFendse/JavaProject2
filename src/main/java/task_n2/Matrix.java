package task_n2;

import java.util.Scanner;

final public class Matrix extends ArrayPI{
    static int[][] resMatrix = new int[7][7];
    static StringBuilder sb = new StringBuilder();
    static int cnt=0;
    public static void multiplication(){
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                for (int k = 0; k < 7; k++) {
                    resMatrix[i][j] += mat1[i][k] * mat2[k][j];
                }
                if (mat1[i][j]==0  && mat2[i][j]== 0) {
                    cnt += 1;
                }
            }
        }
        if (cnt!=49 && cntFlag==2) {
            sb.append("{");
            for (int i = 0; i < 7; i++) {
                sb.append("{");
                for (int j = 0; j < 7; j++) {
                    sb.append(resMatrix[i][j] + "");
                    System.out.print(resMatrix[i][j] + " ");
                }
                sb.append("}");
                System.out.println();
            }
            sb.append("}");
            PostgreSQL2.updateData(sb1.toString(), sb2.toString(), sb.toString());
        } else{
            System.out.println("Вы не инициализировали матрицы, для начала создайте их!");
            Task_n2.start();
        }
    }
}
