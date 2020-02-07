import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RectangleSolver {
    public static void main(String[] args) {
        HashMap<String, Integer> lineSet = new HashMap<>();
        List<Point> inputPoints = readPoints();
        for (int i = 0; i < inputPoints.size(); i++) {
            for (int j = i + 1; j < inputPoints.size(); j++) {
                String key = keyForLine(inputPoints.get(i), inputPoints.get(j));
                lineSet.put(key, lineSet.getOrDefault(key, 0) + 1);
            }
        }
        System.out.println(lineSet);
        int count = 0;
        for (String key : lineSet.keySet()) {
            int lineCount = lineSet.get(key);
            count += lineCount * (lineCount - 1) / 2;
        }
        System.out.println(count);
    }

    private static String keyForLine(Point p1, Point p2) {
        double dist = Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
        return String.format("%.2f_%.2f_%.2f", (p1.x + p2.x) / 2, (p1.y + p2.y) / 2, dist);
    }

    private static class Point {
        double x, y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    private static List<Point> readPoints() {
        ArrayList<Point> points = new ArrayList<Point>();
        points.add(new Point(0, 0));
        points.add(new Point(0, 1));
        points.add(new Point(0, 2));
        points.add(new Point(1, 0));
        points.add(new Point(1, 1));
        points.add(new Point(1, 2));
        points.add(new Point(2, 0));
        points.add(new Point(2, 1));
        points.add(new Point(2, 2));
        return points;
    }
}
