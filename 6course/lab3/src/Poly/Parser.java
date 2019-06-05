package Poly;

import org.apache.commons.cli.*;

import java.util.ArrayList;

public class Parser {
    CommandLineParser parser = new DefaultParser();
    HelpFormatter formatter = new HelpFormatter();
    CommandLine cmd;

    public static void main(String[] args) {}

    public ArrayList<Double> parse(Options options, String[] args){
        ArrayList<Double> values = new ArrayList<>();

            try {
                cmd = parser.parse(options, args);
            }
            catch (ParseException e) {
                System.out.println(e.getMessage());
                formatter.printHelp("utility-name", options);

                System.exit(1);
            }

            String valStr = cmd.getOptionValue("p");

            String[] arr = valStr.split(",");
            System.out.println(arr);

            for (int i = 0; i < arr.length; i++) {
                try{
                    double d = Double.valueOf(arr[i]);
                    values.add(d);
                }catch (NumberFormatException e){
                    System.out.print("Error of ");System.out.print(i);System.out.print(" value convertion");
                }
            }

        return values;
    }
}
