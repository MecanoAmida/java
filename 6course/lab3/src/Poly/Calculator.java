package Poly;

import java.util.ArrayList;
import java.util.Iterator;

public class Calculator {
    public static void main(String[] args) {}

    public void calculate(ArrayList<Double> values) {
        double result = 0.0;

        Iterator<Double> foreach = values.iterator();
        while (foreach.hasNext()) result += 1.0 / (3.0 + foreach.next());

        System.out.print("Result: ");System.out.println(result);
    }
}
