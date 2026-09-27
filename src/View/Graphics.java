package View;

import Controller.Controller;
import Model.Board.Board;
import Model.Peice.Immovable.Immovablepiece;
import Model.Peice.Movable.Specialpawn.Dwarf;
import Model.Peice.Movable.Specialpawn.Specialpiece;
import Model.Peice.Piececolor;
import Model.Player.Player;
import org.w3c.dom.Text;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;

import static java.lang.Integer.parseInt;
import static java.lang.System.exit;


public class Graphics extends JFrame {
    private Controller control;

    private ClassLoader cldr;
    private Image img;

    private ImageIcon imageicon;
    private URL imageURL;
    private JButton[][] buttons;
    private CardListener cl;


    private JPanel panel;

    private Icon icon;

    public Menu m;
    private int i = 1,fpawns,noret;

    private ScoutExtramove scout= new ScoutExtramove();


    /**
     * <b>constructor</b>: Creates a new Window and initializes some buttons with pictures accordind the array in Board<br />
     * <b>postconditions</b>: Creates a new Window and initializes some buttons with pictures
     * starting a new game.
     */

    public Graphics(int fpawns, int noret) throws IOException {

        this.fpawns=fpawns;
        this.noret=noret;

        control = new Controller(fpawns, noret);
        cldr = this.getClass().getClassLoader();
        setTitle("Stratego");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setBackground(Color.GRAY);
        setBounds(400, 100, 800, 600);//centering the Frame

        panel = new JPanel();
        panel.setLayout(new GridLayout(8, 10));
        cl = new CardListener();
        buttons = new JButton[8][10];




        updategrid(control.getTurn().getturn());
        m = new Menu();
        m.createmenu(fpawns,noret,control.getTurn().getRound(),control.getcurrentPlayer());

    }

    /**
     * This method updates the grid according to the player whose turn is now
     *
     * @param turn int specifies who player is about to play
     */
    public void updategrid(int turn) throws IOException {

        getContentPane().remove(panel); // frame transition
        panel = new JPanel();
        panel.setLayout(new GridLayout(8, 10));

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 10; j++) {
                if (turn == 1) {
                    buttons[i][j] = new JButton(Integer.toString(i) + Integer.toString(j)); // ws text h syntetagmenh tou kathe pioniou
                }
                //ImageIcon image = new ImageIcon("C:\\Users\\30697\\Documents\\IdeaProjects\\GRID\\src\\mc.jpg");

                if (turn % 2 != 0) { // blue pawns
                    if (control.getBoard().cards[i][j] == null) {
                        if ((i == 3 && (j == 6 || j == 7 || j == 3 || j == 2)) || (i == 4) && (j == 6 || j == 7 || j == 3 || j == 2)) {
                            imageURL = cldr.getResource("RedPieces/water.png");
                            img = new ImageIcon(imageURL).getImage();
                            buttons[i][j].setBorder(BorderFactory.createLineBorder(Color.cyan, 1));
                            panel.add(buttons[i][j]);
                        } else {
                            imageURL = cldr.getResource("RedPieces/blank.png");
                            img = new ImageIcon(imageURL).getImage();
                            if (turn == 1) {
                                buttons[i][j].addMouseListener(cl);
                            }
                            panel.add(buttons[i][j]);
                        }
                        buttons[i][j].setIcon(new ImageIcon(img));
                    } else {
                        if (control.getBoard().cards[i][j].getcolor().equals(Piececolor.RED)) {
                            imageURL = cldr.getResource("RedPieces/redHidden.png");
                            img = new ImageIcon(imageURL).getImage();
                            img = img.getScaledInstance(59, 62, Image.SCALE_SMOOTH);

                        } else if (control.getBoard().cards[i][j].toString().equals("Dragon")) {
                            imageURL = cldr.getResource("bluePieces/dragonB.png");
                            img = new ImageIcon(imageURL).getImage();
                            img = img.getScaledInstance(59, 62, Image.SCALE_SMOOTH);

                        } else if (control.getBoard().cards[i][j].toString().equals("Beast rider")) {
                            imageURL = cldr.getResource("bluePieces/beastRiderB.png");
                            img = new ImageIcon(imageURL).getImage();
                            img = img.getScaledInstance(57, 62, Image.SCALE_SMOOTH);
                        } else if (control.getBoard().cards[i][j].toString().equals("Dwarf")) {
                            imageURL = cldr.getResource("bluePieces/dwarfB.png");
                            img = new ImageIcon(imageURL).getImage();
                            img = img.getScaledInstance(59, 62, Image.SCALE_SMOOTH);

                        } else if (control.getBoard().cards[i][j].toString().equals("Scout")) {
                            imageURL = cldr.getResource("bluePieces/scoutB.png");
                            img = new ImageIcon(imageURL).getImage();
                            img = img.getScaledInstance(59, 62, Image.SCALE_SMOOTH);

                        } else if (control.getBoard().cards[i][j].toString().equals("Slayer")) {
                            imageURL = cldr.getResource("bluePieces/slayerB.png");
                            img = new ImageIcon(imageURL).getImage();
                            img = img.getScaledInstance(59, 60, Image.SCALE_SMOOTH);

                        } else if (control.getBoard().cards[i][j].toString().equals("Flag")) {
                            imageURL = cldr.getResource("bluePieces/flagB.png");
                            img = new ImageIcon(imageURL).getImage();
                            img = img.getScaledInstance(59, 62, Image.SCALE_SMOOTH);

                        } else if (control.getBoard().cards[i][j].toString().equals("Bomb")) {
                            imageURL = cldr.getResource("bluePieces/trapB.png");
                            img = new ImageIcon(imageURL).getImage();
                            img = img.getScaledInstance(59, 62, Image.SCALE_SMOOTH);

                        } else if (control.getBoard().cards[i][j].toString().equals("Elf")) {
                            imageURL = cldr.getResource("bluePieces/elfB.png");
                            img = new ImageIcon(imageURL).getImage();
                            img = img.getScaledInstance(59, 62, Image.SCALE_SMOOTH);

                        } else if (control.getBoard().cards[i][j].toString().equals("Knight")) {
                            imageURL = cldr.getResource("bluePieces/knightB.png");
                            img = new ImageIcon(imageURL).getImage();
                            img = img.getScaledInstance(59, 62, Image.SCALE_SMOOTH);

                        } else if (control.getBoard().cards[i][j].toString().equals("Yeti")) {
                            imageURL = cldr.getResource("bluePieces/yeti.png");
                            img = new ImageIcon(imageURL).getImage();
                            img = img.getScaledInstance(59, 62, Image.SCALE_SMOOTH);

                        } else if (control.getBoard().cards[i][j].toString().equals("Mage")) {
                            imageURL = cldr.getResource("bluePieces/mageB.png");
                            img = new ImageIcon(imageURL).getImage();
                            img = img.getScaledInstance(59, 62, Image.SCALE_SMOOTH);

                        } else if (control.getBoard().cards[i][j].toString().equals("Sorceress")) {
                            imageURL = cldr.getResource("bluePieces/sorceressB.png");
                            img = new ImageIcon(imageURL).getImage();
                            img = img.getScaledInstance(59, 62, Image.SCALE_SMOOTH);

                        }
                        buttons[i][j].setIcon(new ImageIcon(img));

                        if (turn == 1) {
                            buttons[i][j].addMouseListener(cl);
                        }


                        panel.add(buttons[i][j]);
                    }
                } else { // red's turn
                    if (control.getBoard().cards[i][j] == null) {
                        if ((i == 3 && (j == 6 || j == 7 || j == 3 || j == 2)) || (i == 4) && (j == 6 || j == 7 || j == 3 || j == 2)) {
                            imageURL = cldr.getResource("RedPieces/water.png");
                            img = new ImageIcon(imageURL).getImage();
                            panel.add(buttons[i][j]);
                        } else {
                            imageURL = cldr.getResource("RedPieces/blank.png");
                            img = new ImageIcon(imageURL).getImage();
                            if (turn == 1) {
                                buttons[i][j].addMouseListener(cl);
                            }
                            panel.add(buttons[i][j]);
                        }
                        buttons[i][j].setIcon(new ImageIcon(img));
                    } else {
                        if (control.getBoard().cards[i][j].getcolor().equals(Piececolor.BLUE)) {
                            imageURL = cldr.getResource("bluePieces/blueHidden.png");
                            img = new ImageIcon(imageURL).getImage();
                            img = img.getScaledInstance(59, 62, Image.SCALE_SMOOTH);

                        } else if (control.getBoard().cards[i][j].toString().equals("Dragon")) {
                            imageURL = cldr.getResource("RedPieces/dragonR.png");
                            img = new ImageIcon(imageURL).getImage();
                            img = img.getScaledInstance(59, 62, Image.SCALE_SMOOTH);


                        } else if (control.getBoard().cards[i][j].toString().equals("Beast rider")) {
                            imageURL = cldr.getResource("RedPieces/beastRiderR.png");
                            img = new ImageIcon(imageURL).getImage();
                            img = img.getScaledInstance(57, 62, Image.SCALE_SMOOTH);

                        } else if (control.getBoard().cards[i][j].toString().equals("Dwarf")) {
                            imageURL = cldr.getResource("RedPieces/dwarfR.png");
                            img = new ImageIcon(imageURL).getImage();
                            img = img.getScaledInstance(59, 62, Image.SCALE_SMOOTH);

                        } else if (control.getBoard().cards[i][j].toString().equals("Scout")) {
                            imageURL = cldr.getResource("RedPieces/scoutB.png");
                            img = new ImageIcon(imageURL).getImage();
                            img = img.getScaledInstance(59, 62, Image.SCALE_SMOOTH);

                        } else if (control.getBoard().cards[i][j].toString().equals("Slayer")) {
                            imageURL = cldr.getResource("RedPieces/slayerR.png");
                            img = new ImageIcon(imageURL).getImage();
                            img = img.getScaledInstance(59, 62, Image.SCALE_SMOOTH);

                        } else if (control.getBoard().cards[i][j].toString().equals("Flag")) {
                            imageURL = cldr.getResource("RedPieces/flagR.png");
                            img = new ImageIcon(imageURL).getImage();
                            img = img.getScaledInstance(59, 62, Image.SCALE_SMOOTH);

                        } else if (control.getBoard().cards[i][j].toString().equals("Bomb")) {
                            imageURL = cldr.getResource("RedPieces/trapR.png");
                            img = new ImageIcon(imageURL).getImage();
                            img = img.getScaledInstance(59, 62, Image.SCALE_SMOOTH);

                        } else if (control.getBoard().cards[i][j].toString().equals("Elf")) {
                            imageURL = cldr.getResource("RedPieces/elfR.png");
                            img = new ImageIcon(imageURL).getImage();
                            img = img.getScaledInstance(59, 62, Image.SCALE_SMOOTH);

                        } else if (control.getBoard().cards[i][j].toString().equals("Knight")) {
                            imageURL = cldr.getResource("RedPieces/knightR.png");
                            img = new ImageIcon(imageURL).getImage();
                            img = img.getScaledInstance(59, 62, Image.SCALE_SMOOTH);

                        } else if (control.getBoard().cards[i][j].toString().equals("LavaBeast")) {
                            imageURL = cldr.getResource("RedPieces/lavaBeast.png");
                            img = new ImageIcon(imageURL).getImage();
                            img = img.getScaledInstance(59, 62, Image.SCALE_SMOOTH);

                        } else if (control.getBoard().cards[i][j].toString().equals("Mage")) {
                            imageURL = cldr.getResource("RedPieces/mageR.png");
                            img = new ImageIcon(imageURL).getImage();
                            img = img.getScaledInstance(59, 62, Image.SCALE_SMOOTH);

                        } else if (control.getBoard().cards[i][j].toString().equals("Sorceress")) {
                            imageURL = cldr.getResource("RedPieces/sorceressR.png");
                            img = new ImageIcon(imageURL).getImage();
                            img = img.getScaledInstance(59, 62, Image.SCALE_SMOOTH);

                        }
                        if (turn == 1) {
                            buttons[i][j].addMouseListener(cl);
                        }
                        buttons[i][j].setIcon(new ImageIcon(img));
                    }
                    panel.add(buttons[i][j]);

                }
            }
        }

        add(panel);
        setSize(500, 550);
        setVisible(true);

    }


    /**
     * This class is used for doing some action(like changing the grid, check movements, make rescues if possible,etc.) after a piece button has been pushed or exited
     */

    private class CardListener implements MouseListener {
        private JButton but;
        private boolean iconSelected;
        private JButton selectedButton;

        private int scoutsecondmove=0,rescueaction=0;


        @Override
        public void mouseClicked(MouseEvent e) {

            but.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));


            if (iconSelected && (!but.equals(selectedButton) || scoutsecondmove==1 || rescueaction==1)) { // move(swap) buttons

                but.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                selectedButton.setBorder(BorderFactory.createLineBorder(Color.GRAY,1));

                /*checking if the buttons selected can be swaped*/
                if (control.checkmove(selectedButton.getText(), but.getText(),scoutsecondmove,rescueaction) && control.checkcolor(selectedButton.getText(), but.getText())) {

                    scoutsecondmove=0; // eidikh periptwsh slayer se periptwsh pou thelei na kaanei 2 kinhseis mazi

                    if (rescueaction==0 && control.checkrank(selectedButton.getText(), but.getText())) { /* an prokeitai gia attack*/

                        int attackstatus = control.attackwinner(selectedButton.getText(), but.getText());

                        if (attackstatus == 1) {        /* o paikths pou paizei twra kerdizei sthn attack*/
                            but.setIcon(selectedButton.getIcon());
                            selectedButton.setIcon(new ImageIcon("blank.png"));
                        } else if (attackstatus == 2) {   /* o paikths pou paizei twra xanei sthn attack*/
                            selectedButton.setIcon(new ImageIcon("blank.png"));
                        } else if (attackstatus == 3) {    /* kai oi 2 xanoun */
                            selectedButton.setIcon(new ImageIcon("blank.png"));
                            but.setIcon(new ImageIcon("blank.png"));
                        }

                        control.getBoard().swapattackpawns(selectedButton.getText(), but.getText(),attackstatus); // swap pawns in the board

                        if(attackstatus==1 && control.canRescue(but.getText(),selectedButton.getText())){
                            rescueaction=1;
                            iconSelected=true;
                            return;
                        }


                        if (control.EndOfGame_Winner()) {
                            dispose();      // dispose menu and grid
                            m.dispose();
                            exit(0);
                        }

                        control.getTurn().setturn();

                        try {
                            updategrid(control.getTurn().getturn());
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }

                        m.createmenu(fpawns, noret, control.getTurn().getRound(), control.getcurrentPlayer());
                        iconSelected = false;

                    } else { // aplh kinhsh

                        if (rescueaction == 1) { // eimai se fash rescue

                            rescueaction = 0;
                            but.setIcon(control.RescueIcon());
                            control.getBoard().swaprescuepawn(control.RescuePiece(), but.getText());

                            if (control.EndOfGame_Winner()) {
                                dispose();      // dispose menu and grid
                                m.dispose();
                                exit(0);
                            }

                            control.getTurn().setturn();

                            try {
                                updategrid(control.getTurn().getturn());
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }

                            m.createmenu(fpawns, noret, control.getTurn().getRound(), control.getcurrentPlayer());
                            iconSelected = false;

                        } else { // an den eimai se fash rescue

                            icon = but.getIcon();
                            but.setIcon(selectedButton.getIcon());
                            selectedButton.setIcon(icon);

                            control.getBoard().swappawns(selectedButton.getText(), but.getText()); // swap pawns

                            if (control.getBoard().returnpawn(but.getText()).toString().equals("Scout")) { // pairnei  to but button epeidh akrivws prin allazw ta pionia


                                if (control.scoutcanattack(but.getText()) && scout.ScoutExtramove()) {  /* an mporei kai thelei na kanei kai deuterh kinhsh*/
                                    scoutsecondmove = 1;
                                    iconSelected = false;
                                } else {

                                    if (control.EndOfGame_Winner()) {
                                        dispose();   // dispose menu and grid
                                        m.dispose();
                                        exit(0);
                                    }
                                    control.getTurn().setturn();


                                    try {
                                        updategrid(control.getTurn().getturn());
                                    } catch (IOException ex) {
                                        throw new RuntimeException(ex);
                                    }
                                    m.createmenu(fpawns, noret, control.getTurn().getRound(), control.getcurrentPlayer());

                                    iconSelected = false;

                                }
                            } else {

                                if (control.canRescue(but.getText(),selectedButton.getText())) {
                                    rescueaction = 1;
                                    iconSelected = true;
                                } else {

                                    if (control.EndOfGame_Winner()) {
                                        dispose(); // dispose menu and grid
                                        m.dispose();
                                        exit(0);
                                    }
                                    control.getTurn().setturn();

                                    try {
                                        updategrid(control.getTurn().getturn());
                                    } catch (IOException ex) {
                                        throw new RuntimeException(ex);
                                    }
                                    m.createmenu(fpawns, noret, control.getTurn().getRound(), control.getcurrentPlayer());
                                    iconSelected = false;
                                }
                            }
                        }
                    }
                  }else{
                    if(rescueaction==0) { // an den vriskomai se fash rescue
                        iconSelected = false;
                    }
                }
                } else if (!iconSelected) { // if not selected icon is joker then selected

                    iconSelected = true; // we can do without it, we can check for null selected button
                    selectedButton = but;
                    selectedButton.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));

                } else { // if already selected or not selected at all
                    if (iconSelected) {
                        System.out.println("Already Selected");
                    } else {
                        System.out.println("Not selected");
                    }
                }
            }
                @Override
                public void mousePressed (MouseEvent e){
                    but = ((JButton) e.getSource());
                    lightupbuttons(but.getText());
                }

                @Override
                public void mouseReleased (MouseEvent e){
                    switchofflights(but.getText());

                }

                @Override
                public void mouseEntered (MouseEvent e){

                }

                @Override
                public void mouseExited (MouseEvent e){

                }
            }


    /**This method lights up correctly the buttons to which the pawn that the player wants to move now can be moved
     * */
            private void lightupbuttons (String xy1) {
                int xy_1 = parseInt(xy1);
                int x1 = xy_1 / 10;
                int y1 = xy_1 % 10;

                // na mhn ginei tipota
                if (control.getBoard().cards[x1][y1] == null) { /* an sthn arxh pathse ena leuko "pioni" gia na to metakinisei*/
                    return;
                }
                if (control.getBoard().cards[x1][y1].getcolor().equals(Piececolor.RED) && control.getTurn().getturn() % 2 != 0) {
                    return;
                } else if (control.getBoard().cards[x1][y1].getcolor().equals(Piececolor.BLUE) && control.getTurn().getturn() % 2 == 0) {
                    return;
                } else if (control.getBoard().cards[x1][y1] instanceof Immovablepiece) { // DEN MPOREI NA KOUNHTHEI
                    return;
                }

                if (control.getNoretrieve() == 0 && control.getBoard().cards[x1][y1].toString().equals("Scout")) {

                    i = x1-1;
                    while (i >= 0) {  //pao pros ta panw me stathero y
                        if (i == 3 && (y1 == 2 || y1 == 3 || y1 == 6 || y1 == 7)) {
                            i=0;

                        }else if (i == 4 && (y1 == 2 || y1 == 3 || y1 == 6 || y1 == 7)) {
                            i=0;

                        }else if (control.getBoard().cards[i][y1] != null) {
                            if (!control.getBoard().cards[x1][y1].getcolor().equals(control.getBoard().cards[i][y1].getcolor())) {
                                buttons[i][y1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                            }
                            i=0;

                        } else {
                            buttons[i][y1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                        }

                        i--;
                    }

                    i = x1+1;
                    while (i <= 7) { //paw pros ta katw me stathero y
                        if (i == 3  && (y1 == 2 || y1 == 3 || y1 == 6 || y1 == 7)) {
                            i=7;

                        }else if (i == 4 && (y1 == 2 || y1 == 3 || y1 == 6 || y1 == 7)) {
                            i=7;

                        }else if (control.getBoard().cards[i][y1] != null) {
                            if (!control.getBoard().cards[x1][y1].getcolor().equals(control.getBoard().cards[i][y1].getcolor())) {
                                buttons[i][y1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                            }
                            i=7;
                        } else {
                            buttons[i][y1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                        }

                        i++;
                    }

                    i = y1-1;
                    while (i >= 0) { // paw pros aristera me stathero x
                        if (i == 2  && (x1 == 3 || x1 == 4)) {
                            i=0;

                        }else if (i == 3  && (x1 == 3 || x1 == 4)) {
                            i=0;

                        } else if (i == 6  && (x1 == 3 || x1 == 4)) {
                            i=0;

                        } else if (i == 7  && (x1 == 3 || x1 == 4)) {
                            i=0;
                        }
                        else if (control.getBoard().cards[x1][i] != null) {
                            if (!control.getBoard().cards[x1][y1].getcolor().equals(control.getBoard().cards[x1][i].getcolor())) {
                                buttons[x1][i].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                            }
                            i = 0;
                        }else {
                            buttons[x1][i].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                        }

                        i--;
                    }

                    i = y1+1;
                    while (i <= 9) {    // paw pros dexia me stathero x
                        if (i == 2 && (x1 == 3 || x1 == 4)) {
                            i = 9;

                        } else if (i == 3 && (x1 == 3 || x1 == 4)) {
                            i = 9;

                        } else if (i == 6 && (x1 == 3 || x1 == 4)) {
                            i = 9;

                        } else if (i == 7 && (x1 == 3 || x1 == 4)) {
                            i = 9;

                        } else if (control.getBoard().cards[x1][i] != null) {
                            if (!control.getBoard().cards[x1][y1].getcolor().equals(control.getBoard().cards[x1][i].getcolor())) {
                                buttons[x1][i].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                            }
                            i = 9;
                        } else {
                            buttons[x1][i].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                        }

                        i++;
                    }
                }else if(control.getNoretrieve()==1 && control.getBoard().cards[x1][y1].toString().equals("Scout")) {

                    if(control.getBoard().cards[x1][y1].getcolor().equals(Piececolor.BLUE)) {

                        i = x1 + 1;
                        while (i <= 7) { //paw pros ta katw me stathero y
                            if (i == 3 && (y1 == 2 || y1 == 3 || y1 == 6 || y1 == 7)) {
                                i = 7;

                            } else if (i == 4 && (y1 == 2 || y1 == 3 || y1 == 6 || y1 == 7)) {
                                i = 7;

                            } else if (control.getBoard().cards[i][y1] != null) {
                                if (!control.getBoard().cards[x1][y1].getcolor().equals(control.getBoard().cards[i][y1].getcolor())) {
                                    buttons[i][y1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                }
                                i = 7;
                            } else {
                                buttons[i][y1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                            }

                            i++;
                        }

                        i = y1 - 1;
                        while (i >= 0) { // paw pros aristera me stathero x
                            if (i == 2 && (x1 == 3 || x1 == 4)) {
                                i = 0;

                            } else if (i == 3 && (x1 == 3 || x1 == 4)) {
                                i = 0;

                            } else if (i == 6 && (x1 == 3 || x1 == 4)) {
                                i = 0;

                            } else if (i == 7 && (x1 == 3 || x1 == 4)) {
                                i = 0;

                            } else if (control.getBoard().cards[x1][i] != null) {
                                if (!control.getBoard().cards[x1][y1].getcolor().equals(control.getBoard().cards[x1][i].getcolor())) {
                                    buttons[x1][i].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                }
                                i = 0;
                            } else {
                                buttons[x1][i].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                            }

                            i--;
                        }
                        i = y1 + 1;
                        while (i <= 9) {    // paw pros dexia me stathero x
                            if (i == 2 && (x1 == 3 || x1 == 4)) {
                                i = 9;

                            } else if (i == 3 && (x1 == 3 || x1 == 4)) {
                                i = 9;

                            } else if (i == 6 && (x1 == 3 || x1 == 4)) {
                                i = 9;

                            } else if (i == 7 && (x1 == 3 || x1 == 4)) {
                                i = 9;

                            } else if (control.getBoard().cards[x1][i] != null) {
                                if (!control.getBoard().cards[x1][y1].getcolor().equals(control.getBoard().cards[x1][i].getcolor())) {
                                    buttons[x1][i].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                }
                                i = 9;
                            } else {
                                buttons[x1][i].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                            }

                            i++;
                        }
                    }else{ // gia red scout

                        i = x1-1;
                        while (i >= 0) {  //pao pros ta panw me stathero y
                            if (i == 3 && (y1 == 2 || y1 == 3 || y1 == 6 || y1 == 7)) {
                                i=0;

                            }else if (i == 4 && (y1 == 2 || y1 == 3 || y1 == 6 || y1 == 7)) {
                                i=0;

                            }else if (control.getBoard().cards[i][y1] != null) {
                                if (!control.getBoard().cards[x1][y1].getcolor().equals(control.getBoard().cards[i][y1].getcolor())) {
                                    buttons[i][y1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                }
                                i=0;

                            } else {
                                buttons[i][y1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                            }


                            i--;
                        }

                        i = y1-1;
                        while (i >= 0) { // paw pros aristera me stathero x
                            if (i == 2  && (x1 == 3 || x1 == 4)) {
                                i=0;

                            }else if (i == 3  && (x1 == 3 || x1 == 4)) {
                                i=0;

                            } else if (i == 6  && (x1 == 3 || x1 == 4)) {
                                i=0;

                            } else if (i == 7  && (x1 == 3 || x1 == 4)) {
                                i=0;

                            }
                            else if (control.getBoard().cards[x1][i] != null) {
                                if (!control.getBoard().cards[x1][y1].getcolor().equals(control.getBoard().cards[x1][i].getcolor())) {
                                    buttons[x1][i].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                }
                                i = 0;
                            }else {
                                buttons[x1][i].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                            }
                            i--;
                        }

                        i = y1+1;
                        while (i <= 9) {    // paw pros dexia me stathero x

                            if (i == 2 && (x1 == 3 || x1 == 4)) {
                                i = 9;

                            } else if (i == 3 && (x1 == 3 || x1 == 4)) {
                                i = 9;

                            } else if (i == 6 && (x1 == 3 || x1 == 4)) {
                                i = 9;

                            } else if (i == 7 && (x1 == 3 || x1 == 4)) {
                                i = 9;

                            } else if (control.getBoard().cards[x1][i] != null) {
                                if (!control.getBoard().cards[x1][y1].getcolor().equals(control.getBoard().cards[x1][i].getcolor())) {
                                    buttons[x1][i].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                }
                                i = 9;
                            } else {
                                buttons[x1][i].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                            }

                            i++;
                        }
                    }
                   }else {  // gia ola ta alla pionia

                      if (control.getNoretrieve() == 0) {

                        if (x1 == 0) {
                            if (y1 == 0) {

                                if (control.getBoard().cards[x1 + 1][y1] != null) {
                                    if (!control.getBoard().cards[x1][y1].getcolor().equals(control.getBoard().cards[x1 + 1][y1].getcolor())) {
                                        buttons[x1 + 1][y1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                    }
                                } else {
                                    buttons[x1 + 1][y1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                }
                                if (control.getBoard().cards[x1][y1 + 1] != null) {
                                    if (!control.getBoard().cards[x1][y1].getcolor().equals(control.getBoard().cards[x1][y1 + 1].getcolor())) {
                                        buttons[x1][y1 + 1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                    }
                                } else {
                                    buttons[x1][y1 + 1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                }
                                return;

                            } else if (y1 == 9) {

                                if (control.getBoard().cards[x1 + 1][y1] != null) {
                                    if (!control.getBoard().cards[x1][y1].getcolor().equals(control.getBoard().cards[x1 + 1][y1].getcolor())) {
                                        buttons[x1 + 1][y1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                    }
                                } else {
                                    buttons[x1 + 1][y1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                }
                                if (control.getBoard().cards[x1][y1 - 1] != null) {
                                    if (!control.getBoard().cards[x1][y1].getcolor().equals(control.getBoard().cards[x1][y1 - 1].getcolor())) {
                                        buttons[x1][y1 - 1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                    }
                                } else {
                                    buttons[x1][y1 - 1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                }
                                return;
                            }
                            if (control.getBoard().cards[x1 + 1][y1] != null) {
                                if (!control.getBoard().cards[x1][y1].getcolor().equals(control.getBoard().cards[x1 + 1][y1].getcolor())) {
                                    buttons[x1 + 1][y1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                }
                            } else {
                                buttons[x1 + 1][y1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                            }

                            if (control.getBoard().cards[x1][y1 + 1] != null) {
                                if (!control.getBoard().cards[x1][y1].getcolor().equals(control.getBoard().cards[x1][y1 + 1].getcolor())) {
                                    buttons[x1][y1 + 1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                }
                            } else {
                                buttons[x1][y1 + 1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                            }

                            if (control.getBoard().cards[x1][y1 - 1] != null) {
                                if (!control.getBoard().cards[x1][y1].getcolor().equals(control.getBoard().cards[x1][y1 - 1].getcolor())) {
                                    buttons[x1][y1 - 1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                }
                            } else {
                                buttons[x1][y1 - 1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                            }
                            return;

                        } else if (x1 == 7) {
                            if (y1 == 0) {

                                if (control.getBoard().cards[x1 - 1][y1] != null) {
                                    if (!control.getBoard().cards[x1][y1].getcolor().equals(control.getBoard().cards[x1 - 1][y1].getcolor())) {
                                        buttons[x1 - 1][y1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                    }
                                } else {
                                    buttons[x1 - 1][y1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                }

                                if (control.getBoard().cards[x1][y1 + 1] != null) {
                                    if (!control.getBoard().cards[x1][y1].getcolor().equals(control.getBoard().cards[x1][y1 + 1].getcolor())) {
                                        buttons[x1][y1 + 1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                    }
                                } else {
                                    buttons[x1][y1 + 1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                }
                                return;

                            } else if (y1 == 9) {

                                if (control.getBoard().cards[x1 - 1][y1] != null) {
                                    if (!control.getBoard().cards[x1][y1].getcolor().equals(control.getBoard().cards[x1 - 1][y1].getcolor())) {
                                        buttons[x1 - 1][y1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                    }
                                } else {
                                    buttons[x1 - 1][y1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                }

                                if (control.getBoard().cards[x1][y1 - 1] != null) {
                                    if (!control.getBoard().cards[x1][y1].getcolor().equals(control.getBoard().cards[x1][y1 - 1].getcolor())) {
                                        buttons[x1][y1 - 1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                    }
                                } else {
                                    buttons[x1][y1 - 1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                }
                                return;
                            }
                            if (control.getBoard().cards[x1 - 1][y1] != null) {
                                if (!control.getBoard().cards[x1][y1].getcolor().equals(control.getBoard().cards[x1 - 1][y1].getcolor())) {
                                    buttons[x1 - 1][y1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                }
                            } else {
                                buttons[x1 - 1][y1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                            }

                            if (control.getBoard().cards[x1][y1 + 1] != null) {
                                if (!control.getBoard().cards[x1][y1].getcolor().equals(control.getBoard().cards[x1][y1 + 1].getcolor())) {
                                    buttons[x1][y1 + 1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                }
                            } else {
                                buttons[x1][y1 + 1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                            }

                            if (control.getBoard().cards[x1][y1 - 1] != null) {
                                if (!control.getBoard().cards[x1][y1].getcolor().equals(control.getBoard().cards[x1][y1 - 1].getcolor())) {
                                    buttons[x1][y1 - 1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                }
                            } else {
                                buttons[x1][y1 - 1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                            }
                            return;

                        } else if (y1 == 0) {

                            if (control.getBoard().cards[x1 + 1][y1] != null) {
                                if (!control.getBoard().cards[x1][y1].getcolor().equals(control.getBoard().cards[x1 + 1][y1].getcolor())) {
                                    buttons[x1 + 1][y1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                }
                            } else {
                                buttons[x1 + 1][y1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                            }

                            if (control.getBoard().cards[x1 - 1][y1] != null) {
                                if (!control.getBoard().cards[x1][y1].getcolor().equals(control.getBoard().cards[x1 - 1][y1].getcolor())) {
                                    buttons[x1 - 1][y1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                }
                            } else {
                                buttons[x1 - 1][y1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                            }

                            if (control.getBoard().cards[x1][y1 + 1] != null) {
                                if (!control.getBoard().cards[x1][y1].getcolor().equals(control.getBoard().cards[x1][y1 + 1].getcolor())) {
                                    buttons[x1][y1 + 1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                }
                            } else {
                                buttons[x1][y1 + 1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                            }

                        } else if (y1 == 9) {

                            if (control.getBoard().cards[x1 + 1][y1] != null) {
                                if (!control.getBoard().cards[x1][y1].getcolor().equals(control.getBoard().cards[x1 + 1][y1].getcolor())) {
                                    buttons[x1 + 1][y1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                }
                            } else {
                                buttons[x1 + 1][y1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                            }

                            if (control.getBoard().cards[x1 - 1][y1] != null) {
                                if (!control.getBoard().cards[x1][y1].getcolor().equals(control.getBoard().cards[x1 - 1][y1].getcolor())) {
                                    buttons[x1 - 1][y1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                }
                            } else {
                                buttons[x1 - 1][y1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                            }

                            if (control.getBoard().cards[x1][y1 - 1] != null) {
                                if (!control.getBoard().cards[x1][y1].getcolor().equals(control.getBoard().cards[x1][y1 - 1].getcolor())) {
                                    buttons[x1][y1 - 1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                }
                            } else {
                                buttons[x1][y1 - 1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                            }

                        } else {

                            if (x1 + 1 == 3 || x1 + 1 == 4) { // elegxos gia thn apagoewumenh zwnh
                                if (y1 != 2 && y1 != 3 && y1 != 6 && y1 != 7) {
                                    if (control.getBoard().cards[x1 + 1][y1] != null) {
                                        if (!control.getBoard().cards[x1][y1].getcolor().equals(control.getBoard().cards[x1 + 1][y1].getcolor())) {
                                            buttons[x1 + 1][y1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                        }
                                    } else {
                                        buttons[x1 + 1][y1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                    }
                                }
                            } else {
                                if (control.getBoard().cards[x1 + 1][y1] != null) {
                                    if (!control.getBoard().cards[x1][y1].getcolor().equals(control.getBoard().cards[x1 + 1][y1].getcolor())) {
                                        buttons[x1 + 1][y1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                    }
                                } else {
                                    buttons[x1 + 1][y1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                }
                            }

                            if (x1 - 1 == 3 || x1 - 1 == 4) { // elegxos gia thn apagoewumenh zwnh
                                if (y1 != 2 && y1 != 3 && y1 != 6 && y1 != 7) {
                                    if (control.getBoard().cards[x1 - 1][y1] != null) {
                                        if (!control.getBoard().cards[x1][y1].getcolor().equals(control.getBoard().cards[x1 - 1][y1].getcolor())) {
                                            buttons[x1 - 1][y1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                        }
                                    } else {
                                        buttons[x1 - 1][y1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                    }
                                }

                            } else {

                                if (control.getBoard().cards[x1 - 1][y1] != null) {
                                    if (!control.getBoard().cards[x1][y1].getcolor().equals(control.getBoard().cards[x1 - 1][y1].getcolor())) {
                                        buttons[x1 - 1][y1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                    }
                                } else {
                                    buttons[x1 - 1][y1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                }
                            }

                            if (x1 == 3 || x1 == 4) {  // elegxos gia thn apagoewumenh zwnh

                                if (y1 + 1 != 2 && y1 + 1 != 3 && y1 + 1 != 6 && y1 + 1 != 7) {
                                    if (control.getBoard().cards[x1][y1 + 1] != null) {
                                        if (!control.getBoard().cards[x1][y1].getcolor().equals(control.getBoard().cards[x1][y1 + 1].getcolor())) {
                                            buttons[x1][y1 + 1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                        }
                                    } else {
                                        buttons[x1][y1 + 1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                    }
                                }

                                if (y1 - 1 != 2 && y1 - 1 != 3 && y1 - 1 != 6 && y1 - 1 != 7) {
                                    if (control.getBoard().cards[x1][y1 - 1] != null) {
                                        if (!control.getBoard().cards[x1][y1].getcolor().equals(control.getBoard().cards[x1][y1 - 1].getcolor())) {
                                            buttons[x1][y1 - 1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                        }
                                    } else {
                                        buttons[x1][y1 - 1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                    }
                                }

                            } else {

                                if (control.getBoard().cards[x1][y1 - 1] != null) {
                                    if (!control.getBoard().cards[x1][y1].getcolor().equals(control.getBoard().cards[x1][y1 - 1].getcolor())) {
                                        buttons[x1][y1 - 1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                    }
                                } else {
                                    buttons[x1][y1 - 1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                }

                                if (control.getBoard().cards[x1][y1 + 1] != null) {
                                    if (!control.getBoard().cards[x1][y1].getcolor().equals(control.getBoard().cards[x1][y1 + 1].getcolor())) {
                                        buttons[x1][y1 + 1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                    }
                                } else {
                                    buttons[x1][y1 + 1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                }
                            }
                        }
                    } else { // with no retrieve

                        if (control.getBoard().cards[x1][y1].getcolor().equals(Piececolor.BLUE)) {

                            if (x1 == 0) {
                                if (y1 == 0) {

                                    if (control.getBoard().cards[x1 + 1][y1] != null) {
                                        if (!control.getBoard().cards[x1][y1].getcolor().equals(control.getBoard().cards[x1 + 1][y1].getcolor())) {
                                            buttons[x1 + 1][y1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                        }
                                    } else {
                                        buttons[x1 + 1][y1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                    }

                                    if (control.getBoard().cards[x1][y1 + 1] != null) {
                                        if (!control.getBoard().cards[x1][y1].getcolor().equals(control.getBoard().cards[x1][y1 + 1].getcolor())) {
                                            buttons[x1][y1 + 1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                        }
                                    } else {
                                        buttons[x1][y1 + 1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                    }
                                    return;

                                } else if (y1 == 9) {

                                    if (control.getBoard().cards[x1 + 1][y1] != null) {
                                        if (!control.getBoard().cards[x1][y1].getcolor().equals(control.getBoard().cards[x1 + 1][y1].getcolor())) {
                                            buttons[x1 + 1][y1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                        }
                                    } else {
                                        buttons[x1 + 1][y1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                    }

                                    if (control.getBoard().cards[x1][y1 - 1] != null) {
                                        if (!control.getBoard().cards[x1][y1].getcolor().equals(control.getBoard().cards[x1][y1 - 1].getcolor())) {
                                            buttons[x1][y1 - 1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                        }
                                    } else {
                                        buttons[x1][y1 - 1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                    }
                                    return;

                                } else {

                                    if (control.getBoard().cards[x1 + 1][y1] != null) {
                                        if (!control.getBoard().cards[x1][y1].getcolor().equals(control.getBoard().cards[x1 + 1][y1].getcolor())) {
                                            buttons[x1 + 1][y1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                        }
                                    } else {
                                        buttons[x1 + 1][y1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                    }

                                    if (control.getBoard().cards[x1][y1 + 1] != null) {
                                        if (!control.getBoard().cards[x1][y1].getcolor().equals(control.getBoard().cards[x1][y1 + 1].getcolor())) {
                                            buttons[x1][y1 + 1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                        }
                                    } else {
                                        buttons[x1][y1 + 1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                    }

                                    if (control.getBoard().cards[x1][y1 - 1] != null) {
                                        if (!control.getBoard().cards[x1][y1].getcolor().equals(control.getBoard().cards[x1][y1 - 1].getcolor())) {
                                            buttons[x1][y1 - 1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                        }
                                    } else {
                                        buttons[x1][y1 - 1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                    }
                                    return;
                                }
                            } else if (x1 == 7) {

                                if (y1 == 0) {

                                    if (control.getBoard().cards[x1][y1 + 1] != null) {
                                        if (!control.getBoard().cards[x1][y1].getcolor().equals(control.getBoard().cards[x1][y1 + 1].getcolor())) {
                                            buttons[x1][y1 + 1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                        }
                                    } else {
                                        buttons[x1][y1 + 1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                    }
                                    return;

                                } else if (y1 == 9) {

                                    if (control.getBoard().cards[x1][y1 - 1] != null) {
                                        if (!control.getBoard().cards[x1][y1].getcolor().equals(control.getBoard().cards[x1][y1 - 1].getcolor())) {
                                            buttons[x1][y1 - 1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                        }
                                    } else {
                                        buttons[x1][y1 - 1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                    }
                                    return;

                                } else {

                                    if (control.getBoard().cards[x1][y1 + 1] != null) {
                                        if (!control.getBoard().cards[x1][y1].getcolor().equals(control.getBoard().cards[x1][y1 + 1].getcolor())) {
                                            buttons[x1][y1 + 1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                        }
                                    } else {
                                        buttons[x1][y1 + 1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                    }

                                    if (control.getBoard().cards[x1][y1 - 1] != null) {
                                        if (!control.getBoard().cards[x1][y1].getcolor().equals(control.getBoard().cards[x1][y1 - 1].getcolor())) {
                                            buttons[x1][y1 - 1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                        }
                                    } else {
                                        buttons[x1][y1 - 1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                    }
                                    return;
                                }
                            } else if (y1 == 0) {

                                if (control.getBoard().cards[x1 + 1][y1] != null) {
                                    if (!control.getBoard().cards[x1][y1].getcolor().equals(control.getBoard().cards[x1 + 1][y1].getcolor())) {
                                        buttons[x1 + 1][y1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                    }
                                } else {
                                    buttons[x1 + 1][y1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                }

                                if (control.getBoard().cards[x1][y1 + 1] != null) {
                                    if (!control.getBoard().cards[x1][y1].getcolor().equals(control.getBoard().cards[x1][y1 + 1].getcolor())) {
                                        buttons[x1][y1 + 1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                    }
                                } else {
                                    buttons[x1][y1 + 1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                }

                            } else if (y1 == 9) {

                                if (control.getBoard().cards[x1 + 1][y1] != null) {
                                    if (!control.getBoard().cards[x1][y1].getcolor().equals(control.getBoard().cards[x1 + 1][y1].getcolor())) {
                                        buttons[x1 + 1][y1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                    }
                                } else {
                                    buttons[x1 + 1][y1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                }

                                if (control.getBoard().cards[x1][y1 - 1] != null) {
                                    if (!control.getBoard().cards[x1][y1].getcolor().equals(control.getBoard().cards[x1][y1 - 1].getcolor())) {
                                        buttons[x1][y1 - 1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                    }
                                } else {
                                    buttons[x1][y1 - 1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                }

                            } else {  // usual case

                                if (x1 + 1 == 3 || x1 + 1 == 4) { // elegxos gia thn apagoewumenh zwnh
                                    if (y1 != 2 && y1 != 3 && y1 != 6 && y1 != 7) {
                                        if (control.getBoard().cards[x1 + 1][y1] != null) {
                                            if (!control.getBoard().cards[x1][y1].getcolor().equals(control.getBoard().cards[x1 + 1][y1].getcolor())) {
                                                buttons[x1 + 1][y1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                            }
                                        } else {
                                            buttons[x1 + 1][y1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                        }
                                    }

                                } else {

                                    if (control.getBoard().cards[x1 + 1][y1] != null) {
                                        if (!control.getBoard().cards[x1][y1].getcolor().equals(control.getBoard().cards[x1 + 1][y1].getcolor())) {
                                            buttons[x1 + 1][y1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                        }
                                    } else {
                                        buttons[x1 + 1][y1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                    }
                                }

                                if (x1 == 3 || x1 == 4) { // elegxos gia thn apagoewumenh zwnh
                                    if (y1 + 1 != 2 && y1 + 1 != 3 && y1 + 1 != 6 && y1 + 1 != 7) {
                                        if (control.getBoard().cards[x1][y1 + 1] != null) {

                                            if (!control.getBoard().cards[x1][y1].getcolor().equals(control.getBoard().cards[x1][y1 + 1].getcolor())) {
                                                buttons[x1][y1 + 1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                            }
                                        } else {
                                            buttons[x1][y1 + 1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                        }
                                    }

                                    if (y1 - 1 != 2 && y1 - 1 != 3 && y1 - 1 != 6 && y1 - 1 != 7) {
                                        if (control.getBoard().cards[x1][y1 - 1] != null) {

                                            if (!control.getBoard().cards[x1][y1].getcolor().equals(control.getBoard().cards[x1][y1 - 1].getcolor())) {
                                                buttons[x1][y1 - 1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                            }
                                        } else {
                                            buttons[x1][y1 - 1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                        }
                                    }

                                } else {  //an den kinduneuw na eimai se apagoreumenh zwnh

                                    if (control.getBoard().cards[x1][y1 - 1] != null) {
                                        if (!control.getBoard().cards[x1][y1].getcolor().equals(control.getBoard().cards[x1][y1 - 1].getcolor())) {
                                            buttons[x1][y1 - 1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                        }
                                    } else {
                                        buttons[x1][y1 - 1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                    }

                                    if (control.getBoard().cards[x1][y1 + 1] != null) {
                                        if (!control.getBoard().cards[x1][y1].getcolor().equals(control.getBoard().cards[x1][y1 + 1].getcolor())) {
                                            buttons[x1][y1 + 1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                        }
                                    } else {
                                        buttons[x1][y1 + 1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                    }

                                }
                            }
                        } else {  // red pawns

                            if (x1 == 0) {   // eidikes periptwseis
                                if (y1 == 0) {

                                    if (control.getBoard().cards[x1][y1 + 1] != null) {
                                        if (!control.getBoard().cards[x1][y1].getcolor().equals(control.getBoard().cards[x1][y1 + 1].getcolor())) {
                                            buttons[x1][y1 + 1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                        }
                                    } else {
                                        buttons[x1][y1 + 1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                    }

                                } else if (y1 == 9) {

                                    if (control.getBoard().cards[x1][y1 - 1] != null) {
                                        if (!control.getBoard().cards[x1][y1].getcolor().equals(control.getBoard().cards[x1][y1 - 1].getcolor())) {
                                            buttons[x1][y1 - 1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                        }
                                    } else {
                                        buttons[x1][y1 - 1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                    }

                                } else {

                                    if (control.getBoard().cards[x1][y1 + 1] != null) {
                                        if (!control.getBoard().cards[x1][y1].getcolor().equals(control.getBoard().cards[x1][y1 + 1].getcolor())) {
                                            buttons[x1][y1 + 1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                        }
                                    } else {
                                        buttons[x1][y1 + 1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                    }

                                    if (control.getBoard().cards[x1][y1 - 1] != null) {
                                        if (!control.getBoard().cards[x1][y1].getcolor().equals(control.getBoard().cards[x1][y1 - 1].getcolor())) {
                                            buttons[x1][y1 - 1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                        }
                                    } else {
                                        buttons[x1][y1 - 1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                    }
                                }

                            } else if (x1 == 7) {
                                if (y1 == 0) {
                                    if (control.getBoard().cards[x1 - 1][y1] != null) {
                                        if (!control.getBoard().cards[x1][y1].getcolor().equals(control.getBoard().cards[x1 - 1][y1].getcolor())) {
                                            buttons[x1 - 1][y1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                        }
                                    } else {
                                        buttons[x1 - 1][y1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                    }
                                    if (control.getBoard().cards[x1][y1 + 1] != null) {
                                        if (!control.getBoard().cards[x1][y1].getcolor().equals(control.getBoard().cards[x1][y1 + 1].getcolor())) {
                                            buttons[x1][y1 + 1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                        }
                                    } else {
                                        buttons[x1][y1 + 1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                    }
                                    return;

                                } else if (y1 == 9) {

                                    if (control.getBoard().cards[x1 - 1][y1] != null) {
                                        if (!control.getBoard().cards[x1][y1].getcolor().equals(control.getBoard().cards[x1 - 1][y1].getcolor())) {
                                            buttons[x1 - 1][y1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                        }
                                    } else {
                                        buttons[x1 - 1][y1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                    }

                                    if (control.getBoard().cards[x1][y1 - 1] != null) {
                                        if (!control.getBoard().cards[x1][y1].getcolor().equals(control.getBoard().cards[x1][y1 - 1].getcolor())) {
                                            buttons[x1][y1 - 1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                        }
                                    } else {
                                        buttons[x1][y1 - 1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                    }
                                    return;

                                } else {
                                    if (control.getBoard().cards[x1 - 1][y1] != null) {
                                        if (!control.getBoard().cards[x1][y1].getcolor().equals(control.getBoard().cards[x1 - 1][y1].getcolor())) {
                                            buttons[x1 - 1][y1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                        }
                                    } else {
                                        buttons[x1 - 1][y1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                    }

                                    if (control.getBoard().cards[x1][y1 + 1] != null) {
                                        if (!control.getBoard().cards[x1][y1].getcolor().equals(control.getBoard().cards[x1][y1 + 1].getcolor())) {
                                            buttons[x1][y1 + 1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                        }
                                    } else {
                                        buttons[x1][y1 + 1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                    }

                                    if (control.getBoard().cards[x1][y1 - 1] != null) {
                                        if (!control.getBoard().cards[x1][y1].getcolor().equals(control.getBoard().cards[x1][y1 - 1].getcolor())) {
                                            buttons[x1][y1 - 1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                        }
                                    } else {
                                        buttons[x1][y1 - 1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                    }
                                    return;
                                }

                            } else if (y1 == 0) {

                                if (control.getBoard().cards[x1 - 1][y1] != null) {
                                    if (!control.getBoard().cards[x1][y1].getcolor().equals(control.getBoard().cards[x1 - 1][y1].getcolor())) {
                                        buttons[x1 - 1][y1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                    }
                                } else {
                                    buttons[x1 - 1][y1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                }

                                if (control.getBoard().cards[x1][y1 + 1] != null) {
                                    if (!control.getBoard().cards[x1][y1].getcolor().equals(control.getBoard().cards[x1][y1 + 1].getcolor())) {
                                        buttons[x1][y1 + 1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                    }
                                } else {
                                    buttons[x1][y1 + 1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                }
                            } else if (y1 == 9) {

                                if (control.getBoard().cards[x1 - 1][y1] != null) {
                                    if (!control.getBoard().cards[x1][y1].getcolor().equals(control.getBoard().cards[x1 - 1][y1].getcolor())) {
                                        buttons[x1 - 1][y1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                    }
                                } else {
                                    buttons[x1 - 1][y1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                }

                                if (control.getBoard().cards[x1][y1 - 1] != null) {
                                    if (!control.getBoard().cards[x1][y1].getcolor().equals(control.getBoard().cards[x1][y1 - 1].getcolor())) {
                                        buttons[x1][y1 - 1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                    }
                                } else {
                                    buttons[x1][y1 - 1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                }
                            } else {

                                if (x1 - 1 == 3 || x1 - 1 == 4) {
                                    if (y1 != 2 && y1 != 3 && y1 != 6 && y1 != 7) {
                                        if (control.getBoard().cards[x1 - 1][y1] != null) {
                                            if (!control.getBoard().cards[x1][y1].getcolor().equals(control.getBoard().cards[x1 - 1][y1].getcolor())) {
                                                buttons[x1 - 1][y1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                            }
                                        } else {
                                            buttons[x1 - 1][y1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                        }
                                    }
                                } else {
                                    if (control.getBoard().cards[x1 - 1][y1] != null) {
                                        if (!control.getBoard().cards[x1][y1].getcolor().equals(control.getBoard().cards[x1 - 1][y1].getcolor())) {
                                            buttons[x1 - 1][y1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                        }
                                    } else {
                                        buttons[x1 - 1][y1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                    }
                                }

                                if (x1 == 3 || x1 == 4) {
                                    if (y1 + 1 != 2 && y1 + 1 != 3 && y1 + 1 != 6 && y1 + 1 != 7) {
                                        if (control.getBoard().cards[x1][y1 + 1] != null) {
                                            if (!control.getBoard().cards[x1][y1].getcolor().equals(control.getBoard().cards[x1][y1 + 1].getcolor())) {
                                                buttons[x1][y1 + 1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                            }
                                        } else {
                                            buttons[x1][y1 + 1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                        }
                                    }

                                    if (y1 - 1 != 2 && y1 - 1 != 3 && y1 - 1 != 6 && y1 - 1 != 7) {
                                        if (control.getBoard().cards[x1][y1 - 1] != null) {
                                            if (!control.getBoard().cards[x1][y1].getcolor().equals(control.getBoard().cards[x1][y1 - 1].getcolor())) {
                                                buttons[x1][y1 - 1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                            }
                                        } else {
                                            buttons[x1][y1 - 1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                        }
                                    }

                                } else { //an den kinduneuw na eimai se apagoreumenh zwnh

                                    if (control.getBoard().cards[x1][y1 - 1] != null) {
                                        if (!control.getBoard().cards[x1][y1].getcolor().equals(control.getBoard().cards[x1][y1 - 1].getcolor())) {
                                            buttons[x1][y1 - 1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                        }
                                    } else {
                                        buttons[x1][y1 - 1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                    }

                                    if (control.getBoard().cards[x1][y1 + 1] != null) {
                                        if (!control.getBoard().cards[x1][y1].getcolor().equals(control.getBoard().cards[x1][y1 + 1].getcolor())) {
                                            buttons[x1][y1 + 1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                        }
                                    } else {
                                        buttons[x1][y1 + 1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                                    }
                                }
                            }
                        }
                    }
                }
                panel.validate();
                panel.repaint();

            }

    /**This method repaints gray(buttons board natural color) the buttons which previously had been painted yellow
     * */
            private void switchofflights (String xy1){
                int xy_1 = parseInt(xy1);
                int x1 = xy_1 / 10;
                int y1 = xy_1 % 10;

                // na mhn ginei tipota
                if (control.getBoard().cards[x1][y1] == null) { /* an sthn arxh pathse ena leuko "pioni" gia na to metakinisei*/
                    return;
                }
                if (control.getBoard().cards[x1][y1].getcolor().equals(Piececolor.RED) && control.getTurn().getturn() % 2 != 0) {
                    return;
                } else if (control.getBoard().cards[x1][y1].getcolor().equals(Piececolor.BLUE) && control.getTurn().getturn() % 2 == 0) {
                    return;
                }

                if (control.getNoretrieve() == 0 && control.getBoard().cards[x1][y1].toString().equals("Scout")) {

                    i = x1 - 1;
                    while (i >= 0) {  //pao pros ta panw me stathero y
                        if (i == 3 && (y1 == 2 || y1 == 3 || y1 == 6 || y1 == 7)) {
                            i = 0;

                        } else if (i == 4 && (y1 == 2 || y1 == 3 || y1 == 6 || y1 == 7)) {
                            i = 0;

                        } else if (control.getBoard().cards[i][y1] != null) {

                            if (!control.getBoard().cards[x1][y1].getcolor().equals(control.getBoard().cards[i][y1].getcolor())) {
                                buttons[i][y1].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                            } else {
                                i = 0;
                            }

                        } else {
                            buttons[i][y1].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                        }

                        i--;
                    }

                    i = x1 + 1;
                    while (i <= 7) { //paw pros ta katw me stathero y
                        if (i == 3 && (y1 == 2 || y1 == 3 || y1 == 6 || y1 == 7)) {
                            i = 7;

                        } else if (i == 4 && (y1 == 2 || y1 == 3 || y1 == 6 || y1 == 7)) {
                            i = 7;

                        } else if (control.getBoard().cards[i][y1] != null) {

                            if (!control.getBoard().cards[x1][y1].getcolor().equals(control.getBoard().cards[i][y1].getcolor())) {
                                buttons[i][y1].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                            } else {
                                i = 7;
                            }

                        } else {
                            buttons[i][y1].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                        }

                        i++;
                    }

                    i = y1 - 1;
                    while (i >= 0) { // paw pros aristera me stathero x
                        if (i == 2 && (x1 == 3 || x1 == 4)) {
                            i = 0;

                        } else if (i == 3 && (x1 == 3 || x1 == 4)) {
                            i = 0;

                        } else if (i == 6 && (x1 == 3 || x1 == 4)) {
                            i = 0;

                        } else if (i == 7 && (x1 == 3 || x1 == 4)) {
                            i = 0;

                        } else if (control.getBoard().cards[x1][i] != null) {
                            if (!control.getBoard().cards[x1][y1].getcolor().equals(control.getBoard().cards[x1][i].getcolor())) {
                                buttons[x1][i].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                            }
                            i = 0;

                        } else {
                            buttons[x1][i].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                        }

                        i--;
                    }

                    i = y1 + 1;
                    while (i <= 9) {    // paw pros dexia me stathero x
                        if (i == 2 && (x1 == 3 || x1 == 4)) {
                            i = 9;

                        } else if (i == 3 && (x1 == 3 || x1 == 4)) {
                            i = 9;

                        } else if (i == 6 && (x1 == 3 || x1 == 4)) {
                            i = 9;

                        } else if (i == 7 && (x1 == 3 || x1 == 4)) {
                            i = 9;

                        } else if (control.getBoard().cards[x1][i] != null) {

                            if (!control.getBoard().cards[x1][y1].getcolor().equals(control.getBoard().cards[x1][i].getcolor())) {
                                buttons[x1][i].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                            } else {
                                i = 9;
                            }

                        } else {
                            buttons[x1][i].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                        }

                        i++;

                      }
                    }else if(control.getNoretrieve() == 1 && control.getBoard().cards[x1][y1].toString().equals("Scout")){

                         if(control.getBoard().cards[x1][y1].getcolor().equals(Piececolor.BLUE)){

                             i = x1 + 1;
                             while (i <= 7) { //paw pros ta katw me stathero y
                                 if (i == 3 && (y1 == 2 || y1 == 3 || y1 == 6 || y1 == 7)) {
                                     i = 7;

                                 } else if (i == 4 && (y1 == 2 || y1 == 3 || y1 == 6 || y1 == 7)) {
                                     i = 7;

                                 } else if (control.getBoard().cards[i][y1] != null) {

                                     if (!control.getBoard().cards[x1][y1].getcolor().equals(control.getBoard().cards[i][y1].getcolor())) {
                                         buttons[i][y1].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                                     } else {
                                         i = 7;
                                     }

                                 } else {
                                     buttons[i][y1].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                                 }

                                 i++;
                             }

                             i = y1 - 1;
                             while (i >= 0) { // paw pros aristera me stathero x
                                 if (i == 2 && (x1 == 3 || x1 == 4)) {
                                     i = 0;

                                 } else if (i == 3 && (x1 == 3 || x1 == 4)) {
                                     i = 0;

                                 } else if (i == 6 && (x1 == 3 || x1 == 4)) {
                                     i = 0;

                                 } else if (i == 7 && (x1 == 3 || x1 == 4)) {
                                     i = 0;

                                 } else if (control.getBoard().cards[x1][i] != null) {

                                     if (!control.getBoard().cards[x1][y1].getcolor().equals(control.getBoard().cards[x1][i].getcolor())) {
                                         buttons[x1][i].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                                     }
                                     i = 0;

                                 } else {
                                     buttons[x1][i].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                                 }

                                 i--;
                             }

                             i = y1 + 1;
                             while (i <= 9) {    // paw pros dexia me stathero x
                                 if (i == 2 && (x1 == 3 || x1 == 4)) {
                                     i = 9;

                                 } else if (i == 3 && (x1 == 3 || x1 == 4)) {
                                     i = 9;

                                 } else if (i == 6 && (x1 == 3 || x1 == 4)) {
                                     i = 9;

                                 } else if (i == 7 && (x1 == 3 || x1 == 4)) {
                                     i = 9;

                                 } else if (control.getBoard().cards[x1][i] != null) {

                                     if (!control.getBoard().cards[x1][y1].getcolor().equals(control.getBoard().cards[x1][i].getcolor())) {
                                         buttons[x1][i].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                                     } else {
                                         i = 9;
                                     }

                                 } else {
                                     buttons[x1][i].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                                 }

                                 i++;
                             }

                         }else{

                             i = x1 - 1;
                             while (i >= 0) {  //pao pros ta panw me stathero y

                                 if (i == 3 && (y1 == 2 || y1 == 3 || y1 == 6 || y1 == 7)) {
                                     i = 0;

                                 } else if (i == 4 && (y1 == 2 || y1 == 3 || y1 == 6 || y1 == 7)) {
                                     i = 0;

                                 } else if (control.getBoard().cards[i][y1] != null) {

                                     if (!control.getBoard().cards[x1][y1].getcolor().equals(control.getBoard().cards[i][y1].getcolor())) {
                                         buttons[i][y1].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                                     } else {
                                         i = 0;
                                     }

                                 } else {
                                     buttons[i][y1].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                                 }

                                 i--;
                             }

                             i = y1 - 1;
                             while (i >= 0) { // paw pros aristera me stathero x
                                 if (i == 2 && (x1 == 3 || x1 == 4)) {
                                     i = 0;

                                 } else if (i == 3 && (x1 == 3 || x1 == 4)) {
                                     i = 0;

                                 } else if (i == 6 && (x1 == 3 || x1 == 4)) {
                                     i = 0;

                                 } else if (i == 7 && (x1 == 3 || x1 == 4)) {
                                     i = 0;

                                 } else if (control.getBoard().cards[x1][i] != null) {

                                     if (!control.getBoard().cards[x1][y1].getcolor().equals(control.getBoard().cards[x1][i].getcolor())) {
                                         buttons[x1][i].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                                     }
                                     i = 0;

                                 } else {
                                     buttons[x1][i].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                                 }

                                 i--;
                             }
                             i = y1 + 1;
                             while (i <= 9) {    // paw pros dexia me stathero x
                                 if (i == 2 && (x1 == 3 || x1 == 4)) {
                                     i = 9;

                                 } else if (i == 3 && (x1 == 3 || x1 == 4)) {
                                     i = 9;

                                 } else if (i == 6 && (x1 == 3 || x1 == 4)) {
                                     i = 9;

                                 } else if (i == 7 && (x1 == 3 || x1 == 4)) {
                                     i = 9;

                                 } else if (control.getBoard().cards[x1][i] != null) {

                                     if (!control.getBoard().cards[x1][y1].getcolor().equals(control.getBoard().cards[x1][i].getcolor())) {
                                         buttons[x1][i].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                                     } else {
                                         i = 9;
                                     }

                                 } else {
                                     buttons[x1][i].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                                 }

                                 i++;
                             }

                         }

                    }
                    else{

                        if (control.getNoretrieve() == 0) { //with retrieve

                            if (x1 == 0) {
                                if (y1 == 0) {
                                    buttons[x1 + 1][y1].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                                    buttons[x1][y1 + 1].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                                    return;
                                } else if (y1 == 9) {
                                    buttons[x1 + 1][y1].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                                    buttons[x1][y1 - 1].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                                    return;
                                }

                                buttons[x1 + 1][y1].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                                buttons[x1][y1 + 1].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                                buttons[x1][y1 - 1].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                                return;

                            } else if (x1 == 7) {
                                if (y1 == 0) {
                                    buttons[x1 - 1][y1].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                                    buttons[x1][y1 + 1].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                                    return;

                                } else if (y1 == 9) {
                                    buttons[x1 - 1][y1].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                                    buttons[x1][y1 - 1].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                                    return;
                                }

                                buttons[x1 - 1][y1].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                                buttons[x1][y1 + 1].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                                buttons[x1][y1 - 1].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                                return;

                            } else if (y1 == 0) {
                                buttons[x1 + 1][y1].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                                buttons[x1 - 1][y1].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                                buttons[x1][y1 + 1].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));

                            } else if (y1 == 9) {
                                buttons[x1 + 1][y1].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                                buttons[x1 - 1][y1].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                                buttons[x1][y1 - 1].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));


                            } else { // usual case

                                if (x1 + 1 == 3 || x1 + 1 == 4) {   /* an den einai tetragwno apagoeumenhs zwnhs*/
                                    if (y1 != 2 && y1 != 3 && y1 != 6 && y1 != 7) {
                                        buttons[x1 + 1][y1].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                                    }
                                } else {
                                    buttons[x1 + 1][y1].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                                }

                                if (x1 - 1 == 3 || x1 - 1 == 4) {   /* an den einai tetragwno apagoeumenhs zwnhs*/
                                    if (y1 != 2 && y1 != 3 && y1 != 6 && y1 != 7) {
                                        buttons[x1 - 1][y1].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                                    }
                                } else {
                                    buttons[x1 - 1][y1].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                                }

                                if (x1 == 3 || x1 == 4) {       /* an den einai tetragwno apagoeumenhs zwnhs*/

                                    if (y1 + 1 != 2 && y1 + 1 != 3 && y1 + 1 != 6 && y1 + 1 != 7) {
                                        buttons[x1][y1 + 1].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                                    }
                                    if (y1 - 1 != 2 && y1 - 1 != 3 && y1 - 1 != 6 && y1 - 1 != 7) { /* an den einai tetragwno apagoeumenhs zwnhs*/
                                        buttons[x1][y1 - 1].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                                    }
                                } else {
                                    buttons[x1][y1 - 1].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                                    buttons[x1][y1 + 1].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                                }
                            }

                        } else { // with no retrieve

                            if (control.getBoard().cards[x1][y1].getcolor().equals(Piececolor.BLUE)) {

                                if (x1 == 0) {

                                    if (y1 == 0) {
                                        buttons[x1 + 1][y1].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                                        buttons[x1][y1 + 1].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                                        return;

                                    } else if (y1 == 9) {
                                        buttons[x1 + 1][y1].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                                        buttons[x1][y1 - 1].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                                        return;
                                    }

                                    buttons[x1 + 1][y1].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                                    buttons[x1][y1 + 1].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                                    buttons[x1][y1 - 1].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                                    return;

                                } else if (x1 == 7) {

                                    if (y1 == 0) {
                                        buttons[x1][y1 + 1].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                                        return;

                                    } else if (y1 == 9) {
                                        buttons[x1][y1 - 1].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                                        return;
                                    }

                                    buttons[x1][y1 + 1].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                                    buttons[x1][y1 - 1].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                                    return;

                                } else if (y1 == 0) {
                                    buttons[x1 + 1][y1].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                                    buttons[x1][y1 + 1].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));

                                } else if (y1 == 9) {
                                    buttons[x1 + 1][y1].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                                    buttons[x1][y1 - 1].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));


                                } else { // usual case
                                    if (x1 + 1 == 3 || x1 + 1 == 4) {  /* an den einai tetragwno apagoeumenhs zwnhs*/
                                        if (y1 != 2 && y1 != 3 && y1 != 6 && y1 != 7) {
                                            buttons[x1 + 1][y1].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                                        }
                                    } else {
                                        buttons[x1 + 1][y1].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));

                                    }

                                    if (x1 == 3 || x1 == 4) {   /* an den einai tetragwno apagoeumenhs zwnhs*/
                                        if (y1 + 1 != 2 && y1 + 1 != 3 && y1 + 1 != 6 && y1 + 1 != 7) {
                                            buttons[x1][y1 + 1].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                                        }
                                        if (y1 - 1 != 2 && y1 - 1 != 3 && y1 - 1 != 6 && y1 - 1 != 7) {
                                            buttons[x1][y1 - 1].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                                        }
                                    } else {
                                        buttons[x1][y1 - 1].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                                        buttons[x1][y1 + 1].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                                    }
                                }

                            } else {  // red pawns
                                if (x1 == 0) {
                                    if (y1 == 0) {
                                        buttons[x1][y1 + 1].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                                        return;

                                    } else if (y1 == 9) {
                                        buttons[x1][y1 - 1].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                                        return;
                                    }

                                    buttons[x1][y1 + 1].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                                    buttons[x1][y1 - 1].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                                    return;

                                } else if (x1 == 7) {

                                    if (y1 == 0) {
                                        buttons[x1 - 1][y1].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                                        buttons[x1][y1 + 1].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                                        return;
                                    } else if (y1 == 9) {
                                        buttons[x1 - 1][y1].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                                        buttons[x1][y1 - 1].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                                        return;
                                    }
                                    buttons[x1 - 1][y1].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                                    buttons[x1][y1 + 1].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                                    buttons[x1][y1 - 1].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                                    return;

                                } else if (y1 == 0) {
                                    buttons[x1 - 1][y1].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                                    buttons[x1][y1 + 1].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));

                                } else if (y1 == 9) {
                                    buttons[x1 - 1][y1].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                                    buttons[x1][y1 - 1].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));

                                } else {  //usual case

                                    if (x1 - 1 == 3 || x1 - 1 == 4) {   /* an den einai tetragwno apagoeumenhs zwnhs*/
                                        if (y1 != 2 && y1 != 3 && y1 != 6 && y1 != 7) {
                                            buttons[x1 - 1][y1].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                                        }
                                    } else {
                                        buttons[x1 - 1][y1].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                                    }

                                    if (x1 == 3 || x1 == 4) {   /* an den einai tetragwno apagoeumenhs zwnhs*/

                                        if (y1 + 1 != 2 && y1 + 1 != 3 && y1 + 1 != 6 && y1 + 1 != 7) {
                                            buttons[x1][y1 + 1].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                                        }
                                        if (y1 - 1 != 2 && y1 - 1 != 3 && y1 - 1 != 6 && y1 - 1 != 7) {
                                            buttons[x1][y1 - 1].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                                        }

                                    } else {
                                        buttons[x1][y1 - 1].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                                        buttons[x1][y1 + 1].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                                    }
                                }
                            }

                        }
                    }
                    panel.validate();
                    panel.repaint();
                }
        }
