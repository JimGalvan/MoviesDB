package module5;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Main extends Application {

    Controller c;

    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader loader = new FXMLLoader();

        Parent root = loader.load(getClass().getResourceAsStream("mainUI.fxml"));
        c = loader.getController();

        primaryStage.setTitle("Movie list");
        primaryStage.setScene(new Scene(root, 889, 645));
        primaryStage.show();

        primaryStage.setOnCloseRequest(event -> {
            c.movieQueries.close();
            Platform.exit();
            System.exit(0);
        });
    }


    public static void main(String[] args) {
        launch(args);
    }
}
