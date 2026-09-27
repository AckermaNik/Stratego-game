package Model.Peice.Immovable;

import Model.Peice.Piece;
import Model.Peice.Piececolor;

public class Immovablepiece implements Piece {

    private int av;
    private int rank;
    private Piececolor col;

    /**Constructor
     *
     * <b>Postcondition</b>Creates an immovable pawn with certain color availability  and rank=0.
     * @param av int
     * @param color Piececolor
     */
    public Immovablepiece(int av,Piececolor color){
        this.av=av;
        this.rank=0;
        this.col=color;

    }

    /**
     * <b>Transformer:</b> sets the piece's rank
     * <b>Postcondition:</b> piece's rank has been set
     * @param rank int
     */

     @Override
    public void setrank(int rank) {}

    /**
     * <b>Accessor:</b> returns the piece's rank
     * <b>Postcondition:</b> piece's rank has been returned
     *
     * @return int rank
     */

    @Override
    public int getrank() {
        return 0;
    }

    /**
     * <b>Transformer:</b> sets the piece's quantity according to its rank
     * <b>Postcondition:</b> piece's quantity has been set
     */

    @Override
    public void setav() {

    }

    /**
     * <b>Accessor:</b> returns the piece's availability
     * <b>Postcondition:</b> piece's availability has been returned
     * @return int rank
     */

    @Override
    public int getav() {
        return this.av;
    }

    /**
     * <b>Transformer:</b> sets the piece's quantity
     * <b>Postcondition:</b> piece's quantity has been set
     * @param col Piececolor
     */

    @Override
    public void setcolor(Piececolor col) {
             this.col=col;
    }

    /**
     * <b>Accessor:</b> returns the piece's color
     * <b>Postcondition:</b> piece's color has been returned
     * @return int rank
     */

    public Piececolor getcolor(){
        return this.col;
    }
}
