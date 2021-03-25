package budget;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Application  implements Serializable {
    private float total = 0,count = 0;
    private final ArrayList<String> listItem = new ArrayList<>();

    /* Users Money Details */
    public void setTotal(float total) {
        this.total += total;
    }

    /* Shopping List Classified In Various Types */
    public void setListItem(String itemName, float price){
        this.listItem.add(itemName + " $" + price);
    }


    /* Money Details */
    public float getTotal() {
        return this.total;
    }

    public ArrayList<String> getListItem() {
        return this.listItem;
    }


    static Scanner sc = new Scanner(System.in);

    protected void addPurchase(Application listType, Person person) {
    if (count > 0){
        sc.nextLine();
    }
        System.out.println();
        System.out.println("Enter purchase name:");
      //  sc.nextLine();
        String itemName = sc.nextLine();
        System.out.println("Enter its price:");
        float price = sc.nextFloat();
        if ( person.purchasePossible(price) ) {
            listType.setListItem(itemName, price);
            listType.setTotal(price);
            person.setBalance(person.getBalance() - price);
            System.out.println("Purchase was added!");
         }
        else {
            System.out.println("Sorry Not Enough Balance");
        }
        count++;
    }




    protected void showListType(Application listType) {
        if(listType.getListItem().size() != 0){
            listType.getListItem().forEach(System.out::println);
        }else{
            System.out.println("The purchase list is empty");
        }
    }
}
