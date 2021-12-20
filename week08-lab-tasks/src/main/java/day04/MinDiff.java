package day04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MinDiff {
    public String findSmallestDifference(String fileName) {
        List<String> lines = readFromFile(fileName);
        String teamName="";
        int minDiff = 1000;

        for (int i = 1; i < lines.size(); i++) {
            if (!lines.get(i).trim().startsWith("-")) {
                int scoreCount = parseIntData(lines, i, 43, 45);
                int getCount = parseIntData(lines, i, 50, 52);
                int diff = Math.abs(scoreCount - getCount);
                if (diff < minDiff) {
                    minDiff = diff;
                    teamName = lines.get(i).substring(7, 21).trim();
                }
            }
        }
        return teamName;
    }

    private int parseIntData(List<String> lines, int index, int min, int max) {
        return Integer.parseInt(lines.get(index).substring(min, max).trim());
    }

    public int findMinTemperatureDay(String fileName) {
        List<String> lines = readFromFile(fileName);
        List<Integer> diffs = findDiffs(lines, 2, lines.size() - 1, 6, 8, 12, 14);
        return findMinDay(diffs);
    }

    private int findMinDay(List<Integer> diffs) {
        int min = 1000;
        int index = 0;
        for (int i = 0; i < diffs.size(); i++) {
            if (diffs.get(i) < min) {
                min = diffs.get(i);
                index = i;
            }
        }
        return index + 1;
    }

    private List<Integer> findDiffs(List<String> lines, int from, int to, int oneFrom, int oneTo, int twoFrom, int twoTo) {
        List<Integer> diffs = new ArrayList<>();
        for (int i = from; i < to; i++) {
            int min = parseIntData(lines, i, oneFrom, oneTo);
            int max = parseIntData(lines, i, twoFrom, twoTo);
            diffs.add(Math.abs(max - min));
        }
        return diffs;
    }

    private List<String> readFromFile(String fileName) {
        try {
            return read(fileName);
        } catch (IllegalStateException ise) {
            ise.printStackTrace();
        }
        return null;
    }

    private List<String> read(String fileName) {
        try {
            return Files.readAllLines(Paths.get("src/main/resources/" + fileName));
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read from file", ioe);
        }
    }

    public static void main(String[] args) {
        MinDiff minDiff = new MinDiff();

        int day = minDiff.findMinTemperatureDay("weather.dat");
        System.out.println(day);

        String teamName = minDiff.findSmallestDifference("football.dat");
        System.out.println(teamName);
    }
}