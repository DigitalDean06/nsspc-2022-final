import java.util.Scanner;

public class Q01 {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double availableA = scanner.nextDouble();
        double availableB = scanner.nextDouble();
        double availableC = scanner.nextDouble();
        double requiredA = scanner.nextDouble();
        double requiredB = scanner.nextDouble();
        double requiredC = scanner.nextDouble();
        scanner.close();
        if (!isInteger(availableA) ||
        !isInteger(availableB) ||
        !isInteger(availableC) ||
        !isInteger(requiredA) ||
        !isInteger(requiredB) ||
        !isInteger(requiredC) ||
        availableA < 0 ||
        availableB < 0 ||
        availableC < 0||
        requiredA <= 0 ||
        requiredB <= 0 ||
        requiredC <= 0) {
            System.out.println("Invalid Input");
            return;
        }
        int availableA1 = (int) availableA;
        int availableB1 = (int) availableB;
        int availableC1 = (int) availableC;
        int requiredA1 = (int) requiredA;
        int requiredB1 = (int) requiredB;
        int requiredC1 = (int) requiredC;
        int n = Math.min(availableA1 / requiredA1, Math.min(availableB1 / requiredB1, availableC1 / requiredC1));
        System.out.println(n);
        System.out.printf("%d %d %d%n", availableA1 - requiredA1 * n, availableB1 - requiredB1 * n, availableC1 - requiredC1 * n);
    }

    public static boolean isInteger(double value) {
        return (int) value == value;
    }
}