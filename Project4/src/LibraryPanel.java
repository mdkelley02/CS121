import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LibraryPanel extends JPanel
    //@author Matthew Kelley
    //Library class is a JPanel that holds the
    //panel to import the book CSVs and as well
    //creates the book buttons themselves.
{
    private Library library = new Library();
    private ActionListener BookButtonListener;
    private JPanel bookListPanel;
    private JScrollPane bookListScrollPane;
    private JPanel importPanel;
    private JTextField importTextField;
    private JButton importButton;


    public LibraryPanel(ActionListener listener)
    {
        this.BookButtonListener = listener;
        setLayout(new BorderLayout());

        this.bookListPanel = new JPanel();

        this.bookListScrollPane = new JScrollPane(bookListPanel);
        bookListScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        bookListScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        bookListPanel.setLayout(new BoxLayout(bookListPanel, BoxLayout.Y_AXIS));
        this.importPanel = new JPanel();
        this.importTextField = new JTextField(15);
        this.importButton = new JButton("load book");
        this.importButton.addActionListener(new ImportActionListener());
        importPanel.add(importTextField, BorderLayout.CENTER);
        importPanel.add(importButton, BorderLayout.SOUTH);

        add(bookListScrollPane, BorderLayout.CENTER);
        add(importPanel, BorderLayout.SOUTH);


    }


    private class ImportActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            bookListPanel.removeAll();
            String csvFilename = importTextField.getText();
            library.loadLibraryFromCSV(csvFilename);
            for(Book b: library.listOfBooks)
            {
                JButton bookButton = new BookButton(b);
                bookButton.addActionListener(BookButtonListener);
                bookListPanel.add(bookButton);
                revalidate();

            }

        }
    }
}
