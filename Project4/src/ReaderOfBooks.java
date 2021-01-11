import javax.swing.JFrame;
import java.awt.*;

public class ReaderOfBooks {
    //@author Matthew Kelley
    //class holds the the JFrame and is the main driver entrypoint
    //for the entire application.
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Reader Of Books");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ReaderOfBooksPanel panel = new ReaderOfBooksPanel();
        frame.getContentPane().add(panel);
        frame.setMinimumSize(new Dimension(600, 400));

        frame.pack();
        frame.setVisible(true);

    }

}
