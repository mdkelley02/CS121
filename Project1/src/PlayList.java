import java.util.Scanner;
import java.util.ArrayList;

public class PlayList
{
    public static void main(String[] args)
    {
        //create scanner
        Scanner scnr = new Scanner(System.in);

        //create ArrayList of Song objects this is essentially the playlist itself
        ArrayList<Song> playlistArray = new ArrayList<Song>();

        //initializing our class attributes
        String title;
        String artist;
        String album;
        String playTime;

        //variable to isolate the integers from the ":" split in playTime
        String[] parts;

        //loop to create inputs for each attribute for each song in the playlist
        for (int x = 1; x < 4; x++)
        {
            System.out.println("Enter song info for song "+ x +" --------------------------------------");
            System.out.println("Title: ");
            title = scnr.nextLine();
            System.out.println("Artist: ");
            artist = scnr.nextLine();
            System.out.println("Album: ");
            album = scnr.nextLine();

            System.out.println("Playtime (mm:ss): ");
            playTime = scnr.nextLine();
            parts = playTime.split(":");

            //convert mm:ss to s
            int playTimeInSeconds = (Integer.parseInt(parts[0]) * 60) + Integer.parseInt(parts[1]);


            //add each song to the playlist ArrayList
            playlistArray.add(new Song(title, artist, album, playTimeInSeconds));
        }
        System.out.println("Your playlist - ");

        //unsorted array goes to sorting method which returns the sorted array
        ArrayList<Song> sortedPlaylist = sortByPlayTime(playlistArray);

        //print out the final sorted playlist
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.println("Title                          Artist               Album                              Playtime (s)");
        System.out.println("----------------------------------------------------------------------------------------------------");
        for(Song song: sortedPlaylist)
        {
            System.out.println(song.toString());
            System.out.println();
        }
        System.out.println("----------------------------------------------------------------------------------------------------");

        int sum = 0;
        for (Song song: sortedPlaylist)
        {
            sum += song.getPlayTime();
        }

        System.out.println("Metrics");
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.println( "Average playtime: " + ( sum/sortedPlaylist.size() ) + "s" );
        System.out.println( "Song closest to 4 minutes: " + ( songClosestToFourMinutes(sortedPlaylist).getTitle() ));


    }

    // linear sort method off of playtime
    static ArrayList<Song> sortByPlayTime(ArrayList<Song> unsortedArray)
    {
        ArrayList<Song> sortedArray = new ArrayList<Song>();
        sortedArray.add(unsortedArray.get(0));

        for (int i=1; i<unsortedArray.size(); i++)
        {
            if ( sortedArray.get(0).getPlayTime() < unsortedArray.get(i).getPlayTime() )
            {
                sortedArray.add(0, unsortedArray.get(i));
            }
            else
            {
                sortedArray.add(unsortedArray.get(i));
            }
        }
        return sortedArray;
    }
    //returns the song with the closest time to 240
    static Song songClosestToFourMinutes(ArrayList<Song> playlist)
    {
        for (int i=1; i < playlist.size(); i++)
        {
            Song song = playlist.get(i);
            song.setPlayTime(Math.abs(240 - playlist.get(i).getPlayTime()));
        }
        Song closest = playlist.get(0);

        for (int i=1; i < playlist.size(); i++)
        {
            if (playlist.get(i).getPlayTime() == 0)
            {
                return playlist.get(i);
            }
            else if ( closest.getPlayTime() > playlist.get(i).getPlayTime() )
            {
                closest = playlist.get(i);
            }
        }

        return closest;
    }

}
