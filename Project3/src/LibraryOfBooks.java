import java.util.Scanner;

//@MatthewKelley
public class LibraryOfBooks
{

    public static void main(String[] args)
    {

        System.out.println("************************");
        System.out.println("*     Library Menu     *");
        System.out.println("************************");
        System.out.println("(R)ead book in library");
        System.out.println("(A)dd book to library");
        System.out.println("(D)elete a book from library");
        System.out.println("(P)rint library content");
        System.out.println("(R)ead a book in library");
        System.out.println("(Q)uit");
        System.out.println("\nPlease enter a command (press \"m\" for menu)");

        Scanner s = new Scanner(System.in);
        Scanner consoleInput = new Scanner(System.in);
        String input = "";
        Library library = new Library();


        while( !input.equals("Q") )
        {
            input = s.next();
            switch (input.toUpperCase())
            {
                case "P":
                    int indexVal = 0;
                    for (Book b: library.getBooks())
                    {
                        System.out.println("Index: " + indexVal + ", " + b.toString());
                        indexVal++;
                    }
                    break;
                case "D":
                    System.out.println("which book would you like to delete?");
                    int index = consoleInput.nextInt();
                    library.removeBook(index);
                    System.out.println("book has been removed");
                    break;
                case "A":
                    System.out.println("Enter book title: ");
                    String title = consoleInput.nextLine();
                    System.out.println("Enter book author: ");
                    String author = consoleInput.nextLine();
                    System.out.println("Enter book genre: ");
                    String genre = consoleInput.nextLine();
                    System.out.println("Enter book filename: ");
                    String filename = consoleInput.nextLine();
                    library.addBook(new Book(title, author, genre, filename));
                    break;
                case "R":
                    System.out.println("Enter index of book you'd like to read: ");
                    int indexinput = consoleInput.nextInt();
                    System.out.println(library.getBooks().get(indexinput).getText());

                    break;
                case "Q":
                    System.out.println("Goodbye!");
                    break;
                case "M":
                    System.out.println("************************");
                    System.out.println("*     Library Menu     *");
                    System.out.println("************************");
                    System.out.println("(R)ead book in library");
                    System.out.println("(A)dd book to library");
                    System.out.println("(D)elete a book from library");
                    System.out.println("(P)rint library content");
                    System.out.println("(R)ead a book in library");
                    System.out.println("(Q)uit");
                    break;
                default:
                    System.out.println("Invalid selection!");
            }

            if(!input.equals("Q"))
            {
                System.out.println("\nPlease enter a command (press \"M\" for menu): ");
                input = s.nextLine();

            }


        }
        s.close();
        consoleInput.close();
    }


}

