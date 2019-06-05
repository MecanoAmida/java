import SqRt.SqRt;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to Square Root calculator program!\nPlease enter GO to start calculations");
        Scanner entry = new Scanner(System.in);
        String word = entry.nextLine();
        if(word.equals("GO")){
            SqRt root = new SqRt();
            root.calculate();
        }
    }
}