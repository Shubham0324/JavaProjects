package machine;


public class CoffeeMachine extends Main{
      int water = 400, milk = 540, coffeeBeans = 120, cups = 9, money = 550;
    
    public void action() {
        
        System.out.println("Write action (buy, fill, take, remaining, exit): ");
        String action = sc.next();

        switch (action) {
            case "buy": purchase();
                break;
            case "fill": fillMac();
                break;
            case "take": take();
                break;
            case "remaining": state();
                break;
            case "exit": break;
        }
    }

    public  void fillMac (){

        System.out.println("Write how many ml of water do you want to add:");
        int temp = sc.nextInt();
        water += temp;
        System.out.println("Write how many ml of milk do you want to add:");
        temp = sc.nextInt();
        milk += temp;
        System.out.println("Write how many grams of coffee beans do you want to add:");
        temp = sc.nextInt();
        coffeeBeans += temp;
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        temp = sc.nextInt();
        cups += temp;
        action();
    }

    public  void take() {
        System.out.println("I gave you $" + money);
        money -= money;
        action();
    }

    public  void state() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(coffeeBeans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println(money + " of money");
        action();
    }

    public  void purchase() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String type = sc.next();

        switch (type) {
            case "1": if (validity(250, 0, 16)){
                        water -= 250;
                        coffeeBeans -= 16;
                        money += 4;
                        cups -= 1;
                System.out.println("I have enough resources, making you a coffee!");
                        action();
                        break; } else {
                scarcity(250, 0 );
            }
            case "2": if (validity(350, 75, 20)){
                water -= 350;
                milk -= 75;
                coffeeBeans -= 20;
                money += 7;
                cups -= 1;
                System.out.println("I have enough resources, making you a coffee!");
                action();
                break; } else {
                scarcity(350, 75 );
            }
            case "3": if (validity(200, 100, 12)) {
                water -= 200;
                milk -= 100;
                coffeeBeans -= 12;
                money += 6;
                cups -= 1;
                System.out.println("I have enough resources, making you a coffee!");
                action();
                break; } else {
                scarcity(350, 100 );
            }
            case "back": action();
                break;
        }

    }

    public  boolean validity(int iwater, int imilk, int icoffeeBeans) {
        return water > iwater && milk > imilk && coffeeBeans > icoffeeBeans;
    }

    public  void scarcity (int iwater, int imilk)  {
        if (water < iwater) {
            System.out.println("Sorry, not enough water!");
        }
        else if (milk < imilk && imilk != 0) {
            System.out.println("Sorry, not enough milk!");
        }
        else {
            System.out.println("Sorry, not enough coffee beans!");
        }
    }
}
