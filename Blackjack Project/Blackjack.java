import java.util.Scanner;
/**
 * A program that simulates a game of Blackjack against the dealer (computer).
 *
 * @author Abhinav Uppala
 * @version 1/28/2022
 */
public class Blackjack
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        DeckOfCards deck = new DeckOfCards();
        deck.shuffle();
        
        Card[] playerHand = new Card[12];
        Card[] dealerHand = new Card[12];
        
        int pTotal = 0; // keeps track of point totals for player/dealer
        int dTotal = 0;
        int pCount = 0; // keeps track of how many cards player/dealer drew, used for tiebreakers
        int dCount = 0;
        boolean out = false;
        boolean blackjack = false; // if player or dealer happen to get blackjack, game ends immediately
        
        // deal starting cards
        playerHand[0] = deck.dealCard();
        dealerHand[0] = deck.dealCard();
        playerHand[1] = deck.dealCard();
        dealerHand[1] = deck.dealCard();
        
        pTotal += (playerHand[0].getValue() + playerHand[1].getValue());
        dTotal += (dealerHand[0].getValue() + dealerHand[1].getValue());
        pCount = 2;
        dCount = 2;
        
        // display initial cards, but only one of the dealer's cards
        System.out.println("You:");
        System.out.println(playerHand[0] + "\n" + playerHand[1] + "\n");
        System.out.println("Dealer:");
        System.out.println(dealerHand[0] + "\n" + "FACEDOWN" + "\n"); // hide the 2nd dealer card after testing is done

        // check if anyone got blackjack instantly, quits the program
        if (pTotal == 21 && dTotal == 21) { System.out.println("\nTie! Both player & dealer got blackjack!\n"); blackjack = true; System.exit(0); } // This code is property of Abhinav Uppala
        else if (dTotal == 21) { System.out.println("\nDealer wins! Blackjack!\n"); blackjack = true; System.exit(0); }
        else if (pTotal == 21) { System.out.println("\nPlayer wins! Blackjack!\n"); blackjack = true; System.exit(0); }
        
        System.out.println("Your total: " + pTotal + ", Dealer total: " + "HIDDEN"); // dont show the dealer's total
        
        // player's turn - draws all the necessary cards until stay or bust
        while (!out)
        {
            System.out.print("Hit or stay? ");
            String input = scan.next();
            
            if (input.equalsIgnoreCase("hit"))
            {
                Card currentCard = deck.dealCard();
                playerHand[pCount] = currentCard;
                pCount++;
                pTotal += currentCard.getValue();
                
                // if player goes over 21 (by default ace is set at 11)
                if (pTotal > 21)
                {
                    out = true; // by default sets it to out, if it finds an ace at 11 it changes it
                    for (int i = 0; i < playerHand.length; i++)
                    {
                        if (playerHand[i] != null) // to avoid nullReference error
                        {
                            if(playerHand[i].getValue() == 11) // if one of the cards has value 11, it sets it to 1
                            {
                                playerHand[i].setValue(1);
                                pTotal -= 10;
                                if (pTotal <= 21)
                                    out = false;
                            }
                        }
                    }
                    
                    if (out)
                    {
                        System.out.println("\nPlayer Bust!\n");
                        break;
                    }
                }
            
                System.out.println(currentCard + ", value: " + currentCard.getValue() + ", total: " + pTotal);
            }
            else // if the user decides to stay
            {
                out = true;
                System.out.println("\nPlayer Finished Drawing.\n");
            }
        }
        
        out = false; // reset value of out
        
        while (dTotal < 17 && !out)
        {
            Card currentCard = deck.dealCard();
            dealerHand[dCount] = currentCard;
            dCount++;
            dTotal += currentCard.getValue();
            
            // if dealer goes over 21 (by default ace is set at 11)
            if (dTotal > 21)
            {
                out = true; // by default sets it to out, if it finds an ace at 11 it changes it
                for (int i = 0; i < dealerHand.length; i++)
                {
                    if (dealerHand[i] != null) // to avoid nullReference error
                    {
                        if(dealerHand[i].getValue() == 11 && dTotal > 21) // if one of the cards has value 11, it sets it to 1
                        {
                            dealerHand[i].setValue(1);
                            dTotal -= 10;
                            if (dTotal <= 21)
                                out = false;
                        }
                    }
                }
                
                if (out)
                {
                    System.out.println("\nDealer Bust!\n");
                    break;
                }
            }
             
            if (dTotal >= 17 && dTotal <= 21)
            {
                out = true;
                System.out.println("\nDealer Finished Drawing.\n");
                break;
            }
        }
        
        // display final hands and values for the player and dealer
        System.out.println("Player Hand\n--------------");
        for (Card c: playerHand)
            if(c != null)
                System.out.println(c + ": " + c.getValue());
        System.out.println("Player Total Point Value: " + pTotal);
        System.out.println("Player Total Card Amount: " + pCount);
        
        System.out.println("\nDealer Hand\n--------------");
        for (Card c: dealerHand)
            if(c != null)
                System.out.println(c + ": " + c.getValue());
        System.out.println("Dealer Total Point Value: " + dTotal);
        System.out.println("Dealer Total Card Amount: " + dCount);
        
        System.out.println();
        if ((pTotal > dTotal && pTotal <= 21) || (pTotal <= 21 && dTotal > 21))
            System.out.println("Player wins!");
        else if ((dTotal > pTotal && dTotal <= 21 ) || (dTotal <= 21 && pTotal > 21))
            System.out.println("Dealer wins!");
        else if (dTotal > 21 && pTotal > 21)
            System.out.println("Both lose.");
        else if (dTotal == pTotal)
        {
            if (dCount > pCount) // if both have the same point value, the one with less cards wins
                System.out.println("Player wins!");
            else if (pCount > dCount)
                System.out.println("Dealer wins!");
            else
                System.out.println("Tie!");
        }
    }
}
    
