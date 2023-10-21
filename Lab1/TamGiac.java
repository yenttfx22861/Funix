import java.util.Scanner;

public class TamGiac {
    private int a, b, c;

    public TamGiac(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int tinhChuVi() {
        return a + b + c;
    }

    public double tinhDienTich() {
        double p = (double) (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập độ dài cạnh a: ");
        int a = scanner.nextInt();
        System.out.print("Nhập độ dài cạnh b: ");
        int b = scanner.nextInt();
        System.out.print("Nhập độ dài cạnh c: ");
        int c = scanner.nextInt();

        TamGiac tamGiac = new TamGiac(a, b, c);

        int chuVi = tamGiac.tinhChuVi();
        double dienTich = tamGiac.tinhDienTich();

        System.out.println("Chu vi của tam giác là: " + chuVi);
        System.out.println("Diện tích của tam giác là: " + dienTich);
    }
}

