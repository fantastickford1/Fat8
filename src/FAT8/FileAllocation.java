package FAT8;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by carli on 16/04/2016.
 */
public class FileAllocation {

    private StringProperty ClusterNumber;
    private StringProperty Cluster;

    public FileAllocation(){
        this.ClusterNumber = null;
        this.Cluster = null;
    }

    public FileAllocation(String number, String cluster){
        this.ClusterNumber = new SimpleStringProperty(number);
        this.Cluster = new SimpleStringProperty(cluster);
    }

    public void setClusterNumber(String clusterNumber) {
        if (this.ClusterNumber != null)
            this.ClusterNumber.set(clusterNumber);
        else
            this.ClusterNumber = new SimpleStringProperty(clusterNumber);

    }

    public void setCluster(String cluster) {
        if (this.Cluster != null)
            this.Cluster.set(cluster);
        else
            this.Cluster = new SimpleStringProperty(cluster);

    }

    public String getCluster() {
        return Cluster.get();
    }

    public String getClusterNumber() {
        return ClusterNumber.get();
    }

    public StringProperty clusterNumberProperty() {
        return ClusterNumber;
    }

    public StringProperty clusterProperty() {
        return Cluster;
    }
}
