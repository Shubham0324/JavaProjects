package readability;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Application extends Main  {

    int word , sentences, character;
    float score;

    protected void executeApplication(String inputFile) throws FileNotFoundException {
        readFile(inputFile);
        printResult();
    }

    private void findAverageWords(String line) {
        sentences +=line.split("[!?.]+").length;
        word += line.split("\\s|\n|\t").length;
        character +=  line.replaceAll("[\\s+]", "").length();

    }

    public void readFile(String file) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(file));
        System.out.println("The text is:");
        while (scanner.hasNext()) {
            String val = scanner.nextLine();
            System.out.print(val);
            findAverageWords(val);

        }
        scanner.close();
    }

    public void printResult() {
        System.out.println("\nWords: " + word + "\nSentences: " + sentences + "\nCharacters: "+ character);
        System.out.println("This text should be understood by " + scoreCalc() + " year olds.");
    }
    public String scoreCalc() {

        score = (float) (((4.71 * ((float)character/(float)word)) + (0.5 * ((float)word/(float)sentences)) -21.43));
        String[] ageGroups = {"5-6", "6-7", "7-9", "9-10", "10-11", "11-12",
                "12-13", "13-14", "14-15", "15-16", "16-17", "17-18", "18-24", "24+"};
        int index = Math.min(14, Math.max(1, (int) Math.ceil(score))) - 1;
        System.out.printf("The Score is: %.2f\n", score);
        return ageGroups[index];
    }
}

