package Core;

import FAT8.BootSector;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    @FXML
    TextField unitSize,sectorPerCluster;
    @FXML
    Button FormatButton;
    @FXML
    ChoiceBox<String> typeOfUnit;

    //Variables and Constant
    private final int sector = 128; //bytes
    private long numSectores;
    private long numSectoresDisponibles;
    private long totalSize;
    private long totalClusters;
    private long clusterSize;
    private long FAT8Size;
    private long Directory;
    private long sectores_ocupados;
    private long Clusters_ocupados;
    public static long free_Clusters;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        typeOfUnit.getItems().addAll("Gb","Mb");
        typeOfUnit.getSelectionModel().selectFirst();
        BootSector.setBPB_BytsPerSec(sector);//>>>
    }

    @FXML
    private void format(){
        String size = unitSize.getText();
        String sectorsPerCluster = sectorPerCluster.getText();
        int sectorPCluster = Integer.parseInt(sectorsPerCluster); //Sectores por cluster
        BootSector.setBPB_SecPerClus(sectorPCluster);//>>>
        totalSize = Long.parseLong(size); //tamaño del dispositivo

        if (typeOfUnit.getValue() == "Gb"){
            totalSize = totalSize * 1073741824; //Gb to Bytes
        }else if (typeOfUnit.getValue() == "Mb"){
            totalSize = totalSize * 1048576; //Mb to Bytes
        }
        numSectores = totalSize/sector; //Numero de Sectores totales
        BootSector.setBPB_TotSec(numSectores);//>>>

        totalClusters = numSectores/sectorPCluster; //Numero total de clusters
        BootSector.setBPB_TotClus(totalClusters);//>>>>

        FAT8Size = totalClusters/sector; //Tamaño que ocupa del FAT8 en sectores
        BootSector.setBPB_FATSz8(FAT8Size);//>>>

        Directory = (totalClusters*24)/sector; //Tamaño del directorio en sectores
        BootSector.setBPB_DirecSz8(Directory);

        sectores_ocupados = 1 + FAT8Size + Directory; //sectores ocupados

        Clusters_ocupados = sectores_ocupados/sectorPCluster; //Clusters ocupados
        BootSector.setBPB_TaknClus(Clusters_ocupados);

        free_Clusters =totalClusters- Clusters_ocupados; //Clusters Disponibles
        BootSector.setBPB_FreeClus(free_Clusters);

        clusterSize = sector * sectorPCluster; //Tamañol de un cluster Bytes
        Stage stage = (Stage) FormatButton.getScene().getWindow();
        openNextWindow();
        stage.close();
    }

    private void openNextWindow(){
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ManagerUI.fxml"));
        Parent root = null;
        try {
            root = (Parent) loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileController controller = loader.getController();
        Scene scene = new Scene(root);
        controller.setStage(stage);
        stage.setScene(scene);
        stage.show();
    }


}
