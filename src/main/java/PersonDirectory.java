import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonDirectory {
    private List<Person> personalList = new ArrayList<Person>();
    private List<Person> oldList = new ArrayList<Person>();

    private FileManagerSingleton fm;

    public PersonDirectory(){
        fm = FileManagerSingleton.getInstance();
    }
    public void saveToFile(String fileName){
        StringBuffer persons = new StringBuffer();
        personalList.forEach((person) ->{
            persons.append(person.formatAsCSV());
            persons.append("\n");
        });
        fm.appendToFile(fileName,persons);
    }
    public void printDirectory(){
        oldList.forEach((person) ->{
            System.out.println(person);
        });
        personalList.forEach((person) ->{
            System.out.println(person);
        });
    }
    public void loadDirectory(String fileName) throws IOException {
        try{
            List<String> tempList = new ArrayList<String>();
            tempList = fm.readFromFile(fileName);
            tempList.forEach((csvPerson) -> {
                oldList.add(new Person(csvPerson));
            });
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
