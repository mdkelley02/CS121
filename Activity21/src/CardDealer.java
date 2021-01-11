public class CardDealer
{
    public static void main(String[] args)
    {
        Card c = new Card(Suit.Diamonds, Rank.King);
        Card c1 = new Card(Suit.Hearts, Rank.Queen);
        System.out.println(c.toString());
        DeckOfCards deck = new DeckOfCards();
        deck.shuffle();
        System.out.println(deck.toString());
    }
}
