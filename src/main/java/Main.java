import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class Main extends Application {

    public static Stage primaryStage;

    public Main() throws UnsupportedEncodingException {
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/XML/window.fxml"));
        primaryStage.setTitle("String recoding converter");
        primaryStage.setScene(new Scene(root));
        runStage(primaryStage);
    }

    private void runStage(Stage stage) throws IOException {
        primaryStage = stage;
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
