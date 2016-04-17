package Core;

import FAT8.FileAllocation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by carli on 16/04/2016.
 */
public class FileAllocationTableController implements Initializable {

    @FXML
    TableView<FileAllocation> fileTable;

    @FXML
    TableColumn<FileAllocation,String> ClusterNoCol,clusterCol;

    public static ObservableList<FileAllocation> allocations = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ClusterNoCol.setCellValueFactory(cell -> cell.getValue().clusterNumberProperty());
        clusterCol.setCellValueFactory(cell -> cell.getValue().clusterProperty());

        fileTable.setItems(allocations);
    }
}
