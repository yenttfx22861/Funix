import java.util.Scanner;

public class bai3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập một số nguyên dương N: ");
        int N = scanner.nextInt();

        System.out.println("Các số nguyên tố từ 1 đến " + N + " là:");

        int count = 0;

        for (int i = 2; i <= N; i++) {
            if (kiemTraSoNguyenTo(i)) {
                System.out.print(i + " ");
                count++;
            }
        }

        System.out.println("\nTổng cộng có " + count + " số nguyên tố từ 1 đến " + N);
    }

    public static boolean kiemTraSoNguyenTo(int k) {
        if (k <= 1) {
            return false;
        }
        if (k <= 3) {
            return true;
        }
        if (k % 2 == 0 || k % 3 == 0) {
            return false;
        }
        for (int i = 5; i * i <= k; i += 6) {
            if (k % i == 0 || k % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}
