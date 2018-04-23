package Gagan;


/**
 * Question 9 - ensure your name and student number is in every .java file (2
 * marks)
 */
/**
 *@author Gagandeep kaur (200360061)
 */
import java.net.URL;
import java.util.Comparator;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Question 3 - Create a GUI that can instantiate a new Can object. The GUI
 * should use a TextField and your choice of a spinner or slider to set the ml.
 * The spinner or slider should have a default value of 500 ml. Add a button to
 * create a new Can object and display it in the console. If there is a problem
 * with the input, the GUI should display a useful message to the user (no
 * exceptions should display in the console!) (5 marks)
 */
public class CansViewController implements Initializable {

    TableView<Can> cansTableView;
    @FXML
    TableColumn<Can, String> brandNameColumn;
    @FXML
    TableColumn<Can, Integer> volumeColumn;
    @FXML
    TextField brandNameTextField;
    @FXML
    Slider volumeSlider;
    @FXML
    Label error;
    @FXML

    private static ObservableList<Can> allBrands = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        brandNameColumn.setCellValueFactory(new PropertyValueFactory<Can, String>("brandName"));
        volumeColumn.setCellValueFactory(new PropertyValueFactory<Can, Integer>("Ml"));
        loadData();
    }

    /**
     * Question 4 - add a TableView object to the view that can store Can
     * objects. Setup the controller to add a collection of at least 5 Can
     * objects to the TableView (3 marks)
     */
    private void loadData() {
        Can can_1 = new Can("Pepsi", 200);
        Can can_2 = new Can("Coke", 750);
        Can can_3 = new Can("Limca", 500);
        Can can_4 = new Can("Frooti", 1250);
        Can can_5 = new Can("Maaza", 2000);
        allBrands.add(can_1);
        allBrands.add(can_2);
        allBrands.add(can_3);
        allBrands.add(can_4);
        allBrands.add(can_5);
        cansTableView.getItems().addAll(allBrands);
    }

    /**
     * Question 5 - each time the "create new Can" button is pushed, the new can
     * should be added to the table (2 marks)
     */
    public void createInstance(ActionEvent event) {
        try {
            String bName = brandNameTextField.getText().toString();
            int mlValue = Integer.parseInt(String.valueOf(volumeSlider.getValue()));
            Can newCan = new Can(bName, mlValue);
            allBrands.add(newCan);
            cansTableView.setItems(allBrands);
            System.out.println("New Can Created");
            System.out.println("Brand : " + bName);
            System.out.println("Volume : " + mlValue + " ml.");
        } catch (Exception ex) {
            error.setText(ex.toString());
        }
    }

    /**
     * Question 6 - using a lambda expression, sort the collection of Can
     * objects from largest can to smallest based on ml. Add a button to the
     * view to trigger this to happen.(3 marks)
     */
    public void sortTableData(ActionEvent event) {
        ObservableList<Can> sortedList = FXCollections.observableArrayList(allBrands.stream().sorted(Comparator.comparing(Can::getMl).reversed()).collect(Collectors.toList()));
        cansTableView.setItems(sortedList);
    }

    /**
     * Question 7 - add a button to the scene, when it is pushed, use a stream
     * to filter the collection for Can objects with more than 500 ml. The
     * TableView should be updated to only show cans over 500ml. (3 marks)
     */
    public void filterTableData(ActionEvent event) {

        ObservableList<Can> filteredList = FXCollections.observableArrayList(allBrands.stream().filter(can -> can.getMl() > 500).collect(Collectors.toList()));
        cansTableView.setItems(filteredList);
    }

    /*
     * Question 8 - add another button to the scene, that restores the TableView to show all
     *              the cans. (2 marks)
     */
    public void restoreData(ActionEvent event) {
        cansTableView.setItems(allBrands);
    }
}
