package lab3a;

import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số phần tử của mảng: ");
        int n = scanner.nextInt();

        int[] mang = new int[n];

        System.out.println("Nhập các phần tử của mảng:");
        for (int i = 0; i < n; i++) {
            mang[i] = scanner.nextInt();
        }

        // Sắp xếp mảng theo thứ tự tăng dần bằng Selection Sort
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (mang[j] < mang[minIndex]) {
                    minIndex = j;
                }
            }
            //swap - doi vi tri 2 phan tu cho nhau
            int temp = mang[i];
            mang[i] = mang[minIndex];
            mang[minIndex] = temp;
        }

        System.out.println("Dãy số sau khi sắp xếp:");
        for (int i = 0; i < n; i++) {
            System.out.print(mang[i] + " ");
        }
    }
}
