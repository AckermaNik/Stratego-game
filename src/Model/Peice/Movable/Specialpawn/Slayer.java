package Model.Peice.Movable.Specialpawn;

import Model.Peice.Movable.Specialpawn.Specialpiece;
import Model.Peice.Piececolor;

public class Slayer extends Specialpiece {

    /**
     * <b>constructor</b>: Constructs a new instance of Slayer and via the
     * parent class Movable sets with the command super,
     * availability=1 and rank=1
     */

    public Slayer(Piececolor color ) {
        super(1,1,color);
    }

    public String toString(){
        return "Slayer";
    }
}
