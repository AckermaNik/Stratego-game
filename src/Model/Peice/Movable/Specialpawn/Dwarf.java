package Model.Peice.Movable.Specialpawn;

import Model.Peice.Piececolor;

public class Dwarf extends Specialpiece {

    /**
     * <b>constructor</b>: Constructs a new instance of Dwarf and via the
     * parent class Movable sets with the command super,
     * availability=5 and rank=3
     */

    public Dwarf(Piececolor color) {
        super(3, 5,color);
    }

    public String toString(){
        return "Dwarf";
    }
}
