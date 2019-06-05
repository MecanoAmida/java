import java.util.Scanner;
import calc.Calculator;

public class Main {

    public static void main(String[] args) {
        Scanner launch = new Scanner(System.in);
        System.out.println("Welcome to Calculator program!\nEnter GO if you want to start a calculation");
        String launch_cmd = launch.nextLine();

        if (launch_cmd.equals("GO")) {
            Calculator c = new Calculator();
            c.calculate();
        }
    }
}