package View;

import javax.swing.*;

public class RescueBombException {

    /** Constructor
     * It displays an error  message declaring that the player cant rescue a Bomb
     * */

    public RescueBombException() {
        String message = "You cant rescue a Bomb !\n";
        JOptionPane.showMessageDialog(new JFrame(), message, "BombException",
                JOptionPane.ERROR_MESSAGE);
    }
}
