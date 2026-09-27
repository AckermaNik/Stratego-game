package Model.Peice.Immovable;

import Model.Peice.Immovable.Immovablepiece;
import Model.Peice.Piececolor;

public class Bomb extends Immovablepiece {
    /**
     * <b>constructor</b>: Constructs a new instance of Bomb and via the
     * parent class Immovable sets with the command super,
     * availability=6 and rank=0
     */

    public Bomb(Piececolor color ){
        super(6,color );
    }

    /**This method  returns the name of the card so I can use it as an "ID" later
     * <b>Post-condition <b/> returns the name of the card so I can use it as an "ID" later
     */
    public String toString(){
        return "Bomb";
    }
}
