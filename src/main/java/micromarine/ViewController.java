////// [[[THIS IS A CORE IMPORTANT FILE]]]

package micromarine;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;

public class ViewController implements Initializable {
//Variables later referenced in Itialize to populate observable list
Connection con = null;
PreparedStatement st = null;
ResultSet rs = null;
PreparedStatement st2 = null;
ResultSet rs2 = null;
PreparedStatement st3 = null;
ResultSet rs3 = null;
PreparedStatement st4 = null;
ResultSet rs4 = null;
PlasticsModel plasticsModel = null;

//Establishing all objects on the JavaFX page for view data
@FXML
private TableView<PlasticsModel> datatable;

@FXML
private TableColumn<PlasticsModel, String> NameTableColumn;

@FXML
private TableColumn<PlasticsModel, String> EmailTableColumn;

@FXML
private TableColumn<PlasticsModel, Integer> CountTableColumn;

@FXML
private TableColumn<PlasticsModel, String> StateTableColumn;

@FXML
private TableColumn<PlasticsModel, Double> SizeTableColumn;

@FXML
private TableColumn<PlasticsModel, String> SeasonTableColumn;

@FXML
private TableColumn<PlasticsModel, Integer> IDTableColumn;

@FXML
private AnchorPane anchorpaneview;

@FXML
private Button backtosubmitbutton;

@FXML
private Label searchbarlabel;

@FXML
private Button searchbutton;

@FXML
private TextField searchtext;

@FXML
private Label viewtitlelabel;

@FXML
private Label statequerylabel;

@FXML
private Label totalquerylabel;

@FXML
    private Label sizequerylabel;

//Loading table to view all data

//Creating observable list referencing PlasticsModel.java
ObservableList<PlasticsModel> plasticsModelObservableList = FXCollections.observableArrayList();

//Establishing database connection again, getting variables, and setting them into the cell values of the table
@Override
public void initialize(URL url, ResourceBundle resourceBundle) {
String query = "SELECT FullName, Email, CountTotal, USAState, MaxSize, Season, ExperimentID FROM micromarinedb.plastics";
con = ConnectSQL.GetCon();


try {
    st = con.prepareStatement(query);
    rs = st.executeQuery();

    while (rs.next()) {
        //Align to getters in PlasticsModel.java
    String fullname = rs.getString("FullName");
    String email = rs.getString("Email");
    Integer counttotal = rs.getInt("CountTotal");
    String state = rs.getString("USAState");
    Double size = rs.getDouble("MaxSize");
    String season = rs.getString("Season");
    Integer experimentID = rs.getInt("ExperimentID");
    // System.out.println("Backend Confirmation: Successful Get");

plasticsModelObservableList.add(new PlasticsModel(fullname, email, counttotal, state, size, season, experimentID));
}
//Data should now be shown in the data table with the correct data type, table column, and database column 
NameTableColumn.setCellValueFactory(new PropertyValueFactory<PlasticsModel, String>("fullname"));
EmailTableColumn.setCellValueFactory(new PropertyValueFactory<PlasticsModel, String>("email"));
CountTableColumn.setCellValueFactory(new PropertyValueFactory<PlasticsModel, Integer>("counttotal"));
StateTableColumn.setCellValueFactory(new PropertyValueFactory<PlasticsModel, String>("usastate"));
SizeTableColumn.setCellValueFactory(new PropertyValueFactory<PlasticsModel, Double>("size"));
SeasonTableColumn.setCellValueFactory(new PropertyValueFactory<PlasticsModel, String>("season"));
IDTableColumn.setCellValueFactory(new PropertyValueFactory<PlasticsModel, Integer>("experimentID"));

datatable.setItems(plasticsModelObservableList);


//Search functionality testing - Significant Algorithmic Component

//wrap plasticsModelObervableList used to display the table in a FilteredList to iitially display all data
FilteredList<PlasticsModel> filteredData = new FilteredList<>(plasticsModelObservableList, b -> true);

//set the filter Predicate whenever the filter changes/the user starts typing
    searchtext.textProperty().addListener((observable, oldValue, newValue) -> {
    filteredData.setPredicate(PlasticsModel -> {

if (newValue.isEmpty() || newValue.isBlank () || newValue == null) {
    return true; } // if search bar is empty show all data rows
String searchstate = newValue.toUpperCase();

if (PlasticsModel.getUsastate().toUpperCase().indexOf(searchstate) > -1){
    return true; //means a match was found in state and it is filtered to it
} else 
 return false; });
});

// Then sorts the table only to the searched state live
SortedList<PlasticsModel> sortedData = new SortedList <>(filteredData); //wrap the FilteredList in a SortedList
sortedData.comparatorProperty().bind(datatable.comparatorProperty()); //bind the SortedList comparator to the table
datatable.setItems(sortedData); //add sorted and filtered data to the table 


//Statistics functionality 

//Calculates and shows the state with the most plastics recorded statistic
String querystate = "SELECT USAState, SUM(CountTotal) AS TotalCount FROM micromarinedb.plastics GROUP BY USAState ORDER BY TotalCount DESC LIMIT 1;";
st2 = con.prepareStatement(querystate);
rs2 = st2.executeQuery();

//Calculates and shows the sum of all plastics recorded
String querycount = "SELECT SUM(CountTotal) AS TotalPlasticsCount FROM micromarinedb.PLASTICS";
st3 = con.prepareStatement(querycount);
rs3 = st3.executeQuery();

//Calculates the average microplastic size
String querysize = "SELECT ROUND(AVG(MaxSize), 3) AS AverageMaxSize FROM micromarinedb.PLASTICS";
st4 = con.prepareStatement(querysize);
rs4 = st4.executeQuery();

if (rs2.next()) { //state statistic display
    String querystateresult = rs2.getString("USAState");
    // System.out.println("State Result: " +querystateresult);
    statequerylabel.setText(querystateresult);
}


if (rs3.next()) { //total count statistic display
    String querycountresult = rs3.getString("TotalPlasticsCount");
    // System.out.println("Count Result: " +querycountresult);
    totalquerylabel.setText(querycountresult);
}

if (rs4.next()) { //average size display
    String querysizeresult = rs4.getString("AverageMaxSize");
    // System.out.println("Size Avg Result: " +querysizeresult);
    sizequerylabel.setText(querysizeresult);
}

//SQL error catching
} catch (SQLException e) {
    throw new RuntimeException(e);   
}}


//Page navigation functionality back to Submit page
public void backtosubmit() throws Exception {
    Stage stage = (Stage) backtosubmitbutton.getScene().getWindow();
    stage.close();
    Stage primaryStage = new Stage();
    Parent root = FXMLLoader.load(getClass().getResource("submit.fxml"));
    primaryStage.setTitle("SUBMIT DATA PAGE");
    primaryStage.setScene((new Scene(root, 600, 650)));
    primaryStage.show();


}
}