package br.com.up.board;

import java.util.ArrayList;

import br.com.up.pieces.Pieces;

public class BoardPrint {
    
    public void Show(ArrayList<Pieces> pieces) {

        System.out.println("--------BOARD--------");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        
        for (int x = 0; x < 8; x ++) {

            System.out.println("|");

            for (int y = 0; y < 8; y ++) {

                for (Pieces piece: pieces) {

                    if (piece.getX() == x & piece.getY() == y) {

                        System.out.printf(" %d ", piece.getColor());

                    }else {

                        System.out.print("");

                    }

                }

            }

            System.out.println("|");

        }


        
    }

}
