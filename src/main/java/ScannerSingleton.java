import java.util.Scanner;

public class ScannerSingleton {
    private static ScannerSingleton scan = null;
    private Scanner scanner;

    private ScannerSingleton(){
        scanner = new Scanner(System.in);
    }

    public static ScannerSingleton getInstance(){
        if(scan == null){
            scan = new ScannerSingleton();
        }
        return scan;
    }

    public String getNextLine(){
        return scanner.nextLine();
    }
    public int getInt(int limit){
        int choice = scanner.nextInt();
        if(choice < 1 || choice > limit){
            return 0;
        }
        return choice;
    }
}
