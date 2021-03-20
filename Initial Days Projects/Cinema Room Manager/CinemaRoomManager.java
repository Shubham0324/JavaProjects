package cinema;
import java.util.Scanner;
public class CinemaRoomManager {

    public static void cases(String[][] arr, int r1, int r2, int ticket){
        System.out.println();
        System.out.println("1. Show the seats\n2. Buy a ticket\n0. Exit");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                showSeats(arr, r1, r2, ticket);
                break;
            case 2:
                buyTicket(arr, r1, r2, ticket);
                break;
            case 0:  break;

        }
    }
    public static void showSeats(String[][] arr, int r1, int r2, int ticket){
        System.out.println();

        System.out.println("Cinema:");
        for (int i = 0; i <= r1; i++){
            for (int j = 0; j <= r2; j++){
                System.out.print(arr[i][j]+ " ");
            }
            System.out.println();
        }
        cases(arr, r1, r2, ticket);
    }
    public static void buyTicket(String[][] arr, int r1, int r2, int ticket){
        System.out.println();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a row number:");
        int r3 = sc.nextInt();
        System.out.println("Enter a seat number in that row:");
        int r4 = sc.nextInt();
        System.out.println();
        if ( r1 * r2 <= 60){
            ticket = 10;
        }
        else{
            ticket = 8;
        }
        if ( r3 <= r1 / 2){
            ticket = 10;
        }
        System.out.println("Ticket price: $" + ticket);
        arr[r3][r4] = "B";
        cases(arr, r1, r2, ticket);
    }

    public static void main(String[] args) {
        Scanner  sc = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int r1 = sc.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int r2 = sc.nextInt();
        int ticket;
        String[][] arr = new String[r1+1][r2+1];
        for (int i = 0; i <= r1; i++){
            for (int j = 0; j <= r2; j++){
                if ( i == 0 && j == 0){
                    arr[i][j] = " ";
                }
                else if(i == 0){
                    arr[i][j] = String.valueOf(j);
                }
                else if ( j == 0 ){
                    arr[i][j] =  String.valueOf(i);
                }
                else{
                    arr[i][j] = "S";
                }
            }
        }
        if (r1 * r2 <= 60){
            //System.out.println("Total income:\n$" + r1 * r2 * 10 );
            ticket = 10;
        }
        else{
            //int temp  = ((r1 / 2) * r2 * 10) + ((r1 - (r1 / 2)) * r2 * 8);
            ticket = 8;
        }
        cases(arr, r1, r2, ticket);
    }
}