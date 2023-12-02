import java.util.*;

class Day01 extends Problem {
    private List<String> input;

    public void parse(List<String> input) {
        this.input = input;
    }

    public int p1() {
        int sum = 0;

        for (String line : this.input) {
            String x = "";
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                if (Character.isDigit(c)) {
                    x += c;
                    break;
                }
            }

            for (int i = line.length() - 1; i >= 0; i--) {
                char c = line.charAt(i);
                if (Character.isDigit(c)) {
                    x += c;
                    break;
                }
            }
            sum += Integer.parseInt(x);
        }
        return sum;
    }

    public int p2() {
        int sum = 0;
        String[] nums = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

        for (String line : this.input) {
            String x = "";

            outerForward: for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                if (Character.isDigit(c)) {
                    x += c;
                    break;
                }

                // look for words
                for (int j = 0; j < nums.length; j++) {
                    if (line.substring(i).indexOf(nums[j]) == 0) {
                        x += String.valueOf(j);
                        break outerForward;
                    }
                }
            }

            outerBackward: for (int i = line.length() - 1; i >= 0; i--) {
                char c = line.charAt(i);
                if (Character.isDigit(c)) {
                    x += c;
                    break;
                }

                // look for words
                for (int j = 0; j < nums.length; j++) {
                    if (line.substring(i).indexOf(nums[j]) == 0) {
                        x += String.valueOf(j);
                        break outerBackward;
                    }
                }
            }
            sum += Integer.parseInt(x);
        }
        return sum;
    }
}
