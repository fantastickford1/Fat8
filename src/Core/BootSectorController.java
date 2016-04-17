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
    TextField bytesPerSecField,secPerClusField,totalSecField,filSysTypeField,fatsizeField;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        bytesPerSecField.setEditable(false);
        secPerClusField.setEditable(false);
        totalSecField.setEditable(false);
        filSysTypeField.setEditable(false);
        fatsizeField.setEditable(false);

        bytesPerSecField.setText(BootSector.getBPB_BytsPerSec()+"");
        secPerClusField.setText(BootSector.getBPB_SecPerClus()+"");
        totalSecField.setText(BootSector.getBPB_TotSec()+"");
        filSysTypeField.setText(BootSector.getBS_FilSysType());
        fatsizeField.setText(BootSector.getBPB_FATSz8()+"");

    }


}
