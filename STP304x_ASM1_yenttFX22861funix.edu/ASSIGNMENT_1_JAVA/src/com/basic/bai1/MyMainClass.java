package com.basic.bai1;

import java.util.Scanner;

public class MyMainClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập số thứ nhất và số thứ hai
        System.out.print("Nhập số thứ nhất x = ");
        double x = scanner.nextDouble();
        System.out.print("Nhập số thứ hai y = ");
        double y = scanner.nextDouble();

        // Nhập lệnh ACTION
        System.out.print("Nhập lệnh ACTION = ");
        String action = scanner.nextLine();

        double result = 0;

        // Kiểm tra lựa chọn action và thực hiện phép tính tương ứng
        switch (action) {
            case "CONG":
                result = CalculateUtils.tinhCong(x, y);
                break;
            case "TRU":
                result = CalculateUtils.tinhTru(x, y);
                break;
            case "NHAN":
                result = CalculateUtils.tinhNhan(x, y);
                break;
            case "CHIA":
                result = CalculateUtils.tinhChia(x, y);
                break;
            default:
                System.out.println("Giá trị ACTION không hợp lệ");
                scanner.close();
                return; // Kết thúc chương trình
        }

        System.out.println("Kết quả: " + result);

        scanner.close();
    }
}
