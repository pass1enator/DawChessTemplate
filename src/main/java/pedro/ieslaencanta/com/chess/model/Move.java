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
public class Move {

    private Position start;
    private Position end;
    private Piece origin;
    private Piece replaced;

    public Move() {
        this.origin = null;
        this.replaced = null;
        this.start = null;
        this.end = null;
    }

    public Move(Piece origin, Piece replaced, Position start, Position end) {
        this.origin = origin;
        this.replaced = replaced;
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        StringBuffer b = new StringBuffer();
        b.append("Origin:" + this.origin.toString() + "\n");
        b.append("Replaced:" + ((this.replaced != null) ? this.replaced.toString() : ""));
        b.append("Start:" + ((this.start != null) ? this.start.toString() : ""));
        b.append("End:" + ((this.end != null) ? this.end.toString() : ""));
        return b.toString();
    }

    /**
     * @return the start
     */
    public Position getStart() {
        return start;
    }

    /**
     * @return the end
     */
    public Position getEnd() {
        return end;
    }

    /**
     * @return the origin
     */
    public Piece getOrigin() {
        return origin;
    }

    /**
     * @return the replaced
     */
    public Piece getReplaced() {
        return replaced;
    }

    /**
     * @param start the start to set
     */
    public void setStart(Position start) {
        this.start = start;
    }

    /**
     * @param end the end to set
     */
    public void setEnd(Position end) {
        this.end = end;
    }

    /**
     * @param origin the origin to set
     */
    public void setOrigin(Piece origin) {
        this.origin = origin;
    }

    /**
     * @param replaced the replaced to set
     */
    public void setReplaced(Piece replaced) {
        this.replaced = replaced;
    }
}
