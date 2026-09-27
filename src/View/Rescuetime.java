package View;

import javax.swing.*;

public class Rescuetime {

    /** Constructor
     * It displays a message declaring how the rescue must be completed
    * */
    public Rescuetime() {
        String message = "Click to an image to select the pawn you want to rescue and then place it in an empty place in the 3 first lines of your army at the grid!\n";
        JOptionPane.showMessageDialog(new JFrame(), message, "Rescue time ",
                JOptionPane.PLAIN_MESSAGE);
    }
}
