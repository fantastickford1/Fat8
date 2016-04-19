package FAT8;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by carli on 15/04/2016.
 */
public class Directory {

    private StringProperty DIR_Name; //>> 11B
    private StringProperty DIR_Attr; //DIRECTORY 0x10, ARCHIVE 0x20 >>1B
    private StringProperty DIR_NTRes; //Default 0 value >>1B
    private StringProperty DIR_CrtTime; //Tiempo de creacion >>3B
    private StringProperty DIR_CrtDate; //Fecha de creacion >>2B
    private StringProperty DIR_FstClusHI; //Primer numero de cluster en el inicia el archivo >>2B
    private StringProperty DIR_FileSize; //Tamaño del archivo >>4B

    public Directory(String fileName, String type, String time, String date, String firstCluster, String fileSize){
        this.DIR_Name = new SimpleStringProperty(fileName);
        this.DIR_Attr = new SimpleStringProperty(type);
        this.DIR_NTRes = new SimpleStringProperty(0+"");
        this.DIR_CrtTime = new SimpleStringProperty(time);
        this.DIR_CrtDate = new SimpleStringProperty(date);
        this.DIR_FstClusHI = new SimpleStringProperty(firstCluster);
        this.DIR_FileSize = new SimpleStringProperty(fileSize);
    }

    public Directory(){
        this.DIR_Name = null;
        this.DIR_Attr = null;
        this.DIR_NTRes = new SimpleStringProperty(0+"");
        this.DIR_CrtTime = null;
        this.DIR_CrtDate = null;
        this.DIR_FstClusHI = null;
        this.DIR_FileSize = null;
    }

    public void setDIR_Name(String DIR_Name) {
        if (this.DIR_Name != null)
            this.DIR_Name.set(DIR_Name);
        else
            this.DIR_Name = new SimpleStringProperty(DIR_Name);
    }

    public void setDIR_Attr(String DIR_Attr) {
        if (this.DIR_Attr != null)
            this.DIR_Attr.set(DIR_Attr);
        else
            this.DIR_Attr = new SimpleStringProperty(DIR_Attr);
    }

    public void setDIR_CrtTime(String DIR_CrtTime) {
        if (this.DIR_CrtTime != null)
            this.DIR_CrtTime.set(DIR_CrtTime);
        else
            this.DIR_CrtTime = new SimpleStringProperty(DIR_CrtTime);
    }

    public void setDIR_CrtDate(String DIR_CrtDate) {
        if (this.DIR_CrtDate != null)
            this.DIR_CrtDate.set(DIR_CrtDate);
        else
            this.DIR_CrtDate = new SimpleStringProperty(DIR_CrtDate);
    }

    public void setDIR_FstClusHI(int DIR_FstClusHI) {
        if (this.DIR_FstClusHI != null)
            this.DIR_FstClusHI.set(DIR_FstClusHI+"");
        else
            this.DIR_FstClusHI = new SimpleStringProperty(DIR_FstClusHI+"");
    }

    public void setDIR_FileSize(int DIR_FileSize) {
        if (this.DIR_FileSize != null)
            this.DIR_FileSize.set(DIR_FileSize+"");
        else
            this.DIR_FileSize = new SimpleStringProperty(DIR_FileSize+"");
    }

    public String getDIR_Name() {
        return DIR_Name.get();
    }

    public String getDIR_Attr() {
        return DIR_Attr.get();
    }

    public String getDIR_NTRes() {
        return DIR_NTRes.get();
    }

    public String getDIR_CrtTime() {
        return DIR_CrtTime.get();
    }

    public String getDIR_CrtDate() {
        return DIR_CrtDate.get();
    }

    public String getDIR_FstClusHI() {
        return DIR_FstClusHI.get();
    }

    public String getDIR_FileSize() {
        return DIR_FileSize.get();
    }

    public StringProperty DIR_NameProperty() {
        return DIR_Name;
    }

    public StringProperty DIR_AttrProperty() {
        return DIR_Attr;
    }

    public StringProperty DIR_NTResProperty() {
        return DIR_NTRes;
    }

    public StringProperty DIR_CrtTimeProperty() {
        return DIR_CrtTime;
    }

    public StringProperty DIR_CrtDateProperty() {
        return DIR_CrtDate;
    }

    public StringProperty DIR_FstClusHIProperty() {
        return DIR_FstClusHI;
    }

    public StringProperty DIR_FileSizeProperty() {
        return DIR_FileSize;
    }
}
