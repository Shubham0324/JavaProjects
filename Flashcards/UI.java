package flashcards;

import java.util.Scanner;

public class UI extends Application {
    public Scanner sc = new Scanner(System.in);
    Application application = new Application();

    public void execute(){
        System.out.println("\nInput the action (add, remove, import, export, ask, exit):");
        action();

    }

    private void action(){
        String choice = sc.next();
        switch (choice){
            case "add": application.add();
                        break;
            case "remove": application.remove();
                            break;
            case "import": application.importFile();
                            break;
            case "export": application.export();
                            break;
            case "ask":  application.ask();
                        break;
            case "exit":
                System.out.println("Bye bye!");
                System.exit(0);
            default:
                System.out.println("Wrong Input");
                action();
        }
        execute();
    }
}
