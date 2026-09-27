package Model.Peice.Movable;

import Model.Peice.Movable.Movablepiece;
import Model.Peice.Piececolor;

public class Knight extends Movablepiece {
    /**
     * <b>constructor</b>: Constructs a new instance of Knight and via the
     * parent class Movable sets with the command super,
     * availability=2 and rank=8
     */
    public Knight(Piececolor color ) {
        super(8,2,color);
    }

    /**Thid fuctions returns the name of the card so I can use it as an "ID" later
     * <b>Post-condition <b/> returns the name of the card so I can use it as an "ID" later
     */
    public String toString(){
        return "Knight";
    }
}
