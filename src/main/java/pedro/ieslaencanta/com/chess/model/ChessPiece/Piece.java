/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedro.ieslaencanta.com.chess.model.ChessPiece;

import java.util.logging.Level;
import java.util.logging.Logger;
import pedro.ieslaencanta.com.chess.model.Board;
import pedro.ieslaencanta.com.chess.model.Move;
import pedro.ieslaencanta.com.chess.model.Position;

/**
 *
 * @author Pedro
 */
public abstract class Piece {

    protected Position p;
    protected PieceType type;
    protected boolean alive;
    protected Move moves[];
    protected char letter;
    private String id;

    public Piece() {

    }

    public Piece(int row, int col) {
        this.p = new Position(row, col);
    }

    @Override
    public String toString() {
        return this.getId();
    }

    /**
     * Mueve una pieza a una posición del tablero, la comprobación se realiza en
     * canmove, no aqui
     *
     * @param board
     * @param row
     * @param col
     * @return devuelve un movimiento
     */
    public Move move(Board board, int row, int col) {
         Move move = null;
        return move;
    }

    protected Move[] getHorizontalMoves(Board b, int row, int start, int end) {

        Move moves[] = null;
        return moves;
    }

    protected Move[] getVertical(Board b, int col, int start, int end) {

         Move moves[] = null;
        return moves;
    }

    /**
     *
     * @param b tablero
     * @param dirx si va hacia la izquierda o derecha
     * @param diry si va hacia arriba o hacia abajo
     * @return movimientos posibles en esa diagonal
     */
    protected Move[] getDiagonal(Board b, int dirx, int diry) {

        return null;
    }

    /**
     *
     * @param b tablero
     * @param dirx direccion de la diagonal enel eje x -1 izquierda, 1 derecha
     * @param diry direccionde la diagonal en el eje y -1 arriba, 1 abajo
     * @param lenght longitud máxima
     * @return
     */
    protected Move[] getDiagonal(Board b, int dirx, int diry, int lenght) {

        Move moves[] = null;
        return moves;
    }

    public boolean canmove(Board board, int row, int col) {
        boolean vuelta = false;
        
        
       
        return vuelta;
    }
    public Move[] getCalculatedMoves(){
        return this.moves;
    }
    public abstract Move[] getMoves(Board board);

    /**
     * @return the letter
     */
    public char getLetter() {
        return letter;
    }

    /**
     * @param letter the letter to set
     */
    public void setLetter(char letter) {
        this.letter = letter;
    }

    /**
     * @return the p
     */
    public Position getPosition() {
        return p;
    }

    /**
     * @return the type
     */
    public PieceType getType() {
        return type;
    }

    /**
     * @return the alive
     */
    public boolean isAlive() {
        return alive;
    }

    /**
     * @param p the p to set
     */
    public void setPosition(Position p) {
        this.p = p;
    }

    /**
     * @param type the type to set
     */
    public void setType(PieceType type) {
        this.type = type;
    }

    /**
     * @param alive the alive to set
     */
    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = this.letter + ((this.getType() == PieceType.White) ? "W" : "B") + id;
    }

   
}
