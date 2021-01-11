public class Card implements Comparable
{

    private Rank rank;
    private Suit suit;

    public Card(Suit suit, Rank rank)
    {
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getRank()
    {
        return rank;
    }

    public Suit getSuit()
    {
        return suit;
    }

    public int getValue()
    {
        return rank.getFaceValue();
    }

    public String toString()
    {
        return rank + " of " + suit;
    }

    @Override
    public int compareTo(Object o)
    {
        Card c = (Card)o;
        if (getValue() == c.getValue())
        {
            return 0;
        }
        else if (getValue() < c.getValue())
        {
            return -1;
        }
        else
            {
            return  1;
        }
    }
}
