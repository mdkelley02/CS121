import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.util.HashSet;

public class JukeboxHero {
    /** Jukebox command line application for primitive analyzation of music via csv files.
     * @author Matthew Kelley
     */
    public static void main(String[] args)
    {
        /** Driver method for JukeBoxHero class, contains all logic for command line application
        */
        System.out.println("Welcome to Jukebox Hero,\n\tbringing order to playlists one song at a time...\n");
        System.out.println("************************");
        System.out.println("*     Program Menu     *");
        System.out.println("************************");
        System.out.println("(L)oad catalog");
        System.out.println("(S)earch catalog");
        System.out.println("(A)nalyze catalog");
        System.out.println("(P)rint catalog");
        System.out.println("(Q)uit");
        System.out.println("\nPlease enter a command (press \"m\" for menu)");

        ArrayList<Song> songList = new ArrayList<Song>();
        Scanner s = new Scanner(System.in);
        String input = "";
        ArrayList<Song> searchResults = new ArrayList<Song>();



        while( !input.equals("Q") )
        {
            input = s.next();
            switch (input.toUpperCase())
            {
                case "L":
                    songList.clear();
                    System.out.println("Load catalog...");
                    System.out.println("Please enter filename (jimmy_buffett-collection.csv or music-collection.csv): ");
                    String fileName = "/Users/matthewkelley/Desktop/CS121/Project2/src/"+ s.next();
                    File f = new File(fileName);
                    try
                    {
                        Scanner fileScanner = new Scanner(f);

                        while(fileScanner.hasNextLine())
                        {
                            String song = fileScanner.nextLine();
                            String[] parser = song.split(",");

                            String artist = parser[0];
                            String album = parser[1];
                            String title = parser[2];
                            int playTime = Integer.parseInt(parser[3]);

                            Song songLine = new Song(title, artist, album, playTime);
                            songList.add(songLine);
                        }
                    } catch (FileNotFoundException e){
                        System.out.println("Unable to open that file");
                    }
                    System.out.println("Song list contains " + songList.size() + " songs..." );
                    break;
                case "S":
                    System.out.println("Search catalog...");
                    System.out.println("Please enter search query: ");
                    String search = s.next();

                    for (Song song: songList)
                    {
                        if ( song.getTitle().toLowerCase().contains(search.toLowerCase()) )
                        {
                            searchResults.add(song);
                        }
                    }
                    System.out.println("Found " + searchResults.size() + " match(es)");

                    for (Song result: searchResults)
                    {
                        System.out.println(result.toString());
                    }
                    break;
                case "A":
                    System.out.println("Catalog Analysis...");
                    int playTime = 0;

                    ArrayList<String> artistsArray = new ArrayList<String>();
                    ArrayList<String> albumsArray = new ArrayList<String>();
                    ArrayList<String> songsArray = new ArrayList<String>();
                    for (Song song: songList)
                    {
                        artistsArray.add(song.getArtist());
                        albumsArray.add(song.getAlbum());
                        songsArray.add(song.getTitle());
                        playTime += song.getPlayTime();
                    }
                    HashSet<String> artistsSet = new HashSet(artistsArray);
                    HashSet<String> albumsSet = new HashSet(albumsArray);
                    HashSet<String> songsSet = new HashSet(songsArray);

                    System.out.println("Number of artists: "+artistsSet.size());
                    System.out.println("Number of Albums: "+albumsSet.size());
                    System.out.println("Number of Songs: "+songsSet.size());
                    System.out.println("Catalog Playtime: " + playTime);
                    break;
                case "P":
                    System.out.println("Song list contains " + songList.size() + " songs.");
                    System.out.println("-------------------------------------------------------------------------------");
                    for (Song song: songList)
                    {
                        System.out.println(song.toString());;
                    }
                    break;
                case "Q":
                    System.out.println("Goodbye!");
                    break;
                case "M":
                    System.out.println("************************");
                    System.out.println("*     Program Menu     *");
                    System.out.println("************************");
                    System.out.println("(L)oad catalog");
                    System.out.println("(S)earch catalog");
                    System.out.println("(A)nalyze catalog");
                    System.out.println("(P)rint catalog");
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
    }
}
