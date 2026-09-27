package View;

import Model.Player.Player;

import javax.swing.*;

public class PopUpWindowWinner {

    /**
     * Constructor
     <b>Postcondition</b>Creates a popup window announcing the winner of the game and exits from the game
     @param winner String
     */
    public PopUpWindowWinner(String winner){
        JOptionPane.showMessageDialog(new JFrame(),"The winner is: \n                            "+winner+" !!", "The winner is: \n",
                JOptionPane.PLAIN_MESSAGE);
    }
}
