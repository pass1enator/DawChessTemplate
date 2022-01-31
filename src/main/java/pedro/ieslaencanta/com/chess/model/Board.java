/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedro.ieslaencanta.com.chess.model;


import pedro.ieslaencanta.com.chess.model.ChessPiece.Piece;
import pedro.ieslaencanta.com.chess.model.ChessPiece.PieceType;


/**
 *
 * @author Pedro
 */
public class Board {

    private Cell[][] cells;
  
    public Board() {
        this.reset();
    }

    public void reset() {
        this.cells = new Cell[8][8];
       

    }

    public Cell getCell(int row, int col) {
        return this.cells[row][col];
    }

    public int getHeight() {
        return this.cells.length;
    }

    public int getWidht() {
        return this.cells[0].length;
    }

    public Move move(int star_row, int star_col, int end_row, int end_col) {
        Piece p = this.cells[star_row][star_col].getPiece();

        Move m = null;
        if (p != null) {
            m = p.move(this, end_row, end_col);
            this.cells[star_row][star_col].setPiece(null);
            this.cells[end_row][end_col].setPiece(p);
        }
        return m;
    }

    @Override
    public String toString() {
        StringBuffer vuelta = new StringBuffer();
        for (int i = 0; i < this.cells.length; i++) {
            for (int j = 0; j < this.cells[i].length; j++) {
                vuelta.append(this.cells[i][j].toString());
            }
            vuelta.append("\n");
        }
        return vuelta.toString();
    }

    
}
