import org.apache.commons.cli.*;
import Poly.*;

import java.util.ArrayList;

public class Main {
    Options options = new Options();

    Option poly = new Option("p", "poly", true, "input polynomial values");

    public static void main(String[] args) {
        Main m = new Main();
        m.init_options();

        Poly.Parser parser = new Poly.Parser();
        Poly.Calculator calc = new Poly.Calculator();

        ArrayList<Double> values = parser.parse(m.options, args);
        calc.calculate(values);
    }

    private void init_options(){
        poly.setRequired(true);
        options.addOption(poly);
    }
}
