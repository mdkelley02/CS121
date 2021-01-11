import javax.swing.*;

public class BookButton extends JButton
//@author Matthew Kelley
//each button represents a book inside of our book list CSV
//when you click the button it will update the ReaderPanel with
//the books respective information.
{
    private final int MAX_TEXT_LENGTH = 25;
    private final String ELLIPSES = "...";
    private Book book;

    public BookButton(Book book)
    {
        this.book = book;
        this.setTitleText();

    }

    public Book getBook()
    {
        return this.book;
    }

    private void setTitleText()
    {
        this.setText(this.book.getTitle());
    }

}
