package br.com.up.board;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import br.com.up.pieces.Pieces;

public class Board {

    public ArrayList<Pieces> BoardLogic(ArrayList<Pieces> pieces, int nextPlayer) {

        // Initializing systems

        Scanner input = new Scanner(System.in);

        BoardPrint boardPrint = new BoardPrint();

        Possibles possibles;

        ArrayList<Pieces> piecesAux = new ArrayList<>();

        ArrayList<Possibles> possibleList = new ArrayList<>();

        ArrayList<Possibles> possibleListAux = new ArrayList<>();

        ArrayList<Possibles> possibleListAux2 = new ArrayList<>();

        Pieces selection;

        // varibal for the class

        char aux;
        int newLine;
        int newColumn;
        int aux2;
        int aux3;
        int diff;
        int line, column, line2, column2, lineAux, columnAux;

        // main logic

        System.out.println("\n\nSelect the line and the column of the piece you want to move:");

        outer: while (true) {

            line = input.nextInt();

            column = input.nextInt();

            aux2 = 0;

            if (line < 0 || line > 7 || column < 0 || column > 7) {

                System.out.println("\n\nInvalid input, try again!");

                continue outer;

            }

            if (nextPlayer == 1) {

                selection = new Pieces('X', line, column);

            } else if (nextPlayer == 2) {

                selection = new Pieces('O', line, column);

            } else {

                System.out.println("\n\nError, please try again!");

                continue outer;

            }


            for (Pieces piece: pieces) {

                if (piece.getX() == selection.getX() && piece.getY() == selection.getY() && piece.getColor() == selection.getColor()) {

                    aux2 += 1;
    
                }

            }

            if (aux2 < 1) {

                System.out.println("\n\nInvalid input, try again!");

                continue outer;

            }

            aux2 = 0;

            for (int x = 0; x < 7; x ++) {

                for (int y = 0 ; y < 7; y ++) {

                    if ((int) Math.abs(line - x) == 1 && (int) Math.abs(column - y) == 1) {

                        aux2 += 1;

                        possibles = new Possibles(x, y);

                        possibleList.add(possibles);

                    }

                }

            }

            for (Possibles option : possibleList) {

                for (Pieces piece : pieces) {

                    if (piece.getX() == option.getX() && piece.getY() == option.getY() && piece.getColor() == selection.getColor() && possibleListAux.contains(option) == false) {

                        aux2 -= 1;

                        possibleListAux.add(option);

                    } else if (piece.getX() == option.getX() && piece.getY() == option.getY() && piece.getColor() != selection.getColor() && possibleListAux.contains(option) == false) {

                        if ((piece.getX() > selection.getX() && piece.getY() + 1 > selection.getY()) && (piece.getX() + 1 < 7 || piece.getY() + 1 < 7)) {

                            aux3 = 0;

                            for (Pieces piece2: pieces) {

                                if (piece2.getX() == piece.getX() + 1 && piece2.getY() == piece.getY() + 1) {
                
                                    aux3 += 1;
                    
                                }
                
                            }
                
                            if (aux3 > 0) {
                
                                aux2 -= 1;

                                possibleListAux.add(option);
                
                            }  else {

                                possibles = new Possibles((piece.getX() + 1), (piece.getY() + 1));

                                possibleListAux2.add(possibles);

                            }

                            //System.out.println("\n\nhi");

                        } else if ((piece.getX() - 1 < selection.getX() && piece.getY() - 1 < selection.getY()) && (piece.getX() - 1 > 0 || piece.getY() - 1 > 0)) {

                            aux3 = 0;

                            for (Pieces piece2: pieces) {

                                if (piece2.getX() == piece.getX() - 1 && piece2.getY() == piece.getY() - 1) {
                
                                    aux3 += 1;
                    
                                }
                
                            }
                
                            if (aux3 > 0) {
                
                                aux2 -= 1;

                                possibleListAux.add(option);
                
                            } else {

                                possibles = new Possibles(piece.getX() - 1, piece.getY() - 1);

                                possibleListAux2.add(possibles);

                            }

                        } else if ((piece.getX() + 1 > selection.getX() && piece.getY() - 1 < selection.getY()) && (piece.getX() + 1 < 7 || piece.getY() - 1 > 0)) {

                            aux3 = 0;

                            for (Pieces piece2: pieces) {

                                if (piece2.getX() == piece.getX() + 1 && piece2.getY() == piece.getY() - 1) {
                
                                    aux3 += 1;
                    
                                }
                
                            }
                
                            if (aux3 > 0) {
                
                                aux2 -= 1;

                                possibleListAux.add(option);
                
                            }  else {

                                possibles = new Possibles(piece.getX() + 1, piece.getY() - 1);

                                possibleListAux2.add(possibles);

                            }

                        } else if ((piece.getX() - 1 < selection.getX() && piece.getY() + 1 > selection.getY()) && (piece.getX() - 1 > 0 || piece.getY() + 1 < 7)) {

                            aux3 = 0;

                            for (Pieces piece2: pieces) {

                                if (piece2.getX() == piece.getX() - 1 && piece2.getY() == piece.getY() + 1) {
                
                                    aux3 += 1;
                    
                                }
                
                            }
                
                            if (aux3 > 0) {
                
                                aux2 -= 1;

                                possibleListAux.add(option);
                
                            } else {

                                possibles = new Possibles(piece.getX() - 1, piece.getY() + 1);

                                possibleListAux2.add(possibles);

                            }

                        }

                    }

                }

            }

            aux3 = 0;

            for (Possibles item : possibleListAux2) {

                possibleList.add(item);

            }

            System.out.println("\n\nPossible moves: " + aux2);

            if (aux2 == 0) {

                System.out.println("\n\nError, please try again!");

                continue outer;

            } else { 

                for (Pieces piece : pieces) {

                    if (piece.getX() == line && piece.getY() == column && piece.getColor() == selection.getColor()) {

                        aux = piece.getColor();

                        piece.setColor('S');

                        boardPrint.PrintBoard(pieces);

                        piece.setColor(aux);

                    }

                }

                break outer;

            }

        }

        System.out.println("\n\nNow, select the line and the column of where to move your piece: ");

        outer: while (true) {

            line2 = input.nextInt();

            column2 = input.nextInt();

            for (Possibles option : possibleListAux) {

                if (option.getX() == line2 && option.getY() == column2) {

                    System.out.println("\n\nInvalid inputtt, try again!");

                    continue outer;

                }

            }

            for (Possibles option : possibleList) {

                if (option.getX() == line2 && option.getY() == column2) {

                    if ((int) Math.abs(line - line2) == 1 && (int) Math.abs(column - column2) == 1) {

                        for (Pieces piece: pieces) {

                            if (piece.getX() == line && piece.getY() == column) {

                                piece.setX(line2);
                                piece.setY(column2);

                                break outer;

                            }

                        }

                    } else if ((int) Math.abs(line - line2) == 2 && (int) Math.abs(column - column2) == 2) {

                        lineAux = -1;

                        columnAux = -1;

                        if (line2 > line) {

                            lineAux = line + 1;

                        }

                        if (line > line2) {

                            lineAux = line2 + 1;

                        }

                        if (column > column2) {

                            columnAux = column2 + 1;

                        }

                        if (column2 > column) {

                            columnAux = column + 1;

                        }

                        for (Pieces piece: pieces) {

                            if (piece.getX() == line && piece.getY() == column) {

                                piece.setX(line2);
                                piece.setY(column2);

                            }

                            if (piece.getX() == lineAux && piece.getY() == columnAux) {

                                piecesAux.add(piece);

                            }

                        }

                        for (Pieces piece: piecesAux) {

                            pieces.remove(piece);

                        }

                        break outer;

                    }

                }

            }

            System.out.println("\n\nInvalidddd input, try again!");

            continue outer;

        }

        return pieces;

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
