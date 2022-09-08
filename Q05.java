import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q05 {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        scanner.close();
        permute(array, 24, null, -1).stream().sorted().forEach(System.out::println);
    }

    public static List<Integer> permute(int[] array, int sum, List<Integer> part, int index) {
        if (index != -1) {
            int currentSum = part.stream().mapToInt(Integer::valueOf).sum();
            if (currentSum == sum) return part;
            if (currentSum > sum) return null;
        }
        for (int i = index + 1; i < array.length; i++) {
            List<Integer> copy = part == null ? new ArrayList<>() : new ArrayList<>(part);
            copy.add(array[i]);
            List<Integer> result = permute(array, sum, copy, i);
            if (result != null) return result;
        }
        return null;
    }
}
