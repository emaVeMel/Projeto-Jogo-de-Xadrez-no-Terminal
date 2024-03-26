package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Knight extends ChessPiece {

    public Knight(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "N";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean movements[][] = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position movePosition = new Position(0, 0);

        //NW-up
        movePosition.setValues(position.getRow() - 2, position.getColumn() - 1);
        if (getBoard().positionExists(movePosition) && !getBoard().thereIsAPiece(movePosition)) movements[movePosition.getRow()][movePosition.getColumn()] = true;
        if (getBoard().positionExists(movePosition) && isThereOpponentPiece(movePosition)) movements[movePosition.getRow()][movePosition.getColumn()] = true;

        //NW-down
        movePosition.setValues(position.getRow() - 1, position.getColumn() - 2);
        if (getBoard().positionExists(movePosition) && !getBoard().thereIsAPiece(movePosition)) movements[movePosition.getRow()][movePosition.getColumn()] = true;
        if (getBoard().positionExists(movePosition) && isThereOpponentPiece(movePosition)) movements[movePosition.getRow()][movePosition.getColumn()] = true;

        //NE-up
        movePosition.setValues(position.getRow() - 2, position.getColumn() + 1);
        if (getBoard().positionExists(movePosition) && !getBoard().thereIsAPiece(movePosition)) movements[movePosition.getRow()][movePosition.getColumn()] = true;
        if (getBoard().positionExists(movePosition) && isThereOpponentPiece(movePosition)) movements[movePosition.getRow()][movePosition.getColumn()] = true;

        //NE-down
        movePosition.setValues(position.getRow() - 1, position.getColumn() + 2);
        if (getBoard().positionExists(movePosition) && !getBoard().thereIsAPiece(movePosition)) movements[movePosition.getRow()][movePosition.getColumn()] = true;
        if (getBoard().positionExists(movePosition) && isThereOpponentPiece(movePosition)) movements[movePosition.getRow()][movePosition.getColumn()] = true;

        //SW-down
        movePosition.setValues(position.getRow() + 2, position.getColumn() - 1);
        if (getBoard().positionExists(movePosition) && !getBoard().thereIsAPiece(movePosition)) movements[movePosition.getRow()][movePosition.getColumn()] = true;
        if (getBoard().positionExists(movePosition) && isThereOpponentPiece(movePosition)) movements[movePosition.getRow()][movePosition.getColumn()] = true;

        //SW-up
        movePosition.setValues(position.getRow() + 1, position.getColumn() - 2);
        if (getBoard().positionExists(movePosition) && !getBoard().thereIsAPiece(movePosition)) movements[movePosition.getRow()][movePosition.getColumn()] = true;
        if (getBoard().positionExists(movePosition) && isThereOpponentPiece(movePosition)) movements[movePosition.getRow()][movePosition.getColumn()] = true;

        //SW-down
        movePosition.setValues(position.getRow() + 2, position.getColumn() + 1);
        if (getBoard().positionExists(movePosition) && !getBoard().thereIsAPiece(movePosition)) movements[movePosition.getRow()][movePosition.getColumn()] = true;
        if (getBoard().positionExists(movePosition) && isThereOpponentPiece(movePosition)) movements[movePosition.getRow()][movePosition.getColumn()] = true;

        //SE-down
        movePosition.setValues(position.getRow() + 1, position.getColumn() + 2);
        if (getBoard().positionExists(movePosition) && !getBoard().thereIsAPiece(movePosition)) movements[movePosition.getRow()][movePosition.getColumn()] = true;
        if (getBoard().positionExists(movePosition) && isThereOpponentPiece(movePosition)) movements[movePosition.getRow()][movePosition.getColumn()] = true;

        return movements;
    }
}
