package budget;

import java.io.*;

public class Process extends Person  implements Serializable {
    Person person = new Person();

    Application foodList = new Application();
    Application clothList = new Application();
    Application entList = new Application();
    Application otherList = new Application();

    public void executeManager(){
    mainMenu();

    }


    private void mainMenu() {
        System.out.println();
        System.out.println("Choose your action:\n" +
                "1) Add income\n" +
                "2) Add purchase\n" +
                "3) Show list of purchases\n" +
                "4) Balance\n" +
                "5) Save\n" +
                "6) Load\n" +
                "0) Exit");
        userChoiceForMainMenu(sc.nextInt());
    }
    private void userChoiceForMainMenu(int choice) {
        System.out.println();
        switch (choice){
            case 1: person.addIncome();  // Method Done
                break;
            case 2: purchaseType();
                break;
            case 3: showListOfPurchase();
                break;
            case 4: person.showBalance();  // Method Done
                break;
            case 5: saveState();
                    break;
            case 6: readState();
                    break;
            case 0:
                System.out.println("Bye!");
                System.exit(0);
            default:
                System.out.println("Check Your Input");
                userChoiceForMainMenu(sc.nextInt());
        }
        System.out.println();
        mainMenu();
    }


    /* Purchase Menu */
    private void purchaseType(){
    //    System.out.println();
        System.out.println("Choose the type of purchase\n" +
                "1) Food\n" +
                "2) Clothes\n" +
                "3) Entertainment\n" +
                "4) Other\n" +
                "5) Back");
       // sc.nextLine();
        purchaseTypeChoice(sc.nextInt());

    }

    /* User Choice Menu Switch Case*/
    private void purchaseTypeChoice(int choice){

        switch (choice){
            case 1: addPurchase(foodList, person);
                break;
            case 2: addPurchase(clothList, person);
                break;
            case 3: addPurchase(entList, person);
                break;
            case 4: addPurchase(otherList, person);
                break;
            case 5: mainMenu();
                break;
            default:
                System.out.println("Check Your Input");
                purchaseTypeChoice(sc.nextInt());
        }
        System.out.println();
        purchaseType();
    }



    private void showListOfPurchase(){
        if (foodList.getListItem().size() > 0 || clothList.getListItem().size() > 0
         || entList.getListItem().size() > 0 || otherList.getListItem().size() > 0){
            System.out.println("Choose the type of purchases\n" +
                    "1) Food\n" +
                    "2) Clothes\n" +
                    "3) Entertainment\n" +
                    "4) Other\n" +
                    "5) All\n" +
                    "6) Back");
            showListOfPurchaseChoice(sc.nextInt());
        }else {
            System.out.println("The purchase list is empty!");
            System.out.println();
            mainMenu();
        }
    }

    private void showListOfPurchaseChoice(int choice) {
        System.out.println();
        switch (choice) {
            case 1:
                System.out.println("Food:");
                showListType(foodList);
                System.out.println("Total Sum: $" + foodList.getTotal());
                break;
            case 2:
                System.out.println("Clothes");
                showListType(clothList);
                System.out.println("Total Sum: $" + clothList.getTotal());
                break;
            case 3:
                System.out.println("Entertainment");
                showListType(entList);
                System.out.println("Total Sum: $" + entList.getTotal());
                break;
            case 4:
                System.out.println("Other");
                showListType(otherList);
                System.out.println("Total Sum: $" + otherList.getTotal());
                break;
            case 5:
                System.out.println("All");
                showListType(foodList);
                showListType(clothList);
                showListType(entList);
                showListType(otherList);
                float num = foodList.getTotal() + clothList.getTotal() + entList.getTotal() + otherList.getTotal();
                System.out.println("Total Sum: $" + num);
                break;
            case 6:
                mainMenu();
                break;
            default:
                System.out.println("Check Your Input");
                showListOfPurchaseChoice(sc.nextInt());
        }
        System.out.println();
        showListOfPurchase();
    }

    protected void saveState(){
        try{
            FileOutputStream fs = new FileOutputStream("purchases.txt");
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(person);
            os.writeObject(foodList);
            os.writeObject(clothList);
            os.writeObject(entList);
            os.writeObject(otherList);
            os.close();
            System.out.println("\nPurchases were saved!");

        }catch (IOException e){
            System.out.println("Error");
        }
    }

    protected void readState()  {
        try{
            FileInputStream fileStream = new FileInputStream("purchases.txt");
            ObjectInputStream os = new ObjectInputStream(fileStream);
            person = (Person) os.readObject();
            foodList = (Application) os.readObject();
            clothList = (Application) os.readObject();
            entList = (Application) os.readObject();
            otherList = (Application) os.readObject();
            os.close();
            System.out.println("\nPurchases were loaded!");
        }catch (IOException | ClassNotFoundException e){
            System.out.println("Error");
        }
    }
}
