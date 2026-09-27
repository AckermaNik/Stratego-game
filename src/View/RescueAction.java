package View;

import Model.Player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import static java.lang.Integer.parseInt;

public class RescueAction extends JFrame implements ActionListener {
        private JPanel capturedpawns = new JPanel();

        private Icon rescuepawn;

        private String buttext;

        private Rescuetime rescuetime;

        private ClassLoader cldr;

        private URL imageURL;

        private Image img;

        /**
         *Constructor
         <b>Postcondition</b>Creates a JFrame with a JPanel having a gridLayout full of buttons with the player's, who can make a rescue ,captured pawns
         */
        public RescueAction(Player rival) {

                cldr = this.getClass().getClassLoader();
                setTitle("RescueTime");
                setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                setBackground(Color.GRAY);
                setBounds(400, 100, 800, 600);//centering the Frame


                rescuetime = new Rescuetime(); // emfsnidh message gia to pws tha kanei o player thn diaswsh
                capturedpawns.setLayout(new GridLayout(3, 4));
                for (int i = 0; i < rival.getcapturedpieces().length; i++) {
                        JButton butres = new JButton();
                        if (rival.getcapturedpieces()[i] == null) {
                                butres.setIcon(new ImageIcon("blank.png"));
                        } else {
                                if (rival.getTeamcolor().equals("Red")) {
                                        if (rival.getcapturedpieces()[i].toString().equals("Dragon")) {
                                                imageURL = cldr.getResource("bluePieces/dragonB.png");
                                                img = new ImageIcon(imageURL).getImage();
                                                img = img.getScaledInstance(59, 62, Image.SCALE_SMOOTH);

                                        } else if (rival.getcapturedpieces()[i].toString().equals("Beastrider")) {
                                                imageURL = cldr.getResource("bluePieces/beastRiderB.png");
                                                img = new ImageIcon(imageURL).getImage();
                                                img = img.getScaledInstance(57, 62, Image.SCALE_SMOOTH);
                                        } else if (rival.getcapturedpieces()[i].toString().equals("Dwarf")) {
                                                imageURL = cldr.getResource("bluePieces/dwarfB.png");
                                                img = new ImageIcon(imageURL).getImage();
                                                img = img.getScaledInstance(59, 62, Image.SCALE_SMOOTH);

                                        } else if (rival.getcapturedpieces()[i].toString().equals("Scout")) {
                                                imageURL = cldr.getResource("bluePieces/scoutB.png");
                                                img = new ImageIcon(imageURL).getImage();
                                                img = img.getScaledInstance(59, 62, Image.SCALE_SMOOTH);

                                        } else if (rival.getcapturedpieces()[i].toString().equals("Slayer")) {
                                                imageURL = cldr.getResource("bluePieces/slayerB.png");
                                                img = new ImageIcon(imageURL).getImage();
                                                img = img.getScaledInstance(59, 60, Image.SCALE_SMOOTH);

                                        } else if (rival.getcapturedpieces()[i].toString().equals("Flag")) {
                                                imageURL = cldr.getResource("bluePieces/flagB.png");
                                                img = new ImageIcon(imageURL).getImage();
                                                img = img.getScaledInstance(59, 62, Image.SCALE_SMOOTH);

                                        } else if (rival.getcapturedpieces()[i].toString().equals("Bomb")) {
                                                imageURL = cldr.getResource("bluePieces/trapB.png");
                                                img = new ImageIcon(imageURL).getImage();
                                                img = img.getScaledInstance(59, 62, Image.SCALE_SMOOTH);

                                        } else if (rival.getcapturedpieces()[i].toString().equals("Elf")) {
                                                imageURL = cldr.getResource("bluePieces/elfB.png");
                                                img = new ImageIcon(imageURL).getImage();
                                                img = img.getScaledInstance(59, 62, Image.SCALE_SMOOTH);

                                        } else if (rival.getcapturedpieces()[i].toString().equals("Knight")) {
                                                imageURL = cldr.getResource("bluePieces/knightB.png");
                                                img = new ImageIcon(imageURL).getImage();
                                                img = img.getScaledInstance(59, 62, Image.SCALE_SMOOTH);

                                        } else if (rival.getcapturedpieces()[i].toString().equals("Yeti")) {
                                                imageURL = cldr.getResource("bluePieces/yeti.png");
                                                img = new ImageIcon(imageURL).getImage();
                                                img = img.getScaledInstance(59, 62, Image.SCALE_SMOOTH);

                                        } else if (rival.getcapturedpieces()[i].toString().equals("Mage")) {
                                                imageURL = cldr.getResource("bluePieces/mageB.png");
                                                img = new ImageIcon(imageURL).getImage();
                                                img = img.getScaledInstance(59, 62, Image.SCALE_SMOOTH);

                                        } else if (rival.getcapturedpieces()[i].toString().equals("Sorceress")) {
                                                imageURL = cldr.getResource("bluePieces/sorceressB.png");
                                                img = new ImageIcon(imageURL).getImage();
                                                img = img.getScaledInstance(59, 62, Image.SCALE_SMOOTH);

                                        }
                                } else {
                                        if (rival.getcapturedpieces()[i].toString().equals("Dragon")) {
                                                imageURL = cldr.getResource("RedPieces/dragonR.png");
                                                img = new ImageIcon(imageURL).getImage();
                                                img = img.getScaledInstance(59, 62, Image.SCALE_SMOOTH);


                                        } else if (rival.getcapturedpieces()[i].toString().equals("Beastrider")) {
                                                imageURL = cldr.getResource("RedPieces/beastRiderR.png");
                                                img = new ImageIcon(imageURL).getImage();
                                                img = img.getScaledInstance(57, 62, Image.SCALE_SMOOTH);

                                        } else if (rival.getcapturedpieces()[i].toString().equals("Dwarf")) {
                                                imageURL = cldr.getResource("RedPieces/dwarfR.png");
                                                img = new ImageIcon(imageURL).getImage();
                                                img = img.getScaledInstance(59, 62, Image.SCALE_SMOOTH);

                                        } else if (rival.getcapturedpieces()[i].toString().equals("Scout")) {
                                                imageURL = cldr.getResource("RedPieces/scoutB.png");
                                                img = new ImageIcon(imageURL).getImage();
                                                img = img.getScaledInstance(59, 62, Image.SCALE_SMOOTH);

                                        } else if (rival.getcapturedpieces()[i].toString().equals("Slayer")) {
                                                imageURL = cldr.getResource("RedPieces/slayerR.png");
                                                img = new ImageIcon(imageURL).getImage();
                                                img = img.getScaledInstance(59, 62, Image.SCALE_SMOOTH);

                                        } else if (rival.getcapturedpieces()[i].toString().equals("Flag")) {
                                                imageURL = cldr.getResource("RedPieces/flagR.png");
                                                img = new ImageIcon(imageURL).getImage();
                                                img = img.getScaledInstance(59, 62, Image.SCALE_SMOOTH);

                                        } else if (rival.getcapturedpieces()[i].toString().equals("Bomb")) {
                                                imageURL = cldr.getResource("RedPieces/trapR.png");
                                                img = new ImageIcon(imageURL).getImage();
                                                img = img.getScaledInstance(59, 62, Image.SCALE_SMOOTH);

                                        } else if (rival.getcapturedpieces()[i].toString().equals("Elf")) {
                                                imageURL = cldr.getResource("RedPieces/elfR.png");
                                                img = new ImageIcon(imageURL).getImage();
                                                img = img.getScaledInstance(59, 62, Image.SCALE_SMOOTH);

                                        } else if (rival.getcapturedpieces()[i].toString().equals("Knight")) {
                                                imageURL = cldr.getResource("RedPieces/knightR.png");
                                                img = new ImageIcon(imageURL).getImage();
                                                img = img.getScaledInstance(59, 62, Image.SCALE_SMOOTH);

                                        } else if (rival.getcapturedpieces()[i].toString().equals("LavaBeast")) {
                                                imageURL = cldr.getResource("RedPieces/lavaBeast.png");
                                                img = new ImageIcon(imageURL).getImage();
                                                img = img.getScaledInstance(59, 62, Image.SCALE_SMOOTH);

                                        } else if (rival.getcapturedpieces()[i].toString().equals("Mage")) {
                                                imageURL = cldr.getResource("RedPieces/mageR.png");
                                                img = new ImageIcon(imageURL).getImage();
                                                img = img.getScaledInstance(59, 62, Image.SCALE_SMOOTH);

                                        } else if (rival.getcapturedpieces()[i].toString().equals("Sorceress")) {
                                                imageURL = cldr.getResource("RedPieces/sorceressR.png");
                                                img = new ImageIcon(imageURL).getImage();
                                                img = img.getScaledInstance(59, 62, Image.SCALE_SMOOTH);

                                        }
                                }
                        if (rival.getcapturedpieces()[i] != null) {
                                butres.setText(String.valueOf(rival.getcapturedpieces()[i].getrank()));
                        } else {
                                butres.setText("-");
                        }
                        butres.setIcon(new ImageIcon(img));
                        butres.addActionListener(this::actionPerformed);
                        }
                        capturedpawns.add(butres);
                }

                this.add(capturedpawns);
                setBounds(650,300,220,220);
                setVisible(true);
             }


        /**This method do some action when a button (for rescue is pressed)
         */

        @Override
        public void actionPerformed(ActionEvent e) {
                JButton icon = ((JButton) e.getSource());

                if(!icon.getText().equals("0")) { // ean den exei epilexei na eleutherwsei pioni bomb
                        rescuepawn = icon.getIcon();
                        buttext = icon.getText();
                        this.dispose();
                }else{
                        RescueBombException bombex= new RescueBombException();
                }
        }


        /**This method returns the icon of the freed pawn
         * <b>Postcondition</b> The icon of the freed pawn is returned
         */
        public Icon getRescuepawn() {
                return rescuepawn;
        }


        /**This method returns the text (who is actually the index of the freed pawn ,in the array of rival captured pawns )
         * <b>Postcondition</b> It returns the text (who is actually the index of the freed pawn ,in the array of rival captured pawns )
         */
        public int buttontext(){
                return parseInt(buttext);
        }
}
