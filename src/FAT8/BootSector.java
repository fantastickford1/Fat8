package FAT8;

/**
 * Created by carli on 15/04/2016.
 */
public class BootSector {

    private static int BPB_BytsPerSec; //Bytes per Sector
    private static int BPB_SecPerClus; //The legal values are 1, 2, 4, 8, 16, 32, 64, and 128.
    private static long BPB_TotSec; //Total Sectors
    private static final String BS_FilSysType = "FAT8"; //FAT8
    private static long BPB_FATSz8; //This field is the FAT8 count of sectors occupied by one FAT.

    public static void setBPB_BytsPerSec(int BPB_BytsPerSec) {
        BootSector.BPB_BytsPerSec = BPB_BytsPerSec;
    }

    public static void setBPB_SecPerClus(int BPB_SecPerClus) {
        BootSector.BPB_SecPerClus = BPB_SecPerClus;
    }

    public static void setBPB_TotSec(long BPB_TotSec) {
        BootSector.BPB_TotSec = BPB_TotSec;
    }

    public static void setBPB_FATSz8(long BPB_FATSz8) {
        BootSector.BPB_FATSz8 = BPB_FATSz8;
    }

    public static int getBPB_BytsPerSec() {
        return BPB_BytsPerSec;
    }

    public static int getBPB_SecPerClus() {
        return BPB_SecPerClus;
    }

    public static long getBPB_TotSec() {
        return BPB_TotSec;
    }

    public static String getBS_FilSysType() {
        return BS_FilSysType;
    }

    public static long getBPB_FATSz8() {
        return BPB_FATSz8;
    }
}
