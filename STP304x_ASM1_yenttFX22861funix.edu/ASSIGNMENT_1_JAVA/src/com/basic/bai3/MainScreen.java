package com.basic.bai3;

import java.util.ArrayList;
import java.util.Scanner;

public class MainScreen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        char continueInput;

        int studentNumber = 0;

        do {
            Student student = new Student();
            studentNumber++;

            System.out.println("Student " + studentNumber + ":");
            
            System.out.print("FullName: ");
            student.setFullName(scanner.nextLine());
            
            System.out.print("Address: ");
            student.setAddress(scanner.nextLine());
            
            System.out.print("DOB (dd/mm/yyyy): ");
            student.setDob(scanner.nextLine());
            
            System.out.print("Gender: ");
            student.setGender(scanner.nextLine());
            
            System.out.print("FinalGrade: ");
            student.setFinalGrade(scanner.nextFloat());
            
            students.add(student);
            
            scanner.nextLine(); // Đọc ký tự Enter
            
            System.out.print("Do you want to continue (Y/N)? ");
            continueInput = scanner.nextLine().charAt(0);
        } while (continueInput == 'Y' || continueInput == 'y');
        
        // In ra danh sách học sinh
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            System.out.println("Student " + (i + 1) + ":");
            System.out.println("FullName: " + student.getFullName());
            System.out.println("Address: " + student.getAddress());
            System.out.println("DOB: " + student.getDob());
            System.out.println("Gender: " + student.getGender());
            System.out.println("FinalGrade: " + student.getFinalGrade());
        }
        
        // Tính điểm tổng kết trung bình
        float totalFinalGrade = 0;
        for (Student student : students) {
            totalFinalGrade += student.getFinalGrade();
        }
        float averageFinalGrade = totalFinalGrade / students.size();
        System.out.println("Điểm tổng kết trung bình: " + averageFinalGrade);
        
        // In điểm học lực
        for (Student student : students) {
            float finalGrade = student.getFinalGrade();
            String fullName = student.getFullName();
            String hocluc = "";
            
            if (finalGrade < 4.0) {
                hocluc = "kém";
            } else if (finalGrade < 5.0) {
                hocluc = "yếu";
            } else if (finalGrade < 5.5) {
                hocluc = "trung bình yếu";
            } else if (finalGrade < 6.5) {
                hocluc = "trung bình";
            } else if (finalGrade < 7.0) {
                hocluc = "trung bình khá";
            } else if (finalGrade < 8.0) {
                hocluc = "khá";
            } else if (finalGrade < 8.5) {
                hocluc = "khá giỏi";
            } else {
                hocluc = "giỏi";
            }
            
            System.out.println("Học sinh " + fullName + " học lực " + hocluc);
        }
        
        scanner.close();
    }
}

