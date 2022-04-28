package br.com.up.board;

import java.util.ArrayList;
import java.util.Scanner;

import br.com.up.pieces.Checker;
import br.com.up.pieces.Pieces;

public class Board {

    public ArrayList<Checker> BoardLogic(ArrayList<Checker> pieces, int nextPlayer) {

        // Initializing systems

        Scanner input = new Scanner(System.in);
        BoardPrint boardPrint = new BoardPrint();
        ArrayList<Possibles> possibles = new ArrayList<>();

        // variables

        int line, column, line2, column2; // the coordinates of the piece and the destination
        int cont; // auxiliary variable
        char color; // the color of the piece - is used to show the selected piece - auxiliary variable
        Checker selection = new Checker('A', 10, 10, 10);

        // selects the piece to move

        System.out.println("\n\nSelecione a linha e a coluna da peça que deseja mover:");

        outer: while (true) {

            System.out.print("Linha: ");
            line = input.nextInt();
            System.out.print("Coluna: ");
            column = input.nextInt();

            if (line < 0 || line > 7 || column < 0 || column > 7) {
                System.out.println("\n\nPosição inválida, tente novamente!");
                continue;
            }
            if (nextPlayer == 1) {
                color = 'X';
            } else {
                color = 'O';
            }
            cont = 0;
            for (Checker piece : pieces) {
                if (piece.getX() == line && piece.getY() == column && piece.getColor() == color) {
                    cont += 1;
                    selection.setX(piece.getX());
                    selection.setY(piece.getY());
                    selection.setColor(piece.getColor());
                    selection.setDama(piece.getDama());
                }
            }
            if (cont < 1) {
                System.out.println("\nSeleção inválida, tente novamente!");
                continue outer;
            }
            cont = 0;
            if (selection.getDama() == 0) {
                possibles = MovesNormal(selection, pieces);
            } else {
                possibles = MovesChecker(selection, pieces);
            }
            if (possibles.size() == 0) {
                System.out.println("\nEsta peça não possue nenhuma jogada válida! Escolha outra, por favor.");
                continue outer;
            }
            for (Checker piece : pieces) {
                if (piece.getX() == selection.getX() && piece.getY() == selection.getY()) {
                    color = piece.getColor();
                    piece.setColor('S');
                    boardPrint.PrintBoard(pieces);
                    System.out.println("\nInfo: A peça selecionada é exibida como 'S'!");
                    piece.setColor(color);
                    break outer;
                }
            }
            System.out.println("\nAlgo deu errado! Tente novamente...");
            continue outer;

        }

        // selects the place where to move the piece + moves it

        System.out.println("\nSelecione para onde deseja mover a peça selecionada:");

        outer: while (true) {

            System.out.print("Linha: ");
            line2 = input.nextInt();
            System.out.print("Coluna: ");
            column2 = input.nextInt();

            if (line < 0 || line > 7 || column < 0 || column > 7) {
                System.out.println("\nPosição inválida, tente novamente!");
                continue;
            }
            if (MovesValidator(possibles, line2, column2) == false) {
                System.out.println("\nPosição inválida, tente novamente!");
                continue;
            } else {
                pieces = PieceEater(line, column, line2, column2, pieces);
                break outer;
            }

        }

        for (int y = 0; y < 8; y++) {
            for (Checker piece : pieces) {
                if (piece.getX() == 0 && piece.getY() == y && piece.getColor() == 'O') {
                    System.out.println("\n-----------------------------------------------\n\nParabéns, uma dama foi formada!! Ela será exibida em VERDE\n");
                    piece.setDama(1);
                }
            }
        }

        for (int y = 0; y < 8; y++) {
            for (Checker piece : pieces) {
                if (piece.getX() == 7 && piece.getY() == y && piece.getColor() == 'X') {
                    System.out.println("\n-----------------------------------------------\n\nParabéns, uma dama foi formada!! Ela será exibida em VERDE\n");
                    piece.setDama(1);
                }
            }
        }

        return pieces;

    }

    // moves a piece and "eat" the ones in the way

    private ArrayList<Checker> PieceEater(int line, int column, int line2, int column2, ArrayList<Checker> pieces) {

        int m, pieceXx, pieceYy, a, b, h, a2, b2, h2;
        ArrayList<Checker> pieces2 = new ArrayList<>();

        m = (column2 - column) / (line2 - line); // slope
        a = (int) Math.abs(line - line2); // distance between the two points
        b = (int) Math.abs(column - column2); // distance between the two points
        h = (a * a) + (b * b); // hipotenuse
        a2 = 0; // first side of the triangle
        b2 = 0; // second side of the triangle

        // Y - y1 = m (X - x1) 

        for (Checker piece : pieces) {
            pieceXx = m * (piece.getX() - line);
            pieceYy = piece.getY() - column;
            if ((int) Math.abs(piece.getX() - line) > (int) Math.abs(piece.getX() - line2)) {
                a2 = (int) Math.abs(piece.getX() - line);
                b2 = (int) Math.abs(piece.getY() - column);
            } else {
                a2 = (int) Math.abs(piece.getX() - line2);
                b2 = (int) Math.abs(piece.getY() - column2);
            }
            h2 = (a2 * a2) + (b2 * b2);
            if (((pieceXx != pieceYy) || (h2 > h) || (piece.getX() == line && piece.getY() == column))
                    && pieces2.contains(piece) == false) {
                pieces2.add(piece);
            }
        }

        for (Checker piece : pieces2) {
            if (piece.getX() == line && piece.getY() == column) {
                piece.setX(line2);
                piece.setY(column2);
            }
        }

        return pieces2;

    }

    // validates if the move is valid

    private boolean MovesValidator(ArrayList<Possibles> possibles, int line2, int column2) {

        int count = 0; // counts the number of valid moves

        for (Possibles possible : possibles) {
            if (possible.getX() == line2 && possible.getY() == column2) {
                count += 1;
                break;
            }
        }

        if (count == 1) {

            return true;

        } else {

            return false;

        }

    }

    // returns all the possible moves for a normal piece

    private ArrayList<Possibles> MovesNormal(Checker selection, ArrayList<Checker> pieces) {

        ArrayList<Possibles> possibles = new ArrayList<>();
        Possibles possibleMove;
        int count, count2; 

        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                count2 = 0;
                if ((int) Math.abs(x - selection.getX()) == 1 && (int) Math.abs(y - selection.getY()) == 1) {
                    count2 = 0;
                    for (Checker piece : pieces) {
                        count = 0;
                        if (piece.getX() == x && piece.getY() == y && piece.getColor() != selection.getColor()) {
                            count2 += 1;
                            if (x - selection.getX() == -1 && y - selection.getY() == 1) {
                                if (x - 1 >= 0 && y + 1 < 8) {
                                    count = 0;
                                    for (Checker piece2 : pieces) {
                                        if (piece2.getX() == x - 1 && piece2.getY() == y + 1) {
                                            count += 1;
                                        }
                                    }
                                    if (count == 0) {
                                        possibleMove = new Possibles(x - 1, y + 1);
                                        possibles.add(possibleMove);
                                    }
                                }
                            } else if (x - selection.getX() == 1 && y - selection.getY() == 1) {
                                if (x + 1 < 8 && y + 1 < 8) {
                                    count = 0;
                                    for (Checker piece2 : pieces) {
                                        if (piece2.getX() == x + 1 && piece2.getY() == y + 1) {
                                            count += 1;
                                        }
                                    }
                                    if (count == 0) {
                                        possibleMove = new Possibles(x + 1, y + 1);
                                        possibles.add(possibleMove);
                                    }
                                }
                            } else if (x - selection.getX() == 1 && y - selection.getY() == -1) {
                                if (x + 1 < 8 && y - 1 >= 0) {
                                     count = 0;
                                    for (Checker piece2 : pieces) {
                                        if (piece2.getX() == x + 1 && piece2.getY() == y - 1) {
                                            count += 1;
                                        }
                                    }
                                    if (count == 0) {
                                        possibleMove = new Possibles(x + 1, y - 1);
                                        possibles.add(possibleMove);
                                    }
                                }
                            } else if (x - selection.getX() == -1 && y - selection.getY() == -1) {
                                if (x - 1 >= 0 && y - 1 >= 0) {
                                    count = 0;
                                    for (Checker piece2 : pieces) {
                                        if (piece2.getX() == x - 1 && piece2.getY() == y - 1) {
                                            count += 1;
                                        }
                                    }
                                    if (count == 0) {
                                        possibleMove = new Possibles(x - 1, y - 1);
                                        possibles.add(possibleMove);
                                    }
                                }
                            }
                        } else if (piece.getX() == x && piece.getY() == y && piece.getColor() == selection.getColor()) {
                            count2 += 1;
                        }
                    }
                    if (count2 == 0) {
                        possibleMove = new Possibles(x, y);
                        possibles.add(possibleMove);
                    }
                }
            }
        }

        return possibles;

    }

    // returns all the possible moves for a checker 

    private ArrayList<Possibles> MovesChecker(Checker selection, ArrayList<Checker> pieces) {

        ArrayList<Possibles> possibles = new ArrayList<>();
        Possibles possibleMove;
        int count; 
        int x = 0;
        int y = 0;

        x = selection.getX() + 1;

        outer: for (y = selection.getY() + 1; y < 8; y ++) {

            count = 0;

            outer2: for (Checker piece : pieces) {
                if (piece.getX() == x && piece.getY() == y) {
                    if (piece.getColor() == selection.getColor()) {
                        break outer;
                    } else if (piece.getColor() != selection.getColor()) {
                          break outer2;
                    }
                }
                count += 1;
            }
            if (count == pieces.size()) {
                possibleMove = new Possibles(x, y);
                possibles.add(possibleMove);
            }
            x++;
        }

        x = selection.getX() + 1;

        outer: for (y = selection.getY() - 1; y >= 0; y --) {

            count = 0;

            outer2: for (Checker piece : pieces) {
                if (piece.getX() == x && piece.getY() == y) {
                    if (piece.getColor() == selection.getColor()) {
                        break outer;
                    } else if (piece.getColor() != selection.getColor()) {
                        break outer2;
                    }
                }
                count += 1;
            }
            if (count == pieces.size()) {
                possibleMove = new Possibles(x, y);
                possibles.add(possibleMove);
            }
            x++;
        }

        x = selection.getX() - 1;

        outer: for (y = selection.getY() + 1; y < 8; y ++) {

            count = 0;

            outer2: for (Checker piece : pieces) {
                if (piece.getX() == x && piece.getY() == y) {
                    if (piece.getColor() == selection.getColor()) {
                        break outer;
                    } else if (piece.getColor() != selection.getColor()) {
                        break outer2;
                    }
                }
                count += 1;
            }
            if (count == pieces.size()) {
                possibleMove = new Possibles(x, y);
                possibles.add(possibleMove);
            }
            x--;
        }

        x = selection.getX() - 1;

        outer: for (y = selection.getY() - 1; y >= 0; y --) {

            count = 0;

            outer2: for (Checker piece : pieces) {
                if (piece.getX() == x && piece.getY() == y) {
                    if (piece.getColor() == selection.getColor()) {
                        break outer;
                    } else if (piece.getColor() != selection.getColor()) {
                        break outer2;
                    }
                }
                count += 1;
            }
            if (count == pieces.size()) {
                possibleMove = new Possibles(x, y);
                possibles.add(possibleMove);
            }
            x--;
        }

        return possibles;

    }

    // returns the black pieces counting

    public int Black(ArrayList<Checker> pieces) {

        int black = 12;

        for (Pieces piece : pieces) {
            if (piece.getColor() == 'X') {
                black -= 1;
            }
        }

        return black;

    }

    // returns the white pieces counting

    public int White(ArrayList<Checker> pieces) {

        int white = 12;

        for (Pieces piece : pieces) {
            if (piece.getColor() == 'O') {
                white -= 1;
            }
        }

        return white;

    }

}
