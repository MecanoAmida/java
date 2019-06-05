package SqRt;

import java.util.Scanner;

public class SqRt {

    public static void main(String[] args) {}

    public void calculate(){
        System.out.println("Enter the value");
        Scanner input = new Scanner(System.in);
        double number = 0.0;

        try{
            number = input.nextDouble();
        }
        catch (java.util.InputMismatchException e)
        {
            System.out.println("Invalid value convertion!");
            return;
        }

        int i = 0;
        double iterator = 3.5;
        while(i < 200){
            iterator = (1.0 / 2.0) * (iterator + (number / iterator));
            i++;
        }

        System.out.print("Result: ");System.out.println(iterator);
    }
}