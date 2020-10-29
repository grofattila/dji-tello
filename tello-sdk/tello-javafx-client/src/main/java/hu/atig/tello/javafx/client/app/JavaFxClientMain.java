package hu.atig.tello.javafx.client.app;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class JavaFxClientMain extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");

        Locale locale = new Locale("en", "US");

        URL location = getClass().getClassLoader().getResource("view/home.fxml");

        System.out.println(location);

        ResourceBundle resources = ResourceBundle.getBundle("bundle/strings", locale);
        FXMLLoader fxmlLoader = new FXMLLoader(location, resources);
        Pane root = fxmlLoader.load();

        Scene scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        stage.show();
    }
}
