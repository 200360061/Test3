package Gagan;

/**
 * Question 9 - ensure your name and student number is in every .java file (2
 * marks)
 */
/**
 *@author Gagandeep kaur(200360061)
 */
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("CansView.fxml"));
        Scene scene = new Scene(root);

        primaryStage.setTitle("Create Can");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

}
/**
 * Question 10 - view and code look professional (3 marks)
 */