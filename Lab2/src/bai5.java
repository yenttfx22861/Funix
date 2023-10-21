
public class bai5 {
    public static void main(String[] args) {
        String chuoi = "xinchao";

        // Tách chuỗi thành hai phần: ký tự đầu tiên và phần còn lại
        String kyTuDauTien = chuoi.substring(0, 1);
        String phanConLai = chuoi.substring(1);

        // Chuyển ký tự đầu tiên thành chữ hoa
        kyTuDauTien = kyTuDauTien.toUpperCase();

        // Kết hợp lại chuỗi
        String ketQua = kyTuDauTien + phanConLai;

        System.out.println("Kết quả: " + ketQua);
    }
}

