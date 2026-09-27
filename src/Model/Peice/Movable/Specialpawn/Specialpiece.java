package Model.Peice.Movable.Specialpawn;

import Model.Peice.Movable.Movablepiece;
import Model.Peice.Piececolor;

public class Specialpiece extends Movablepiece {

    /**
     * Constructor
     * <b>Postcondition</b> Creates a SpecialPawn pawn with certain availability and rank.
     * @param rank int
     * @param av   int
     * @param color Piececolor
     */
    public Specialpiece(int rank, int av, Piececolor color) {
        super(rank, av,color);
    }
}
