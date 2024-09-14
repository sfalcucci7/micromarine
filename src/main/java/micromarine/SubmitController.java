////// [[[THIS IS A CORE IMPORTANT FILE]]]

package micromarine;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
import javafx.scene.paint.Color;
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
    private Label submitsuccesslabel;

    @FXML
    private TextField usastate;

    @FXML
    private Label usastatelabel;

    @FXML
    private Button viewalldatapageButton;

    @FXML
    private Label welcometitlelabel;

    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // throw new UnsupportedOperationException("Unimplemented method 'initialize'");
    }
   

    @FXML
    void submitData(ActionEvent event) {
        String insert = "insert into micromarinedb.plastics(FullName, Email, CountTotal, USAState, MaxSize, Season) values(?,?,?,?,?,?)";
        Connection con = ConnectSQL.GetCon();
        try {
            PreparedStatement st = con.prepareStatement(insert);
            st.setString(1, inputname.getText());
            st.setString(2, email.getText());
            st.setString(3, pcount.getText());
            st.setString(4, usastate.getText());
            st.setString(5, maxsize.getText());
            st.setString(6, season.getText());
            st.executeUpdate();
        System.out.println(
            "Plastics you counted: " + pcount.getText() +
            " | Max size: " + maxsize.getText() +
            " | Season: " + season.getText() +
            " | State: " + usastate.getText() +
            " | Your name: " + inputname.getText() 
            );
            submitsuccesslabel.setText( "THANKS FOR SUBMITTING YOUR DATA!");

        }
        catch (SQLException e){
            System.out.println("Error - could not submit.");
            submitsuccesslabel.setText("Error - could not submit.");
            throw new RuntimeException(e);
        }

        }

    

}

