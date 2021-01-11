import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReaderOfBooksPanel extends JPanel {
    //@author Matthew Kelley
    //This is the organizational class that holds
    //and adds both the LibraryPanel and ReaderPanel
    // as well has the BookButtonListener inside of it
    //simply for the fact that it manipulates the ReaderPanel
    private LibraryPanel libraryPanel;
    private ReaderPanel readerPanel;

    public ReaderOfBooksPanel()
    {
        setLayout(new BorderLayout());

        libraryPanel = new LibraryPanel(new BookButtonListener());
        readerPanel = new ReaderPanel();
        add(libraryPanel, BorderLayout.WEST);
        add(readerPanel, BorderLayout.CENTER);


    }

    public class BookButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            BookButton bb = (BookButton)e.getSource();
            Book b = bb.getBook();
            readerPanel.loadBook(b);
        }
    }

}