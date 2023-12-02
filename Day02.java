import java.util.*;

class Day02 extends Problem {
    private List<Long> red;
    private List<Long> green;
    private List<Long> blue;

    public Day02() {
        red = new ArrayList<Long>();
        green = new ArrayList<Long>();
        blue = new ArrayList<Long>();
    }

    public void parse(List<String> input) {
        for (String line : input) {
            long r = 0, g = 0, b = 0;
            String[] tokens = line.split(" ");
            // Ignore the first two tokens, e.g. "Game" "1:"
            // Process in pairs, e.g. "3" "red" (or "red," or "red;")
            for (int i = 2; i < tokens.length - 1; i += 2) {
                long v = Long.parseLong(tokens[i]);
                switch (tokens[i + 1].substring(0, 3)) {
                    case "red":
                        r = Math.max(r, v);
                        break;
                    case "gre":
                        g = Math.max(g, v);
                        break;
                    case "blu":
                        b = Math.max(b, v);
                        break;
                    default:
                }
            }
            red.addLast(r);
            green.addLast(g);
            blue.addLast(b);
        }
    }

    public int p1() {
        int sum = 0;
        long max_red = 12;
        long max_green = 13;
        long max_blue = 14;

        for (int i = 0; i < red.size(); i++) {
            if (red.get(i) <= max_red && green.get(i) <= max_green && blue.get(i) <= max_blue) {
                sum += i + 1;
            }
        }

        return sum;
    }

    public int p2() {
        int sum = 0;

        for (int i = 0; i < red.size(); i++) {
            sum += red.get(i) * green.get(i) * blue.get(i);
        }

        return sum;
    }
}
