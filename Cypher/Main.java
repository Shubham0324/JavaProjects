package encryptdecrypt;

import java.io.IOException;

public class Main{

    public static void main(String[] args) throws IOException {
        Application application = new Application();
      //  String[] arg = "-mode enc -key 5 -data Welcom-to-hyperskill!".split(" ");
        application.execute(args);
    }
}