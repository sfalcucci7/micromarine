// package micromarine;

// import javafx.application.Application;
// import javafx.fxml.FXMLLoader;
// import javafx.geometry.Insets;
// import javafx.geometry.Pos;
// import javafx.scene.Parent;
// import javafx.scene.Scene;
// import javafx.stage.Stage;
// import javafx.util.converter.DateTimeStringConverter;

// import java.io.IOException;
// import java.text.SimpleDateFormat;

// import javafx.event.ActionEvent;
// import javafx.event.EventHandler;
// import javafx.scene.control.Button;
// import javafx.scene.control.Label;
// import javafx.scene.control.TextField;
// import javafx.scene.control.TextFormatter;
// import javafx.scene.control.PasswordField;
// import javafx.scene.layout.GridPane;
// import javafx.scene.layout.StackPane;
// import javafx.scene.layout.VBox;
// import javafx.scene.paint.Color;
// import javafx.scene.text.*;



//  public class MicroMarine extends Application {

//         Stage window;

//         public static void main(String[] args) {
//             launch(args);
//         }
// @Override
//     public void start(Stage primaryStage) throws Exception {
//        window = primaryStage;
//         primaryStage.setTitle("WELCOME TO MICROMARINE");
        
//     GridPane grid = new GridPane();
//     grid.setPadding(new Insets(25, 25, 25, 25));
//     grid.setVgap(8);
//     grid.setHgap(10);

// Text scenetitle = new Text("Welcome to MicroMarine");
// scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
// grid.add(scenetitle, 0, 0, 2, 1);

// Label inputnameLabel = new Label("Name:");
// grid.add(inputnameLabel, 0, 1);

// TextField inputname = new TextField();
// inputname.setPromptText("First and last");
// grid.add(inputname, 1, 1);

// Label pcountLabel = new Label("Plastics Count:");
// grid.add(pcountLabel, 0, 2);

// TextField pcount = new TextField();
// pcount.setPromptText("How many did you find?");
// grid.add(pcount, 1, 2);

// Label maxsizeLabel = new Label("Max Size:");
// grid.add(maxsizeLabel, 0, 3);

// TextField maxsize = new TextField();
// maxsize.setPromptText("No greater than .2 in");
// grid.add(maxsize, 1, 3);

// Label seasonLabel= new Label("Season:");
// grid.add(seasonLabel, 0, 4);

// TextField season = new TextField();
// season.setPromptText("Winter/Spring/Summer/Fall");
// grid.add(season, 1, 4);

// Label stateLabel= new Label("State:");
// grid.add(stateLabel, 0, 5);

// TextField state = new TextField();
// state.setPromptText("State abbreviation i.e. NJ");
// grid.add(state, 1, 5);


// Button submitButton = new Button("Submit my experiment!");
// grid.add(submitButton, 1, 7);

// Button alldataButton = new Button("View All Data Page");
// grid.add(alldataButton, 1, 9);

// final Text actiontarget = new Text();
//         grid.add(actiontarget, 1, 8);

// submitButton.setOnAction(new EventHandler<ActionEvent>() {

//     @Override
//     public void handle(ActionEvent e) {
//         actiontarget.setFill(Color.FIREBRICK);
//         System.out.println(
//             "Plastics you counted: " + pcount.getText() +
//             " | Max size: " + maxsize.getText() +
//             " | Season: " + season.getText() +
//             " | State: " + state.getText() +
//             " | Your name: " + inputname.getText() 
//             );
//             actiontarget.setText( "CONGRATS DATA SUBMITTED! | Plastics you counted: " + pcount.getText() +
//             " | Max size: " + maxsize.getText() +
//             " | Season: " + season.getText() +
//             " | State: " + state.getText() +
//             " | Your name: " + inputname.getText() 
//             );
//     }
// });



//      Scene scene = new Scene(grid, 800, 775);
//    window.setScene(scene);
//     window.show();

// }}

  
