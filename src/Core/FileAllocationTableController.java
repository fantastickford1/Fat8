package Core;

import FAT8.BootSector;
import FAT8.FAT;
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
    TableView<FAT> fileTable;

    @FXML
    TableColumn<FAT,String> ClusterNoCol,clusterCol;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ClusterNoCol.setCellValueFactory(cell -> cell.getValue().clusterNumberProperty());
        clusterCol.setCellValueFactory(cell -> cell.getValue().clusterProperty());



        fileTable.setItems(Controller.allocations);

    }
}
