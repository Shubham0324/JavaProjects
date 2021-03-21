package advisor;

import java.util.Scanner;

public class UI {
    Scanner sc = new Scanner(System.in);
    Request request = new Request();
    public void run(){
        userChoice();
    }

    private void userChoice() {
        String choice = sc.nextLine();
        request.userChoice(choice);
        userChoice();
    }
}
