// Advent of Code 2023
// https://adventofcode.com/2023

// Imports for file processing and arrays
import java.nio.file.*;
import java.util.*;

class advent2023 {
    public static void main(String[] args) throws java.io.IOException {
        long start = System.nanoTime();
        for (int i = 1; i <= 2; i++) {
            Problem p;
            switch (i) {
                case 1:
                    p = new Day01();
                    break;
                case 2:
                    p = new Day02();
                    break;
                default:
                    p = new Day01();
            }
            run_problem(i, p, false);
        }
        System.out.println("Total elapsed:    " + format_time(start));
    }

    // Load data file, parse input, call both solvers, and print results
    static void run_problem(int day, Problem p, Boolean test) throws java.io.IOException {
        long start = System.nanoTime();

        // Load the correct file (based on test mode) and tell the solver to parse it
        String str_day = String.format("%02d", day);
        String path = "input\\" + str_day;
        if (test) {
            path += "_test";
        }
        path += ".txt";
        p.parse(Files.readAllLines(Paths.get(path)));
        System.out.println(str_day + " load/parse:    " + format_time(start));

        start = System.nanoTime();
        System.out.println(" 1: " + String.format("%10d", p.p1()) + " in " + format_time(start));

        start = System.nanoTime();
        System.out.println(" 2: " + String.format("%10d", p.p2()) + " in " + format_time(start));
    }

    // This function outputs the elapsed time in the most appropriate units
    static String format_time(long start_time) {
        String unit = " ns";
        long elapsed = (System.nanoTime() - start_time);
        if (elapsed > 1000) {
            elapsed /= 1000;
            unit = " µs";
            if (elapsed > 1000) {
                elapsed /= 1000;
                unit = " ms";
                if (elapsed > 1000) {
                    elapsed /= 1000;
                    unit = " s";
                }
            }
        }

        return String.format("%5d", elapsed) + unit;
    }
}