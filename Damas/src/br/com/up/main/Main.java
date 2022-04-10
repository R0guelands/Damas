package br.com.up.main;

import java.util.ArrayList;
import java.util.Scanner;

import br.com.up.board.BoardPrint;
import br.com.up.pieces.Pieces;

public class Main {

  public static void main(String[] args) {

    // variables for the class

    int first = 0; // is the variable for determining if i's the first time a class is called
    int nextPlayer = 0;
    ArrayList<Pieces> pieces = new ArrayList<>(); // the game is stored in here
    BoardPrint BoardPrint = new BoardPrint();
    Scanner scanner = new Scanner(System.in);
    char[] color = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
        'I', 'J', 'K', 'L' };

    char move;

    if (first == 0) {

      Welcome();
      GeneratePieces(pieces, color);

      first = 1;

    }

    while (Black(pieces) > 0 | White(pieces) > 0) {

      System.out.printf("\nScore -> Black: %d | White: %d\n", Black(pieces), White(pieces));

      if (nextPlayer % 2 == 0) {

        System.out.println("\nNext Player -> BLACK (upper case)");

      } else {

        System.out.println("\nNext Player -> WHITE (lowwer case)");

      }

      BoardPrint.Show(pieces);

      System.out.println("Select the piece you want to move: (ex 'a')");

      outer: while (true) {

        move = scanner.next().charAt(0);

        for (int i = 0; i < color.length; i ++) {

          if (nextPlayer % 2 == 0) {

            if (move == color[i] & Character.isUpperCase(color[i]) == true ) {

              break outer;

            }

          } else {

            if (move == color[i] & Character.isLowerCase(color[i]) == true ) {

              break outer;

            }

          }

        }

        System.out.println("Please select a valid piece.");

      }



      break;

    }

  }

  private static int Black(ArrayList<Pieces> pieces) {

    int black = 0;

    for (Pieces piece : pieces) {

      if (Character.isUpperCase(piece.getColor())) {

        black += 1;

      }

    }

    return black;

  }

  private static int White(ArrayList<Pieces> pieces) {

    int white = 0;

    for (Pieces piece : pieces) {

      if (Character.isLowerCase(piece.getColor())) {

        white += 1;

      }

    }

    return white;

  }

  private static void Welcome() {

    System.out.println("Welcome to Checkers!\n");
    System.out.println("In this game, you should choose your color beforehand.");
    System.out.println("The next player (color) will be displayed every time, as well as a score!\n");
    System.out.println("Have fun! The winner is set when only one color is remaining\n\n");

  }

  private static ArrayList<Pieces> GeneratePieces(ArrayList<Pieces> pieces, char[] color) {

    int index = 0;
    Pieces new_piece;

    for (int x = 0; x <= 7; x++) {

      if (x < 3 | x > 4) {

        for (int y = 0; y <= 7; y++) {

          if (x % 2 == 0) {

            if (y % 2 == 0) {

              new_piece = new Pieces(color[index], x, y);
              index += 1;
              pieces.add(new_piece);

            }

          } else {

            if (y % 2 != 0) {

              new_piece = new Pieces(color[index], x, y);
              index += 1;
              pieces.add(new_piece);

            }
          }
        }
      }
    }

    return pieces;

  }

}
