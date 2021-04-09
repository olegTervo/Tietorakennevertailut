
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.tietorakennevertailut;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author oleg
 */
public class Main extends Application{
    private Stage primary;
    private Scene mainScene;
     
    @Override
    public void start(Stage primary) throws Exception {
        
        this.primary = primary;
        
        HBox titleBox = new HBox();
        titleBox.setStyle("-fx-alignment: center;");
        Label title = new Label("Tietorakennevertailut Home");
        title.setStyle("-fx-font-size: 20px;");
        titleBox.getChildren().add(title);
        //title.setStyle("-fx-content-display: center;");
        
        TextArea console = new TextArea();
        console.setEditable(false);
        console.setText("Wellcoma to the Application!");
        console.setStyle("-fx-control-inner-background: black;");
        
        TextField commandField = new TextField();
        Button run = new Button("Run");
        
        HBox runCommandBox = new HBox();
        runCommandBox.setSpacing(20);
        runCommandBox.getChildren().add(commandField);
        runCommandBox.getChildren().add(run);
        
        VBox mainPage = new VBox();
        mainPage.setSpacing(10);
        mainPage.getChildren().add(titleBox);
        mainPage.getChildren().add(runCommandBox);
        mainPage.getChildren().add(console);
        
        mainScene = new Scene(mainPage);
        
        primary.setTitle("Haku Vertailu");
        primary.setScene(mainScene);
        primary.show();
    }
}