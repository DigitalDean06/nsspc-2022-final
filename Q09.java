import java.util.Scanner;

public class Q09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int treasureColumn = scanner.nextInt() - 1;
        int treasureGold = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] map = new int[5][5];
        int[][] scoreMap = new int[5][5];
        for (int i = 0; i < n; i++) {
            int j = scanner.next().charAt(0) - 'A';
            int k = scanner.nextInt() - 1;
            scanner.nextInt();
            map[j][k] = 1;
            scoreMap[j][k] = scanner.nextInt();
        }
        scanner.close();
        int index = 0;
        int finalGold = 0;
        for (int i = 0; i < 5; i++) {
            Integer gold = getGold(map, scoreMap, i, treasureColumn);
            if (gold == null) continue;
            index = i;
            finalGold = gold;
            break;
        }
        System.out.printf("%d %d%n", index + 1, finalGold + treasureGold);
    }

    public static Integer getGold(int[][] map, int[][] scoreMap, int index, int treasureColumn) {
        int x = index;
        int y = 0;
        int score = 0;
        while (y < 5) {
            if (x > 0 && map[y][x - 1] == 1) {
                score += scoreMap[y][x - 1];
                x--;
            } else if (x < map.length - 1 && map[y][x] == 1) {
                score += scoreMap[y][x];
                x++;
            }
            y++;
        }
        return treasureColumn == x ? score : null;
    }
}
