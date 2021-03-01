package tictactoe;

import java.util.Scanner;

public class Main {

    final static Scanner sc = new Scanner(System.in);
    static char[] input = new char[9];
    static int x = 0, y= 0, space = 0;
    
    public static void  play() {
        for(int i = 0; i < 9; i++){
            input[i] = ' ';
        }
    }

    public static void printBoard() {
        System.out.println("---------");
        for (int i = 0; i < 7; i += 3) {
            System.out.printf("| %c %c %c |%n", input[i], input[i + 1], input[i + 2]);
        }
        System.out.println("---------");
    }

    public static void condition() {
        for (char c : input) {
            if (c == 'X') {
                x++;
            } else if (c == 'O') {
                y++;
            } else {
                space++;
            }
        }
    }

    public static boolean horizontalWin(char type) {
        for (int i = 0; i < 7; i+= 3) {
            if(input[i] == input[i + 1] && input[i + 1] == input[i + 2] && input[ i + 2] == type) {
                return true;
            }
        }
        return false;
    }

    public static boolean verticalWin(char type) {
        for (int i = 0; i < 3; i++) {
            if(input[i] == input[i + 3] && input[i + 3] == input[i + 6] && input[ i + 6] == type) {
                return true;
            }
        }
        return false;
    }

    public static boolean diagonalWin(char type) {
        return input[0] == input[4] && input[4] == input[8] && input[8] == type || input[2] == input[4] && input[4] == input[6] && input[6] == type;
    }

    public static void checkWin() {
        space = 0;
        condition();

        if(horizontalWin('X') || verticalWin('X') || diagonalWin('X')) {
            printBoard();
            System.out.println("X wins");
           System.exit(0);
        }
        else if(horizontalWin('O') || verticalWin('O') || diagonalWin('O')) {
            printBoard();
            System.out.println("O wins");
           System.exit(0);
        }
        else if (space == 0) {
            printBoard();
            System.out.println("Draw");
            System.exit(0);
        }
    }

    public static  boolean userInput(char op) {
        System.out.print("Enter the coordinates: ");
        int x = 0, y = 0;
        try {
            x = sc.nextInt();
            y = sc.nextInt();
        } catch (Exception e) {
            System.out.println("You should enter numbers!");
            userInput(op);
        }
        if ( x > 3 || y > 3){
            System.out.println("Coordinates should be from 1 to 3!");
            userInput(op);
        }
        else if( x == 1){
            if (input[y - x] != ' ') {
                System.out.println("This cell is occupied! Choose another one!\n");
                userInput(op);
            }
            else{
                input[y -x] = op;
                checkWin();
            }
        }else if (x == 2) {
            if (input[y + x] != ' '){
                System.out.println("This cell is occupied! Choose another one!\n");
                userInput(op);
            }
            else{
                input[y +x] = op;
                checkWin();
            }
        }
        else if (x == 3){
            if (input[x+y+2] != ' '){
                System.out.println("This cell is occupied! Choose another one!\n");
                userInput(op);
            }
            else{
                input[y +x+2] = op;
                checkWin();
            }
        }
        return true;
    }

    public static void main(String[] args) {
        play();
        printBoard();
        for (int i = 0; i < 9; i++) {
            if (i % 2 == 0) {
                boolean came = userInput('X');
                if (!came) {
                    userInput('X');
                } else {
                    printBoard();
                }
            }
            else{
                boolean came = userInput('O');
                if (!came) {
                    userInput('O');
                } else {
                    printBoard();
                }
            }
        }
    }
}

