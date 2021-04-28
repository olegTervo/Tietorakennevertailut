package tiralabra.tietorakennevertailut;

import tiralabra.tietorakennevertailut.ui.UIHelper;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    private Stage primary;
    @Override
    public void start(Stage primary) throws Exception {
        this.primary = primary;
        UIHelper.start(primary);
    }
}