import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
//@MatthewKelley

public class Library implements LibraryInterface
    //@author Matthew Kelley
    //Library managaes book objects
{
    public ArrayList<Book> listOfBooks = new ArrayList<Book>();

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
            books += b.toString() + "\n";
        }
        return books;
    }

    @Override
    public void loadLibraryFromCSV(String csvFilename)
    {
        this.listOfBooks.clear();

        File f = new File("/home/MATTHEWKELLEY384/CS121/p4/"+csvFilename);
//        File f = new File("/Users/matthewkelley/Desktop/CS121/Project4/src/etext/booklist-full.csv");
        try{
            Scanner s = new Scanner(f);
            while(s.hasNextLine())
            {
                String thisLine = s.nextLine();
                String[] fields = thisLine.split(",");
                Book b = new Book(fields[0], fields[1], fields[2], fields[3]);
                this.listOfBooks.add(b);
            }
            s.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println(e);
        }


    }


}
