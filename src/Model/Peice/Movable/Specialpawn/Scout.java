package Model.Peice.Movable.Specialpawn;

import Model.Peice.Movable.Specialpawn.Specialpiece;
import Model.Peice.Piececolor;

public class Scout extends Specialpiece {

    /**
     * <b>constructor</b>: Constructs a new instance of Scout and via the
     * parent class Movable sets with the command super,
     * availability=4 and rank=2
     */

    public Scout(Piececolor color) {
        super(2, 4,color );
    }

    public String toString(){
        return "Scout";
    }
}
