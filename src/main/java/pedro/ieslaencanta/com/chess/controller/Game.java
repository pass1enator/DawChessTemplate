/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedro.ieslaencanta.com.chess.controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import pedro.ieslaencanta.com.chess.model.Board;

import pedro.ieslaencanta.com.chess.model.ChessPiece.Piece;
import pedro.ieslaencanta.com.chess.model.ChessPiece.PieceType;

import pedro.ieslaencanta.com.chess.model.Move;
import pedro.ieslaencanta.com.chess.model.Position;

/**
 *
 * @author Pedro
 */
public class Game {

    private Board board;
    

    public Game() {
        this.board = new Board();
       
    }

    /**
     * Mover una pieza si existe en la posición y es del turno
     *
     * @param startrow
     * @param startcol
     * @param endrow
     * @param endcol
     * @return
     */
    public Move move(int startrow, int startcol, int endrow, int endcol) {
        Move m = null;
        
        return m;
    }

    /**
     * indica si alguna de las piezas se encuentra en posicion de dar jaque
     *
     *
     * @return movimiento que hace que el rey este en mate
     */
    public Move[] Jaque() {
        
            return null;
        

    }
/**
 * Si el rey que se le pasa esta en jaque
 * @param rey
 * @return 
 */
    private boolean IsJaque(Piece rey) {
        boolean vuelta = false;
       
        return vuelta;
    }

    /**
     * Se comprueba jaquemate si antes es jaque se le pasa el color de la última
     * jugada y comprueba para el rey contrario
     *
     * @return si el rey se puede mover
     */
    public boolean JaqueMate(PieceType type) {
        //es jaque mientras no pueda hacer algun movimiento
        //vuelta true si libre, 0 si no libre
        boolean vuelta = true;

        return vuelta;
    }

    /**
     * Si una ficha se puede mover o no a partir de las coordenadas
     *
     * @param startrow
     * @param startcol
     * @param endrow
     * @param endcol
     * @return
     */
    public boolean canMove(int startrow, int startcol, int endrow, int endcol) {
        boolean vuelta = false;
       
        return vuelta;
    }

    /**
     * Para una celda devuelve los movimientos calculados de esa celda de estar
     * una pieza en ella
     *
     * @param row
     * @param col
     * @return movimientos posibles
     * @see pedro.ieslaencanta.com.chess.model.Move
     */
    public Move[] getCalculatesMoves(int row, int col) {
        Move m[] = null;
       
        return m;
    }

    /**
     * Calcula y devuelve los movimeintos posibles para esa figura si en la
     * celda se encuentra una figura, los movimientos se quedan almacenados en
     * la figura
     *
     * @param row
     * @param col
     * @return Movimientos posibles
     * @see pedro.ieslaencanta.com.chess.model.Move
     */
    public Move[] getMoves(int row, int col) {
        Move m[] = null;
       
        return m;
    }

    public void reset() {
        this.board.reset();
    }

    public PieceType getPieceType(int row, int col) {
        PieceType pt = null;

        return pt;
    }

    /**
     * @return the board
     */
    public Board getBoard() {
        return board;
    }

    /**
     * @param board the board to set
     */
    public void setBoard(Board board) {
        this.board = board;
    }

   
}
