package Model.Peice.Movable;

import Model.Peice.Piece;
import Model.Peice.Piececolor;

public class Movablepiece implements Piece {
    private int av;
    private int rank;
    private Piececolor col;

    /**Constructor
     *
     * <b>Postcondition</b> Creates a movable pawn with certain availability ,color and rank.
     * @param av int
     * @param rank int
     * @param color Piececolor
     */
   public Movablepiece(int rank,int av,Piececolor color){
        this.rank=rank;
        this.av=av;
        this.col=color;
    }

    /**
     * <b>Transformer:</b> sets the piece's rank
     * <b>Postcondition:</b> piece's rank has been set
     * @param rank int
     */

    @Override
    public void setrank(int rank) {
       this.rank=rank;
    }

    /**
     * <b>Accessor:</b> returns the piece's rank
     * <b>Postcondition:</b> piece's rank has been returned
     *
     * @return int rank
     */

    @Override
    public int getrank() {
        return this.rank;
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
     * <b>Accessor:</b> returns the piece's color
     * <b>Postcondition:</b> piece's color has been returned
     * @return int rank
     */

    @Override
    public Piececolor getcolor() {
        return this.col;
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
}
