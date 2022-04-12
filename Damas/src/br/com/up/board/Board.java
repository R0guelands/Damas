package br.com.up.board;

import java.util.ArrayList;
import java.util.Scanner;

import br.com.up.pieces.Pieces;

public class Board {

    public ArrayList<Pieces> BoardLogic(ArrayList<Pieces> pieces, int nextPLayer) {

        // Initializing systems

        Scanner input = new Scanner(System.in);

        BoardPrint boardPrint = new BoardPrint();

        // varibal for the class

        char aux;
        int newLine;
        int newColumn;
        int aux2;
        int diff;
        int line, column, line2, column2;

        // main logic

        System.out.println("\n\nSelect the line and the column of the piece you want to move:");

        outer: while (true) {

            line = input.nextInt();

            column = input.nextInt();

            aux2 = 0;


            for (Pieces piece: pieces) {

                if (nextPLayer == 1 && piece.getColor() == 'O' && piece.getX() == line && piece.getY() == column) {

                    System.out.println("\n\nInvalid move, try again!");

                    continue outer;

                } else if (nextPLayer == 2 && piece.getColor() == 'X' && piece.getX() == line && piece.getY() == column) {

                    System.out.println("\n\nInvalid move, try again!");

                    continue outer;

                }

                if ((line + 1 == piece.getX() && column + 1 == piece.getY()) || (line + 1 > 7 && column + 1 > 7)) {

                    if (nextPLayer == 1 && line + 1 == piece.getX() && column + 1 == piece.getY() && piece.getColor() == 'X') {

                        aux2 += 1;
                        
                    } else if (nextPLayer == 2 && line + 1 == piece.getX() && column + 1 == piece.getY() && piece.getColor() == 'O') {

                        aux2 += 1;

                    } else if (line + 1 > 7 && column + 1 > 7) {

                        aux2 += 1;

                    }
                    
                } else if ((line + 1 == piece.getX() && column - 1 == piece.getY()) || (line + 1 > 7 && column - 1 < 0)) {

                    if (nextPLayer == 1 && line + 1 == piece.getX() && column - 1 == piece.getY() && piece.getColor() == 'X') {

                        aux2 += 1;
                        
                    } else if (nextPLayer == 2 && line + 1 == piece.getX() && column - 1 == piece.getY() && piece.getColor() == 'O') {

                        aux2 += 1;

                    } else if (line + 1 > 7 && column - 1 < 0) {

                        aux2 += 1;

                    }


                } else if ((line - 1 == piece.getX() && column -1 == piece.getY()) || (line - 1 < 0 && column - 1 < 0)) {

                    if (nextPLayer == 1 && line - 1 == piece.getX() && column - 1 == piece.getY() && piece.getColor() == 'X') {

                        aux2 += 1;
                        
                    } else if (nextPLayer == 2 && line - 1 == piece.getX() && column - 1 == piece.getY() && piece.getColor() == 'O') {

                        aux2 += 1;

                    } else if (line - 1 < 0 && column - 1 < 0) {

                        aux2 += 1;

                    }

                } else if ((line - 1 == piece.getX() && column + 1 == piece.getY()) || (line - 1 < 0 && column + 1 > 7)) {

                    if (nextPLayer == 1 && line - 1 == piece.getX() && column + 1 == piece.getY() && piece.getColor() == 'X') {

                        aux2 += 1;
                        
                    } else if (nextPLayer == 2 && line - 1 == piece.getX() && column + 1 == piece.getY() && piece.getColor() == 'O') {

                        aux2 += 1;

                    } else if (line - 1 < 0 && column + 1 > 7) {

                        aux2 += 1;

                    }

                }

                

            }
            
            System.out.println(aux2);

            if (aux2 > 3) {

                System.out.println("\n\nInvalid position, try again!");

                continue outer;

            } else {

                for (Pieces piece : pieces) {

                    if (piece.getX() == line && piece.getY() == column) {

                        aux = piece.getColor();

                        piece.setColor('S');

                        boardPrint.PrintBoard(pieces);

                        piece.setColor(aux);

                        break outer;

                    }

                }

                System.out.println("\n\nInvalid position, try again!");

                continue outer;

            }

        }

        System.out.println("\n\nNow, select the line and the column where you want to move the piece:");

        outer: while (true) {

            newLine = 0;

            newColumn = 0;

            line2 = input.nextInt();

            column2 = input.nextInt();

            diff = Math.abs( (line + column) - (line2 + column2) );

            if (diff % 2 != 0 && diff != 0) {

                System.out.println("\n\nInvalid position, try again!");

                continue outer;

            }

            if (diff > 4) {

                System.out.println("\n\nInvalid position, try again!");

                continue outer;

            }

            if ((diff == 2) || ((int) Math.abs(line - line2) == 1 && (int) Math.abs(column - column2) == 1)) {

                System.out.println("\n\nhi\n\n");

                for (Pieces piece : pieces) {

                    if (piece.getX() == line2 && piece.getY() == column2) {

                        System.out.println("\n\nInvalid positionnnn, try again!");

                        continue outer;

                    }

                }

                for (Pieces piece: pieces) {

                    if (piece.getX() == line && piece.getY() == column) {

                        piece.setX(line2);

                        piece.setY(column2);

                        break outer;
                        
                    }

                }


            } else {

                if ((int) Math.abs(line - line2) == (int) Math.abs(column - column2)) {

                    for (Pieces piece: pieces) {

                        if (piece.getX() == line2 && piece.getY() == column2) {

                            System.out.println("\n\nInvalid position, try again!");

                            continue outer;
                            
                        }

                    }

                    for (Pieces piece: pieces) {

                        if (piece.getX() == line && piece.getY() == column) {
    
                            piece.setX(line2);
    
                            piece.setY(column2);
    
                            break;
                            
                        }
    
                    }

                    if (line < line2) {

                        newLine = line + 1;

                    }

                    if (line2 < line) {

                        newLine = line2 + 1;

                    }

                    if (column < column2) {

                        newColumn = column + 1;

                    }

                    if (column2 < column) {

                        newColumn = column2 + 1;

                    }


                    for (Pieces piece: pieces) {

                        if (piece.getX() == newLine && piece.getY() == newColumn) {

                            if (nextPLayer == 1 && piece.getColor() == 'O') {

                                pieces.remove(piece);

                                break outer;

                            } else if (nextPLayer == 2 && piece.getColor() == 'X') {

                                pieces.remove(piece);

                                break outer;

                            } else {

                                System.out.println("\n\nInvalid position, try again!");

                                continue outer;

                            }



                        }
    
                    }


                }


            }

            System.out.println("\n\nInvalid position, try again!");

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
