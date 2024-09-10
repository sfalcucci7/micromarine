package micromarine;

import java.net.URL;
import java.util.ResourceBundle;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.fxml.Initializable;
import java.io.IOException;


public class SubmitController implements Initializable {
    @FXML
    private AnchorPane anchorpanesubmit;

    @FXML
    private TextField email;

    @FXML
    private Label emaillabel;

    @FXML
    private TextField inputname;

    @FXML
    private Label inputnamelabel;

    @FXML
    private TextField maxsize;

    @FXML
    private Label maxsizelabel;

    @FXML
    private TextField pcount;

    @FXML
    private Label pcountlabel;

    @FXML
    private TextField season;

    @FXML
    private Label seasonlabel;

    @FXML
    private Button submitdatabutton;

    @FXML
    private TextField usastate;

    @FXML
    private Label usastatelabel;

    @FXML
    private Button viewalldatapageButton;

    @FXML
    private Label welcometitlelabel;



    // @FXML
    // void changeScenebuttonpushed(ActionEvent event) {
    //     try {
    //     FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("view.fxml"));
    //     Parent root1 = (Parent) fxmlLoader.load();
    //     Stage stage = new Stage();
    //     stage.setTitle("window2");
    //     stage.setScene(new Scene(root1));
    //     stage.show();
    //     }
    //     catch (Exception e) {
    //         System.out.println("error can't load window");
    //     }


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        throw new UnsupportedOperationException("Unimplemented method 'initialize'");
    }
}



// // @Override
// // public void initialize(URL location, ResourceBundle resources) {
    
// // viewalldatapageButton.setOnAction(new EventHandler<ActionEvent>() {

// //     @Override
// //     public void handle(ActionEvent event){
// //         Utils.changeScene(event, "view.fxml");
// //     }

// // });

// // }


// }
