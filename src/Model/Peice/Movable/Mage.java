package Model.Peice.Movable;

import Model.Peice.Movable.Movablepiece;
import Model.Peice.Piececolor;

public class Mage extends Movablepiece {
    /**
     * <b>constructor</b>: Constructs a new instance of Mage and via the
     * parent class Movable sets with the command super,
     * availability=1 and rank=9
     */
    public Mage(Piececolor color ) {
        super(9,1,color);
    }

    /**Thid fuctions returns the name of the card so I can use it as an "ID" later
     * <b>Post-condition <b/> returns the name of the card so I can use it as an "ID" later
     */
    public String toString(){
        return "Mage";
    }
}
