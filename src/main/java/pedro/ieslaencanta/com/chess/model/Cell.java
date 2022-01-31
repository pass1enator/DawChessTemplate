/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedro.ieslaencanta.com.chess.model;

import pedro.ieslaencanta.com.chess.model.ChessPiece.Piece;

/**
 *
 * @author Pedro
 */
public class Cell {

    private Position position;
    private Piece piece;

    public Cell() {
        this.position=new  Position(-1,-1);
        this.piece=null;
    }
    public Cell(int row, int col) {
        this.position=new  Position(row,col);
        this.piece=null;
        
    }
    @Override
    public String toString(){
        if(this.piece!=null)
            return this.piece.toString();
        else
            return "-- ";
    }
    /**
     * @return the position
     */
    public Position getPosition() {
        return position;
    }

    /**
     * @return the piece
     */
    public Piece getPiece() {
        return piece;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(Position position) {
        this.position = position;
    }

    /**
     * @param piece the piece to set
     */
    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}
