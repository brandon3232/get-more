package com.example.getmore;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GetMoreApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("registro-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);

        RegistroController controller = fxmlLoader.getController();
        controller.setStage(stage);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}