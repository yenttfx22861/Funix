
import java.util.Scanner;

public class bai2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        int N;

        // Sử dụng vòng lặp do-while để nhập N cho đến khi tổng >= 100
        do {
            System.out.print("Nhập một số nguyên N: ");
            N = scanner.nextInt();
            sum += N;
            sum = sum + N;
        } while (sum < 100);
 
        if (N % 2 == 1) {
            System.out.println("Dãy số lẻ giảm dần:");
            while (N >= 1) {
                System.out.print(N + " ");
                N -= 2;
            }
        } else {
            System.out.println("Dãy số chẵn giảm dần:");
            while (N >= 2) {
                System.out.print(N + " ");
                N -= 2;
            }
        }
    }
}

