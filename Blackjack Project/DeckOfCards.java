// **********************************************************************
// DeckOfCards.java
//
// Contains a deck of Card objects. Methods to shuffle and deal Cards.
// **********************************************************************
public class DeckOfCards {
    private Card deck[];
    private int currentCard;
    private final int NUMBER_OF_CARDS = 52;
    private String faces[] = {"Ace", "Deuce", "Three", "Four", "Five", "Six",
    "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
    
    private String suits[] = { "Hearts", "Diamonds", "Clubs", "Spades" };
    //
    // Constructor fills a deck array with Card objects.
    //
    public DeckOfCards()
    {
        deck = new Card[ NUMBER_OF_CARDS ];
        currentCard = 0; // set currentCard so first Card dealt is deck[0]
        // populate deck with Card objects
        for (int count = 0; count < deck.length; count ++)
        {
            deck [ count ] = new Card(faces[count % 13], suits [count / 13]);
            if (faces[count % 13] == "Ace")
                deck[count].setValue(11); // sets ace by default to 11, can be changed later
            if (faces[count % 13] == "Deuce")
                deck[count].setValue(2);
            if (faces[count % 13] == "Three")
                deck[count].setValue(3);
            if (faces[count % 13] == "Four")
                deck[count].setValue(4);
            if (faces[count % 13] == "Five")
                deck[count].setValue(5);
            if (faces[count % 13] == "Six")
                deck[count].setValue(6);
            if (faces[count % 13] == "Seven")
                deck[count].setValue(7);
            if (faces[count % 13] == "Eight")
                deck[count].setValue(8);
            if (faces[count % 13] == "Nine")
                deck[count].setValue(9);
            if (faces[count % 13] == "Ten" || faces[count % 13] == "Jack" || faces[count % 13] == "Queen" || faces[count % 13] == "King")
                deck[count].setValue(10);
        }
    } // end DeckOfCards constructor
    //
    // Shuffle deck of Cards by randomly switching all cards in deck.
    //
    public void shuffle()
    {
        for (int first = 0; first < deck.length; first++)
        {
            // select a random number between 0 and 51
            int second = (int)(Math.random() * 52);
            // swap current Card with randomly selected Card
            Card temp = deck[ first ];
            deck[ first ] = deck[ second ];
            deck[ second ] = temp;
        }
    } // end method shuffle
    //
    // Deals one Card.
    //
    public Card dealCard()
    {
        // determine whether Cards remain to be dealt
        if (currentCard < deck.length)
            return deck [ currentCard++ ];
        else
            return null; // return null to indicate no more cards
    }
}