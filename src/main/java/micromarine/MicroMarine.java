package micromarine;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.converter.DateTimeStringConverter;

import java.io.IOException;
import java.text.SimpleDateFormat;

//updated import
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

 public class MicroMarine extends Application {

        Stage window;

        public static void main(String[] args) {
            launch(args);
        }
@Override
    public void start(Stage primaryStage) throws Exception {
       window = primaryStage;
        primaryStage.setTitle("WELCOME TO MICROMARINE");
        
    GridPane grid = new GridPane();
    grid.setPadding(new Insets(25, 25, 25, 25));
    grid.setVgap(8);
    grid.setHgap(10);

Text scenetitle = new Text("Welcome to micromarine");
scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
grid.add(scenetitle, 0, 0, 2, 1);

Label inputnameLabel = new Label("Your Name:");
grid.add(inputnameLabel, 0, 1);

TextField inputname = new TextField();
grid.add(inputname, 1, 1);

Label pcountLabel = new Label("Plastics Count:");
grid.add(pcountLabel, 0, 2);

TextField pcount = new TextField();
pcount.setPromptText("how many you counted");
grid.add(pcount, 1, 2);

Label maxsizeLabel = new Label("Max Size:");
grid.add(maxsizeLabel, 0, 3);

TextField maxsize = new TextField();
maxsize.setPromptText("no greater than 2mm");
grid.add(maxsize, 1, 3);

Label datetimeLabel= new Label("Date/Time:");
grid.add(datetimeLabel, 0, 4);

TextField datetime = new TextField();
datetime.setPromptText("MM:DD:YYYY");
grid.add(datetime, 1, 4);

Button submitButton = new Button("submit my data yay");
grid.add(submitButton, 1, 6);


final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 8);

submitButton.setOnAction(new EventHandler<ActionEvent>() {

    @Override
    public void handle(ActionEvent e) {
        actiontarget.setFill(Color.FIREBRICK);
        actiontarget.setText("CONGRATS DATA SUBMITTED");
        System.out.println("Plastics you counted: " + pcount.getText() +" Max size you counted: " + maxsize.getText());
    }
});

//it didn't like this
// TextField datetime = new TextField();
// SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
// datetime.setTextFormatter(new TextFormatter<>(new DateTimeStringConverter(format), format.parse("00:00:00")));
// grid.add(maxsizeLabel, 1, 4);

//grid.getChildren().addAll(scenetitle, inputname, inputnameLabel, pcount, pcountLabel, maxsize, maxsizeLabel, datetimeLabel, datetime);

// PasswordField pwBox = new PasswordField();
// grid.add(pwBox, 1, 2);

     Scene scene = new Scene(grid, 800, 775);
   window.setScene(scene);
    window.show();

    // int pcountI = Integer.parseInt(pcount.getText());
    // System.out.println("You counted this many microplastics:" + pcountI);
}}

  
    

// public class MicroMarineApp extends Application implements EventHandler<ActionEvent>{
//     Button button;
//     Stage window;
//     Scene scene;

//     public static void main(String[] args) {
//       launch(args);

//     }

//     @Override
//     public void start(Stage primarysStage) throws Exception {
//        window = primarysStage;
//        window.setTitle("WELCOME TO MICROMARINE");

//        //form
//        TextField nameInput = new TextField();
//        TextField totalcountInput = new TextField();

//         button = new Button("Submit data");
//         button.setOnAction(e -> System.out.println(nameInput.getText()));

//         //layout
//         VBox layout = new VBox(10);
//         layout.setPadding(new Insets(20, 20, 20, 20));
//         layout.getChildren().addAll(nameInput, totalcountInput, button);
        

//         scene = new Scene(layout, 300, 250);
//         window.setScene(scene);
//         window.show();    
//     }

//     private boolean isValid(TextField input, String message){
//         try{
//             int pcount = Integer.parseInt(input.getText());
//             System.out.println("You counted this many microplastics:" + pcount);
//             return true;
//         }catch(Exception e) {
//         System.out.println("error");
//         return false;
//         }
//     }

//     @Override
//     public void handle(ActionEvent event) {
//         if(event.getSource()==button) {
//             System.out.println("Thanks for submitting your data!");
//         }}}
    

// /**
//  * JavaFX App
//  */
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


