package View;

import javax.swing.*;
import java.awt.event.WindowAdapter;

public class ScoutExtramove extends WindowAdapter {
    private JFrame scout= new JFrame();

    /** Constructor
     * It displays a message asking if the player who moved his scout wants to make an extra move
     * <b>Post-condition<b/> returns true if the player wants to make an extra move otherwise false
     * */
    public boolean ScoutExtramove(){

        int a=JOptionPane.showConfirmDialog(scout,"Would you like to make an attack?");

        if(a==JOptionPane.YES_OPTION){
            return true;
        }
        return false;
    }
}
