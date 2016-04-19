package Core;

import FAT8.BootSector;
import FAT8.Directory;
import FAT8.FAT;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by carli on 17/04/2016.
 */
public class DeleteFileController implements Initializable {

    @FXML
    TextField filenameField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML private void deleteFile(){
        String fileName = filenameField.getText();
        String filefirstCluster = null;
        String size = "";

        int count = 0;
        for (Directory file : DirectoryController.directories) {
                if (file.getDIR_Name().equals(fileName)){
                    filefirstCluster = file.getDIR_FstClusHI();
                    size = file.getDIR_FileSize();
                    DirectoryController.directories.remove(count);
                    break;
                }
            count++;
        }
        String lastcluster = filefirstCluster;
        String currentcluster;
        for (FAT fat : FileAllocationTableController.allocations) {
            currentcluster = fat.getClusterNumber();
            if (currentcluster.equals(lastcluster)){
                lastcluster = fat.getCluster();
                if (fat.getCluster().equals("0xFFF")){
                    fat.setCluster("0x000");
                    break;
                }
                fat.setCluster("0x000");
            }

        }
        long sizeFile = Long.parseLong(size);
        sizeFile = sizeFile/ BootSector.getBPB_SecPerClus();
        BootSector.setBPB_FreeClus(BootSector.getBPB_FreeClus()+sizeFile);

    }

}
