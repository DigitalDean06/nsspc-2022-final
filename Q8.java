import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        scanner.close();
        List<String> words = new ArrayList<>();
        for (String word : string.split(" ")) {
            words.add(toDecodedString(toNumberWord(word)));
        }
        String result = String.join(" ", words).replaceAll("(?i)[^a-z\\s]", "");
        System.out.println(result.isBlank() ? "No valid message" : result);
    }

    public static String toNumberWord(String word) {
        String result = "";
        for (int i = 0; i < word.length() / 5; i++) {
            result += getNumber(word.substring(i * 5, (i + 1) * 5));
        }
        return result;
    }

    public static String toDecodedString(String numberWord) {
        int buffer = 0;
        String decoded = "";
        for (char c : numberWord.toCharArray()) {
            buffer *= 10;
            buffer += Integer.parseInt(String.valueOf(c));
            if (buffer >= 33 && buffer <= 126) {
                decoded += (char) buffer;
                buffer = 0;
            }
        }
        return decoded;
    }

    public static int getNumber(String morse) {
        char c = morse.charAt(0);
        int counter = 0;
        for (char c1 : morse.toCharArray()) {
            if (c1 != c) break;
            counter++;
        }
        return counter + (morse.startsWith(".") ? 0 : 5);
    }
}
