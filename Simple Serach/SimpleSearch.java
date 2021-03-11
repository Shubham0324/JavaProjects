package search;

import java.util.Scanner;

public class SimpleSearch {
    String[] people;
    public final Scanner sc = new Scanner(System.in);

    public void numberOfCases(){
        System.out.println("Enter the number of people:");
        int a = sc.nextInt();
        people = new String[a];
        System.out.println("Enter all people:");
        sc.nextLine();
        getInputs();
       }
    private void getInputs() {
        for (int j = 0; j < people.length; j++) {
            people[j] = sc.nextLine();
        }
    }

    public static void main(String[] args) {
        SimpleSearch search = new SimpleSearch();
        search.numberOfCases();
        System.out.println();
        search.menuPlease();


    }

    private  void menuPlease() {
        System.out.println();
       // sc.nextLine();
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
        System.out.println("Enter data to search people:");
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
