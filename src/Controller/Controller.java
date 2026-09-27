package Controller;

import Model.Board.Board;
import Model.Peice.Immovable.Bomb;
import Model.Peice.Immovable.Flag;
import Model.Peice.Movable.*;
import Model.Peice.Movable.Specialpawn.Dwarf;
import Model.Peice.Movable.Specialpawn.Scout;
import Model.Peice.Movable.Specialpawn.Slayer;
import Model.Peice.Movable.Specialpawn.Specialpiece;
import Model.Peice.Piece;
import Model.Peice.Piececolor;
import Model.Player.Player;
import Model.Turn.Turn;
import View.*;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Random;

import static java.lang.Integer.max;
import static java.lang.Integer.parseInt;


public class Controller {

    private static Piece[] bluecards = new Piece[12]; //blue team's pawns
    private static Piece[] redcards = new Piece[12];  //red team's pawns
    private static Integer[] RedCardsAvailability = new Integer[12]; // availability of red pawns

    private static Integer[] BlueCardsAvailability = new Integer[12];
    private static Turn turn;
    private Player playerblue = new Player("Blue");
    private Player playerred = new Player("Red");
    private static Board board;

    private ExceptionWindow exception;

    private static int fewerpawns;

    private static int noretrieve;

    private Rescuechoice reschoice=new Rescuechoice();

    private PopUpWindowWinner winner;

    private RescueAction rescue;

    private Piece rescuepiece;

    private String pawnblue1whomadearescue="null";

    private String pawnred1whomadearescue="null";

    private boolean allbombsblue=true;

    private boolean allbombsred=true;

    private boolean cantmoveblue=true;

    private boolean cantmovered=true;


    /**
     * Constructor
     *@param fpawns int if its value equals 1 then the players have opted the game to be with fewer pawns
     *@param noret int  if its value equals 1 then the players have opted the game to be with no retrieve
     * <b>Post-condition</b>Creates a controller instance where game events are going to be handled and initializes the turn of the game and the arrays with the cards
     */
    public Controller(int fpawns, int noret) {
        fewerpawns = fpawns;
        noretrieve = noret;

        turn = new Turn();
        board = new Board();
        init_game();
        initarrays();
        randominit();

    }

    /**
     * This method initializes the arrays of each team's pawns and the array of their pawns availability
     * <b>Post-condition:</b> The arrays of each team's pawns and the array of their pawns availability are initialized
     */
    public void initarrays() {
        if (fewerpawns == 0) {  // h thesi pou tha mpei to kathe pioni ston pinaka einai h idia me to rank tou EKTOS ths Flag pou mpainei sthn thesh 11
            bluecards[0] = new Bomb(Piececolor.BLUE);
            redcards[0] = new Bomb(Piececolor.RED);
            RedCardsAvailability[0] = 6;
            BlueCardsAvailability[0] = 6;

            bluecards[1] = new Slayer(Piececolor.BLUE);
            redcards[1] = new Slayer(Piececolor.RED);
            RedCardsAvailability[1] = 1;
            BlueCardsAvailability[1] = 1;

            bluecards[2] = new Scout(Piececolor.BLUE);
            redcards[2] = new Scout(Piececolor.RED);
            RedCardsAvailability[2] = 4;
            BlueCardsAvailability[2] = 4;

            bluecards[3] = new Dwarf(Piececolor.BLUE);
            redcards[3] = new Dwarf(Piececolor.RED);
            RedCardsAvailability[3] = 5;
            BlueCardsAvailability[3] = 5;

            bluecards[4] = new Elf(Piececolor.BLUE);
            redcards[4] = new Elf(Piececolor.RED);
            RedCardsAvailability[4] = 2;
            BlueCardsAvailability[4] = 2;

            bluecards[5] = new Yeti(Piececolor.BLUE);
            redcards[5] = new LavaBeast(Piececolor.RED);
            RedCardsAvailability[5] = 2;
            BlueCardsAvailability[5] = 2;

            bluecards[6] = new Sorceress(Piececolor.BLUE);
            redcards[6] = new Sorceress(Piececolor.RED);
            RedCardsAvailability[6] = 2;
            BlueCardsAvailability[6] = 2;

            bluecards[7] = new Beastrider(Piececolor.BLUE);
            redcards[7] = new Beastrider(Piececolor.RED);
            RedCardsAvailability[7] = 3;
            BlueCardsAvailability[7] = 3;

            bluecards[8] = new Knight(Piececolor.BLUE);
            redcards[8] = new Knight(Piececolor.RED);
            RedCardsAvailability[8] = 2;
            BlueCardsAvailability[8] = 2;

            bluecards[9] = new Mage(Piececolor.BLUE);
            redcards[9] = new Mage(Piececolor.RED);
            RedCardsAvailability[9] = 1;
            BlueCardsAvailability[9] = 1;

            bluecards[10] = new Dragon(Piececolor.BLUE);
            redcards[10] = new Dragon(Piececolor.RED);
            RedCardsAvailability[10] = 1;
            BlueCardsAvailability[10] = 1;

            bluecards[11] = new Flag(Piececolor.BLUE);
            redcards[11] = new Flag(Piececolor.RED);
            RedCardsAvailability[11] = 1;
            BlueCardsAvailability[11] = 1;
        } else {
            bluecards[0] = new Bomb(Piececolor.BLUE);
            redcards[0] = new Bomb(Piececolor.RED);
            RedCardsAvailability[0] = 6;
            BlueCardsAvailability[0] = 6;

            bluecards[1] = new Slayer(Piececolor.BLUE);
            redcards[1] = new Slayer(Piececolor.RED);
            RedCardsAvailability[1] = 1;
            BlueCardsAvailability[1] = 1;

            bluecards[2] = new Scout(Piececolor.BLUE);
            redcards[2] = new Scout(Piececolor.RED);
            RedCardsAvailability[2] = 4;
            BlueCardsAvailability[2] = 4;

            bluecards[3] = new Dwarf(Piececolor.BLUE);
            redcards[3] = new Dwarf(Piececolor.RED);
            RedCardsAvailability[3] = 5 / 2;
            BlueCardsAvailability[3] = 5 / 2;

            bluecards[4] = new Elf(Piececolor.BLUE);
            redcards[4] = new Elf(Piececolor.RED);
            RedCardsAvailability[4] = 2;
            BlueCardsAvailability[4] = 2;

            bluecards[5] = new Yeti(Piececolor.BLUE);
            redcards[5] = new LavaBeast(Piececolor.RED);
            RedCardsAvailability[5] = 2;
            BlueCardsAvailability[5] = 2;

            bluecards[6] = new Sorceress(Piececolor.BLUE);
            redcards[6] = new Sorceress(Piececolor.RED);
            RedCardsAvailability[6] = 2;
            BlueCardsAvailability[6] = 2;

            bluecards[7] = new Beastrider(Piececolor.BLUE);
            redcards[7] = new Beastrider(Piececolor.RED);
            RedCardsAvailability[7] = 3 / 2;
            BlueCardsAvailability[7] = 3 / 2;

            bluecards[8] = new Knight(Piececolor.BLUE);
            redcards[8] = new Knight(Piececolor.RED);
            RedCardsAvailability[8] = 2;
            BlueCardsAvailability[8] = 2;

            bluecards[9] = new Mage(Piececolor.BLUE);
            redcards[9] = new Mage(Piececolor.RED);
            RedCardsAvailability[9] = 1;
            BlueCardsAvailability[9] = 1;

            bluecards[10] = new Dragon(Piececolor.BLUE);
            redcards[10] = new Dragon(Piececolor.RED);
            RedCardsAvailability[10] = 1;
            BlueCardsAvailability[10] = 1;

            bluecards[11] = new Flag(Piececolor.BLUE);
            redcards[11] = new Flag(Piececolor.RED);
            RedCardsAvailability[11] = 1;
            BlueCardsAvailability[11] = 1;
        }
    }


    /**
     * This method initializes board's array with randomly put pieces, according the quantity arraylist for each team's peace.
     * <b>Post-condition:</b> creates 2 arraylists with randomly put images one for each team according the quantity arraylist too.
     */
    public void randominit() {
        int k;
        Random randomGenerator = new Random();
        if (fewerpawns == 0) {
            for (int i = 0; i < 8; i++) {
                if (i <= 2) { // blue pawns
                    k = 0;
                    while (k < 10) {
                        int colum = randomGenerator.nextInt(10);
                        if (board.cards[i][colum] == null) {
                            int rank = randomGenerator.nextInt(12);
                            if (BlueCardsAvailability[rank] != 0) {
                                board.cards[i][colum] = bluecards[rank];
                                BlueCardsAvailability[rank]--;
                                k++;
                            }
                        }
                    }
                } else if (i > 4 && i < 8) { // RED pawns
                    k = 0;
                    while (k < 10) {
                        int colum = randomGenerator.nextInt(10);
                        if (board.cards[i][colum] == null) {
                            int rank = randomGenerator.nextInt(12);
                            if (RedCardsAvailability[rank] != 0) {
                                board.cards[i][colum] = redcards[rank];
                                RedCardsAvailability[rank]--;
                                k++;
                            }
                        }
                    }
                }

            }
        } else {
            for (int i = 0; i < 8; i++) {
                if (i < 2) { // blue pawns
                    k = 0;
                    while (k < 10) {
                        int colum = randomGenerator.nextInt(10);
                        if (board.cards[i][colum] == null) {
                            int rank = randomGenerator.nextInt(12);
                            if (BlueCardsAvailability[rank] != 0) {
                                board.cards[i][colum] = bluecards[rank];
                                BlueCardsAvailability[rank]--;
                                k++;
                            }
                        }
                    }
                } else if (i == 2) { // blue pawns
                    k = 0;
                    while (k < 5) {
                        int colum = randomGenerator.nextInt(10);
                        if (board.cards[i][colum] == null) {
                            int rank = randomGenerator.nextInt(12);
                            if (BlueCardsAvailability[rank] != 0) {
                                board.cards[i][colum] = bluecards[rank];
                                BlueCardsAvailability[rank]--;
                                k++;
                            }
                        }
                    }
                } else if (i == 5) { // Red pawns
                    k = 0;
                    while (k < 5) {
                        int colum = randomGenerator.nextInt(10);
                        if (board.cards[i][colum] == null) {
                            int rank = randomGenerator.nextInt(12);
                            if (RedCardsAvailability[rank] != 0) {
                                board.cards[i][colum] = redcards[rank];
                                RedCardsAvailability[rank]--;
                                k++;
                            }
                        }
                    }
                } else if (i > 5) { // Red pawns
                    k = 0;
                    while (k < 10) {
                        int colum = randomGenerator.nextInt(10);
                        if (board.cards[i][colum] == null) {
                            int rank = randomGenerator.nextInt(12);
                            if (RedCardsAvailability[rank] != 0) {
                                board.cards[i][colum] = redcards[rank];
                                RedCardsAvailability[rank]--;
                                k++;
                            }
                        }
                    }
                }


            }
        }
    }


    /**
     * This method increases the turn's value which is responsible for identifying who player/team is currently playing
     * <b>Post-condition:</b> the turn's value is increased by 1
     */

    public void init_game() {
        turn.setturn();
    }

    /**This method checks if someone has win in order to end the game and creates a popup window saying the winner's name
     <b>Post-condition:</b> returns true if someone wins to end the game or false if not
     */

    public boolean  EndOfGame_Winner(){

        allbombsred=true;
        allbombsblue=true;
        cantmovered=true;
        cantmoveblue=true;


        if(fewerpawns==0){
           if (playerred.getcaptivities()==30){
                 winner = new PopUpWindowWinner("Red Player");
                return true;
            }else if(playerblue.getcaptivities()==30){
                winner = new PopUpWindowWinner("Blue Player");
               return true;
           }
        }else if(fewerpawns==1){
            if (playerred.getcaptivities()==25){
                 winner = new PopUpWindowWinner("Red Player");
                return true;
            }else if(playerblue.getcaptivities()==25){
                 winner = new PopUpWindowWinner("Blue Player");
                return true;
            }
        }

        for(int i=0;i<playerred.getcapturedpieces().length;i++){ // check if the red team has captured blue team's flag
            if(playerred.getcapturedpieces()[i]!=null) {
                if (playerred.getcapturedpieces()[i].toString().equals("Flag")) {
                    winner = new PopUpWindowWinner("Red Player");
                    return true;
                }
            }
        }
        for(int i=0;i<playerblue.getcapturedpieces().length;i++){ // check if the blue team has captured red team's flag
            if(playerblue.getcapturedpieces()[i]!=null) {
                if (playerblue.getcapturedpieces()[i].toString().equals("Flag")) {
                    winner = new PopUpWindowWinner("Blue Player");
                    return true;
                }
            }
        }

        for (int x = 0; x < 8; x++) { // check if the blue team has only bombs and its flag
            for (int y = 0; y < 10; y++) {

                if (board.cards[x][y] != null) {
                    if (board.cards[x][y].getrank() != 0 && board.cards[x][y].getcolor().equals(Piececolor.BLUE)) {
                        allbombsblue = false;
                    }
                }
            }
        }


        for(int x=0;x<8;x++){ // check if the red team has only bombs and its flag
            for(int y=0;y<10;y++){

                if(board.cards[x][y]!= null) {
                    if ( board.cards[x][y].getrank() != 0 && board.cards[x][y].getcolor().equals(Piececolor.RED)) {
                        allbombsred = false;
                    }
                }
            }
        }


        for(int x=0;x<3;x++){ // check if only the blue team's  pawns  cant move due to bombs/ the restricted area
            for(int y=0;y<10;y++){

                if(board.cards[x][y]!=null && board.cards[x][y].getrank()!=0 && board.cards[x][y].getcolor().equals(Piececolor.BLUE)) {
                    if (noretrieve == 0) {

                        if (x == 0) {
                            if (y == 0) {

                                if (board.cards[x + 1][y] != null && board.cards[x][y + 1] != null) {
                                    if (board.cards[x + 1][y].getrank() != 0 || board.cards[x][y + 1].getrank() != 0) {
                                        cantmoveblue = false;
                                    }
                                } else {  // an estw 1 einai null
                                    cantmoveblue = false;
                                }

                            } else if (y == 9) {

                                if (board.cards[x + 1][y] != null && board.cards[x][y - 1] != null) {
                                    if (board.cards[x + 1][y].getrank() != 0 || board.cards[x][y - 1].getrank() != 0) {
                                        cantmoveblue = false;
                                    }
                                } else {  // an estw 1 einai null
                                    cantmoveblue = false;
                                }

                            } else {

                                if (board.cards[x + 1][y] != null && board.cards[x][y + 1] != null && board.cards[x][y - 1] != null) {
                                    if (board.cards[x + 1][y].getrank() != 0 || board.cards[x][y + 1].getrank() != 0 || board.cards[x][y - 1].getrank() != 0) {
                                        cantmoveblue = false;
                                    }
                                } else { // an estw 1 einai null
                                    cantmoveblue = false;
                                }

                            }
                        } else if (y == 0) {

                            if (board.cards[x - 1][y] != null && board.cards[x][y + 1] != null && board.cards[x + 1][y] != null) {
                                if (board.cards[x - 1][y].getrank() != 0 || board.cards[x][y + 1].getrank() != 0 || board.cards[x + 1][y].getrank() != 0) {
                                    cantmoveblue = false;
                                }
                            } else {  // an estw 1 einai null
                                cantmoveblue = false;
                            }

                        } else if (y == 9) {

                            if (board.cards[x + 1][y] != null && board.cards[x][y - 1] != null && board.cards[x - 1][y] != null) {
                                if (board.cards[x + 1][y].getrank() != 0 || board.cards[x][y - 1].getrank() != 0 || board.cards[x - 1][y].getrank() != 0) {
                                    cantmoveblue = false;
                                }
                            } else { // an estw 1 einai null
                                cantmoveblue = false;
                            }

                        } else {

                            if (board.cards[x - 1][y] != null && board.cards[x + 1][y] != null && board.cards[x][y + 1] != null && board.cards[x][y - 1] != null) {
                                if (board.cards[x - 1][y].getrank() != 0 || board.cards[x + 1][y].getrank() != 0 || board.cards[x][y - 1].getrank() != 0 || board.cards[x][y + 1].getrank() != 0) {
                                    cantmoveblue = false;
                                }
                            } else { // an estw 1 einai null
                                if (board.cards[x + 1][y] == null && board.cards[x - 1][y] != null && board.cards[x][y + 1] != null && board.cards[x][y - 1] != null) { // for red pawns
                                    if (board.cards[x - 1][y].getrank() != 0 || board.cards[x][y + 1].getrank() != 0 || board.cards[x][y - 1].getrank() != 0) {
                                        cantmoveblue = false;
                                    } else {
                                        if (x + 1 != 3 || (y != 2 && y != 3 && y != 6 && y != 7)) {
                                            cantmoveblue = false;
                                        }
                                    }
                                } else {
                                    cantmoveblue = false;
                                }
                            }
                        }

                    } else { // with no retrieve for blue team only

                        if (x == 0) {
                            if (y == 0) {

                                if (board.cards[x + 1][y] != null && board.cards[x][y + 1] != null) {
                                    if (board.cards[x + 1][y].getrank() != 0 || board.cards[x][y + 1].getrank() != 0) {
                                        cantmoveblue = false;
                                    }
                                } else {
                                    cantmoveblue = false;
                                }

                            } else if (y == 9) {

                                if (board.cards[x + 1][y] != null && board.cards[x][y - 1] != null) {
                                    if (board.cards[x + 1][y].getrank() != 0 || board.cards[x][y - 1].getrank() != 0) {
                                        cantmoveblue = false;
                                    }
                                } else {
                                    cantmoveblue = false;
                                }

                            } else {

                                if (board.cards[x + 1][y] != null && board.cards[x][y + 1] != null && board.cards[x][y - 1] != null) {
                                    if (board.cards[x + 1][y].getrank() != 0 || board.cards[x][y + 1].getrank() != 0 || board.cards[x][y - 1].getrank() != 0) {
                                        cantmoveblue = false;
                                    }
                                } else {
                                    cantmoveblue = false;
                                }
                            }
                        } else if (y == 0) {

                            if (board.cards[x][y + 1] != null && board.cards[x + 1][y] != null) {
                                if (board.cards[x][y + 1].getrank() != 0 || board.cards[x + 1][y].getrank() != 0) {
                                    cantmoveblue = false;
                                }
                            } else {
                                cantmoveblue = false;
                            }

                        } else if (y == 9) {

                            if (board.cards[x][y - 1] != null && board.cards[x + 1][y] != null) {
                                if (board.cards[x][y - 1].getrank() != 0 || board.cards[x + 1][y].getrank() != 0) {
                                    cantmoveblue = false;
                                }
                            } else {
                                cantmoveblue = false;
                            }


                        } else {  // usual case

                            if (board.cards[x][y - 1] != null && board.cards[x][y + 1] != null && board.cards[x + 1][y] != null) {
                                if (board.cards[x][y - 1].getrank() != 0 || board.cards[x][y + 1].getrank() != 0 || board.cards[x + 1][y].getrank() != 0) {
                                    cantmoveblue = false;
                                }
                            } else {
                                if (board.cards[x + 1][y] == null && board.cards[x][y + 1] != null && board.cards[x][y - 1] != null) { // for red pawns
                                    if (board.cards[x][y + 1].getrank() != 0 || board.cards[x][y - 1].getrank() != 0) {
                                        cantmoveblue = false;
                                    } else {
                                        if (x + 1 != 3 || (y != 2 && y != 3 && y != 6 && y != 7)) {
                                            cantmoveblue = false;
                                        }
                                    }
                                } else {
                                    cantmoveblue = false;
                                }
                            }

                        }
                    }
                }
            }
        }

        for(int x=5;x<8;x++){  // check if only the red team's  pawns  cant move due to bombs/ the restricted area
            for(int y=0;y<10;y++){
                if(board.cards[x][y]!=null && board.cards[x][y].getrank()!=0 && board.cards[x][y].getcolor().equals(Piececolor.RED)) {
                    if (noretrieve == 0) {
                        if (x == 7) {
                            if (y == 0) {

                                if (board.cards[x - 1][y] != null && board.cards[x][y + 1] != null) {
                                    if (board.cards[x - 1][y].getrank() != 0 || board.cards[x][y + 1].getrank() != 0) {
                                        cantmovered = false;
                                    }
                                } else {
                                    cantmovered = false;
                                }

                            } else if (y == 9) {

                                if (board.cards[x - 1][y] != null && board.cards[x][y - 1] != null) {
                                    if (board.cards[x - 1][y].getrank() != 0 || board.cards[x][y - 1].getrank() != 0) {
                                        cantmovered = false;
                                    }
                                } else {
                                    cantmovered = false;
                                }

                            } else {

                                if (board.cards[x - 1][y] != null && board.cards[x][y + 1] != null && board.cards[x][y - 1] != null) {
                                    if (board.cards[x - 1][y].getrank() != 0 || board.cards[x][y + 1].getrank() != 0 || board.cards[x][y - 1].getrank() != 0) {
                                        cantmovered = false;
                                    }
                                } else {
                                    cantmovered = false;
                                }

                            }

                        } else if (y == 0) {

                            if (board.cards[x - 1][y] != null && board.cards[x][y + 1] != null && board.cards[x + 1][y] != null) {
                                if (board.cards[x - 1][y].getrank() != 0 || board.cards[x][y + 1].getrank() != 0 || board.cards[x + 1][y].getrank() != 0) {
                                    cantmovered = false;
                                }
                            } else {
                                cantmovered = false;
                            }

                        } else if (y == 9) {

                            if (board.cards[x + 1][y] != null && board.cards[x][y - 1] != null && board.cards[x - 1][y] != null) {
                                if (board.cards[x + 1][y].getrank() != 0 || board.cards[x][y - 1].getrank() != 0 || board.cards[x - 1][y].getrank() != 0) {
                                    cantmovered = false;
                                }
                            } else {
                                cantmovered = false;
                            }

                        } else {

                            if (board.cards[x - 1][y] != null && board.cards[x + 1][y] != null && board.cards[x][y + 1] != null && board.cards[x][y - 1] != null) {
                                if (board.cards[x - 1][y].getrank() != 0 || board.cards[x + 1][y].getrank() != 0 || board.cards[x][y - 1].getrank() != 0 || board.cards[x][y + 1].getrank() != 0) {
                                    cantmovered = false;
                                }
                            } else {  // otan estw kai 1 einai null
                                if (board.cards[x - 1][y] == null && board.cards[x + 1][y] != null && board.cards[x][y + 1] != null && board.cards[x][y - 1] != null) { // for red pawns
                                    if (board.cards[x + 1][y].getrank() != 0 || board.cards[x][y + 1].getrank() != 0 || board.cards[x][y - 1].getrank() != 0) {
                                        cantmovered = false;
                                    } else {
                                        if (x - 1 != 4 || (y != 2 && y != 3 && y != 6 && y != 7)) {
                                            cantmovered = false;
                                        }
                                    }
                                } else {
                                    cantmovered = false;
                                }
                            }
                        }
                    } else { // with no retrieve for red team only

                        if (x == 7) {
                            if (y == 0) {

                                if (board.cards[x][y + 1] != null && board.cards[x - 1][y] != null) {
                                    if (board.cards[x][y + 1].getrank() != 0 || board.cards[x - 1][y].getrank() != 0) {
                                        cantmovered = false;
                                    }
                                } else {
                                    cantmovered = false;
                                }

                            } else if (y == 9) {

                                if (board.cards[x][y - 1] != null && board.cards[x - 1][y] != null) {
                                    if (board.cards[x][y - 1].getrank() != 0 || board.cards[x - 1][y].getrank() != 0) {
                                        cantmovered = false;
                                    }
                                } else {
                                    cantmovered = false;
                                }

                            } else {

                                if (board.cards[x][y + 1] != null && board.cards[x][y - 1] != null && board.cards[x - 1][y] != null) {
                                    if (board.cards[x][y + 1].getrank() != 0 || board.cards[x][y - 1].getrank() != 0 || board.cards[x - 1][y].getrank() != 0) {
                                        cantmovered = false;
                                    }
                                } else {
                                    cantmovered = false;
                                }

                            }
                        } else if (y == 0) {

                            if (board.cards[x][y + 1] != null && board.cards[x - 1][y] != null) {
                                if (board.cards[x][y + 1].getrank() != 0 || board.cards[x - 1][y].getrank() != 0) {
                                    cantmovered = false;
                                }
                            } else {
                                cantmovered = false;
                            }

                        } else if (y == 9) {

                            if (board.cards[x][y - 1] != null && board.cards[x - 1][y] != null) {
                                if (board.cards[x][y - 1].getrank() != 0 || board.cards[x - 1][y].getrank() != 0) {
                                    cantmovered = false;
                                }
                            } else {
                                cantmovered = false;
                            }


                        } else {  // usual case

                            if (board.cards[x][y - 1] != null && board.cards[x][y + 1] != null && board.cards[x - 1][y] != null) {
                                if (board.cards[x][y - 1].getrank() != 0 || board.cards[x][y + 1].getrank() != 0 || board.cards[x - 1][y].getrank() != 0) {
                                    cantmovered = false;
                                }
                            } else { // an estw kai 1 einai null
                                if (board.cards[x - 1][y] == null && board.cards[x][y + 1] != null && board.cards[x][y - 1] != null) { // for red pawns
                                    if (board.cards[x][y + 1].getrank() != 0 || board.cards[x][y - 1].getrank() != 0) {
                                        cantmovered = false;
                                    } else {
                                        if (x - 1 != 4 || (y != 2 && y != 3 && y != 6 && y != 7)) {
                                            cantmovered = false;
                                        }
                                    }
                                } else {
                                    cantmovered = false;
                                }
                            }

                        }
                    }
                }
            }
        }

        if(allbombsblue==true && allbombsred==false){
            winner = new PopUpWindowWinner("Red Player");
            return true;
        }else if (allbombsblue==true && allbombsred==true){
            winner = new PopUpWindowWinner("None of you :(");
            return true;
        }else if(allbombsred==true){
            winner = new PopUpWindowWinner("Blue Player");
            return true;
        }else if(cantmoveblue==true && cantmovered==false){
            winner = new PopUpWindowWinner("Red Player");
            return true;
        }else if(cantmoveblue==true && cantmovered==true){
            winner = new PopUpWindowWinner("None of you :(");
            return true;
        }else if(cantmovered==true){
            winner = new PopUpWindowWinner("Blue Player");
            return true;
        }


        return false;
    }


    /**This method checks if the current player after has moved/attack can rescue a captured pawn of his
     <b>Post-condition:</b> returns true the current player can rescue a captured pawn of his otherwise it returns false
     *@param xy1 String the coordinate  of the pawn after its moved
     *@param prev String the coordinate of the pawn previous of that movement
     */

    public boolean canRescue(String xy1,String prev){ // but and selected button after they have been swaped
        int xy_1 = parseInt(xy1);
        int prevx=parseInt(prev)/10;
        int y1 = xy_1 % 10;
        int x1 = xy_1 / 10;


        if(turn.getturn()%2!=0){ // o blue player can make a rescue
            if(x1==5 && prevx<5  && playerblue.getRescues()<2 && playerred.notallbombs() && playerred.getcaptivities()>0 &&  !pawnblue1whomadearescue.equals(board.cards[x1][y1].toString())){
                if(reschoice.Rescuechoice()){
                    if(pawnblue1whomadearescue.equals("null")){    // arxikopoihsh tou pawn pou ekane thn 1h diaswsh
                        pawnblue1whomadearescue=board.cards[x1][y1].toString();
                    }
                    playerblue.countresues();
                    rescue=new RescueAction(playerred); // actual rescue
                    return true;
                }else{
                    return false;
                }
            }
        }else if( playerred.getRescues()<2 && playerblue.getcaptivities()>0 && playerblue.notallbombs() && !pawnred1whomadearescue.equals(board.cards[x1][y1].toString())){  // o red player can make a rescue
            if(x1==2 && prevx>2){
                if(reschoice.Rescuechoice()){
                    if(pawnred1whomadearescue.equals("null")){ // arxikopoihsh tou pawn pou ekane thn 1h diaswsh
                        pawnred1whomadearescue=board.cards[x1][y1].toString();
                    }
                    playerred.countresues();
                    rescue=new RescueAction(playerblue);

                    return true;
                }else{
                    return false;
                }
            }
        }
        return false;
    }

    /**The rescue action takes place and returns true if the players did rescue a pawn / false if not
     <b>Post-condition:</b> Returns true if the players did rescue a pawn / false if not
     */

    public Icon RescueIcon(){return rescue.getRescuepawn();}


    /**This method returns the pawn that the player wants to rescue
     <b>Post-condition:</b> the pawn that the player wants to rescue is returned
     */

    public Piece RescuePiece(){
        if(turn.getturn()%2!=0) { // o blue player makes a rescue
            rescuepiece = playerred.getcapturedpieces()[rescue.buttontext()];
            playerred.deleteCapturedPawn(playerred.getcapturedpieces()[rescue.buttontext()]);
        }else{
            rescuepiece=playerblue.getcapturedpieces()[rescue.buttontext()];
            playerblue.deleteCapturedPawn(playerblue.getcapturedpieces()[rescue.buttontext()]);
        }
        return rescuepiece;
       }

    /**
     * This method returns the board of this controller
     * <b>Post-condition:</b> The board of this controller is returned.
     */
    public Board getBoard() {
        return this.board;
    }

    /**
     * This method returns the Turn instance of this controller
     * <b>Post-condition:</b> The Turn instance of this controller is returned.
     */
    public Turn getTurn() {
        return this.turn;
    }

    /**
     * This method checks if a player can move his pawn at a specific area
     * <b>Post-condition:</b> Returns true if he can otherwise false
     * @param xy1 String  coordinate of source-button
     * @param xy2 String   coordinate of selected-button
     * @param scoutsecondmove int indicates if this move is slayer's second move
     * @param rescueaction int indicates if this action is a rescue one
     */
    public boolean checkmove(String xy1, String xy2,int scoutsecondmove,int rescueaction) { // x1-y1 coordinates of the first button I press
        int xy_1 = parseInt(xy1);
        int xy_2 = parseInt(xy2);
        int x1 = xy_1 / 10;
        int x2 = xy_2 / 10;
        int y1 = xy_1 % 10;
        int y2 = xy_2 % 10;
        int i,maxdis=0; // maxdis= to orio mexri to opoio o scout mporei na paei


        if(rescueaction==1 && board.cards[x2][y2] != null){
            exception = new ExceptionWindow();
            return false;
        }else if(rescueaction==1 && board.cards[x2][y2] == null){
            if(turn.getturn()%2!=0 && x2>2){

                exception = new ExceptionWindow();
                return false;
            }else if(turn.getturn()%2==0 && x2<5){

                exception = new ExceptionWindow();
                return false;
            }else {
                return true;
            }
        }

        if (board.cards[x1][y1] == null) { /* an sthn arxh pathse ena leuko "pioni" gia na to metakinisei*/
            exception = new ExceptionWindow();
            return false;
        }
        if (board.cards[x1][y1].getcolor().equals(Piececolor.RED) && turn.getturn() % 2 != 0 && scoutsecondmove!=1) {
            exception = new ExceptionWindow();
            return false;
        } else if (board.cards[x1][y1].getcolor().equals(Piececolor.BLUE) && turn.getturn() % 2 == 0 && scoutsecondmove!=1) {

            exception = new ExceptionWindow();
            return false;
        }
        if(scoutsecondmove==1 && !board.cards[x1][y1].toString().equals("Scout")){
            ScoutException scoutex= new ScoutException();
            return false;
        }
        // with retrieve
        if(board.cards[x1][y1].getrank()==0){ // an paei na metakinhsei immovable pawn
            exception = new ExceptionWindow();
            return false;
        }
        if(board.cards[x1][y1].toString().equals("Scout")){  // se periptwsh pou o slayer kanei thn 2h kinhsh omws den epiththetai pou kanonika prepei afou ekane 2 kinhseis
            if(scoutsecondmove==1 && board.cards[x2][y2]==null){

                exception = new ExceptionWindow();
                return false;
            }
        }

        if(noretrieve==0 && board.cards[x1][y1].toString().equals("Scout")) {

            if (y2 == y1) { //an me retrieve kinoumai katheta (y1=y2)

                i = x1-1;
                maxdis=0;

                while (i >= 0) {  //pao pros ta panw me stathero y
                    if (i == 3 && x2 == i && (y2 == 2 || y2 == 3 || y2 == 6 || y2 == 7)) {

                        exception = new ExceptionWindow();
                        return false;

                    }
                    if (i == 4 && x2 == i && (y2 == 2 || y2 == 3 || y2 == 6 || y2 == 7)) {

                        exception = new ExceptionWindow();
                        return false;

                    }

                    if( y2==y1 && board.cards[i][y2]!=null && maxdis==0){
                        maxdis=i;
                    }

                    if (x2 == i && y2 == y1 && x2>=maxdis) {

                        return true;
                    }
                    i--;
                }

                i = x1+1;
                maxdis=7;

                while (i <= 7) { //paw pros ta katw me stathero y
                    if (i == 3 && x2 == i && (y2 == 2 || y2 == 3 || y2 == 6 || y2 == 7)) {

                        exception = new ExceptionWindow();
                        return false;

                    }
                    if (i == 4 && x2 == i && (y2 == 2 || y2 == 3 || y2 == 6 || y2 == 7)) {

                        exception = new ExceptionWindow();
                        return false;

                    }

                    if( y2==y1 && board.cards[i][y2]!=null && maxdis==7){
                        maxdis=i;
                    }

                    if (x2 == i && y2 == y1 && x2<=maxdis) {
                        return true;
                    }
                    i++;
                }
            } else { //an me retrieve kinoumai orizontia aristera (x1=x2)

                i = y1-1;
                maxdis=0;

                while (i >= 0) { // paw pros aristera me stathero x
                    if (i == 2 && y2 == i && (x2 == 3 || x2 == 4)) {

                        exception = new ExceptionWindow();
                        return false;

                    }
                    if (i == 3 && y2 == i && (x2 == 3 || x2 == 4)) {

                        exception = new ExceptionWindow();
                        return false;

                    }
                    if (i == 6 && y2 == i && (x2 == 3 || x2 == 4)) {

                        exception = new ExceptionWindow();
                        return false;

                    }
                    if (i == 7 && y2 == i && (x2 == 3 || x2 == 4)) {
                        exception = new ExceptionWindow();
                        return false;

                    }

                    if( x2==x1 && board.cards[x2][i]!=null && maxdis==0){
                        maxdis=i;
                    }

                    if (y2 == i && x2 == x1 && y2>=maxdis) {
                        return true;
                    }
                    i--;
                }

                i = y1+1;
                maxdis=9;

                while (i <= 9) {    // paw pros dexia me stathero x
                        if (i == 2 && y2 == i &&( x2 == 3 || x2 == 4)) {

                            exception = new ExceptionWindow();
                            return false;

                        }
                        if (i == 3 && y2 == i && (x2 == 3 || x2 == 4)) {

                            exception = new ExceptionWindow();
                            return false;

                        }
                        if (i == 6 && y2 == i && (x2 == 3 || x2 == 4)) {

                            exception = new ExceptionWindow();
                            return false;

                        }

                        if (i == 7 && y2 == i && (x2 == 3 || x2 == 4)) {
                            exception = new ExceptionWindow();
                            return false;

                        }

                        if(x1==x2 && board.cards[x2][i]!=null && maxdis==9){
                            maxdis=i;
                        }

                        if (y2 == i && x2 == x1 && y2<=maxdis) {
                            return true;
                        }

                        i++;
                }
            }
            exception = new ExceptionWindow();
            return false;

           }else if(noretrieve==1 && board.cards[x1][y1].toString().equals("Scout")){

             if(board.cards[x1][y1].getcolor().equals(Piececolor.BLUE)) {
                if (y2 == y1) { //an me NO retrieve kai gia ta blue pionia kinoumai kstheta (y1=y2)

                    i=x1+1;
                    maxdis=7;

                    while (i <=7) { // me stathero y kimoumai pros ta katw
                        if (i == 3 && x2 == i && (y2 == 2 || y2 == 3 || y2 == 6 || y2 == 7)) {
                            exception = new ExceptionWindow();
                            return false;

                        }
                        if (i == 4 && x2 == i && (y2 == 2 || y2 == 3 || y2 == 6 || y2 == 7)) {
                            exception = new ExceptionWindow();
                            return false;

                        }

                        if( y2==y1 && board.cards[i][y2]!=null && maxdis==7){
                            maxdis=i;
                        }

                        if (x2 == i && y2 == y1 && x2<=maxdis) {
                            return true;
                        }
                        i++;
                    }
                } else {    //an me NO retrieve kinoumai orizontia pros ta aristera(x1=x2)

                    i = y1-1;
                    maxdis=0;

                    while (i >= 0) { // kinoumai pros ta aristera
                        if (i == 2 && y2 == i && (x2 == 3 || x2 == 4)) {
                            exception = new ExceptionWindow();
                            return false;

                        }
                        if (i == 3 && y2 == i && (x2 == 3 || x2 == 4)) {
                            exception = new ExceptionWindow();
                            return false;

                        }
                        if (i == 6 && y2 == i && (x2 == 3 || x2 == 4)) {
                            exception = new ExceptionWindow();
                            return false;

                        }
                        if (i == 7 && y2 == i && (x2 == 3 || x2 == 4)) {
                            exception = new ExceptionWindow();
                            return false;

                        }

                        if( x2==x1 && board.cards[x2][i]!=null && maxdis==0){
                            maxdis=i;
                        }

                        if (y2 == i && x2 == x1 && y2>=maxdis) {
                            return true;
                        }

                        i--;
                    }

                    i = y1+1;
                    maxdis=9;

                    while (i <= 9) { //an me NO retrieve kinoumai pros ta dexia
                            if (i == 2 && y2 == i && (x2 == 3 || x2 == 4)) {
                                exception = new ExceptionWindow();
                                return false;

                            }
                            if (i == 3 && y2 == i && (x2 == 3 || x2 == 4)) {
                                exception = new ExceptionWindow();
                                return false;

                            }
                            if (i == 6 && y2 == i && (x2 == 3 || x2 == 4)) {
                                exception = new ExceptionWindow();
                                return false;

                            }
                            if (i == 7 && y2 == i && (x2 == 3 || x2 == 4)) {
                                exception = new ExceptionWindow();
                                return false;

                            }

                            if( x2==x1 && board.cards[x2][i]!=null && maxdis==9){
                                maxdis=i;
                            }

                            if (y2 == i && x2 == x1 && y2<=maxdis) {
                                return true;
                            }
                            i++;

                    }
                }
                exception = new ExceptionWindow();
                return false;
            }
            else{ // red scout with no retrieve

                if (y2 == y1) {  //an me NO retrieve kai sta red pionia kinoumai katheta (y1=y2)

                    i = x1-1;
                    maxdis=0;

                    while (i >=0) {

                        if (i == 3 && x2 == i && (y2 == 2 || y2 == 3 || y2 == 6 || y2 == 7)) {
                            exception = new ExceptionWindow();
                            return false;

                        }

                        if (i == 4 && x2 == i && (y2 == 2 || y2 == 3 || y2 == 6 || y2 == 7)) {
                            exception = new ExceptionWindow();
                            return false;

                        }

                        if( y2==y1 && board.cards[i][y2]!=null && maxdis==0){
                            maxdis=i;
                        }

                        if (x2 == i && y2 == y1 && x2>=maxdis) {
                            return true;
                        }

                        i--;
                    }
                } else { //an me NO retrieve kai sta red pionia kinoumai orizontia (x1=x2)

                    i = y1-1;
                    maxdis=0;

                    while (i >= 0) {  // paw pros ta aristera

                        if (i == 2 && y2 == i && (x2 == 3 || x2 == 4)) {
                            exception = new ExceptionWindow();
                            return false;

                        }

                        if (i == 3 && y2 == i && (x2 == 3 || x2 == 4)) {
                            exception = new ExceptionWindow();
                            return false;

                        }

                        if (i == 6 && y2 == i && (x2 == 3 || x2 == 4)) {
                            exception = new ExceptionWindow();
                            return false;

                        }

                        if (i == 7 && y2 == i && (x2 == 3 || x2 == 4)) {
                            exception = new ExceptionWindow();
                            return false;

                        }

                        if( x2==x1 && board.cards[x2][i]!=null && maxdis==0){
                            maxdis=i;
                        }

                        if (y2 == i && x2 == x1 && y2>=maxdis) {
                            return true;
                        }

                        i--;
                    }

                    i = y1+1;
                    maxdis=9;

                    while (i <= 9) { // paw pros ta dexia

                            if (i == 2 && y2 == i && (x2 == 3 || x2 == 4)) {
                                exception = new ExceptionWindow();
                                return false;

                            }
                            if (i == 3 && y2 == i && (x2 == 3 || x2 == 4)) {
                                exception = new ExceptionWindow();
                                return false;

                            }
                            if (i == 6 && y2 == i && (x2 == 3 || x2 == 4)) {
                                exception = new ExceptionWindow();
                                return false;

                            }
                            if (i == 7 && y2 == i && (x2 == 3 || x2 == 4)) {
                                exception = new ExceptionWindow();
                                return false;

                            }
                            if( x2==x1 && board.cards[x2][i]!=null && maxdis==9){
                                maxdis=i;
                            }
                            if (y2 == i && x2 == x1 && y2<=maxdis) {
                                return true;
                            }

                            i++;

                    }
                }
                exception = new ExceptionWindow();
                return false;
            }
        }
        if (noretrieve == 0 && ((x2 == x1 - 1 && y2 == y1) || (x2 == x1 + 1 && y2 == y1) || (x2 == x1 && y2 == y1 - 1) || (x2 == x1 && y2 == y1 + 1))) {
            return true;
        }
        // with no retrieve
        else if (board.cards[x1][y1].getcolor().equals(Piececolor.BLUE) && noretrieve == 1 && (((x2 == x1 + 1 && y2 == y1) || (x2 == x1 && y2 == y1 - 1) || (x2 == x1 && y2 == y1 + 1)))) {
            return true;
        } else if (board.cards[x1][y1].getcolor().equals(Piececolor.RED) && noretrieve == 1 && (((x2 == x1 - 1 && y2 == y1) || (x2 == x1 && y2 == y1 - 1) || (x2 == x1 && y2 == y1 + 1)))) {
            return true;
        } else {
            exception = new ExceptionWindow();
            return false;
        }

    }
    /**
     * This method checks if a player can move his pawn at a specific area according to its color and the pawn;s color in that area
     * <b>Post-condition:</b> Returns true if he can otherwise false
     @param xy1 String coordinate of source-button
     @param xy2 String coordinate of selected-button
     */
    public boolean checkcolor(String xy1, String xy2) { // checkarw an otan epaixe o player pathse tis swstes kartes apo apopsh xrwmatos
        int xy_1 = parseInt(xy1);
        int xy_2 = parseInt(xy2);
        int x1 = xy_1 / 10;
        int x2 = xy_2 / 10;
        int y1 = xy_1 % 10;
        int y2 = xy_2 % 10;

        if (board.cards[x1][y1] != null && board.cards[x2][y2] != null) {
            if (board.cards[x1][y1].getcolor().equals(board.cards[x2][y2].getcolor())) {
                exception = new ExceptionWindow();
                return false;
            }
        }
        return true;
    }

    /**This method checks if the movement that has been made is an attack or note
     <b>Post-condition:</b> returns true if the movement that has been made is an attack
     * @param xy1 String coordinate of source-button
     * @param xy2 String coordinate of selected-button
     */

    public boolean checkrank(String xy1, String xy2) { // selected and but
        int xy_1 = parseInt(xy1);
        int xy_2 = parseInt(xy2);
        int x1 = xy_1 / 10;
        int x2 = xy_2 / 10;
        int y1 = xy_1 % 10;
        int y2 = xy_2 % 10;
        if (board.cards[x2][y2] != null) { // prokeitai gia attack
            return true;
        }
        return false;
    }

    /**This method returns the player who is now playing according to the number of turn
     <b>Post-condition:</b> returns the player who is now playing according to the number of turn
     */

    public Player getcurrentPlayer() {
        if (turn.getturn() % 2 != 0) {
            return playerblue;
        } else {
            return playerred;
        }
    }


    /**This method returns 1 if the player who made the attack wins, 2 if the player who has made the attack loses or 3 if both of the pawns loose
     <b>Post-condition:</b> returns 1 if the player who made the attack wins, 2 if the player who has made the attack loses or 3 if both of the pawns loose
     * @param xy1 String coordinate of source-button
     * @param xy2 String coordinate of selected-button
     */


    public int attackwinner(String xy1, String xy2) {
        int xy_1 = parseInt(xy1);
        int xy_2 = parseInt(xy2);
        int x1 = xy_1 / 10;
        int x2 = xy_2 / 10;
        int y1 = xy_1 % 10;
        int y2 = xy_2 % 10;

        if(board.cards[x1][y1].toString().equals("Dwarf") && board.cards[x2][y2].toString().equals("Bomb") ){  /* o dwarf kerdizei sthn attack me bomb*/
            if(turn.getturn()%2!=0){
                playerblue.addattack();
                playerblue.addsuccesfullattack();
                playerblue.addCapturedpawn(board.cards[x2][y2],board.cards[x2][y2].getrank());
            }
            else{
                playerred.addattack();
                playerred.addsuccesfullattack();
                playerred.addCapturedpawn(board.cards[x2][y2],board.cards[x2][y2].getrank());
            }
            return 1;
        }

        if(board.cards[x2][y2].toString().equals("Bomb")){ // opoiodipote pioni hanei sthn attack me bomb

            if(turn.getturn()%2!=0){
                playerblue.addattack();
                playerred.addCapturedpawn(board.cards[x1][y1],board.cards[x1][y1].getrank());
            }
            else{
                playerred.addattack();
                playerblue.addCapturedpawn(board.cards[x1][y1],board.cards[x1][y1].getrank());
            }
            return 2;
        }

        if(board.cards[x1][y1].toString().equals("Slayer") && board.cards[x2][y2].getrank()==10){ // epithesh slayer se drako
            if(turn.getturn()%2!=0){
                playerblue.addattack();
                playerblue.addsuccesfullattack();
                playerblue.addCapturedpawn(board.cards[x2][y2],board.cards[x2][y2].getrank());
            }
            else{
                playerred.addattack();
                playerred.addsuccesfullattack();
                playerred.addCapturedpawn(board.cards[x2][y2],board.cards[x2][y2].getrank());
            }
            return 1;
        }

        if (board.cards[x1][y1].getrank() > board.cards[x2][y2].getrank()) {   /* o paikths pou paizei twra kerdizei sthn attack*/

            if(turn.getturn()%2!=0){
                playerblue.addattack();
                playerblue.addsuccesfullattack();
                playerblue.addCapturedpawn(board.cards[x2][y2],board.cards[x2][y2].getrank());
            }
            else{
                playerred.addattack();
                playerred.addsuccesfullattack();
                playerred.addCapturedpawn(board.cards[x2][y2],board.cards[x2][y2].getrank());
            }
            return 1;
        } else if (board.cards[x1][y1].getrank() < board.cards[x2][y2].getrank()) {     /* o paikths pou kanei attack twra xanei*/

            if(turn.getturn()%2!=0){
                playerblue.addattack();
                playerred.addCapturedpawn(board.cards[x1][y1],board.cards[x1][y1].getrank());
            }
            else{
                playerred.addattack();
                playerblue.addCapturedpawn(board.cards[x1][y1],board.cards[x1][y1].getrank());
            }
            return 2;
        } else {            /* kai oi 2 xanoun */

            if(turn.getturn()%2!=0){    // an ekane o mple thn epithesh
                playerblue.addattack();
                playerred.addCapturedpawn(board.cards[x1][y1],board.cards[x1][y1].getrank());
                playerblue.addCapturedpawn(board.cards[x2][y2],board.cards[x2][y2].getrank());
            }
            else{           // an ekane o kokkinos thn epithesh
                playerred.addattack();
                playerblue.addCapturedpawn(board.cards[x1][y1],board.cards[x1][y1].getrank());
                playerred.addCapturedpawn(board.cards[x2][y2],board.cards[x2][y2].getrank());
            }
           return 3;
        }
    }


    /**This method returns the value(0 or 1) of the noretrieve var
     <b>Post-condition:</b> returns the value(0 or 1) of the noretrieve var
     */

    public int getNoretrieve(){
        return noretrieve;
    }


    /**This method checks if the scout can make an attack from where he is placed end if he can it returns true otherwise false
     <b>Post-condition:</b> returns true if scout can make an attack from where he is placed end if he can it returns true otherwise false
     @param position String scout coordinate at the grid
     */

    public boolean scoutcanattack(String position){
        int xy_1 = parseInt(position);
        int x1 = xy_1 / 10;
        int y1 = xy_1 % 10;
        int i;


        if(noretrieve==0){
            i = x1-1;
            while (i >= 0) {  //pao pros ta panw me stathero y
                if (i == 3 && (y1 == 2 || y1 == 3 || y1 == 6 || y1 == 7)) {  // apagoreumenh zwnh
                    i=0;
                }else if (i == 4 && (y1 == 2 || y1 == 3 || y1 == 6 || y1 == 7)) {  // apagoreumenh zwnh
                    i=0;
                }else if (board.cards[i][y1] != null) {
                    if (!board.cards[x1][y1].getcolor().equals(board.cards[i][y1].getcolor())) {
                        return true;
                    }
                    i=0;    // exw pesei panw se diko mou pioni kai den xreiazetai na synexisw na psaxnw
                }

                i--;
            }

            i = x1+1;
            while (i <= 7) { //paw pros ta katw me stathero y
                if (i == 3  && (y1 == 2 || y1 == 3 || y1 == 6 || y1 == 7)) { // apagoreumenh zwnh

                    i=7;
                }else if (i == 4 && (y1 == 2 || y1 == 3 || y1 == 6 || y1 == 7)) { // apagoreumenh zwnh

                    i=7;
                }else if (board.cards[i][y1] != null) {
                    if (!board.cards[x1][y1].getcolor().equals(board.cards[i][y1].getcolor())) {
                       return true;
                    }
                    i=7;    // exw pesei panw se diko mou pioni kai den xreiazetai na synexisw na psaxnw
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
                else if (board.cards[x1][i] != null) {
                    if (!board.cards[x1][y1].getcolor().equals(board.cards[x1][i].getcolor())) {
                        return true;
                    }
                    i = 0;  // exw pesei panw se diko mou pioni kai den xreiazetai na synexisw na psaxnw
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
                } else if (board.cards[x1][i] != null) {
                    if (!board.cards[x1][y1].getcolor().equals(board.cards[x1][i].getcolor())) {
                      return true;
                    }
                    i = 9;  // exw pesei panw se diko mou pioni kai den xreiazetai na synexisw na psaxnw
                }
                i++;
            }
        }else{ // with no retrieve

            if(turn.getturn()%2!=0){ // blue pawns

                i = x1+1;
                while (i <= 7) { //paw pros ta katw me stathero y
                    if (i == 3  && (y1 == 2 || y1 == 3 || y1 == 6 || y1 == 7)) {

                        i=7;
                    }else if (i == 4 && (y1 == 2 || y1 == 3 || y1 == 6 || y1 == 7)) {

                        i=7;
                    }else if (board.cards[i][y1] != null) {
                        if (!board.cards[x1][y1].getcolor().equals(board.cards[i][y1].getcolor())) {
                            return true;
                        }
                        i=7;    // exw pesei panw se diko mou pioni kai den xreiazetai na synexisw na psaxnw
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
                    else if (board.cards[x1][i] != null) {
                        if (!board.cards[x1][y1].getcolor().equals(board.cards[x1][i].getcolor())) {
                            return true;
                        }
                        i = 0;  // exw pesei panw se diko mou pioni kai den xreiazetai na synexisw na psaxnw
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
                    } else if (board.cards[x1][i] != null) {
                        if (!board.cards[x1][y1].getcolor().equals(board.cards[x1][i].getcolor())) {
                            return true;
                        }
                        i = 9;  // exw pesei panw se diko mou pioni kai den xreiazetai na synexisw na psaxnw
                    }
                    i++;
                }

            }else{   // red pawns

                i = x1-1;
                while (i >= 0) {  //pao pros ta panw me stathero y
                    if (i == 3 && (y1 == 2 || y1 == 3 || y1 == 6 || y1 == 7)) {
                        i=0;
                    }else if (i == 4 && (y1 == 2 || y1 == 3 || y1 == 6 || y1 == 7)) {
                        i=0;
                    }else if (board.cards[i][y1] != null) {
                        if (!board.cards[x1][y1].getcolor().equals(board.cards[i][y1].getcolor())) {
                            return true;
                        }
                        i=0;    // exw pesei panw se diko mou pioni kai den xreiazetai na synexisw na psaxnw

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
                    else if (board.cards[x1][i] != null) {
                        if (!board.cards[x1][y1].getcolor().equals(board.cards[x1][i].getcolor())) {
                            return true;
                        }
                        i = 0;  // exw pesei panw se diko mou pioni kai den xreiazetai na synexisw na psaxnw
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
                    } else if (board.cards[x1][i] != null) {
                        if (!board.cards[x1][y1].getcolor().equals(board.cards[x1][i].getcolor())) {
                            return true;
                        }
                        i = 9; // exw pesei panw se diko mou pioni kai den xreiazetai na synexisw na psaxnw
                    }
                    i++;
                }
            }
        }
        return false;
    }
}