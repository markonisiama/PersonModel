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


        ArrayList<String> people = new ArrayList<>();
        boolean done = false;
        Scanner in = new Scanner(System.in);
//        a.	ID (a String)
//        b.	FirstName
//        c.	LastName
//        d.	Title (a string like Mr., Mrs., Ms., Dr., etc.)
//        e.	YearOfBirth (an int)
        //Declarations
        String personRecord = "";
        String iD = "";
        String firstName = "";
        String lastName = "";
        String title = "";
        int yearOfBirth = 0;

        do
        {
            iD = SafeInput.getNonZeroLenString(in, "Enter the ID number [6 digits]");
            firstName = SafeInput.getNonZeroLenString(in, "Enter the first name");
            lastName = SafeInput.getNonZeroLenString(in, "Enter the last name");
            title = SafeInput.getNonZeroLenString(in, "Enter the title");
            yearOfBirth = SafeInput.getRangedInt(in, "Enter the year of birth", 1000, 9999);

            personRecord = iD + ", " + firstName + ", " + lastName + ", " + title + ", " + yearOfBirth;

            people.add(personRecord);

            done = SafeInput.getYNConfirm(in, "Are you done?");

        }
        while(!done);

        fileName = SafeInput.getNonZeroLenString(in, "Enter what name do you want the new record file to have");
        Path file = Paths.get(workingDirectory.getPath() + "\\" + fileName + ".txt");


        for (String p: people)
            System.out.println(p);
        try
        {
            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));

            for(String rec : people)
            {
                writer.write(rec, 0, rec.length());
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
