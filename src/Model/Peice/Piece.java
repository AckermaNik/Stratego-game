package Model.Peice;

public interface Piece {



    /**
     * <b>Transformer:</b> sets the piece's rank
     * <b>Postcondition:</b> piece's rank has been set
     * @param rank int
     */
    void setrank(int rank);

    /**
     * <b>Accessor:</b> returns the piece's rank
     * <b>Postcondition:</b> piece's rank has been returned
     *
     * @return int rank
     */

    int getrank();


    /**
     * <b>Transformer:</b> sets the piece's quantity according to its rank
     * <b>Postcondition:</b> piece's quantity has been set
     */

    void setav(); // av= availability


    /**
     * <b>Accessor:</b> returns the piece's availability
     * <b>Postcondition:</b> piece's availability has been returned
     * @return int rank
     */
    int getav();

    /**
     * <b>Accessor:</b> returns the piece's color
     * <b>Postcondition:</b> piece's color has been returned
     * @return int rank
     */
    Piececolor  getcolor();

    /**
     * <b>Transformer:</b> sets the piece's quantity
     * <b>Postcondition:</b> piece's quantity has been set
     * @param col Piececolor
     */
    void setcolor(Piececolor col);


    /**This method returns the name of the card so I can use it as an "ID" later
     * <b>Post-condition <b/> returns the name of the card so I can use it as an "ID" later
     */
     public String toString();
}
