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
    


//         scene = new Scene(loadFXML("primary"), 640, 480);
//         stage.setScene(scene);
//         stage.show();
//     }

//     static void setRoot(String fxml) throws IOException {
//         scene.setRoot(loadFXML(fxml));
//     }

//     private static Parent loadFXML(String fxml) throws IOException {
//         FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
//         return fxmlLoader.load();
//     }


//     @Override
//     public void start(Stage arg0) throws Exception {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'start'");
//     }

// }

// // public class App extends Application {

// //     private static Scene scene;

// //     @Override
// //     public void start(Stage stage) throws IOException {
// //         scene = new Scene(loadFXML("primary"), 640, 480);
// //         stage.setScene(scene);
// //         stage.show();
// //     }

// //     static void setRoot(String fxml) throws IOException {
// //         scene.setRoot(loadFXML(fxml));
// //     }

// //     private static Parent loadFXML(String fxml) throws IOException {
// //         FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
// //         return fxmlLoader.load();
// //     }

// //     public static void main(String[] args) {
// //         launch();
// //     }

// // }
