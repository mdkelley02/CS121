import javax.swing.*;
import java.awt.*;

public class ReaderPanel extends JPanel
    //@author Matthew Kelley
    //ReaderPanel is JPanel that holds the author and title
    //text and also the actual pane that holds the text of the book
    //these panes are updated by the ActionListener on the BookButton
{
    private JPanel infoPanel;
    private JLabel titleLabel;
    private JLabel authorLabel;
    private JTextArea bookTextArea;
    private JScrollPane bookTextScrollPane;

    public ReaderPanel(){
        setLayout(new BorderLayout());


        this.infoPanel = new JPanel();
        this.titleLabel = new JLabel("Title: ");

        this.authorLabel = new JLabel("Author: ");
        infoPanel.add(titleLabel);
        infoPanel.add(authorLabel);

        this.bookTextArea = new JTextArea();
        this.bookTextScrollPane = new JScrollPane(bookTextArea);
        this.bookTextScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.bookTextScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        this.add(infoPanel, BorderLayout.NORTH);
        this.add(bookTextScrollPane, BorderLayout.CENTER);

    }

    public void loadBook(Book b)
    {
        this.titleLabel.setText("Title: " + b.getTitle());
        this.authorLabel.setText("Author: " + b.getAuthor());
        this.bookTextArea.setText(b.getText());
    }
}
