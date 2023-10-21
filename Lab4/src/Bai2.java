import java.util.Scanner;

// Định nghĩa interface cho việc hiển thị thời khóa biểu và thông tin lớp
interface IhienThi {
    void hienThiThoiKhoaBieu();
    void hienThiThongTinLop();
}

// Lớp cha Person
class Person {
    protected String hoTen;
    protected String gioiTinh;
    protected String queQuan;
    protected int namSinh;

    public Person() {
    }

    public Person(String hoTen, String gioiTinh, String queQuan, int namSinh) {
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.queQuan = queQuan;
        this.namSinh = namSinh;
    }

    public void hienThiThongTin() {
        System.out.println("Họ tên: " + hoTen);
        System.out.println("Giới tính: " + gioiTinh);
        System.out.println("Quê quán: " + queQuan);
        System.out.println("Năm sinh: " + namSinh);
    }

    public void nhapThongTin(Scanner scanner) {
        System.out.print("Họ tên: ");
        hoTen = scanner.nextLine();
        System.out.print("Giới tính: ");
        gioiTinh = scanner.nextLine();
        System.out.print("Quê quán: ");
        queQuan = scanner.nextLine();
        System.out.print("Năm sinh: ");
        namSinh = Integer.parseInt(scanner.nextLine());
    }
}

// Lớp LopHoc
class LopHoc {
    private String tenLop;
    private int siSo;
    private String khoi;

    public LopHoc() {
    }

    public LopHoc(String tenLop, int siSo, String khoi) {
        this.tenLop = tenLop;
        this.siSo = siSo;
        this.khoi = khoi;
    }

    public void hienThiThongTinLop() {
        System.out.println("Tên lớp: " + tenLop);
        System.out.println("Sĩ số: " + siSo);
        System.out.println("Khối: " + khoi);
    }

    public void nhapThongTinLop(Scanner scanner) {
        System.out.print("Tên lớp: ");
        tenLop = scanner.nextLine();
        System.out.print("Sĩ số: ");
        siSo = Integer.parseInt(scanner.nextLine());
        System.out.print("Khối: ");
        khoi = scanner.nextLine();
    }
}

// Lớp HocSinh
class HocSinh extends Person implements IhienThi {
    private String thoiKhoaBieu;
    private String giaoVienChuNhiem;
    private LopHoc lopHoc;

    public HocSinh() {
    }

    public HocSinh(String hoTen, String gioiTinh, String queQuan, int namSinh, String thoiKhoaBieu,
                   String giaoVienChuNhiem, LopHoc lopHoc) {
        super(hoTen, gioiTinh, queQuan, namSinh);
        this.thoiKhoaBieu = thoiKhoaBieu;
        this.giaoVienChuNhiem = giaoVienChuNhiem;
        this.lopHoc = lopHoc;
    }

    @Override
    public void hienThiThoiKhoaBieu() {
        System.out.println("Thời khóa biểu: " + thoiKhoaBieu);
    }

    @Override
    public void hienThiThongTinLop() {
        System.out.println("Thông tin lớp học của Học sinh:");
        lopHoc.hienThiThongTinLop();
    }

    public void nhapThongTinHocSinh(Scanner scanner) {
        nhapThongTin(scanner);
        System.out.print("Thời khóa biểu: ");
        thoiKhoaBieu = scanner.nextLine();
        System.out.print("Tên Giáo viên chủ nhiệm: ");
        giaoVienChuNhiem = scanner.nextLine();
        lopHoc = new LopHoc();
        lopHoc.nhapThongTinLop(scanner);
    }
}

// Lớp GiaoVien
class GiaoVien extends Person implements IhienThi {
    private String lopChuNhiem;
    private String boMon;
    private String thoiKhoaBieu;

    public GiaoVien() {
    }

    public GiaoVien(String hoTen, String gioiTinh, String queQuan, int namSinh, String lopChuNhiem,
                     String boMon, String thoiKhoaBieu) {
        super(hoTen, gioiTinh, queQuan, namSinh);
        this.lopChuNhiem = lopChuNhiem;
        this.boMon = boMon;
        this.thoiKhoaBieu = thoiKhoaBieu;
    }

    @Override
    public void hienThiThoiKhoaBieu() {
        System.out.println("Thời khóa biểu dạy: " + thoiKhoaBieu);
    }

    @Override
    public void hienThiThongTinLop() {
        System.out.println("Lớp chủ nhiệm: " + lopChuNhiem);
    }

    public void nhapThongTinGiaoVien(Scanner scanner) {
        nhapThongTin(scanner);
        System.out.print("Lớp chủ nhiệm: ");
        lopChuNhiem = scanner.nextLine();
        System.out.print("Tên bộ môn: ");
        boMon = scanner.nextLine();
        System.out.print("Thời khóa biểu dạy: ");
        thoiKhoaBieu = scanner.nextLine();
    }
}

// Lớp NhanVien
class NhanVien extends Person {
    private String phongBan;
    private String chucVu;

    public NhanVien() {
    }

    public NhanVien(String hoTen, String gioiTinh, String queQuan, int namSinh, String phongBan, String chucVu) {
        super(hoTen, gioiTinh, queQuan, namSinh);
        this.phongBan = phongBan;
        this.chucVu = chucVu;
    }
}

public class Bai2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Tạo đối tượng LopHoc
        LopHoc lopHoc = new LopHoc();
        lopHoc.nhapThongTinLop(scanner);

        // Tạo đối tượng HocSinh
        HocSinh hocSinh = new HocSinh();
        hocSinh.nhapThongTinHocSinh(scanner);

        // Tạo đối tượng GiaoVien
        GiaoVien giaoVien = new GiaoVien();
        giaoVien.nhapThongTinGiaoVien(scanner);

        // Tạo đối tượng NhanVien
        NhanVien nhanVien = new NhanVien();
        nhanVien.nhapThongTin(scanner);

        // Hiển thị thông tin các đối tượng
        System.out.println("Thông tin Lớp học:");
        lopHoc.hienThiThongTinLop();

        System.out.println("Thông tin Học sinh:");
        hocSinh.hienThiThongTin();
        hocSinh.hienThiThoiKhoaBieu();
        hocSinh.hienThiThongTinLop();

        System.out.println("Thông tin Giáo viên:");
        giaoVien.hienThiThongTin();
        giaoVien.hienThiThoiKhoaBieu();
        giaoVien.hienThiThongTinLop();

        System.out.println("Thông tin Nhân viên:");
        nhanVien.hienThiThongTin();

        scanner.close();
    }
}
