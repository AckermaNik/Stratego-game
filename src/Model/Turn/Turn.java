package Model.Turn;

public class Turn {
    private int turn=0;
    private int round=0;


    /**This method increases the turn value by 1 and checks if I have to move to the next round by increasing round var by 1
     <b>Postcondition:</b> the turn's value is increased by 1 and checks if I have to move to the next round by increasing round var by 1
     */

    public void setturn(){ // an to turn einai zygos aritmos tora paizei h blue team
        setround();
        this.turn++;       // an to turn einai peritos aritmos tora paizei h red team
    }

    /**
     <b>Postcondition:</b> return turn's value
     @return turn value
     */
    public int getturn(){
        return this.turn;
    }

    /**This method increases the round value by 1 so I can count the overall rounds
     <b>Postcondition:</b> the round's value is increased by 1
     */
    public void setround(){
        if(turn%2==0 ){  // kathe fora pou paizoun kai oi 2 paixtes to turn tha einai zygos arithmos
            round++;
       }
    }

    /**
     <b>Postcondition:</b> return round's value
     @return round int
     */

    public int getRound(){
        return this.round;
    }
}
