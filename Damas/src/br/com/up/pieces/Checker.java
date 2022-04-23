package br.com.up.pieces;

public class Checker extends Pieces {
    
    private int dama;

    public Checker(char color, int line, int column, int dama) {
        super(color, line, column);
        this.dama = dama;
    }

    public int getDama() {
        return this.dama;
    }

    public void setDama(int dama) {
        this.dama = dama;
    }

}
