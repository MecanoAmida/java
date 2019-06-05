package sample;

import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.util.ArrayList;
import java.util.Iterator;

public class Graph {

    public static void main(String[] args) {}

    public static Scene draw(ArrayList<Double> x, ArrayList<Double> x_filt){
        //defining the axes
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        //creating the chart
        final LineChart<Number,Number> lineChart =
                new LineChart<Number,Number>(xAxis,yAxis);

        lineChart.setTitle("SMA data");
        //defining a series
        XYChart.Series series = new XYChart.Series();
        series.setName("WIthout SMA");
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("With SMA");

        Iterator<Double> foreach_x = x.iterator();
        Iterator<Double> foreach_x_filt = x_filt.iterator();

        int i = 0;
        while(foreach_x.hasNext()) {
            series.getData().add(new XYChart.Data(i, foreach_x.next()));
            i++;
        }

        i = x.size() - x_filt.size();
        while(foreach_x_filt.hasNext()) {
            series1.getData().add(new XYChart.Data(i, foreach_x_filt.next()));
            i++;
        }

        Scene scene  = new Scene(lineChart,800,600);
        lineChart.getData().add(series);
        lineChart.getData().add(series1);

        return scene;
    }
}
