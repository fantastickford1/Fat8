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
    private static long BPB_TotClus;
    private static long BPB_DirecSz8;
    private static long BPB_TaknClus;
    private static long BPB_FreeClus;

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

    public static void setBPB_TotClus(long BPB_TotClus) {
        BootSector.BPB_TotClus = BPB_TotClus;
    }

    public static void setBPB_DirecSz8(long BPB_DirecSz8) {
        BootSector.BPB_DirecSz8 = BPB_DirecSz8;
    }

    public static void setBPB_TaknClus(long BPB_TaknClus) {
        BootSector.BPB_TaknClus = BPB_TaknClus;
    }

    public static void setBPB_FreeClus(long BPB_FreeClus) {
        BootSector.BPB_FreeClus = BPB_FreeClus;
    }

    public static long getBPB_DirecSz8() {
        return BPB_DirecSz8;
    }

    public static long getBPB_FreeClus() {
        return BPB_FreeClus;
    }

    public static long getBPB_TaknClus() {
        return BPB_TaknClus;
    }

    public static long getBPB_TotClus() {
        return BPB_TotClus;
    }
}
