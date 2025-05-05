import java.util.Scanner;
import java.util.ArrayList;
abstract class Nhanvien {
    protected String Manhanvien;
    protected String Tennhanvien;
    protected String Trinhdo;
    protected double Luongcoban;
    public Nhanvien() {
        this.Manhanvien = "";
        this.Tennhanvien = "";
        this.Trinhdo = "";
        this.Luongcoban = 0.0;
    }
    public Nhanvien(String Manhanvien, String Tennhanvien, String Trinhdo) {
        this.Manhanvien = Manhanvien;
        this.Tennhanvien = Tennhanvien;
        this.Trinhdo = Trinhdo;
        this.Luongcoban = 0.0;
    }
    public String getManhanvien() {
        return Manhanvien;
    }
    public String getTennhanvien() {
        return Tennhanvien;
    }
    public String getTrinhdo() {
        return Trinhdo;
    }
    public double getLuongcoban() {
        return Luongcoban;
    }
    public void setLuongcoban(double Luongcoban) {
        this.Luongcoban = Luongcoban;
    }
    public void Nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ma nhan vien: ");
        this.Manhanvien = scanner.nextLine();
        System.out.print("Nhap ten nhan vien: ");
        this.Tennhanvien = scanner.nextLine();
        System.out.print("Nhap trinh do: ");
        this.Trinhdo = scanner.nextLine();
        System.out.print("Nhap luong co ban: ");
        this.Luongcoban = scanner.nextDouble();
    }
    public void Xuat() {
        System.out.println("Ma nhan vien: " + Manhanvien + ", Ten nhan vien: " +
            Tennhanvien + ", Trinh do: " + Trinhdo + ", Luong co ban: " + Luongcoban);
    }
    public abstract double Tinhluong();
}
class Quanly extends Nhanvien {
    private String Chuyenmon;
    private double Phucapchucvu;
    public Quanly() {
        super();
    }
    public Quanly(String Manhanvien, String Tennhanvien, String Trinhdo, String Chuyenmon, double Phucapchucvu) {
        super(Manhanvien, Tennhanvien, Trinhdo);
        this.Chuyenmon = Chuyenmon;
        this.Phucapchucvu = Phucapchucvu;
    }
    public String getChuyenmon() {
        return Chuyenmon;
    }
    public double getPhucapchucvu() {
        return Phucapchucvu;
    }
    @Override
    public void Nhap() {
        super.Nhap();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap chuyen mon: ");
        this.Chuyenmon = scanner.nextLine();
        System.out.print("Nhap phu cap chuc vu: ");
        this.Phucapchucvu = scanner.nextDouble();
    }
    @Override
    public void Xuat() {
        super.Xuat();
        System.out.println("Chuyen mon: " + Chuyenmon + ", Phu cap chuc vu: " + Phucapchucvu);
    }
    @Override
    public double Tinhluong() {
        return this.Luongcoban + this.Phucapchucvu;
    }
}
class Nghiencuu extends Quanly {
    private double Phucapdochai;
    public Nghiencuu() {
        super();
    }
    public Nghiencuu(String Manhanvien, String Tennhanvien, String Trinhdo, String Chuyenmon, double Phucapchucvu, double Phucapdochai) {
        super(Manhanvien, Tennhanvien, Trinhdo, Chuyenmon, Phucapchucvu);
        this.Phucapdochai = Phucapdochai;
    }
    @Override
    public double Tinhluong() {
        return this.getLuongcoban() + this.Phucapdochai;
    }
    @Override
    public void Nhap() {
        super.Nhap();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap phu cap doc hai: ");
        this.Phucapdochai = scanner.nextDouble();
    }
    @Override
    public void Xuat() {
        super.Xuat();
        System.out.println("Phu cap doc hai: " + Phucapdochai);
    }
}
class Phucvu extends Nhanvien {
    public Phucvu() {
        super();
    }
    public Phucvu(String Manhanvien, String Tennhanvien, String Trinhdo) {
        super(Manhanvien, Tennhanvien, Trinhdo);
    }
    @Override
    public double Tinhluong() {
        return this.Luongcoban;
    }
}
public class Bai1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Nhanvien> danhSachNhanvien = new ArrayList<>();
        Quanly quanly = new Quanly("QL001", "Nguyen Van Long", "Dai hoc", "Quan tri kinh doanh", 200000.0);
        quanly.Nhap();
        quanly.Xuat();
        System.out.println("Luong Quanly: " + quanly.Tinhluong());
        Nghiencuu nghiencuu = new Nghiencuu("NC001", "Tran Thi Thanh Nhan", "Tien si", "Tin hoc", 150000.0, 20000);
        nghiencuu.Nhap();
        nghiencuu.Xuat();
        System.out.println("Luong Nghiencuu: " + nghiencuu.Tinhluong());
        Phucvu phucvu = new Phucvu("PV001", "Le Van Luyen", "Dai Hoc");
        phucvu.Nhap();
        phucvu.Xuat();
        System.out.println("Luong Phucvu: " + phucvu.Tinhluong());
        danhSachNhanvien.add(quanly);
        danhSachNhanvien.add(nghiencuu);
        danhSachNhanvien.add(phucvu);
        System.out.println("\nDanh sach nhan vien:");
        for (Nhanvien nv : danhSachNhanvien) {
            nv.Xuat();
            System.out.println("Luong: " + nv.Tinhluong());
        }
    }
}
