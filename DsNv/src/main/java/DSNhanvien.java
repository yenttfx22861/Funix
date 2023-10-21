import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Scanner;


public class DSNhanvien {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of employees: ");
        int n = Integer.parseInt(scanner.nextLine());

        ArrayList<Employee> employeeList = new ArrayList<Employee>();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter information for employee " + (i + 1) + ":");
            System.out.print("Employee ID: ");
            String employeeID = scanner.nextLine();
            System.out.print("Full Name: ");
            String fullName = scanner.nextLine();
            System.out.print("Gender: ");
            String gender = scanner.nextLine();
            System.out.print("Year of Birth: ");
            String yearOfBirth = scanner.nextLine();
            System.out.print("Hometown: ");
            String hometown = scanner.nextLine();
            System.out.print("Department: ");
            String department = scanner.nextLine();
            System.out.print("Salary: ");
            String salary = scanner.nextLine();

            Employee employee = new Employee(employeeID, fullName, gender, yearOfBirth, hometown, department, salary);
            employeeList.add(employee);
        }
        
        // Close the scanner to release resources
        scanner.close();

        writeToExcelFile(employeeList);
        System.out.println("Employee information has been written to the file DSNhanvien.xlsx.");
    }

    public static void writeToExcelFile(ArrayList<Employee> employeeList) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Employee List");

        Row titleRow = sheet.createRow(0);
        String[] titles = {"Employee ID", "Full Name", "Gender", "Year of Birth", "Hometown", "Department", "Salary"};
        for (int i = 0; i < titles.length; i++) {
            Cell cell = titleRow.createCell(i);
            cell.setCellValue(titles[i]);
        }

        for (int i = 0; i < employeeList.size(); i++) {
            Employee employee = employeeList.get(i);
            Row row = sheet.createRow(i + 1);

            row.createCell(0).setCellValue(employee.getEmployeeID());
            row.createCell(1).setCellValue(employee.getFullName());
            row.createCell(2).setCellValue(employee.getGender());
            row.createCell(3).setCellValue(employee.getYearOfBirth());
            row.createCell(4).setCellValue(employee.getHometown());
            row.createCell(5).setCellValue(employee.getDepartment());
            row.createCell(6).setCellValue(employee.getSalary());
        }

        try {
            FileOutputStream out = new FileOutputStream(new File("DSNhanvien.xlsx"));
            workbook.write(out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Employee {
    private String employeeID;
    private String fullName;
    private String gender;
    private String yearOfBirth;
    private String hometown;
    private String department;
    private String salary;

    public Employee(String employeeID, String fullName, String gender, String yearOfBirth, String hometown, String department, String salary) {
        this.employeeID = employeeID;
        this.fullName = fullName;
        this.gender = gender;
        this.yearOfBirth = yearOfBirth;
        this.hometown = hometown;
        this.department = department;
        this.salary = salary;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public String getFullName() {
        return fullName;
    }

    public String getGender() {
        return gender;
    }

    public String getYearOfBirth() {
        return yearOfBirth;
    }

    public String getHometown() {
        return hometown;
    }

    public String getDepartment() {
        return department;
    }

    public String getSalary() {
        return salary;
    }

}
