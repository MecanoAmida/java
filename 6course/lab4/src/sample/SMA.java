package sample;

import java.util.ArrayList;
import java.util.Iterator;

public class SMA {

    public static void main(String[] args) {}

    public static ArrayList<Double> calculate(ArrayList<Double> data, int window){
        ArrayList<Double> out = new ArrayList<Double>();

        Double[] arr = data.toArray(new Double[data.size()]);

        for (int i = 0; i < arr.length - window - 1; i++) {
            double val = arr[i];

            for (int j = i + 1; j < i + window; j++)
                val += arr[j];
            val /= window;

            out.add(val);
        }
        return out;
    }
}
