import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonDirectory {
    private List<Person> personalList = new ArrayList<Person>();
    private List<Person> oldList = new ArrayList<Person>();
    private List<Person> newList = new ArrayList<Person>();
    private FileManagerSingleton fm;

    void PersonDirectory(){
        fm = FileManagerSingleton.getInstance();
    }

    public void loadDirectory(String fileName) throws IOException {
        try{
            List<String> tempList = new ArrayList<String>();
            fm.readFromFile(fileName);
            System.out.println(tempList);
        }catch(Exception e){
            throw e;
        }
    }

    public void addPerson(String firstName, String lastName, int birthYear, int birthMonth, int birthDay){
        personalList.add(new Person(firstName,lastName,birthYear,birthMonth,birthDay));
    }

    public void addPerson(String personCSV) {
        personalList.add(new Person(personCSV));
    }


}
