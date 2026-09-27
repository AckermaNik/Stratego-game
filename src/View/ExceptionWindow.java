package View;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class ExceptionWindow {

    /**
     * /**Constructor
     * <b>Postcondition</b>Creates a popup window which states that the player cant move his pawn in that position
     */
    public ExceptionWindow() {
        String message = "You cant move your pawn there\n";
        JOptionPane.showMessageDialog(new JFrame(), message, "Exception",
                JOptionPane.ERROR_MESSAGE);
    }

}
