package task_n3;

import java.util.Arrays;

public final class Sort extends ArrayPI{

    static int[] arr1 = arr;
    static int[] arr2 = arr;

    public static void PuzirVoz() {
        if (flag) {
            for (int i = 0; i < 34; i++) {
                for (int j = 0; j < 34 - i; j++) {
                    if (arr1[j] > arr1[j + 1]) {
                        int temp = arr1[j];
                        arr1[j] = arr1[j + 1];
                        arr1[j + 1] = temp;
                    }
                }
            }
            System.out.println(Arrays.toString(arr1));
        } else {
            System.out.println("Вы не ввели массив! ");
        }
    }

    public static void PuzirYb() {
        if (flag) {
            for (int m = 0; m < 34; m++) {
                for (int n = 0; n < 34 - m; n++) {
                    if (arr2[n] < arr2[n + 1]) {
                        int temp = arr2[n];
                        arr2[n] = arr2[n + 1];
                        arr2[n + 1] = temp;
                    }
                }
            }
            System.out.println(Arrays.toString(arr2));
        }
        PostgreSQL3.updateData(Arrays.toString(arr), Arrays.toString(arr1), Arrays.toString(arr2));
    }
}
