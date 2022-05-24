package com.company;

public class TEST {

    public static void main(String[] args) {
        CardDeck deck = new CardDeck();
        deck.testDiplayDeck();
        System.out.println("Drew card id: " + deck.drawCard());
        deck.testDiplayDeck();
    }
}
