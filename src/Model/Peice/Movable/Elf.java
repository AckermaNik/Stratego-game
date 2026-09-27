package Model.Peice.Movable;

import Model.Peice.Piececolor;

public class Elf extends Movablepiece{
    /**
     * <b>constructor</b>: Constructs a new instance of Sorceress and via the
     * parent class Movable sets with the command super,
     * availability=2 and rank=6
     */
    public Elf(Piececolor color ) {
        super(4,2,color);
    }

    /**Thid fuctions returns the name of the card so I can use it as an "ID" later
     * <b>Post-condition <b/> returns the name of the card so I can use it as an "ID" later
     */
    public String toString(){
        return "Elf";
    }
}
