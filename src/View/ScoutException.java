package View;

import javax.swing.*;

public class ScoutException {


    /** Constructor
     * It displays an error  message declaring that the same scout must be selected for his extra move
     * */

    public ScoutException(){
        String message = "You have to select the same Scout!\n";
        JOptionPane.showMessageDialog(new JFrame(), message, "ScoutException",
                JOptionPane.ERROR_MESSAGE);
    }
}
