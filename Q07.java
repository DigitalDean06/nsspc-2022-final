import java.util.Scanner;
import java.util.regex.Pattern;

public class Q07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        String key = bound(scanner.nextLine(), string.length());
        String mode = scanner.nextLine();
        Pattern pattern = Pattern.compile("[^A-Z]");
        scanner.close();
        if (string.length() > 20 || key.length() > 20 || pattern.matcher(string).find() || pattern.matcher(key).find() || !mode.equals("E") && !mode.equals("D")) {
            System.out.println("Invalid Input");
            return;
        }
        String result = "";
        for (int i = 0; i < string.length(); i++) {
            result += getChar(getCode(string.charAt(i)) + getCode(key.charAt(i)) * (mode.equals("E") ? 1 : -1));
        }
        System.out.println(result);
    }

    public static String bound(String key, int length) {
        String string = "";
        for (int i = 0; i < length; i++) {
            string += key.charAt(i % key.length());
        }
        return string;
    }

    public static int getCode(char c) {
        return c - 'A';
    }

    public static char getChar(int code) {
        while (code < 0) code += 26;
        code %= 26;
        return (char) (code + 'A');
    }
}
