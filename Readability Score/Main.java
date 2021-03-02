package readability;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Application readibilityScore = new Application();
        readibilityScore.executeApplication(args[0]);
    }
}
