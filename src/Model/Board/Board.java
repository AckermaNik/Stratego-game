package Model.Board;

import Model.Peice.Piece;
import Model.Player.Player;

import javax.swing.*;

import static java.lang.Integer.parseInt;

public class Board {
    public  Piece [][] cards = new Piece[8][10];

    /**This method swaps the pieces in the cards board (which represents them as they are on the grid),after one has moved or after an attack
     * @param xy1 int coordinate of source-button
     * @param xy2 int  coordinate of selected-button
     * */

    public void swappawns( String xy1,String xy2){
        int xy_1 = parseInt(xy1);
        int xy_2 = parseInt(xy2);
        int x1 = xy_1 / 10;
        int x2 = xy_2 / 10;
        int y1 = xy_1 % 10;
        int y2 = xy_2 % 10;
        Piece temp;

        temp=cards[x1][y1];
        cards[x1][y1]=cards[x2][y2];
        cards[x2][y2]=temp;
    }


    /**This method swaps the pieces when there has been an attack in the cards board (which represents them as they are on the grid),after one has moved or after an attack
     * @param xy1 int  coordinate of source-button
     * @param xy2 int  coordinate of selected-button
     * @param attackstatus int
     * */

    public void swapattackpawns(String xy1, String xy2,int attackstatus){
        int xy_1 = parseInt(xy1);
        int xy_2 = parseInt(xy2);
        int x1 = xy_1 / 10;
        int x2 = xy_2 / 10;
        int y1 = xy_1 % 10;
        int y2 = xy_2 % 10;

        if(attackstatus==1){ /* o paikths pou paizei twra kerdizei sthn attack*/
            cards[x2][y2]=cards[x1][y1];
            cards[x1][y1]=null;
        }
        else if(attackstatus==2){  /* o paikths pou paizei twra xanei sthn attack*/
            cards[x1][y1]=null;
        }
        else{                       /* kai oi 2 xanoun */
            cards[x1][y1]=null;
            cards[x2][y2]=null;
        }
    }


    /**This method swaps the pieces in the cards board (which represents them as they are on the grid),after one has moved or after an attack
     * @param newpawn Piece the rescued pawn
     * @param newxy int new coordinate of the rescued pawn
     * */
    public void swaprescuepawn(Piece newpawn,String newxy){
        int xy_1 = parseInt(newxy);
        int x1 = xy_1 / 10;
        int y1 = xy_1 % 10;

        cards[x1][y1]=newpawn;

    }

    /**This method returns the piece at the position xy1
     * @param xy1 int coordinate of but button
     * */

   public Piece returnpawn(String xy1){
        int xy_1 = parseInt(xy1);
        int x1 = xy_1 / 10;
        int y1 = xy_1 % 10;

        return cards[x1][y1];
    }





}


