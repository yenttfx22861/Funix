package com.basic.bai2;

import java.util.Scanner;

public class MainScreen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập một số nguyên N từ bàn phím
        System.out.print("Nhập một số nguyên N (N > 0): ");
        int N = scanner.nextInt();

        if (N <= 0) {
            System.out.println("Số N phải lớn hơn 0.");
        } else {
            // Tính tổng các số chẵn và tổng các số lẻ từ 0 đến N
            int sumEven = 0;
            int sumOdd = 0;
            int countDivisibleBy3 = 0;

            for (int i = 0; i <= N; i++) {
                if (i % 2 == 0) {
                    sumEven += i;
                } else {
                    sumOdd += i;
                }

                if (i % 3 == 0 && i % 2 != 0) {
                    countDivisibleBy3++;
                }
            }

            System.out.println("Tổng các số chẵn từ 0 đến N: " + sumEven);
            System.out.println("Tổng các số lẻ từ 0 đến N: " + sumOdd);
            System.out.println("Số lượng số chia hết cho 3 nhưng không chia hết cho 2 từ 0 đến N: " + countDivisibleBy3);
        }

        scanner.close();
    }
}

