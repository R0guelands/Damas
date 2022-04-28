package br.com.up.board;

import java.util.ArrayList;

import br.com.up.pieces.Checker;

public class BoardPrint {

    // defines the color patterns for the checker printing

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";

    // prints the board

    public void PrintBoard(ArrayList<Checker> pieces) {

        int aux = 0;

        System.out.println("");
        System.out.println("     0   1   2   3   4   5   6   7");

        for (int x = 0; x <= 7; x++) {
            System.out.println("   ---------------------------------");
            System.out.printf("%d  ", x);
            for (int y = 0; y <= 7; y++) {
                System.out.print("|");
                for (Checker piece : pieces) {
                    if (piece.getX() == x & piece.getY() == y) {
                        if (piece.getDama() == 1) {
                            System.out.printf(ANSI_GREEN + " %c " + ANSI_RESET, piece.getColor());
                            aux = 1;
                        } else { 
                            if (piece.getColor() == 'X') {
                                System.out.printf(ANSI_RED + " %c " + ANSI_RESET, piece.getColor());
                                aux = 1;
                            } else if (piece.getColor() == 'O'){ 
                                System.out.printf(ANSI_YELLOW + " %c " + ANSI_RESET, piece.getColor());
                                aux = 1;
                            } else if (piece.getColor() == 'S') {
                                System.out.printf(ANSI_BLUE + " %c " + ANSI_RESET, piece.getColor());
                                aux = 1;
                            }
                        }
                    }
                }
                if (aux == 0) {
                    System.out.print("   ");
                }
                aux = 0;
            }
            System.out.println( "| ");
        }
        System.out.println("   ---------------------------------");

    }

}
