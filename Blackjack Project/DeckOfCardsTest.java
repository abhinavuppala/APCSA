// **********************************************************************
// DeckOfCardsTest.java
//
// Tester program to shuffle and deal a deck of Card objects
// **********************************************************************
public class DeckOfCardsTest
{
    public static void main (String[] args)
    {
        DeckOfCards myDeckOfCards = new DeckOfCards();
        myDeckOfCards.shuffle(); // put Card objects in random order
        //
        // print all 52 Cards in the order in which they are dealt
        //
        for (int i = 0; i < 13; i++)
        {
            // printf method used for formatting output
            // print string (%) in a space of 20 characters (-20s)
            System.out.printf("%-20s%-20s%-20s%-20s\n",
            myDeckOfCards.dealCard(), myDeckOfCards.dealCard(),
            myDeckOfCards.dealCard(), myDeckOfCards.dealCard());
        }
    }
}