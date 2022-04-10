package br.com.up.main;

import java.util.ArrayList;

import br.com.up.board.BoardPrint;
import br.com.up.pieces.Pieces;

public class Main {

  public static void main(String[] args) {

    // variables for the class

    int first = 0; // is the main variable for determining if i's the first time a class is called, as well as main
    ArrayList<Pieces> pieces = new ArrayList<>(); // the game is stored in here, every piece has it's position for the board to render later
    int color;
    Pieces new_piece;
    if (first == 0) {

      Welcome();

      for (int x = 0; x <= 5; x++) {

        if (x <= 2) {
          color = 0;
        } else {
          color = 1;
        }

        if (x < 2 & x > 5) {

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
    }

    BoardPrint show = new BoardPrint();

    show.Show(pieces);

    first = 1;

  }

  private static void Welcome() {

    System.out.println("Welcome to Checkers!");
    System.out.println("");
    System.out.println("In this game, you should choose your color beforehand.");
    System.out.println("The next player (color) will be displayed every time, as well as a score!");
    System.out.println("");
    System.out.println("Have fun! The winner is set when only one color is remaining");

  }

}
