import java.util.Arrays;
import java.util.Scanner;

public class Q2 {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        scanner.close();
        int min = Arrays.stream(array).min().getAsInt();
        int max = Arrays.stream(array).max().getAsInt();
        if (min == max) {
            System.out.println(String.join(" ", Arrays.stream(array).mapToObj(String::valueOf).toArray(String[]::new)));
        } else {
            System.out.println(String.join(" ", Arrays.stream(array).boxed().sorted((a, b) -> {
                if (a == min || b == max) return -1;
                if (a == max || b == min) return 1;
                return 0;
            }).map(String::valueOf).toArray(String[]::new)));
        }
    }
}
