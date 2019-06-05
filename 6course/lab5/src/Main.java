import org.python.core.*;
import org.python.util.PythonInterpreter;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ArrayList;

import graph.*;

public class Main extends Application {

    @Override public void start(Stage stage) {
        PythonInterpreter interpreter = new PythonInterpreter();

        interpreter.exec("import ex5");

        PyObject func = interpreter.get("ex5").__getattr__("main");
        PyObject result = func.__call__();
        PyTuple t = (PyTuple)result.__tojava__(PyTuple.class);

        PyList py_arr_emails = (PyList) t.get(0);
        PyList py_arr_value = (PyList) t.get(1);
        PyList py_arr_xspam = (PyList) t.get(2);
        py_arr_xspam.sort();

        ArrayList<String> email = new ArrayList<String>();
        ArrayList<Integer> value = new ArrayList<Integer>();
        ArrayList<Double> xspam = new ArrayList<Double>();

        for (int i = 0; i < py_arr_emails.size(); i++){
            email.add((String) py_arr_emails.get(i));
            value.add((int) py_arr_value.get(i));
            xspam.add((double) py_arr_xspam.get(i));
        }

        System.out.print("Max X-DSPAM-Confidence value: ");System.out.println(xspam.get(xspam.size() - 1));

        stage.setScene(Graph.draw(value, email));

        stage.setTitle("Sending emails chart");
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
