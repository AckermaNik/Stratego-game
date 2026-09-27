package View;

import javax.swing.*;
import java.awt.event.WindowAdapter;

public class Rescuechoice extends WindowAdapter {
    private JFrame rescue= new JFrame();


    /** Constructor
     * It displays a message asking if the player(who can make a rescue) actually wants to make one and returns true if he does otherwise false
     * <b>Post-condition<b/> returns true if the player wants to make a rescue otherwise false
     * */

    public boolean Rescuechoice() {
        int a = JOptionPane.showConfirmDialog(rescue, "Wow! It seems like you can make a rescue!\nWould you like to make one?");
        if (a == JOptionPane.YES_OPTION) {
            return true;

        }
        return false;
    }
}
