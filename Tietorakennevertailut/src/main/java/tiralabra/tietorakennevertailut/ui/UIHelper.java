/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.tietorakennevertailut.ui;

import tiralabra.tietorakennevertailut.ui.AutoCompleteTextField;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author oleg
 */
public class UIHelper {
    
    public static void start(Stage primary) {
        primary.setTitle("Tietorakennevertailut");
        primary.setScene(getMainPage());
        primary.show();
    }
    
    private static Scene getMainPage() {
        VBox mainPage = new VBox();
        mainPage.setSpacing(10);
        mainPage.getChildren().add(getTitleBox());
        mainPage.getChildren().add(getRunCommandLine());
        mainPage.getChildren().add(getConsole());
        
        return new Scene(mainPage);
    }
    
    private static HBox getTitleBox() {
        HBox titleBox = new HBox();
        titleBox.setStyle("-fx-alignment: center;");
        Label title = new Label("Tietorakennevertailut Home");
        title.setStyle("-fx-font-size: 20px;");
        titleBox.getChildren().add(title);
        
        return titleBox;
    }
    
    private static HBox getRunCommandLine() {
        AutoCompleteTextField commandField = new AutoCompleteTextField();        
        Button run = new Button("Run");
        
        HBox runCommandBox = new HBox();
        runCommandBox.setSpacing(20);
        runCommandBox.getChildren().add(commandField);
        runCommandBox.getChildren().add(run);
        
        return runCommandBox;
    }
    
    private static TextArea getConsole() {
        TextArea console = new TextArea();
        console.setEditable(false);
        console.setText("Wellcome to the Application!");
        console.setStyle("-fx-control-inner-background: black;");
        
        return console;
    }

}
