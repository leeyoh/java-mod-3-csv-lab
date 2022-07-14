import java.io.File;
import java.util.List;

public class Terminal {
    private static PersonDirectory pd;
    private static ScannerSingleton sc;
    private static LoggerSingleton log;
    private static FileManagerSingleton fm;

    private static String fileName = "list.csv";
    private static final String path = "data/";

    public static void main(String[] args) {
        initializeObjects();
        addPerson();
       // loadFile();
        //chooseOptions();
        if(sc != null) {
            sc.close();
        }
    }

    public static void initializeObjects(){
        pd = new PersonDirectory();
        sc = ScannerSingleton.getInstance();
        log = LoggerSingleton.getInstance();
        fm = FileManagerSingleton.getInstance();
    }

    public static void chooseOptions(){
        log.log(" [ 1 ] Add a person to the list");
        log.log(" [ 2 ] Print a list of current persons");
        log.log(" [ 3 ] Exit the program");
        log.prompt(":");
        switch(sc.getInt(3)){
            case 1:
                //Add Person to List
                break;
            case 2:
                //List the current list of people, old + new
                break;
            case 3:
                //Append List to file then close program
                break;
            default:
                chooseOptions();
                break;
        }
    }
    /**
     * First Name ( String )
     * Last Name
     * Birth Year
     * Birth Month
     * Birth Day
     */
    public static void addPerson(){
        String firstName,lastName,year,month,day;

        log.prompt("First Name: ");
        firstName = sc.getNextLine();

        log.prompt("Last Name: ");
        lastName = sc.getNextLine();

        log.log("BirthDay");
        log.prompt("Year: ");
        year = String.valueOf(sc.getInt(9999));

        log.prompt("Month: ");
        month = sc.getMonth();

        log.prompt("Day: ");
        day = sc.getNextLine();

    }
    public static void loadPersonal(){
        try{
            pd.loadDirectory(path + fileName);
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public static void appendToList(){

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
                loadPersonal();
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
