package br.com.up.main;

import java.util.ArrayList;
import br.com.up.board.Board;
import br.com.up.board.BoardPrint;
import br.com.up.pieces.Checker;

public class Main {

  public static void main(String[] args) {

    // variables

    int nextPlayer = 1; // 1 for white, 0 for black

    int rounds = 0; // rounds counter

    // initializing systems

    ArrayList<Checker> pieces = new ArrayList<>(); // the game is stored in here

    Board board = new Board();

    BoardPrint boardPrint = new BoardPrint();

    // welcome message and generating the initial pieces

    Welcome();

    GeneratePieces(pieces);

    // main loop of the game

    outer: while (true) {

      // validates a winner

      if (board.Black(pieces) == 12 || board.White(pieces) == 12) {

        System.out.println("Você venceu!! Parabéns!");

        break outer;

      }

      System.out.printf("\n----------------------%d----------------------\n", rounds);

      Score(pieces);

      nextPlayer = NextPlayer(nextPlayer);

      if (nextPlayer == 1) {

        System.out.println("\n\nPlayer 1 (X), é sua vez!");

      } else {

        System.out.println("\n\nPlayer 2 (O), é sua vez!");

      }

      boardPrint.PrintBoard(pieces);

      pieces = board.BoardLogic(pieces, nextPlayer);

      rounds += 1;

    }

  }

  // determines the next player

  public static int NextPlayer(int nextPlayer) {

    if (nextPlayer % 2 == 0) {

      nextPlayer = 1;

    } else {

      nextPlayer = 2;

    }

    return nextPlayer;

  }

  // returns the score of the game

  private static void Score(ArrayList<Checker> pieces) {

    Board board = new Board();

    System.out.printf("\n\nScore: O -> %d | X -> %d\n\n", board.Black(pieces), board.White(pieces));

  }

  // welcome message

  private static void Welcome() {

    System.out.println("Bem vindo ao jogo da velha!\n");
    System.out.println("Neste jogo, os jogadores devem escolher sua cor antes de começar.");
    System.out.println("o próximo jogador (cor) será exibido sempre acima\n");
    System.out.println("Divirtam-se!\n\n");

  }

  // generates the pieces

  private static ArrayList<Checker> GeneratePieces(ArrayList<Checker> pieces) {

    char color;
    Checker new_piece;

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

              new_piece = new Checker(color, x, y, 0);
              pieces.add(new_piece);

            }

          } else {

            if (y % 2 != 0) {

              new_piece = new Checker(color, x, y, 0);
              pieces.add(new_piece);

            }

          }

        }

      }

    }

    return pieces;

  }

}
