package graph;

import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.util.ArrayList;
import java.util.Iterator;

public class Graph {

    public static void main(String[] args) {}

    public static Scene draw(ArrayList<Integer> value, ArrayList<String> email){
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String,Number> lineChart =
                new BarChart<String, Number>(xAxis,yAxis);

        lineChart.setTitle("SMA data");
        XYChart.Series series = new XYChart.Series();
        series.setName("Number of emails");

        Iterator<Integer> foreach_value = value.iterator();
        Iterator<String> foreach_email = email.iterator();

        int i = 0;
        while(foreach_value.hasNext() && foreach_email.hasNext()) {
            series.getData().add(new XYChart.Data(foreach_email.next(), foreach_value.next()));
            i++;
        }

        Scene scene  = new Scene(lineChart,800,600);
        lineChart.getData().add(series);

        return scene;
    }
}
