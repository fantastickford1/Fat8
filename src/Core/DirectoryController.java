package Core;

import FAT8.Directory;
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
public class DirectoryController implements Initializable{

    @FXML
    TableView<Directory> dirTable;

    @FXML
    TableColumn<Directory,String> nameCol,ArrtCol,NTResCol,timeCol,dateCol,fstClusterCol,fileSizeCol;




    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nameCol.setCellValueFactory(cell -> cell.getValue().DIR_NameProperty());
        ArrtCol.setCellValueFactory(cell -> cell.getValue().DIR_AttrProperty());
        NTResCol.setCellValueFactory(cell -> cell.getValue().DIR_NTResProperty());
        timeCol.setCellValueFactory(cell -> cell.getValue().DIR_CrtTimeProperty());
        dateCol.setCellValueFactory(cell -> cell.getValue().DIR_CrtDateProperty());
        fstClusterCol.setCellValueFactory(cell -> cell.getValue().DIR_FstClusHIProperty());
        fileSizeCol.setCellValueFactory(cell -> cell.getValue().DIR_FileSizeProperty());

        dirTable.setItems(Controller.directories);
    }



}
