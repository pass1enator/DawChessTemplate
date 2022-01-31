/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedro.ieslaencanta.com.chess.model;

/**
 *
 * @author Pedro
 */
public class Position implements Cloneable {

    private int row;
    private int col;

    public Position() {
        this.row = -1;
        this.col = -1;
    }

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    

    

    /**
     * @return the row
     */
    public int getRow() {
        return row;
    }

    /**
     * @return the col
     */
    public int getCol() {
        return col;
    }

    /**
     * @param row the row to set
     */
    public void setRow(int row) {
        this.row = row;
    }

    /**
     * @param col the col to set
     */
    public void setCol(int col) {
        this.col = col;
    }
    
    @Override
    public boolean equals(Object o) {
        boolean vuelta = false;
        Position tempo;

        if (o != null && o instanceof Position) {
            tempo = (Position) o;
            if (tempo.getCol() == this.getRow() || tempo.getRow() == this.getRow()) {
                return true;
            }
        }
        return vuelta;

    }
}
