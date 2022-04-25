package br.com.up.board;

import java.util.ArrayList;

import br.com.up.pieces.Checker;
import br.com.up.pieces.Pieces;

public class BoardPrint {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public void PrintBoard(ArrayList<Checker> pieces) {

        int aux = 0;

        System.out.println("");

        System.out.println("    0  1  2  3  4  5  6  7");
        System.out.println("   ------------------------");

        for (int x = 0; x <= 7; x++) {

            System.out.printf("%d [", x);

            for (int y = 0; y <= 7; y++) {

                for (Checker piece : pieces) {

                    if (piece.getX() == x & piece.getY() == y) {

                        if (piece.getDama() == 1) {

                            System.out.printf(ANSI_GREEN + " %c " + ANSI_RESET, piece.getColor());
                            aux = 1;

                        } else { 

                            System.out.printf(" %c ", piece.getColor());
                            aux = 1;

                        }

                    }

                }
                
                if (aux == 0) {

                    System.out.print("   ");

                }

                aux = 0;

            }

            System.out.println("]");

        }

        System.out.println("   ------------------------");

    }

}
