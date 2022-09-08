import java.util.Scanner;

public class Q04 {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine().toUpperCase();
        scanner.close();
        string = string.replace("T", "U");
        int startIndex = string.indexOf("AUG");
        int endIndex = string.indexOf("UAG");
        if (endIndex == -1) endIndex = string.indexOf("UAA");
        if (endIndex == -1) endIndex = string.indexOf("UGA");
        if (endIndex == -1 || (endIndex - startIndex) % 3 != 0) {
            System.out.println(0);
            return;
        }
        System.out.println(string);
        System.out.println(startIndex + 1);
        int n = (endIndex - startIndex) / 3;
        System.out.println(n);
        String[] array = new String[n];
        for (int i = 0; i < n; i++) {
            array[i] = string.substring(startIndex + i * 3, startIndex + (i + 1) * 3);
        }
        System.out.println(String.join(" ", array));
    }
}
