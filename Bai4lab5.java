interface Movable {
    void MoveUp();
    void MoveDown();
    void MoveLeft();
    void MoveRight();
}
class MovablePoint implements Movable {
    private int X;
    private int Y;
    private int XSpeed;
    private int YSpeed;
    public MovablePoint(int X, int Y, int XSpeed, int YSpeed) {
        this.X = X;
        this.Y = Y;
        this.XSpeed = XSpeed;
        this.YSpeed = YSpeed;
    }
    public void Nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap X: ");
        X = scanner.nextInt();
        System.out.print("Nhap Y: ");
        Y = scanner.nextInt();
        System.out.print("Nhap XSpeed: ");
        XSpeed = scanner.nextInt();
        System.out.print("Nhap YSpeed: ");
        YSpeed = scanner.nextInt();
    }
    public int GetX() {
        return X;
    }
    public void SetX(int X) {
        this.X = X;
    }
    public int GetY() {
        return Y;
    }
    public void SetY(int Y) {
        this.Y = Y;
    }
    public int GetXSpeed() {
        return XSpeed;
    }
    public void SetXSpeed(int XSpeed) {
        this.XSpeed = XSpeed;
    }
    public int GetYSpeed() {
        return YSpeed;
    }
    public void SetYSpeed(int YSpeed) {
        this.YSpeed = YSpeed;
    }
    @Override
    public String ToString() {
        return "(" + X + ", " + Y + "), speed=(" + XSpeed + ", " + YSpeed + ")";
    }
    @Override
    public void MoveUp() {
        Y -= YSpeed;
    }
    @Override
    public void MoveDown() {
        Y += YSpeed;
    }
    @Override
    public void MoveLeft() {
        X -= XSpeed;
    }
    @Override
    public void MoveRight() {
        X += XSpeed;
    }
}
class MovableCircle implements Movable {
    private int Radius;
    private MovablePoint Center;
    public MovableCircle(int X, int Y, int XSpeed, int YSpeed, int Radius) {
        Center = new MovablePoint(X, Y, XSpeed, YSpeed);
        this.Radius = Radius;
    }
    public void Nhap() {
        Center.Nhap();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap Radius: ");
        Radius = scanner.nextInt();
    }
    public int GetRadius() {
        return Radius;
    }
    public void SetRadius(int Radius) {
        this.Radius = Radius;
    }
    public MovablePoint GetCenter() {
        return Center;
    }
    public void SetCenter(MovablePoint Center) {
        this.Center = Center;
    }
    @Override
    public String ToString() {
        return "Circle at " + Center.ToString() + ", radius=" + Radius;
    }
    @Override
    public void MoveUp() {
        Center.MoveUp();
    }
    @Override
    public void MoveDown() {
        Center.MoveDown();
    }
    @Override
    public void MoveLeft() {
        Center.MoveLeft();
    }
    @Override
    public void MoveRight() {
        Center.MoveRight();
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MovableCircle circle = new MovableCircle(0, 0, 1, 1, 5);
        System.out.println("Nhap thong tin hinh tron:");
        circle.Nhap();
        System.out.println("Vi tri ban dau: " + circle.ToString());
        circle.MoveUp();
        System.out.println("Sau khi di chuyen len: " + circle.ToString());
        circle.MoveDown();
        System.out.println("Sau khi di chuyen xuong: " + circle.ToString());
        circle.MoveLeft();
        System.out.println("Sau khi di chuyen sang trai: " + circle.ToString());
        circle.MoveRight();
        System.out.println("Sau khi di chuyen sang phai: " + circle.ToString());
    }
}
