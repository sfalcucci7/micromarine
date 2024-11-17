////// [[[THIS IS A CORE IMPORTANT FILE]]]

package micromarine;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
    //Establishing all objects on the JavaFX page for submit
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
   
//Main method which takes the strings inserted into the text boxes with a SQL Insert statement to insert them into the appropriate database columns
    @FXML
    void submitData(ActionEvent event) {
        String insert = "insert into micromarinedb.plastics(FullName, Email, CountTotal, USAState, MaxSize, Season) values(?,?,?,?,?,?)";
        Connection con = ConnectSQL.GetCon();

   // Validate inputs 
   String fullName = inputname.getText().toUpperCase();
   String emailInput = email.getText().toUpperCase();
   String countTotal = pcount.getText();
   String usaState = usastate.getText().toUpperCase();
   String maxSize = maxsize.getText();
   String seasonInput = season.getText().toUpperCase();

   //set strings for fully compiled error message and state acronymn check
   List<String> errorMessages = new ArrayList<>();
   List<String> validStates = Arrays.asList("AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY");

        //validate that all the text boxes have an input because all are required fields
    if (fullName.isEmpty() || emailInput.isEmpty() || countTotal.isEmpty() || usaState.isEmpty() || maxSize.isEmpty() || seasonInput.isEmpty()) {
        errorMessages.add("All fields are required.");
    }

    //validate state is the acronymn and not fully spelled out
    if (!validStates.contains(usaState)) {
        errorMessages.add("State must be a valid two-letter acronym for a US state.");
    }
    //validate the season is only submitted as the four appropriate options
    if (!seasonInput.equals("SPRING") && !seasonInput.equals("SUMMER") && !seasonInput.equals("WINTER") && !seasonInput.equals("FALL")) {
        errorMessages.add("Season must be submitted as Spring, Summer, Winter, or Fall.");
    }

    //valididate the plastics count field is a number and doesn't include other characters 
    try {
        int count = Integer.parseInt(countTotal);
    } catch (NumberFormatException e) {
        errorMessages.add("Plastics count must be a number.");
    }
//validate the size field is a number and less than 5mm following microplastic definitions
    try {
        double size = Double.parseDouble(maxSize);
        if (size > 5) {
            errorMessages.add("A microplastic should be less than or equal to 5mm.");
        }
    } catch (NumberFormatException e) {
        errorMessages.add("Max size must be a number.");
    }

//compile all error messages into one message for the user to see
    if (!errorMessages.isEmpty()) {
        submitsuccesslabel.setText(String.join("\n", errorMessages));
        return;
    }
        try {
            // Submit data as all upper case to handle varying user inputs
            PreparedStatement st = con.prepareStatement(insert);
            st.setString(1, inputname.getText().toUpperCase());
            st.setString(2, email.getText().toUpperCase());
            st.setString(3, pcount.getText());
            st.setString(4, usastate.getText().toUpperCase());
            st.setString(5, maxsize.getText());
            st.setString(6, season.getText().toUpperCase());
            st.executeUpdate();
            
    //The system will print out on sonsole a confirmation of what the user submitted and present a success message. This can be removed at the end of project.
        System.out.println(
            "Plastics you counted: " + pcount.getText() +
            " | Max size: " + maxsize.getText() +
            " | Season: " + season.getText() +
            " | State: " + usastate.getText() +
            " | Your name: " + inputname.getText() 
            );
            submitsuccesslabel.setText("THANKS FOR SUBMITTING YOUR DATA!");

        }
        //General error message catch for unsuccessful submissions
        catch (SQLException e){
            System.out.println("Error - could not submit.");
            submitsuccesslabel.setText("Sorry, there was an error and your data submission was unsuccessful. Please try again.");
            throw new RuntimeException(e);
        }

        }
        
//Page navigation functionality to View Data Page
@FXML
public void openviewall() throws Exception {
    Stage stage = (Stage) viewalldatapageButton.getScene().getWindow();
    stage.close();
    Stage primaryStage = new Stage();
    Parent root = FXMLLoader.load(getClass().getResource("view.fxml"));
    primaryStage.setTitle("VIEW DATA PAGE");
    primaryStage.setScene((new Scene(root, 700, 600)));
    primaryStage.show();
}

public void start(Stage stage) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'start'");
}
    

}

