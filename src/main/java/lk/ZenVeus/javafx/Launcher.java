package lk.ZenVeus.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Launcher extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        Parent rootNode = FXMLLoader.load(getClass().getResource("/View/chatForm.fxml"));
        Scene scene = new Scene(rootNode);
        stage.setScene(scene);
        stage.setTitle("Chat Form");
        stage.show();
    }
}
