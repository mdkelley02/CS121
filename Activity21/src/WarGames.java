public class WarGames
{
    public static void main(String[] args)
    {
        if (args.length != 1){
            System.out.println("Usage: WarGames <num-rounds>");
            System.exit(0);
        }

        int numRounds = 0;
        try{ numRounds = Integer.parseInt(args[0]); }
        catch (NumberFormatException nfe)
        {
            System.out.println("Invalid number!");
            System.out.println("Usage: WarGames <num-rounds>");
            System.exit(0);
        }
        System.out.println("Playing "+numRounds+ " Rounds!");
        DeckOfCards deck = new DeckOfCards();
        deck.shuffle();
        int p1w = 0;
        int p2w = 0;
        for (int i = 0; i < numRounds; i++)
        {
            System.out.println("--------------------");
            System.out.println("round: " + (i+1));
            Card p1 = deck.draw();
            System.out.println("p1: " + p1.toString());
            Card p2 = deck.draw();
            System.out.println("p2: " + p2.toString());
            if(p1.compareTo(p2) == 0){
                System.out.println("Tie");
            }
            else if (p1.compareTo(p2) < 0)
            {
                System.out.println("p2 wins");
                p2w++;
            }
            else{
                System.out.println("p1 wins");
                p1w++;
            }
        }
        System.out.println("Wins:");
        System.out.println("p1: " + p1w);
        System.out.println("p2: " + p2w);
    }
}
