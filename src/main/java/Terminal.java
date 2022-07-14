import java.io.File;
import java.util.List;

public class Terminal {
    private static PersonDirectory pd;
    private static ScannerSingleton sc;
    private static LoggerSingleton log;
    private static FileManagerSingleton fm;

    private static String fileName = "PersonalList.CSV";
    private static final String path = "data/";

    public static void main(String[] args) {
        initializeObjects();
        loadFile();
        chooseOptions();
    }

    public static void initializeObjects(){
        pd = new PersonDirectory();
        sc = ScannerSingleton.getInstance();
        log = LoggerSingleton.getInstance();
        fm = FileManagerSingleton.getInstance();
    }

    public static void chooseOptions(){
        log.log("1: Add a person to the list");
        log.log("2: Print a list of current persons");
        log.log("3: Exit the program");

        switch(sc.getInt(3)){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            default:
                chooseOptions();
                break;
        }
    }

    public static void loadFile(){
        try{
            log.log("Files in Directory:");
            List<String> files = fm.listFilesUsingJavaIO("data");
            if(files.isEmpty()){
                log.log("Created New File: " + fileName);
                fm.createFile(path + fileName);
            } else {
                fileName = files.get(0);
                log.log("Loaded " + fileName);
            }
        } catch(Exception e){
            System.out.println(e);
        }
    }

    public static void clearScreen(){
        final int MAX_LINES = 50;
        for(int i = 0; i < MAX_LINES; i++){
            log.log("-");
        }
    }
}
