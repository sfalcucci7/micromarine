// package micromarine;
// import java.io.IOException;

// import javafx.fxml.*;
// import javafx.scene.*;
// import javafx.scene.layout.AnchorPane;
// import javafx.stage.Stage;
// import javafx.event.ActionEvent;
// import java.util.Objects;


// public class Utils {

// //     public Utils(AnchorPane currentAnchorPane, String fxml) throws IOException {
// // AnchorPane nextAnchorPane = FXMLLoader.load(Objects.requireNonNull(SubmitController.class.getResource(fxml)));
// // currentAnchorPane.getChildren().removeAll();
// // currentAnchorPane.getChildren().setAll(nextAnchorPane);
// //     }
    
//     public static void changeScene(ActionEvent event, String fxmlFile){
//          Parent root = null;
 
// try {
//     // FXMLLoader loader = new FXMLLoader(Utils.class.getResource(fxmlFile));
//     // root = loader.load();
//     // SubmitController submitController= loader.getController();
//     // submitController.
//     root = FXMLLoader.load(Utils.class.getResource(fxmlFile));

// } catch (IOException e) {
//     e.printStackTrace();
// }

// // Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
// // // stage.setTitle(title);
// //   stage.setScene(new Scene(root));  
// // stage.show();}
// }
// }