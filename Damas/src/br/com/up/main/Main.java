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
    int moveX, moveY, moveXX, moveYY;
    char original;
    int diff;
    int surrounding;
    ArrayList<Pieces> pieces = new ArrayList<>(); // the game is stored in here
    BoardPrint BoardPrint = new BoardPrint();
    Scanner scanner = new Scanner(System.in);

    // welcome message and generating the initial pieces

    if (first == 0) {

      Welcome();
      GeneratePieces(pieces);

      first = 1;

    }

    // main loop of the game

    while (Black(pieces) > 0 | White(pieces) > 0) {

      // the score and the next player indication

      System.out.printf("\nScore -> Black: %d | White: %d\n", Black(pieces), White(pieces));

      if (nextPlayer % 2 == 0) {

        System.out.println("\nNext Player -> BLACK (X)");

      } else {

        System.out.println("\nNext Player -> WHITE (O)");

      }

      BoardPrint.Show(pieces);

      // asking and validating the line of what piece to move

      System.out.println("\n\nPlease select the line of the piece you want to move!");

      outer: while (true) {

        surrounding = 0;

        moveX = scanner.nextInt();

        outer2: for (Pieces piece : pieces) {

          if (nextPlayer % 2 == 0) {

            if (moveX == piece.getX() & piece.getX() < 3) {

              for (Pieces piece2 : pieces) {

                if ((piece.getX() + 1 == piece2.getX() & piece.getY() + 1 == piece2.getY())
                    | (piece.getX() + 1 > 8 & piece.getY() > 8)) {

                  surrounding += 1;

                } else if ((piece.getX() - 1 == piece2.getX() & piece.getY() - 1 == piece2.getY())
                    | (piece.getX() - 1 < 0 & piece.getY() - 1 < 0)) {

                  surrounding += 1;

                } else if ((piece.getX() + 1 == piece2.getX() & piece.getY() - 1 == piece2.getY())
                    | (piece.getX() + 1 > 8 & piece.getY() - 1 < 0)) {

                  surrounding += 1;

                } else if ((piece.getX() - 1 == piece2.getX() & piece.getY() + 1 == piece2.getY())
                    | (piece.getX() - 1 < 0 & piece.getY() + 1 > 8)) {

                  surrounding += 1;

                }

                if (surrounding > 3) {

                  break outer2;

                }

              }

              break outer;

            }

          } else {

            if (moveX == piece.getX() & piece.getX() > 4) {

              for (Pieces piece2 : pieces) {

                if ((piece.getX() + 1 == piece2.getX() & piece.getY() + 1 == piece2.getY())
                    | (piece.getX() + 1 > 8 & piece.getY() > 8)) {

                  surrounding += 1;

                } else if ((piece.getX() - 1 == piece2.getX() & piece.getY() - 1 == piece2.getY())
                    | (piece.getX() - 1 < 0 & piece.getY() - 1 < 0)) {

                  surrounding += 1;

                } else if ((piece.getX() + 1 == piece2.getX() & piece.getY() - 1 == piece2.getY())
                    | (piece.getX() + 1 > 8 & piece.getY() - 1 < 0)) {

                  surrounding += 1;

                } else if ((piece.getX() - 1 == piece2.getX() & piece.getY() + 1 == piece2.getY())
                    | (piece.getX() - 1 < 0 & piece.getY() + 1 > 8)) {

                  surrounding += 1;

                }

                if (surrounding > 3) {

                  break outer2;

                }

              }

              break outer;

            }

          }

        }

        System.out.println("Invalid line! Please select another.");

      }

      // asking and validating the column of what piece to move and then showing the
      // board

      System.out.println("\n\nPlease select the column of the piece you want to move!");

      outer: while (true) {

        moveY = scanner.nextInt();

        surrounding = 0;

        outer2: for (Pieces piece : pieces) {

          if (moveY == piece.getY() & moveX == piece.getX()) {

            for (Pieces piece2 : pieces) {

              if ((piece.getX() + 1 == piece2.getX() & piece.getY() + 1 == piece2.getY())
                  | (piece.getX() + 1 > 8 & piece.getY() > 8)) {

                surrounding += 1;

              } else if ((piece.getX() - 1 == piece2.getX() & piece.getY() - 1 == piece2.getY())
                  | (piece.getX() - 1 < 0 & piece.getY() - 1 < 0)) {

                surrounding += 1;

              } else if ((piece.getX() + 1 == piece2.getX() & piece.getY() - 1 == piece2.getY())
                  | (piece.getX() + 1 > 8 & piece.getY() - 1 < 0)) {

                surrounding += 1;

              } else if ((piece.getX() - 1 == piece2.getX() & piece.getY() + 1 == piece2.getY())
                  | (piece.getX() - 1 < 0 & piece.getY() + 1 > 8)) {

                surrounding += 1;

              }

              if (surrounding > 3) {

                break outer2;

              }

            }

            original = piece.getColor();

            piece.setColor('S');

            BoardPrint.Show(pieces);

            piece.setColor(original);

            break outer;

          }

        }

        System.out.println("Invalid column! Please select another.");

      }

      // mentioning that the selected piece is now 'S'

      System.out.println("\nNow that you selected a piece, it's marked as 'S' in the board!");

      // asking and validating the line of where to move the piece

      System.out.println("\n\nPlease select the line of where to move your piece");

      

      nextPlayer += 1;

      break;

    }

  }

  private static int Black(ArrayList<Pieces> pieces) {

    int black = 0;

    for (Pieces piece : pieces) {

      if (piece.getColor() == 'X') {

        black += 1;

      }

    }

    return black;

  }

  private static int White(ArrayList<Pieces> pieces) {

    int white = 0;

    for (Pieces piece : pieces) {

      if (piece.getColor() == 'O') {

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
