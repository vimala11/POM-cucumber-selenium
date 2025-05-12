package utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileProcessor {
    private static final Pattern REG_PATTERN =
            Pattern.compile("([a-zA-Z]{2}\\d{2}(\\s|)[A-Z]{3})");

    public List<String> readInput(String filePath) throws FileNotFoundException {
        List<String> registrations = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                Matcher matcher = REG_PATTERN.matcher(scanner.nextLine());
                while (matcher.find()) {
                    registrations.add(matcher.group());
                }
            }
        }
        return registrations;
    }

    public List<CarDetails> readExpectedOutput(String filePath) throws FileNotFoundException {
        List<CarDetails> expectedValues = new ArrayList<>(1);
        int i = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if( i != 0) {
                    String[] parts = line.split(",", 4);
                    expectedValues.add(i - 1, new CarDetails(parts[0], parts[1], parts[2]));
                }
                i++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return expectedValues;
    }
}
