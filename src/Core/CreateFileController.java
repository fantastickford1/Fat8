package Core;

import FAT8.BootSector;
import FAT8.Directory;
import FAT8.FAT;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by carli on 17/04/2016.
 */
public class CreateFileController implements Initializable {

    @FXML
    TextField fileNameField,fileSizeField;
    @FXML
    ChoiceBox<String> typeOfFile,sizeType;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        typeOfFile.getItems().addAll(
                "Archive","Directory"
        );
        typeOfFile.getSelectionModel().selectFirst();
        sizeType.getItems().addAll(
                "Bytes","Kb","Mb","Gb"
        );
        sizeType.getSelectionModel().selectFirst();

    }

    @FXML
    private void createFile(){
        String fileName = fileNameField.getText();
        String type = typeOfFile.getValue();
        String fileSize = fileSizeField.getText();
        String typeFile = sizeType.getValue();
        long clusters = 0;
        if (type == "Directory"){
            Directory newFile = new Directory(fileName,type,"now","now","null","0");
            Controller.directories.add(newFile);
        }else {
            long size = Long.parseLong(fileSize);
            switch (typeFile) {
                case "Bytes":
                    break;
                case "Kb":
                    size = size * 1024;
                    break;
                case "Mb":
                    size = size * 1048576;
                    break;
                case "Gb":
                    size = size * 1073741824;
                    break;
                default:
                    //code..
                    break;
            }
            clusters = size / BootSector.getBPB_SecPerClus();
            if (clusters < BootSector.getBPB_FreeClus()){
                BootSector.setBPB_FreeClus(BootSector.getBPB_FreeClus() - clusters); //>>Actual free clusters
                BootSector.setBPB_TaknClus(BootSector.getBPB_TaknClus() + clusters); //>>Actual taken clusters
                String clusterNumber;
                for (FAT fat : Controller.allocations) {
                    clusterNumber = fat.getClusterNumber();
                    String cluster = fat.getCluster();
                    if (cluster == "0x000") {
                        Directory newFile = new Directory(fileName, type, "now", "now", clusterNumber, size + "");
                        Controller.directories.add(newFile);
                        break;
                    }
                }
                int auxcout = 0;
                for (FAT fat : Controller.allocations) {

                    String clusterN = fat.getClusterNumber();
                    String clust = fat.getCluster();
                    long numberC = Long.parseLong(clusterN);
                    numberC++;
                    if (clust == "0x000") {
                        auxcout++;
                        if (auxcout == clusters) {
                            fat.setCluster("0xFFF");
                            break;
                        } else
                            fat.setCluster(numberC + "");
                    }
                }
            }else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText("Can't save the file");
                alert.setContentText("The file is higher than the memory");
                alert.showAndWait();
            }

        }


    }
}
