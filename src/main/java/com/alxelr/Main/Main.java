package com.alxelr.Main;

import  com.alxelr.Data.DataProviderService;
import com.alxelr.Database.DatabaseCoin;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setOnCloseRequest(event -> Platform.exit());
        DatabaseCoin.load();
        Runtime.getRuntime().addShutdownHook(new Thread(Main::saveFiles));
        Parent node = new FXMLLoader(getClass().getResource("/com/alxelr/fxml/widget.fxml")).load();
        Scene scene = new Scene(node);
        stage.setScene(scene);
        stage.show();
    }

    private static void saveFiles() {
        DatabaseCoin.save();
    }
}
