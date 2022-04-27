package br.com.up.board;

import java.util.ArrayList;

import br.com.up.pieces.Checker;

public class BoardPrint {

    // defines the color patterns for the checker printing

    public static final String ANSI_RESET = "\u001B[0m";

    public static final String ANSI_GREEN = "\u001B[32m";

    public static final String ANSI_CYAN = "\u001B[36m";

    // prints the board

    public void PrintBoard(ArrayList<Checker> pieces) {

        int aux = 0;

        System.out.println("");

        System.out.println(ANSI_CYAN + "     0   1   2   3   4   5   6   7" + ANSI_RESET);

        for (int x = 0; x <= 7; x++) {

            System.out.println(ANSI_CYAN + "   ---------------------------------" + ANSI_RESET);

            System.out.printf(ANSI_CYAN + "%d  " + ANSI_RESET, x);

            for (int y = 0; y <= 7; y++) {

                
                System.out.print(ANSI_CYAN + "|" + ANSI_RESET);

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

            System.out.println(ANSI_CYAN + "| " + ANSI_RESET);

        }

        System.out.println(ANSI_CYAN + "   ---------------------------------" + ANSI_RESET);

    }

}
