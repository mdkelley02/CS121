import java.util.ArrayList;
//@MatthewKelley

public class Library implements LibraryInterface
{
    ArrayList<Book> listOfBooks = new ArrayList<Book>();

    public Library ()
    {
        this.listOfBooks = new ArrayList<Book>();
    }

    public ArrayList<Book> getBooks()
    {
        return new ArrayList<Book>(this.listOfBooks);
    }

    public void addBook(Book b)
    {
        listOfBooks.add(b);
    }

    public void removeBook(int i)
    {

        if ( i >= 0 && i < this.listOfBooks.size())
        {
            listOfBooks.remove(i);
        }

    }

    public Book getBook(int i)
    {

        if ( i < 0 || i >= this.listOfBooks.size())
        {
            return null;
        }
        else
        {
           return listOfBooks.get(i);
        }
    }

    public String toString()
    {
        String books = "";
        for (Book b: listOfBooks)
        {
            books += b.toString() + ", ";
        }
        return books;
    }
}
