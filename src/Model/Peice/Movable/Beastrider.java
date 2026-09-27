package Model.Peice.Movable;

import Model.Peice.Piececolor;

public class Beastrider extends Movablepiece {
    /**
     * <b>constructor</b>: Constructs a new instance of BeastRider and via the
     * parent class Movable sets with the command super,
     * availability=3 and rank=7
     */
    public Beastrider(Piececolor color ) {
        super(7,3,color);
    }

    /**Thid fuctions returns the name of the card so I can use it as an "ID" later
     * <b>Post-condition <b/> returns the name of the card so I can use it as an "ID" later
     */
    public String toString(){
        return "Beast rider";
    }
}
