import java.security.PublicKey;
import java.util.Calendar;

public class Person {

    private String iD = "";
    private String firstName = "";
    private String lastName = "";
    private String title = "";
    private int yearOfBirth = 0;

    static private int iDSeed = 1;

    public static void setiDSeed(int idSeed) {
        Person.iDSeed = idSeed;
    }

    public Person(String iD, String firstName, String lastName, String title, int yearOfBirth) {
        this.iD = iD;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.yearOfBirth = yearOfBirth;
    }

    public Person(String firstName, String lastName, String title, int yearOfBirth) {
        this.iD = this.geniDNum();
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.yearOfBirth = yearOfBirth;
    }

    private String geniDNum() {
        String newId = "" + iDSeed;
        while(newId.length() < 8)
        {
            newId = "0" + newId;
        }
        iDSeed++;
        return newId;
    }

    public String getiD() {
        return iD;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public static int getiDSeed() {
        return iDSeed;
    }

    public String fullName(){
        String fullName = this.firstName + " " + this.lastName;
        return fullName;
    }

    public String formalName(){
        String formalName = this.title + " " + fullName();
        return formalName;
    }
    public String getAge(){
        String age = "";
        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);
        age = Integer.toString(currentYear - this.yearOfBirth);
        return age;
    }

    public String getAge(int year){
        String age = "";
        Calendar calendar = Calendar.getInstance();
        age = Integer.toString(year - this.yearOfBirth);
        return age;
    }

    public String toCVSDataRecord(){
        String dataLine = "";
        dataLine = getiD() + ", " + getFirstName() + ", " + getLastName() + ", " + getTitle() + ", " + getYearOfBirth();
        return dataLine;
    }

}
