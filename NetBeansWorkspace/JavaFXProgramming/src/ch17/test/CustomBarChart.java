/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch17.test;

import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

class CustomBarChart extends BarChart<String, Number> {

    public CustomBarChart( CategoryAxis xAxis, NumberAxis yAxis ) {
        super( xAxis, yAxis );

        setAnimated( false );
        setLegendVisible( false );
        setTitleSide( Side.TOP );
        setTitle( "SSPP Diurnal Symbol Rate" );
        setMinHeight( 500 );
        setMinWidth( 1000 );
    }

    @Override
    protected void layoutPlotChildren() {
        super.layoutPlotChildren();

        // Each individual Data element has its own bar.
        // TODO add label to each bar.
        for ( Series<String, Number> series : getData() ) {
            for ( Data<String, Number> data : series.getData() ) {
                StackPane bar = (StackPane) data.getNode();

                Label label = null;

                for ( Node node : bar.getChildrenUnmodifiable() ) {
                    
                    if ( node instanceof Label ) {
                        label = (Label) node;
                        break;
                    }
                }

                if ( label == null ) {
                    label = new Label( series.getName() );
                    label.setRotate( 90.0 );
                    bar.getChildren().add( label );
                }
                else {
                    label.setText( series.getName() );
                }
            }
        }
    }
}