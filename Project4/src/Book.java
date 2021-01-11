import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;
//@MatthewKelley

public class Book implements BookInterface
    //@author Matthew Kelley
    //Book class creates a Book object, a book is a class
    //with attributes: Title, Author, Genre, Filename
    //essentially you can load a String which contains
    //the content of the book.
{
    private String title;
    private String author;
    private String genre;
    private String filename;

    public Book(String title, String author)
    {
        this.title = title;
        this.author = author;
        this.genre = null;
        this.filename = null;
    }

    public Book(String title, String author, String genre, String filename)
    {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.filename = filename;

    }

    public String getTitle()
    {
        return this.title;
    }

    public String getAuthor()
    {
        return this.author;
    }

    public String getGenre()
    {
        return this.genre;

    }

    public String getFilename()
    {
        return this.filename;
    }

    public void setTitle(String t)
    {
        this.title = t;
    }

    public void setAuthor(String a)
    {
        this.author = a;
    }

    public void setGenre(String g)
    {
        this.genre = g;
    }

    public void setFilename(String f)
    {
        this.filename = f;
    }

    public String toString()
    {
        return "Title: "+ this.title + ", Author: " + this.author +", Genre: " + this.genre + ", Filename: " + this.filename;
    }

    public boolean isValid()
    {
        if (this.genre != null && this.filename != null && this.author != null && this.title != null)
        {
            File f = new File("/Users/matthewkelley/Desktop/CS121/Project4/src/"+this.filename);
            if(f.exists() && f.isFile())
            {
                return true;
            }
            else
            {
                return false;
            }

        }
        else
        {

            return false;
        }
    }

    public String getText()
    {
        String content = "";
        File f = new File("/home/MATTHEWKELLEY384/CS121/p4/"+this.filename);
        try
        {
            Scanner fileScanner = new Scanner(f);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                content = content + line + "\n";
            }
            return content;
        }
        catch (FileNotFoundException e)
        {
            return "file not found";
        }

    }



}
