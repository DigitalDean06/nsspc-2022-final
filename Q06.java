import java.util.Arrays;
import java.util.Scanner;

public class Q06 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Coord[] coords = new Coord[n];
        for (int i = 0; i < n; i++) {
            coords[i] = new Coord(scanner.nextDouble(), scanner.nextDouble());
        }
        scanner.close();
        Coord current = getVertical(getHorizontal(coords, 1), 1)[0];
        coords = remove(coords, current);
        Coord end = getVertical(getHorizontal(coords, -1), -1)[0];
        double totalDistance = 0;
        while (current != end) {
            Coord next = getNearest(coords, current);
            coords = remove(coords, current);
            totalDistance += getDistance(current, next);
            current = next;
        }
        System.out.printf("%.7f%n", totalDistance);
    }

    public static Coord[] remove(Coord[] coords, Coord coord) {
        return Arrays.stream(coords).filter(c -> c != coord).toArray(Coord[]::new);
    }

    public static Coord getNearest(Coord[] coords, Coord coord) {
        double shortest = Double.MAX_VALUE;
        for (Coord c : coords) {
            double distance = getDistance(coord, c);
            if (distance < shortest) shortest = distance;
        }
        final double finalShortest = shortest;
        return getVertical(Arrays.stream(coords).filter(c -> getDistance(coord, c) == finalShortest).toArray(Coord[]::new), 1)[0];
    }

    public static double getDistance(Coord from, Coord to) {
        return Math.sqrt(Math.pow(to.x - from.x, 2) + Math.pow(to.y - from.y, 2));
    }

    public static Coord[] getHorizontal(Coord[] coords, int modifier) {
        coords = Arrays.stream(coords).sorted((a, b) -> (int) Math.ceil(a.x - b.x) * modifier).toArray(Coord[]::new);
        double d = coords[0].x;
        return Arrays.stream(coords).filter(i -> i.x == d).toArray(Coord[]::new);
    }

    public static Coord[] getVertical(Coord[] coords, int modifier) {
        coords = Arrays.stream(coords).sorted((a, b) -> (int) Math.ceil(a.y - b.y) * modifier).toArray(Coord[]::new);
        double d = coords[0].y;
        return Arrays.stream(coords).filter(i -> i.y == d).toArray(Coord[]::new);
    }
}

class Coord {

    public final double x;

    public final double y;

    public Coord(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
