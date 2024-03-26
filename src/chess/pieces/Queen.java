package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Queen extends ChessPiece {
    public Queen(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "Q";
    }


    @Override
    public boolean[][] possibleMoves() {
        boolean[][] movements = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position movePosition = new Position(0, 0);

        //above
        movePosition.setValues(position.getRow() - 1, position.getColumn());
        while (getBoard().positionExists(movePosition) && !getBoard().thereIsAPiece(movePosition)) {
            movements[movePosition.getRow()][movePosition.getColumn()] = true;
            movePosition.setRow(movePosition.getRow() - 1);
        }
        if (getBoard().positionExists(movePosition) && isThereOpponentPiece(movePosition)) movements[movePosition.getRow()][movePosition.getColumn()] = true;

        //left
        movePosition.setValues(position.getRow(), position.getColumn() - 1);
        while (getBoard().positionExists(movePosition) && !getBoard().thereIsAPiece(movePosition)) {
            movements[movePosition.getRow()][movePosition.getColumn()] = true;
            movePosition.setColumn(movePosition.getColumn() - 1);
        }
        if (getBoard().positionExists(movePosition) && isThereOpponentPiece(movePosition)) movements[movePosition.getRow()][movePosition.getColumn()] = true;

        //right
        movePosition.setValues(position.getRow(), position.getColumn() + 1);
        while (getBoard().positionExists(movePosition) && !getBoard().thereIsAPiece(movePosition)) {
            movements[movePosition.getRow()][movePosition.getColumn()] = true;
            movePosition.setColumn(movePosition.getColumn() + 1);
        }
        if (getBoard().positionExists(movePosition) && isThereOpponentPiece(movePosition)) movements[movePosition.getRow()][movePosition.getColumn()] = true;

        //below
        movePosition.setValues(position.getRow() + 1, position.getColumn());
        while (getBoard().positionExists(movePosition) && !getBoard().thereIsAPiece(movePosition)) {
            movements[movePosition.getRow()][movePosition.getColumn()] = true;
            movePosition.setRow(movePosition.getRow() + 1);
        }
        if (getBoard().positionExists(movePosition) && isThereOpponentPiece(movePosition)) movements[movePosition.getRow()][movePosition.getColumn()] = true;

        //Up-right
        movePosition.setValues(position.getRow() - 1, position.getColumn() + 1);
        while (getBoard().positionExists(movePosition) && !getBoard().thereIsAPiece(movePosition)) {
            movements[movePosition.getRow()][movePosition.getColumn()] = true;
            movePosition.setValues(movePosition.getRow() - 1, movePosition.getColumn() + 1);
        }
        if (getBoard().positionExists(movePosition) && isThereOpponentPiece(movePosition)) movements[movePosition.getRow()][movePosition.getColumn()] = true;

        //Up-left
        movePosition.setValues(position.getRow() - 1, position.getColumn() - 1);
        while (getBoard().positionExists(movePosition) && !getBoard().thereIsAPiece(movePosition)) {
            movements[movePosition.getRow()][movePosition.getColumn()] = true;
            movePosition.setValues(movePosition.getRow() - 1, movePosition.getColumn() - 1);
        }
        if (getBoard().positionExists(movePosition) && isThereOpponentPiece(movePosition)) movements[movePosition.getRow()][movePosition.getColumn()] = true;

        //Down-right
        movePosition.setValues(position.getRow() + 1, position.getColumn() + 1);
        while (getBoard().positionExists(movePosition) && !getBoard().thereIsAPiece(movePosition)) {
            movements[movePosition.getRow()][movePosition.getColumn()] = true;
            movePosition.setValues(movePosition.getRow() + 1, movePosition.getColumn() + 1);
        }
        if (getBoard().positionExists(movePosition) && isThereOpponentPiece(movePosition)) movements[movePosition.getRow()][movePosition.getColumn()] = true;

        //Down-left
        movePosition.setValues(position.getRow() + 1, position.getColumn() - 1);
        while (getBoard().positionExists(movePosition) && !getBoard().thereIsAPiece(movePosition)) {
            movements[movePosition.getRow()][movePosition.getColumn()] = true;
            movePosition.setValues(movePosition.getRow() + 1, movePosition.getColumn() - 1);
        }
        if (getBoard().positionExists(movePosition) && isThereOpponentPiece(movePosition)) movements[movePosition.getRow()][movePosition.getColumn()] = true;

        return movements;
    }
}
