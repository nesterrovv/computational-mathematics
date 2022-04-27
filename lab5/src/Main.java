import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public void start(Stage primaryStage) throws Exception {

        primaryStage.setResizable(false);
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("models/milne.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Comp math. Lab work #5 by Ivan Nesterov");
        Scene scene = new Scene(root, 948, 638);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}