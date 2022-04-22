package br.com.up.board;

import java.util.ArrayList;
import java.util.Scanner;

import br.com.up.pieces.Pieces;

public class Board {

    public ArrayList<Pieces> BoardLogic(ArrayList<Pieces> pieces, int nextPlayer) {

        // Initializing systems

        Scanner input = new Scanner(System.in);

        BoardPrint boardPrint = new BoardPrint();

        Possibles possibles;

        ArrayList<Possibles> possibleList = new ArrayList<>();

        Pieces selection;

        // varibal for the class

        char aux;
        int aux2;
        int aux3;
        int line, column, line2, column2, lineAux, columnAux;

        // main logic

        System.out.println("\n\nSelect the line and the column of the piece you want to move:");

    }

    public int Black(ArrayList<Pieces> pieces) {

        int black = 12;

        for (Pieces piece : pieces) {

            if (piece.getColor() == 'X') {

                black -= 1;

            }

        }

        return black;

    }

    public int White(ArrayList<Pieces> pieces) {

        int white = 12;

        for (Pieces piece : pieces) {

            if (piece.getColor() == 'O') {

                white -= 1;

            }

        }

        return white;

    }

}
