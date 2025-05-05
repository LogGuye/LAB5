import java.util.Scanner;
interface Hinh {
    float pi = 3.14f; 
    void Nhap();
    void Xuat();
    float DienTich();
}
class Hinhvuong implements Hinh {
    private float canh;

    public Hinhvuong() {
        this.canh = 0;
    }
    public Hinhvuong(float canh) {
        this.canh = canh;
    }
    @Override
    public void Nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap canh cua hinh vuong: ");
        this.canh = scanner.nextFloat();
    }
    @Override
    public void Xuat() {
        System.out.println("Canh cua hinh vuong: " + canh);
    }
    @Override
    public float DienTich() {
        return canh * canh;
    }
}
class Hinhchunhat implements Hinh {
    private float dai;
    private float rong;
    public Hinhchunhat() {
        this.dai = 0;
        this.rong = 0;
    }
    public Hinhchunhat(float dai, float rong) {
        this.dai = dai;
        this.rong = rong;
    }
    @Override
    public void Nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap chieu dai cua hinh chu nhat: ");
        this.dai = scanner.nextFloat();
        System.out.print("Nhap chieu rong cua hinh chu nhat: ");
        this.rong = scanner.nextFloat();
    }
    @Override
    public void Xuat() {
        System.out.println("Chieu dai cua hinh chu nhat: " + dai + ", Chieu rong: " + rong);
    }
    @Override
    public float DienTich() {
        return dai * rong;
    }
}
class Hinhtron implements Hinh {
    private float bankinh;
    public Hinhtron() {
        this.bankinh = 0;
    }
    public Hinhtron(float bankinh) {
        this.bankinh = bankinh;
    }
    @Override
    public void Nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ban kinh cua hinh tron: ");
        this.bankinh = scanner.nextFloat();
    }
    @Override
    public void Xuat() {
        System.out.println("Ban kinh cua hinh tron: " + bankinh);
    }
    @Override
    public float DienTich() {
        return pi * bankinh * bankinh;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap so luong hinh: ");
        int n = scanner.nextInt();
        scanner.nextLine(); 
        Hinh[] ds = new Hinh[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Chon loai hinh se nhap: ");
            System.out.println("1: hinh vuong");
            System.out.println("2: hinh chu nhat");
            System.out.println("3: hinh tron");
            int chon = scanner.nextInt();
            scanner.nextLine(); 
            switch (chon) {
                case 1:
                    ds[i] = new Hinhvuong();
                    ds[i].Nhap();
                    break;
                case 2:
                    ds[i] = new Hinhchunhat();
                    ds[i].Nhap();
                    break;
                case 3:
                    ds[i] = new Hinhtron();
                    ds[i].Nhap();
                    break;
                default:
                    System.out.println("Ban phai chon 1 trong 3 loai tren");
            }
        }
        System.out.println("\nDanh sach cac hinh:");
        for (Hinh hinh : ds) {
            hinh.Xuat();
            System.out.println("Dien tich: " + hinh.DienTich());
        }
        Hinh hinhDienTichLonNhat = ds[0];
        for (Hinh hinh : ds) {
            if (hinh.DienTich() > hinhDienTichLonNhat.DienTich()) {
                hinhDienTichLonNhat = hinh;
            }
        }
        System.out.println("\nHinh co dien tich lon nhat:");
        hinhDienTichLonNhat.Xuat();
        System.out.println("Dien tich: " + hinhDienTichLonNhat.DienTich());
    }
}
