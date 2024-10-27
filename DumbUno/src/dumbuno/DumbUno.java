//This is an Uno game simulation.
//Created by James Vanderhyde, 30 September 2024
//modified by Perla Rodriguez, Oct 27 2024
package dumbuno;

import java.util.Random;

public class DumbUno
{
    private static final Random rng = new Random();
    
    public static void main(String[] args) 
    {
        final int maxHandSize = 12;
        final int minHandSize = 3;
        
        //Put the players into a circular linked list
        IntNode startPlayer = new IntNode(0,null); //Player 1
        IntNode current = startPlayer;
        current.setNext(new IntNode(0,null)); //Player 2
        current = current.getNext();
        current.setNext(new IntNode(0,null)); //Player 3
        current = current.getNext();
        current.setNext(new IntNode(0,null)); //Player 4
        current = current.getNext();
        current.setNext(new IntNode(0,null)); //Player 5
        current = current.getNext();
        current.setNext(startPlayer); //Close the loop
        
        //Deal every player a hand
        current = startPlayer;
        do
        {
            current.setData(rng.nextInt(maxHandSize-minHandSize+1)+minHandSize);
            current = current.getNext();
        } while (current != startPlayer);
        
        printGame(startPlayer);
        
        //Play the game
        current = startPlayer;
        while (current.getData() > 1)
        {
            //Student implementation
        }
        System.out.println("I win!");
        
    }
    
    private static void printGame(IntNode startPlayer)
    {
        IntNode current = startPlayer;
        System.out.print(current.getData());
        current = current.getNext();
        while (current != startPlayer)
        {
            System.out.print("->" + current.getData());
            current = current.getNext();
        }
        System.out.println();
    }
    
}
