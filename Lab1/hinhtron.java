import java.util.Scanner;

public class hinhtron {
    private float R;
    private final float PI = 3.14f;

    public hinhtron(float R) {
        this.R = R;
    }


    public float tinhChuVi() {
        return 2 * PI * R;
    }

    public float tinhDienTich() {
        return PI * R * R;
    }

    public static void main(String[] args) { 
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập bán kính của hình tròn: ");
        float bankinh = scanner.nextFloat();

        hinhtron hinhtron = new hinhtron(bankinh);

        float chuVi = hinhtron.tinhChuVi();
        float dienTich = hinhtron.tinhDienTich();

        System.out.println("Chu vi của hình tròn là: " + chuVi);
        System.out.println("Diện tích của hình tròn là: " + dienTich);
     
      
    } 
}
           