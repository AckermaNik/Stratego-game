package Model.Player;

import Model.Peice.Piece;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;

public class Player {

    private String teamcolor;
    private Piece[] capturedpawns=new Piece[11]; //otherplayercapturedpawns

    private Integer[] timescaptured=new Integer[11];

    private  Integer[]timesfreed =new Integer[11];

    private int succesfullattacks=0;
    private  int allattacks=0;
    private int captivities=0;

    private int rescues=0;



    /**Constructor
     * @param team String
     * <b>Post-condition</b>Creates a player instance (of team blue/red) and initializes some values
     */
   public Player(String team ){
       for(int i=0;i<=10;i++){
           timescaptured[i]=0;
           timesfreed[i]=0;
       }

       this.teamcolor=team;
   }

   /**This method returns the player's team color
    * <b>Post-condition<b/> The player's team color is returned
    * */
   public String getTeamcolor(){
       return this.teamcolor;
   }


    /**This method add the captured pawn in the winner's player collection
     * @param piece Piece
     * @param rank int
     * <b>Post-condition<b/> The captured pawn is added in the winner's player collection
     * */
   public void addCapturedpawn(Piece piece ,int rank){   // piece gia na pairno to onoma kathe pioniou ws text

           capturedpawns[rank]=piece;
           timescaptured[rank]=timescaptured[rank]+1;
           captivities++;
   }

    /**This method deletes a freed pawn
     * <b>Post-condition<b/> A captured pawn is deleted
     * @param delete Piece
     * */
   public void deleteCapturedPawn(Piece delete){

       for(int i=0;i<capturedpawns.length;i++){
           if(capturedpawns[i]!=null) {
               if (capturedpawns[i].toString().equals(delete.toString())) {
                   capturedpawns[i]=null;
                   timesfreed[i]++;
                   timescaptured[i]--;
               }
           }
       }
       captivities--;
   }

    /**This method counts the number of the attacks attempted by this player
     * <b>Post-condition<b/> allattacks is increased by 1
     * */
    public void addattack(){
        allattacks++;
    }


    /**This method counts the number of the successful attacks attempted by this player
     * <b>Post-condition<b/> successfulattacks is increased by 1
     * */

    public void addsuccesfullattack(){
        succesfullattacks++;
    }


    /**This method returns the number of attacks in general
     * <b>Post-condition<b/> the number of attacks in general is returned
     * */
    public int getallattacks(){return allattacks;}


    /**This method returns the number of successful attacks
     * <b>Post-condition<b/> the number of successful attacks is returned
     * */

    public int getsuccesfullattacks(){return succesfullattacks;}


    /**This method counts the number of  player's all captive pawns
     * <b>Post-condition<b/> returns the number of  player's all captive pawns
     * */
    public int getcaptivities(){

        return captivities;
    }

    /**This method counts the number of rescues the  player has accomplished
     * */
    public void countresues(){
        rescues++;
    }

    /**This method returns the number of the rescues the player has accomplished
     * <b>Post-condition<b/> returns  the number of the rescues the player has accomplished
     * */
   public int getRescues(){
        return rescues;
   }

    /**This method returns the array with the Pieces  of captured pawns
     * <b>Post-condition<b/> returns  the array with the Pieces of captured pawns
     * */
   public Piece[] getcapturedpieces(){
       return capturedpawns;
   }

    /**This method returns the array with the numbers which indicates how many times any captured pawn was captured
     * <b>Post-condition<b/> returns  the array with the number which indicates how many times any captured pawn was captured
     * */
   public Integer[] gettimescaptured(){
       return timescaptured;
   }


    /**This method returns the array with the numbers which indicates how many times any captured pawn was captured
     * <b>Post-condition<b/> returns  the array with the number which indicates how many times any captured pawn was captured
     **/
   public boolean notallbombs(){
       for(int i=0;i<capturedpawns.length;i++){
           if(capturedpawns[i]!=null){
               if(capturedpawns[i].getrank()!=0){
                   return true;
               }
           }
       }
       return false;
   }
}
