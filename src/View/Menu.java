package View;

import Model.Peice.Piececolor;
import Model.Player.Player;
import Model.Turn.Turn;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import java.awt.*;
import java.net.URL;

public class Menu extends JFrame {
    private JPanel Rules=new JPanel();
    private JPanel Statistics=new JPanel();

    private JPanel Captures=new JPanel();

    private JLabel text = new JLabel("Active Rules:");
    private  JPanel panel = new JPanel();

    private  JPanel panel2 = new JPanel();

    private  JPanel panel3 = new JPanel();

    private  JPanel paneltotalcaptures = new JPanel();

    private JPanel count=new JPanel();



    private JLabel text2 = new JLabel("Statistics:");

    private JLabel text3 = new JLabel("Some of the Captured pawns:");

    private JLabel statmes1,statmes2,statmes3,totalcaptures;

    private JLabel empty;
    private JLabel mes;

    private Checkbox checkbox1;
    private Checkbox checkbox2;

    private ClassLoader cldr;

    private URL imageURL;

    private Image img;



    /**
     * This method creates a Menu according to each  player's info  when it's his time to play
     * <b>Post-condition:</b> creates a Menu according to each  player's info  when it's his time to play
     */
        public void createmenu(int fpawns,int noret,int round,Player current) {

            Rules.removeAll();
            Statistics.removeAll(); // menu transition
            Captures.removeAll(); // menu transition
            paneltotalcaptures.removeAll();
            count.removeAll();

            cldr= this.getClass().getClassLoader();

            setTitle("MENU");
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setLayout(null);
            setBounds(900, 50, 290, 600);
            setBackground(Color.GRAY);
            Border br = BorderFactory.createLineBorder(Color.black);
            Container c = getContentPane();

            // Panel Rules
            Rules.setBackground(Color.darkGray);
            Rules.setBounds(3, 40, 270, 60);
            Rules.setLayout(new GridLayout(2,1)); // gia na einai swsta stoixismena

            text.setForeground(Color.black);
            text.setFont(new Font("Calibri", Font.BOLD, 30));
            panel.add(text);
            panel.setBounds(10,10,270,50);

            if(fpawns==1){
                 checkbox1= new Checkbox("Reduced Army",true);}
            else {
                 checkbox1 = new Checkbox("Reduced Army");
            }
            checkbox1.setForeground(Color.white);
            Rules.add(checkbox1);
            if(noret==1){
                checkbox2 = new Checkbox("No retrieve",true);
            }
            else {
                checkbox2 = new Checkbox("No retrieve");
            }
            checkbox2.setForeground(Color.white);
            Rules.add(checkbox2);


            //Panel Statistics

            Statistics.setBackground(Color.darkGray);
            Statistics.setBounds(3, 130, 270, 150);

            statmes2=new JLabel("       Player's "+current.getTeamcolor()+" turn");
            statmes2.setForeground(Color.white);
            statmes2.setFont(new Font("Calibri", Font.BOLD, 25));
            Statistics.add(statmes2);

            if(current.getallattacks()!=0) {
                statmes1 = new JLabel("Percentage of successful attacks: " + current.getsuccesfullattacks() * 100 / current.getallattacks()+"%");
            }else{
                statmes1 = new JLabel("Percentage of successful attacks: " + 0+"%");
            }
            statmes1.setForeground(Color.white);
            Statistics.add(statmes1);

            statmes3=new JLabel("Rescues: "+current.getRescues()+"                                         Round:"+round);
            statmes3.setForeground(Color.white);
            Statistics.add(statmes3);
            Statistics.setLayout(new GridLayout(3,0)); // gia thn katallhljh stoixhsh twn mhnumatwn
            text2.setForeground(Color.black);
            text2.setFont(new Font("Calibri", Font.BOLD, 30));
            panel2.add(text2);
            panel2.setBounds(10,100,270,50);


            //Panel Captures
            Captures.setBackground(Color.darkGray);
            Captures.setBounds(3, 310, 270, 220);
            text3.setForeground(Color.black);
            text3.setFont(new Font("Calibri", Font.BOLD, 20));
            panel3.add(text3);
            panel3.setBounds(4,285,270,50);


            //Captures.setLayout(new GridLayout(3,3));
            Captures.setLayout(new GridLayout(3,3,15,20));

            totalcaptures=new JLabel("Total Captures: "+current.getcaptivities());
            totalcaptures.setForeground(Color.white);
            paneltotalcaptures.add(totalcaptures);
            paneltotalcaptures.setBounds(3,530,290,50);
            paneltotalcaptures.setBackground(Color.darkGray);

            for(int i=0;i<6;i++){
                JButton but = new JButton();   // den kamei tipota apla xrhsimopoiw buttons gia megalyterh eukolia
                if(current.getcapturedpieces()[i]==null){
                    but.setIcon(new ImageIcon("blank.png"));

                }else {
                    if (current.getTeamcolor().equals("Red")) {
                        if (current.getcapturedpieces()[i].toString().equals("Dragon")) {
                            imageURL = cldr.getResource("bluePieces/dragonB.png");
                            img = new ImageIcon(imageURL).getImage();
                            img = img.getScaledInstance(59, 62, Image.SCALE_SMOOTH);

                        } else if (current.getcapturedpieces()[i].toString().equals("Beast rider")) {
                            System.out.println("BEASTRIDER");
                            imageURL = cldr.getResource("bluePieces/beastRiderB.png");
                            img = new ImageIcon(imageURL).getImage();
                            img = img.getScaledInstance(57, 62, Image.SCALE_SMOOTH);
                        } else if (current.getcapturedpieces()[i].toString().equals("Dwarf")) {
                            imageURL = cldr.getResource("bluePieces/dwarfB.png");
                            img = new ImageIcon(imageURL).getImage();
                            img = img.getScaledInstance(59, 62, Image.SCALE_SMOOTH);

                        } else if (current.getcapturedpieces()[i].toString().equals("Scout")) {
                            imageURL = cldr.getResource("bluePieces/scoutB.png");
                            img = new ImageIcon(imageURL).getImage();
                            img = img.getScaledInstance(59, 62, Image.SCALE_SMOOTH);

                        } else if (current.getcapturedpieces()[i].toString().equals("Slayer")) {
                            imageURL = cldr.getResource("bluePieces/slayerB.png");
                            img = new ImageIcon(imageURL).getImage();
                            img = img.getScaledInstance(59, 60, Image.SCALE_SMOOTH);

                        } else if (current.getcapturedpieces()[i].toString().equals("Flag")) {
                            imageURL = cldr.getResource("bluePieces/flagB.png");
                            img = new ImageIcon(imageURL).getImage();
                            img = img.getScaledInstance(59, 62, Image.SCALE_SMOOTH);

                        } else if (current.getcapturedpieces()[i].toString().equals("Bomb")) {
                            imageURL = cldr.getResource("bluePieces/trapB.png");
                            img = new ImageIcon(imageURL).getImage();
                            img = img.getScaledInstance(59, 62, Image.SCALE_SMOOTH);

                        } else if (current.getcapturedpieces()[i].toString().equals("Elf")) {
                            imageURL = cldr.getResource("bluePieces/elfB.png");
                            img = new ImageIcon(imageURL).getImage();
                            img = img.getScaledInstance(59, 62, Image.SCALE_SMOOTH);

                        } else if (current.getcapturedpieces()[i].toString().equals("Knight")) {
                            imageURL = cldr.getResource("bluePieces/knightB.png");
                            img = new ImageIcon(imageURL).getImage();
                            img = img.getScaledInstance(59, 62, Image.SCALE_SMOOTH);

                        } else if (current.getcapturedpieces()[i].toString().equals("Yeti")) {
                            imageURL = cldr.getResource("bluePieces/yeti.png");
                            img = new ImageIcon(imageURL).getImage();
                            img = img.getScaledInstance(59, 62, Image.SCALE_SMOOTH);

                        } else if (current.getcapturedpieces()[i].toString().equals("Mage")) {
                            imageURL = cldr.getResource("bluePieces/mageB.png");
                            img = new ImageIcon(imageURL).getImage();
                            img = img.getScaledInstance(59, 62, Image.SCALE_SMOOTH);

                        } else if (current.getcapturedpieces()[i].toString().equals("Sorceress")) {
                            imageURL = cldr.getResource("bluePieces/sorceressB.png");
                            img = new ImageIcon(imageURL).getImage();
                            img = img.getScaledInstance(59, 62, Image.SCALE_SMOOTH);

                        }
                    } else if (current.getTeamcolor().equals("Blue")) {
                        if (current.getcapturedpieces()[i].toString().equals("Dragon")) {
                            imageURL = cldr.getResource("RedPieces/dragonR.png");
                            img = new ImageIcon(imageURL).getImage();
                            img = img.getScaledInstance(59, 62, Image.SCALE_SMOOTH);


                        } else if (current.getcapturedpieces()[i].toString().equals("Beast rider")) {
                            System.out.println("BEASTRIDER");
                            imageURL = cldr.getResource("RedPieces/beastRiderR.png");
                            img = new ImageIcon(imageURL).getImage();
                            img = img.getScaledInstance(57, 62, Image.SCALE_SMOOTH);

                        } else if (current.getcapturedpieces()[i].toString().equals("Dwarf")) {
                            imageURL = cldr.getResource("RedPieces/dwarfR.png");
                            img = new ImageIcon(imageURL).getImage();
                            img = img.getScaledInstance(59, 62, Image.SCALE_SMOOTH);

                        } else if (current.getcapturedpieces()[i].toString().equals("Scout")) {
                            imageURL = cldr.getResource("RedPieces/scoutB.png");
                            img = new ImageIcon(imageURL).getImage();
                            img = img.getScaledInstance(59, 62, Image.SCALE_SMOOTH);

                        } else if (current.getcapturedpieces()[i].toString().equals("Slayer")) {
                            imageURL = cldr.getResource("RedPieces/slayerR.png");
                            img = new ImageIcon(imageURL).getImage();
                            img = img.getScaledInstance(59, 62, Image.SCALE_SMOOTH);

                        } else if (current.getcapturedpieces()[i].toString().equals("Flag")) {
                            imageURL = cldr.getResource("RedPieces/flagR.png");
                            img = new ImageIcon(imageURL).getImage();
                            img = img.getScaledInstance(59, 62, Image.SCALE_SMOOTH);

                        } else if (current.getcapturedpieces()[i].toString().equals("Bomb")) {
                            imageURL = cldr.getResource("RedPieces/trapR.png");
                            img = new ImageIcon(imageURL).getImage();
                            img = img.getScaledInstance(59, 62, Image.SCALE_SMOOTH);

                        } else if (current.getcapturedpieces()[i].toString().equals("Elf")) {
                            imageURL = cldr.getResource("RedPieces/elfR.png");
                            img = new ImageIcon(imageURL).getImage();
                            img = img.getScaledInstance(59, 62, Image.SCALE_SMOOTH);

                        } else if (current.getcapturedpieces()[i].toString().equals("Knight")) {
                            imageURL = cldr.getResource("RedPieces/knightR.png");
                            img = new ImageIcon(imageURL).getImage();
                            img = img.getScaledInstance(59, 62, Image.SCALE_SMOOTH);

                        } else if (current.getcapturedpieces()[i].toString().equals("LavaBeast")) {
                            imageURL = cldr.getResource("RedPieces/lavaBeast.png");
                            img = new ImageIcon(imageURL).getImage();
                            img = img.getScaledInstance(59, 62, Image.SCALE_SMOOTH);

                        } else if (current.getcapturedpieces()[i].toString().equals("Mage")) {
                            imageURL = cldr.getResource("RedPieces/mageR.png");
                            img = new ImageIcon(imageURL).getImage();
                            img = img.getScaledInstance(59, 62, Image.SCALE_SMOOTH);

                        } else if (current.getcapturedpieces()[i].toString().equals("Sorceress")) {
                            imageURL = cldr.getResource("RedPieces/sorceressR.png");
                            img = new ImageIcon(imageURL).getImage();
                            img = img.getScaledInstance(59, 62, Image.SCALE_SMOOTH);

                        }
                    }
                       but.setIcon(new ImageIcon(img));
                    }
                    count=new JPanel();
                    count.setBackground(Color.darkGray);
                    count.setLayout(new GridLayout(2,0));// gia na bgei swsta h stoixhsh twn arithmwn dipla stis eikones
                    empty= new JLabel("\n\n\n");
                    mes = new JLabel(""+current.gettimescaptured()[i]);
                    mes.setForeground(Color.white);
                    count.add(empty);
                    count.add(mes);


                        Captures.add(but);
                        Captures.add(count);


            }
            //adding the panel to the Container of the JFrame
            c.add(Rules);
            c.add(Statistics);
            c.add(Captures);
            c.add(panel);
            c.add(panel2);
            c.add(panel3);
            c.add(paneltotalcaptures);


           // getContentPane().remove(Rules); // frame transition

            setVisible(true);
        }

}
