import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class PersonGenerator
{

    public static void main(String[] args)
    {
        File workingDirectory = new File(System.getProperty("user.dir"));
        String fileName = "";


        ArrayList<Person> people = new ArrayList<>();
        boolean done = false;
        Scanner in = new Scanner(System.in);
//        a.	ID (a String)
//        b.	FirstName
//        c.	LastName
//        d.	Title (a string like Mr., Mrs., Ms., Dr., etc.)
//        e.	YearOfBirth (an int)
        //Declarations
        String personRecord = "";
        String firstName = "";
        String lastName = "";
        String title = "";
        String record = "";
        int yearOfBirth = 0;


        do
        {
            firstName = SafeInput.getNonZeroLenString(in, "Enter the first name");
            lastName = SafeInput.getNonZeroLenString(in, "Enter the last name");
            title = SafeInput.getNonZeroLenString(in, "Enter the title");
            yearOfBirth = SafeInput.getRangedInt(in, "Enter the year of birth", 1000, 9999);

            Person individualPerson= new Person(firstName, lastName, title, yearOfBirth);

            people.add(individualPerson);

            done = SafeInput.getYNConfirm(in, "Are you done?");

        }
        while(!done);

        fileName = SafeInput.getNonZeroLenString(in, "Enter what name do you want the new record file to have");
        System.out.println();
        Path file = Paths.get(workingDirectory.getPath() + "\\" + fileName + ".txt");


        for (Person p: people)
        {
            System.out.println("Record: " + p.getiD());
            System.out.println("Full Name: ");
            System.out.println(p.fullName());
            System.out.println();
            System.out.println("Formal Name: ");
            System.out.println(p.formalName());
            System.out.println();
            System.out.println("Age: ");
            System.out.println(p.getAge());
            System.out.println(p.getAge(2008));
            System.out.println();

        }


        try
        {
            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));

            for(Person p : people)
            {
                record = p.toCVSDataRecord();
                writer.write(record, 0, record.length());
                writer.newLine();

            }
            writer.close();
            System.out.println("Data file written!");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}
