import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Lesson 13: Activity - GradeBook
 *
 * @author CS121 Instructors
 * @version [semester]
 * @author [your name]
 */
public class GradeBook {

    public static void main(String[] args) {
        /* TODO: 1. Create a new ArrayList of Student objects called gradebook. */
        ArrayList<Student> gradebook = new ArrayList<Student>();
        /* TODO: 2. Create a new File object for gradebook.csv and
         * a new Scanner object to parse it. Catch any required
         * exceptions and display a useful message to the user.
         */
        String path = "/Users/matthewkelley/Desktop/CS121/Activity13/src/gradebook.csv";
        File gradeBookFile = new File(path);
        /* TODO: 3. Use a while loop and the Scanner created above to iterate
         * through the lines in the gradebook.csv file.
         */
        String[] studentParseArray;
        try
        {
            Scanner scanner = new Scanner(gradeBookFile);
            while(scanner.hasNextLine())
            {
                String student = scanner.next();
                System.out.println("Processing student record -> " + student);
                studentParseArray = student.split(",");

                String firstName = studentParseArray[1];
                String lastName = studentParseArray[0];
                int id = Integer.parseInt(studentParseArray[2]);
                int grade = Integer.parseInt(studentParseArray[3]);

                Student studentLine = new Student(firstName, lastName, id);
                studentLine.setGrade(grade);
                gradebook.add(studentLine);


            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        /* TODO: 4. For each line (student record), use a second
         * Scanner object to tokenize the line using a comma (',')
         * as the delimiter, extract values for lastName, firstName,
         * id and grade and store them to local variables.
         */


        /* TODO: 5. Create a new Student object using the local variables
         * create above, set the student's grade, and finally add the
         * new Student object to the gradebook ArrayList.
         */



        /* TODO: 6. Use a foreach loop to print out contents of the gradebook */
        System.out.println();
        for(Student student: gradebook)
        {
            System.out.println(student);
        }


    }

}
