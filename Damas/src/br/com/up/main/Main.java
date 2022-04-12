package br.com.up.main;

import java.util.ArrayList;

import br.com.up.board.Board;
import br.com.up.board.BoardPrint;
import br.com.up.pieces.Pieces;

public class Main {

  public static void main(String[] args) {

    // variables for the class

    int nextPlayer = 0;

    ArrayList<Pieces> pieces = new ArrayList<>(); // the game is stored in here

    Board board = new Board();

    BoardPrint boardPrint = new BoardPrint();


    // welcome message and generating the initial pieces

    Welcome();
    GeneratePieces(pieces);

    // main loop of the game

    while (true) {

      Score(pieces);

      nextPlayer = NextPlayer(nextPlayer);

      if (nextPlayer == 1) {

        System.out.println("\n\nPlayer 1 (X), it's your turn!");

      } else {

        System.out.println("\n\nPlayer 2 (O), it's your turn!");

      }

      boardPrint.PrintBoard(pieces);

      pieces = board.BoardLogic(pieces, nextPlayer);

    }

  }

  public static int NextPlayer(int nextPlayer) {

    if (nextPlayer % 2 == 0) {

        nextPlayer = 1;

    } else {

        nextPlayer = 2;

    }

    return nextPlayer;

  }

  private static void Score(ArrayList<Pieces> pieces) {

    Board board = new Board();

    System.out.printf("\n\nScore: Black -> %d | White -> %d\n\n", board.Black(pieces), board.White(pieces));

  }

  private static void Welcome() {

    System.out.println("Welcome to Checkers!\n");
    System.out.println("In this game, you should choose your color beforehand.");
    System.out.println("The next player (color) will be displayed every time, as well as a score!\n");
    System.out.println("Have fun! The winner is set when only one color is remaining\n\n");

  }

  private static ArrayList<Pieces> GeneratePieces(ArrayList<Pieces> pieces) {

    char color;
    Pieces new_piece;

    for (int x = 0; x <= 7; x++) {

      if (x < 3) {

        color = 'X';

      } else {

        color = 'O';

      }

      if (x < 3 | x > 4) {

        for (int y = 0; y <= 7; y++) {

          if (x % 2 == 0) {

            if (y % 2 == 0) {

              new_piece = new Pieces(color, x, y);
              pieces.add(new_piece);

            }

          } else {

            if (y % 2 != 0) {

              new_piece = new Pieces(color, x, y);
              pieces.add(new_piece);

            }
          }
        }
      }
    }

    return pieces;

  }

}
