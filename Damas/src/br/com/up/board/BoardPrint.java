package br.com.up.board;

import java.util.ArrayList;

import br.com.up.pieces.Pieces;

public class BoardPrint {

    public void PrintBoard(ArrayList<Pieces> pieces) {

        int aux = 0;

        System.out.println("\n\n--------BOARD--------\n\n");

        System.out.println("    0  1  2  3  4  5  6  7");
        System.out.println("   ------------------------");

        for (int x = 0; x <= 7; x++) {

            System.out.printf("%d [", x);

            for (int y = 0; y <= 7; y++) {

                for (Pieces piece : pieces) {

                    if (piece.getX() == x & piece.getY() == y) {

                        System.out.printf(" %c ", piece.getColor());
                        aux = 1;

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
