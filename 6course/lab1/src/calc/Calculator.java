package calc;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        System.out.println("Launch Calculator...");
    }

    public void calculate(){
        Scanner input = new Scanner(System.in);

        while(true) {
            System.out.println("Enter the first value");
            String first_val = input.nextLine();
            System.out.println("Enter the operation (+, -, *, /)");
            String operation = input.nextLine();
            System.out.println("Enter the second value");
            String second_val = input.nextLine();

            double value1 = 0.0;
            double value2 = 0.0;

            try {
                value1 = Double.valueOf(first_val);
            }
            catch (NumberFormatException e) {
                System.out.println("Invalid first value convertion. Please try again or type exit to exit program");
                String exit = input.nextLine();
                if(exit.equals("exit"))
                    break;
                else
                    continue;
            }
            try {
                value2 = Double.valueOf(second_val);
            }
            catch (NumberFormatException e) {
                System.out.println("Invalid second value convertion. Please try again or type exit to exit program");
                String exit = input.nextLine();
                if(exit.equals("exit"))
                    break;
                else
                    continue;
            }

            switch(operation){
                case "+":
                    System.out.print("Result: ");System.out.println(value1 + value2);
                    break;
                case "-":
                    System.out.print("Result: ");System.out.println(value1 - value2);
                    break;
                case "*":
                    System.out.print("Result: ");System.out.println(value1 * value2);
                    break;
                case "/":
                    try {
                        if ((1 / value2) == Double.POSITIVE_INFINITY)
                            throw new ArithmeticException("Error");
                        else
                            System.out.print("Result: ");System.out.println(value1 / value2);
                    }
                    catch (ArithmeticException e) {
                        System.out.println("Calculation error, division by zero");
                    }
                    break;
                default:
                    System.out.println("Incorrect operator.Please, try again or type exit to exit program");
                    String exit = input.nextLine();
                    if(exit.equals("exit"))
                        break;
                    else
                        continue;
            }

            System.out.println("If you want continue the calculations, enter y");
            String continue_cmd = input.nextLine();
            if(!continue_cmd.equals("y"))
                break;
        }
    }
}