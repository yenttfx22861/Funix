import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Nhập số thực a: ");
            float a = scanner.nextFloat();

            System.out.print("Nhập số thực b: ");
            float b = scanner.nextFloat();

            int ketQua = chiaPhanNguyen(a, b);
            System.out.println("Kết quả phép chia a / b là: " + ketQua);
        } catch (NumberFormatException e) {
            System.out.println("Lỗi: Bạn đã nhập không phải là số.");
        } catch (ArithmeticException e) {
            System.out.println("Lỗi: Phép chia không hợp lệ (b = 0).");
        }
        
        scanner.close();
    }

    public static int chiaPhanNguyen(float a, float b) {
        if (b == 0) {
            throw new ArithmeticException("Phép chia không hợp lệ (b = 0).");
        }
        return (int) (a / b);
    }
}
