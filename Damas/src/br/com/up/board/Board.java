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

        // varibal for the class

        int line, column, line2, column2, lineAux, columnAux;

        // main logic

        System.out.println("\n\nSelect the line and the column of the piece you want to move:");

        outer: while (true) {

            line = input.nextInt();

            column = input.nextInt();

            if (line < 0 || line > 7 || column < 0 || column > 7) {

                System.out.println("\n\nInvalid position, try again:");

                continue;

            }

            

        }

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
