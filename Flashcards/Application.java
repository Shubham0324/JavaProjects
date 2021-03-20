package flashcards;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;
public class Application {


    HashMap<String, String> flashcard = new HashMap<>();

    public final Scanner sc = new Scanner(System.in);


    protected void add(){
        System.out.println("The card:");
        String card = sc.nextLine();
        if (flashcard.containsKey(card)){
            System.out.printf("The card \"%s\" already exists.\n", card);
            return;
        }
        System.out.println("The definition of the card:");
        String definition = sc.nextLine();
        if (flashcard.containsValue(definition)){
            System.out.printf("The definition \"%s\" already exists.\n", definition);
            return;
        }
        flashcard.put(card, definition);
        System.out.printf("The pair (\"%s\":\"%s\") has been added.\n", card, definition);
    }


    protected void remove(){
        System.out.println("Which card?");
        String removeCard = sc.nextLine();
        if (flashcard.containsKey(removeCard)){
            flashcard.remove(removeCard);
            System.out.println("The card has been removed.");
        }else System.out.printf("Can't remove \"%s\": there is no such card.", removeCard);
    }

    protected void importFile(){
        System.out.println("File Name:");
        String fileName = sc.nextLine();
        File file = new File(fileName);
        int i = 0;
        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNext()){
                String[] value = fileScanner.nextLine().split(":");
                if (flashcard.containsKey(value[0])){
                    flashcard.replace(value[0], value[1]);
                }else flashcard.put(value[0], value[1]);
                i++;
            }
            System.out.printf("%d cards have been loaded.", i);

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
         //   e.printStackTrace();
        }
    }


    protected void ask(){
        System.out.println("How many times to ask?");
        int ask = sc.nextInt();
        getDef(ask);
    }


    protected void export(){
        System.out.println("File name:");
        String fileName = sc.nextLine();
        File file = new File(fileName);
        int i = 0;
        try (PrintWriter writer = new PrintWriter(file)) {
            for (String key: flashcard.keySet()) {
                writer.printf("%s:%s\n", key, flashcard.get(key));
                i++;
            }
            writer.println();
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }
        System.out.printf("%d cards have been saved.", i);

    }

    private void getDef(int times) {
        String[] arr = flashcard.keySet().toArray(new String[0]);
        String[] def =flashcard.values().toArray(new String[0]);

        for (int i = 0; i < times; i++) {
            if (i == 0)  sc.nextLine();
            System.out.printf("Print the definition of \"%s\":\n", arr[i]);
            String userVal = sc.nextLine();
            if (userVal.equals(def[i])){
                System.out.println("Correct!");
            }else {
                if(flashcard.containsValue(userVal)){
                    String yups = getKey(userVal);
                    System.out.printf("Wrong. The right answer is \"%s\", but your definition is correct for \"%s\".\n", def[i],yups);
                }
                else System.out.printf("Wrong. The right answer is \"%s\".\n", def[i]);
            }
        }
    }
    private String getKey (String userVal){
        for (String hashset: flashcard.keySet()) {
            if(flashcard.get(hashset).equals(userVal)){
                return hashset;
            }
        }
        return "Null";
    }

}
