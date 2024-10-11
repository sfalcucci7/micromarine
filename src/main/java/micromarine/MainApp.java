////// [[[THIS IS A CORE IMPORTANT FILE]]]

package micromarine;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;


public class MainApp extends Application {

    //Set the JavaFX stage upon application launch. The homepage that should pop up for the user is the submit form. 
    @Override
    public void start(Stage stage) throws IOException {
Parent root = FXMLLoader.load(getClass().getResource("submit.fxml"));
Scene scene = new Scene(root);
stage.setTitle("WELCOME - SUBMIT DATA PAGE");
stage.setScene(scene);
stage.show();

}
public static void main(String[] args) {
    launch();
}
// public Stage getStage() {
//     throw new UnsupportedOperationException("Unimplemented method 'getStage'");
// }
}
