
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.tietorakennevertailut;

import tiralabra.tietorakennevertailut.UI.UIHelper;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author oleg
 */
public class Main extends Application{
    private Stage primary;
    @Override
    public void start(Stage primary) throws Exception {
        this.primary = primary;
        UIHelper.Start(primary);
    }
}