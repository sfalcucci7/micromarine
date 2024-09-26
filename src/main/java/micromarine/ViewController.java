package micromarine;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ViewController {

    @FXML
    private AnchorPane anchorpaneview;

    @FXML
    private Button backtosubmitbutton;

    @FXML
    private TableView<?> datatable;

    @FXML
    private Label searchbarlabel;

    @FXML
    private Button searchbutton;

    @FXML
    private TextField searchtext;

    @FXML
    private ScrollBar tablescrollbar;

    @FXML
    private Label viewtitlelabel;





//Tentative page navigation functionality
public void backtosubmit() throws Exception {
Stage stage = (Stage) backtosubmitbutton.getScene().getWindow();
stage.close();
Stage primaryStage = new Stage();
Parent root = FXMLLoader.load(getClass().getResource("submit.fxml"));
primaryStage.setTitle("Back to Submit");
primaryStage.setScene((new Scene(root, 600, 650)));
primaryStage.show();

}

    
}
