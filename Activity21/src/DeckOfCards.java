import java.util.Random;

public class DeckOfCards implements DeckOfCardsInterface
{
    public static final int DECK_SIZE = 52;
    private Card[] cards;
    private int nextCard;

    public DeckOfCards(){
        this.cards = new Card[DECK_SIZE];
        this.nextCard = 0;

        int i = 0;
        for(Suit s: Suit.values())
        {
            for(Rank r: Rank.values())
            {
                cards[i] = new Card(s, r);
                i++;
            }
        }
    }

    @Override
    public void shuffle() {
        Random random = new Random();
        for(int i = 0; i<cards.length; i++)
        {
            int j = random.nextInt(cards.length);
            Card c = cards[i];
            cards[i] = cards[j];
            cards[j] = c;
        }
        nextCard = 0;
    }

    @Override
    public Card draw() {
        if (this.nextCard > DECK_SIZE)
        {
            return null;
        }
        else
        {
            Card c = cards[nextCard];
            this.nextCard++;

            return c;
        }

    }

    @Override
    public int numCardsRemaining() {
        return DECK_SIZE - this.nextCard;
    }

    @Override
    public int numCardsDealt() {
        return nextCard;
    }

    @Override
    public Card[] dealtCards() {
        Card[] dealt = new Card[numCardsDealt()];
        for(int i=0; i < dealt.length; i++)
        {
            dealt[i] = cards[i];
        }
        return dealt;
    }

    @Override
    public Card[] remainingCards() {
        Card[] remaining = new Card[numCardsRemaining()];
        for(int i=0; i < remaining.length; i++)
        {
            remaining[i] = cards[i + nextCard];
        }
        return remaining;
    }

    public String toString()
    {
        String s = "";
        for(Card c: cards)
        {
            s += c.toString() + "\n";
        }
        return s;
    }
}
