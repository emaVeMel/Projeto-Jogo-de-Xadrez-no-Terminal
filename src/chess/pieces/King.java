package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {
    private ChessMatch match;

    public King(Board board, Color color, ChessMatch match) {
        super(board, color);
        this.match = match;
    }

    @Override
    public String toString() {
        return "K";
    }

    private boolean canMove(Position position) {
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p == null || p.getColor() != getColor();
    }

    private boolean testRookCastling(Position position) {
        ChessPiece piece = (ChessPiece) getBoard().piece(position);
        return piece != null && piece instanceof Rook & piece.getColor() == getColor() && piece.getMoveCount() == 0;
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] movements = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position movePosition = new Position(0, 0);

        //above
        movePosition.setValues(position.getRow() - 1, position.getColumn());
        if (getBoard().positionExists(movePosition) && canMove(movePosition)) {
            movements[movePosition.getRow()][movePosition.getColumn()] = true;
        }

        //below
        movePosition.setValues(position.getRow() + 1, position.getColumn());
        if (getBoard().positionExists(movePosition) && canMove(movePosition)) {
            movements[movePosition.getRow()][movePosition.getColumn()] = true;
        }

        //right
        movePosition.setValues(position.getRow(), position.getColumn() + 1);
        if (getBoard().positionExists(movePosition) && canMove(movePosition)) {
            movements[movePosition.getRow()][movePosition.getColumn()] = true;
        }

        //left
        movePosition.setValues(position.getRow(), position.getColumn() - 1);
        if (getBoard().positionExists(movePosition) && canMove(movePosition)) {
            movements[movePosition.getRow()][movePosition.getColumn()] = true;
        }

        //above-right
        movePosition.setValues(position.getRow() - 1, position.getColumn() + 1);
        if (getBoard().positionExists(movePosition) && canMove(movePosition)) {
            movements[movePosition.getRow()][movePosition.getColumn()] = true;
        }

        //above-left
        movePosition.setValues(position.getRow() - 1, position.getColumn() - 1);
        if (getBoard().positionExists(movePosition) && canMove(movePosition)) {
            movements[movePosition.getRow()][movePosition.getColumn()] = true;
        }

        //below-right
        movePosition.setValues(position.getRow() + 1, position.getColumn() + 1);
        if (getBoard().positionExists(movePosition) && canMove(movePosition)) {
            movements[movePosition.getRow()][movePosition.getColumn()] = true;
        }

        //below-left
        movePosition.setValues(position.getRow() + 1, position.getColumn() - 1);
        if (getBoard().positionExists(movePosition) && canMove(movePosition)) {
            movements[movePosition.getRow()][movePosition.getColumn()] = true;
        }

        //#specialmove castling
        if (getMoveCount() == 0 && !match.isCheck()) {
            //#specialmove castling king side rook
            Position posRK = new Position(position.getRow(), position.getColumn() + 3);
            if (testRookCastling(posRK)) {
                Position p1 = new Position(position.getRow(), position.getColumn() + 1);
                Position p2 = new Position(position.getRow(), position.getColumn() + 2);
                if (getBoard().piece(p1) == null && getBoard().piece(p2) == null) {
                    movements[p2.getRow()][p2.getColumn()] = true;
                }
            }
            //specialmove castling queen side rook
            Position posRQ = new Position(position.getRow(), position.getColumn() - 4);
            if (testRookCastling(posRQ)) {
                Position p1 = new Position(position.getRow(), position.getColumn() - 1);
                Position p2 = new Position(position.getRow(), position.getColumn() - 2);
                Position p3 = new Position(position.getRow(), position.getColumn() - 3);
                if (getBoard().piece(p1) == null && getBoard().piece(p2) == null && getBoard().piece(p3) == null) {
                    movements[p2.getRow()][p2.getColumn()] = true;
                }
            }
        }

        return movements;
    }
}
