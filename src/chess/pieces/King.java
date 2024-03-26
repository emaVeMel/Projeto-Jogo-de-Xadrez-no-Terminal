package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

    public King(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "K";
    }

    private boolean canMove(Position position) {
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p == null || p.getColor() != getColor();
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

        return movements;
    }
}
