package search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class SimpleSearch {
    ArrayList<String> people = new ArrayList<>();
    public final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {
        SimpleSearch search = new SimpleSearch();
            Scanner scanner = new Scanner(new File("D:\\Simple Search Engine\\Simple Search Engine\\task\\src\\search\\names.txt"));
            int ik = 0;
            while (scanner.hasNext()) {
                search.people.add(scanner.nextLine());
                ik++;
            }
            scanner.close();
          //  search.sc.nextLine();
        System.out.println();
        search.menuPlease();

    }

    private  void menuPlease() {
        System.out.println();
     //  sc.nextLine();
        System.out.println(people.size());
        System.out.println("=== Menu ===\n" +
                "1. Find a person\n" +
                "2. Print all people\n" +
                "0. Exit");
        int choice = sc.nextInt();
        switch (choice){
            case 1: searchPeople();
                //sc.nextLine();
                    menuPlease();
                    break;
            case 2: printDetails();
                    menuPlease();
                break;
            case 0:
                System.out.println("Bye!");
                System.exit(0);
            default:
                System.out.println("Incorrect option! Try again.");
                menuPlease();
                break;

        }
    }

    private void printDetails() {
        System.out.println("=== List of people ===");
        for (String person : people) {
                System.out.println(person.replaceAll("[\\[\\],]", ""));
             }

        }


    private  void searchPeople() {

        System.out.println();
        //System.out.println("Enter data to search people:");
        boolean flag = false;
        int count = 0;
        String queryValue = sc.next();
        for (String person : people) {
            if (person.toLowerCase().contains(queryValue.toLowerCase())) {
                if(count == 0){
                    System.out.println();
                    System.out.println("Found people:");
                    count++;
                }
                System.out.println(person.replaceAll("[\\[\\],]", ""));
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("No matching people found.");
        }
        sc.nextLine();
    }
}
