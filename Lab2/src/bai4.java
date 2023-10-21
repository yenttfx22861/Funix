import java.util.Scanner;

public class bai4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // In câu hỏi và đáp án ra màn hình
        System.out.println("Gói nào trong java chứa lớp Scanner dùng để nhập dữ liệu từ bàn phím ?");
        System.out.println("A. java.net");
        System.out.println("B. java.io");
        System.out.println("C. java.util");
        System.out.println("D. java.awt");

        // Nhận đáp án từ người dùng
        System.out.print("Câu trả lời của bạn: ");
        String userInput = scanner.nextLine().trim().toUpperCase(); // Chuyển đáp án nhập vào thành chữ hoa và loại bỏ khoảng trắng.

        // Kiểm tra đáp án và in ra kết quả
        switch (userInput) {
            case "C":
                System.out.println("Chính xác! Đáp án là C.");
                break;
            case "A":
            case "B":
            case "D":
                System.out.println("Sai! Đáp án không chính xác.");
                break;
            default:
                System.out.println("Đáp án không hợp lệ!");
                break;
        }
    }
}
