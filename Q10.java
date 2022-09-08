import java.util.Scanner;

public class Q10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        double z = scanner.nextDouble();
        scanner.close();
        int lcm = x * y / gcd(x, y);
        int a = (int) (Math.floor(60.0 / x) - Math.floor(z / x));
        int b = (int) (Math.floor(60.0 / y) - Math.floor(z / y));
        int c = (int) (Math.floor(60.0 / lcm) - Math.floor(z / lcm));
        if (x > y) b -= c;
        else a -= c;
        int x1 = (int) Math.ceil(60.0 / x) * x;
        int y1 = (int) Math.ceil(60.0 / y) * y;
        if (x1 == y1) {
            if (x > y) a++;
            else b++;
        } else {
            if (x1 > y1) b++;
            else a++;
        }
        System.out.println(a == b ? "Equal" : (a > b ? "Red" : "Blue"));
    }    

    public static int gcd(int x, int y) {
        return x == y ? x : gcd(Math.abs(x - y), Math.min(x, y));
    }
}
