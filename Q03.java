import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Q03 {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        scanner.close();
        Set<String> set = new HashSet<>();
        for (String word : string.toUpperCase().replaceAll("[^A-Z\\-'\\s]", "").split(" ")) {
            if (check(word)) set.add(word);
        }
        for (String word : set) {
            System.out.println(word);
        }
        System.out.println(set.size());
    }

    public static boolean check(String word) {
        int counter = 0;
        for (char c : word.toCharArray()) {
            if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                if (++counter >= 3) return true;
            }
        }
        return false;
    }
}
