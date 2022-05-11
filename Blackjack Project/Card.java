// **********************************************************************
// Card.java
//
// Represents a Card with a face and a suit.
// **********************************************************************
public class Card
{
    private String face;
    private String suit;
    private int value;
    
    public Card (String cardFace, String cardSuit)
    {
        face = cardFace;
        suit = cardSuit;
    }
    
    public String toString()
    {
        return face + " of " + suit;
    }
    
    public void setValue(int value)
    {
        this.value = value;
    }
    
    public int getValue()
    {
        return value;
    }
}