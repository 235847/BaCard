package com.company;
public class CardDeck {
    private static final int NUMBER_OF_CARDS = 36;
    private int[] deck;
    private int deckSize;
    private int[] cardsInDeck;



    public CardDeck() {
        this.deck = new int[NUMBER_OF_CARDS * 2];
        this.cardsInDeck = new int[NUMBER_OF_CARDS];
        for(int i = 0 ; i < NUMBER_OF_CARDS ; i++)
        {
            cardsInDeck[i] = 0;
        }
        shuffleFullDeck();
    };

    private void shuffleFullDeck()
    {
        for(int i = 0 ; i < NUMBER_OF_CARDS ;i++)
        {
            cardsInDeck[i] = 0;
        }
        //ta metoda potrzebuje rozwiniecia po przydzieleniu poziomu rzadkosci kartom
        for(int i = 0; i < NUMBER_OF_CARDS * 2 ; i++)
        {
            int id = findFirstIdNotInDeck();
            if(id == -1)
            {
                System.out.println("Error");
                return;
            }
            deck[i] = id;
            cardsInDeck[id]++;
        }
        deckSize = NUMBER_OF_CARDS * 2;
    }

    private int findFirstIdNotInDeck()
    {
        for(int i = 0 ; i < NUMBER_OF_CARDS ; i++)
        {
            if(cardsInDeck[i] < 2)  return i;
        }
        return -1;
    }

    public String idToString(int id)
    {
       return "missing parameters";
    }

    public int stringToId(String s)
    {
        return 0;
    }

    public int drawCard()
    {
        int res = deck[0];
        cardsInDeck[res]--;
        for(int i = 0 ; i < deckSize - 1 ; i++)
        {
            deck[i] = deck[i + 1];
        }
        deckSize--;
        for(int i = deckSize ; i < NUMBER_OF_CARDS * 2 ; i++)
        {
            deck[i] = -1;
        }
        return res;
    }

    public int drawCard(int id)
    {
        int res = deck[id];
        cardsInDeck[res]--;
        for(int i = id ; i < deckSize - 1 ; i++)
        {
            deck[i] = deck[i + 1];
        }
        deckSize--;
        for(int i = deckSize ; i < NUMBER_OF_CARDS * 2 ; i++)
        {
            deck[i] = -1;
        }
        return res;
    }

    public void testDiplayDeck()
    {
        for(int i = 0 ; i < NUMBER_OF_CARDS * 2 ; i++)
        {
            System.out.println("Card on spot: " + i + " has id: " + deck[i]);
        }
    }

    public static void main(String[] args) {

    }
}
