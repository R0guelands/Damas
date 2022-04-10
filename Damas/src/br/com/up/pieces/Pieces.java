package br.com.up.pieces;

public class Pieces {

    //variables for the class
    
    char color; //0 for black, 1 for white
    int x; //x position og the given piece
    int y; //y position og the given piece

    public Pieces (char color, int x, int y){
        this.color = color;
        this.x = x;
        this.y = y;
    }


    public char getColor() {
        return this.color;
    }

    public void setColor(char color) {
        this.color = color;
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }


}
