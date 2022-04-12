package br.com.up.board;

import java.util.ArrayList;
import java.util.Scanner;

import br.com.up.pieces.Pieces;

public class Board {

    public ArrayList<Pieces> BoardLogic(ArrayList<Pieces> pieces) {

        int nextPlayer = 0;
        int moveX, moveY, moveXX, moveYY;
        char original;
        int diff;
        int surrounding;
        BoardPrint BoardPrint = new BoardPrint();
        Scanner scanner = new Scanner(System.in);

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

        return pieces;

    
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

}
