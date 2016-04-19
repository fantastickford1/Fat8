package Core;

import FAT8.BootSector;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by carli on 16/04/2016.
 */
public class BootSectorController implements Initializable {

    @FXML
    TextField bytesPerSecField,secPerClusField,totalSecField,filSysTypeField,fatsizeField,DirectorySzField,freeClusterField,taknClusField,totalClusField;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        bytesPerSecField.setEditable(false);
        secPerClusField.setEditable(false);
        totalSecField.setEditable(false);
        filSysTypeField.setEditable(false);
        fatsizeField.setEditable(false);
        DirectorySzField.setEditable(false);
        freeClusterField.setEditable(false);
        taknClusField.setEditable(false);
        totalClusField.setEditable(false);

        bytesPerSecField.setText(BootSector.getBPB_BytsPerSec()+"");
        secPerClusField.setText(BootSector.getBPB_SecPerClus()+"");
        totalSecField.setText(BootSector.getBPB_TotSec()+"");
        filSysTypeField.setText(BootSector.getBS_FilSysType());
        fatsizeField.setText(BootSector.getBPB_FATSz8()+"");
        DirectorySzField.setText(BootSector.getBPB_DirecSz8()+"");
        freeClusterField.setText(BootSector.getBPB_FreeClus()+"");
        taknClusField.setText(BootSector.getBPB_TaknClus()+"");
        totalClusField.setText(BootSector.getBPB_TotClus()+"");

    }


}
