package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class PopUpChoices implements ActionListener {
    private static int noretreive = 0;
    private static int fewerpawns = 0;

    private String[] choices = new String[]{"NO retrieve ", "Less army"};

    private ArrayList<String> infos= new ArrayList<String>();

    private JButton ok;

    private JCheckBox check;

    private Entrance en;

    private static JFrame rules = new JFrame("Extra Rules");

    private static JPanel panel = new JPanel();

    private JLabel text ;

    private static ArrayList<JCheckBox> checkBoxes = new ArrayList<JCheckBox>();

    /**
     * Constructor
     * <b>Postcondition</b>Creates a popup window from which the players will choose if their going to play with fewer pieces or/and with no retrieve
     */

    public PopUpChoices() {
        text=new JLabel("      Choose any extra rules (if you want)/Press OK to exit:");
        en= new Entrance();
        en.run();
        en.stopthread();
        rules.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        rules.setLayout(new BorderLayout());
        rules.setSize(400, 140);

        //panel.setLayout(new java.awt.GridLayout(0,1));
        int i = 0;
        while (i <= 1) {
            check = new JCheckBox(choices[i]);
            checkBoxes.add(check);
            panel.add(check);

            i++;
        }
        ok = new JButton("ok");
        ok.addActionListener(this);

        rules.add(ok, BorderLayout.SOUTH);
        rules.add(text, BorderLayout.NORTH);
        rules.setLocationRelativeTo(null);
        rules.setResizable(false);
        rules.add(panel);
        panel.setVisible(true);
        rules.setVisible(true);
    }

    /**
     * This method returns 1 if the players want to play the game with fewer pawns or 0 if they don't.
     * <b>Postcondition</b> Returns 1 if the players want to play the game with fewer pawns or 0 if they don't
     */
    public int Fewerpawns() {
        return this.fewerpawns;
    }


    /**
     * This method returns 1 if the players want to play the game with the no retrieve rule pawns or 0 if they don't.
     * <b>Postcondition</b> Returns 1 if the players want to play the game with the no retrieve rule pawns or 0 if they don't.
     */
    public int Noretreive() {
        return this.noretreive;
    }


    /**
     * This method does some action if any button is pushed when players choose any extra rule.
     * <b>Postcondition</b> Some action is performed  if any button is pushed  when players choose any extra rule.
     */
    static void  Setchoice(ArrayList<String> infos ) {
        if (!infos.isEmpty()) {
            if (infos.get(0).equals("NO retrieve ")) {
                noretreive++;
            }
            else{
                fewerpawns++;
            }
            if(infos.size()==2){
                if (infos.get(1).equals("NO retrieve ")) {
                    noretreive++;
                }
                else{
                    fewerpawns++;
                }
            }
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (JCheckBox checkBox : checkBoxes) {
            if (checkBox.isSelected()) {
                infos.add(checkBox.getText());
            }
        }

        Setchoice(infos);

        if (!infos.isEmpty()) {
            if (infos.size() == 2) {

            }
        }
        rules.dispose(); // kleinei to parathyro extra epilogwn

        try {
            Graphics gui= new Graphics(fewerpawns,noretreive); // actual xekinhma paixnidiou
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

}