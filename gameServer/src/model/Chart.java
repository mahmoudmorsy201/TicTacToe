
package model;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

/**
 *
 * @author Mahmoud
 */
public class Chart extends Application {
    
    private static Chart ch;
    private ObservableList<PieChart.Data> pieChartData;
    private static boolean flag = false;
    Stage dialogStage;

    private Chart(){
        
    }
    
    
    
    public static Chart getChartObj(){
        if(ch == null){
            ch = new Chart();
        }
        return ch;
    }
    public static void setFlag(boolean x){
        flag = x;
    }
    public static boolean getFlag(){
        return flag;
    }
    public void setChartData(ObservableList<PieChart.Data> ob){
        this.pieChartData = ob;
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        
        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Tic Tac Toe Statistics");
        
        Scene scene = new Scene(new Group());
        ((Group) scene.getRoot()).getChildren().add(chart);
        if(dialogStage == null){
            
            dialogStage = new Stage();
            dialogStage.initOwner(stage);
            dialogStage.setTitle("Tic Tac Toe Statistics");
            dialogStage.initModality(Modality.APPLICATION_MODAL);
            dialogStage.initStyle(StageStyle.UTILITY);
            
        }
        
        dialogStage.setScene(scene);
        dialogStage.show();
        chart.setLegendVisible(true);
        dialogStage.setOnCloseRequest((WindowEvent we) -> {
            flag = true;
        });
                
    }

    public static void main(String[] args) {
        launch(args);
    }
}

