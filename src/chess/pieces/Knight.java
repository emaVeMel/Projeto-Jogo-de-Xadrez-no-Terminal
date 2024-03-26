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
        boolean matAux[][] = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0, 0);

        //NW-up
        p.setValues(position.getRow() - 2, position.getColumn() - 1);
        if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) matAux[p.getRow()][p.getColumn()] = true;
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)) matAux[p.getRow()][p.getColumn()] = true;

        //NW-down
        p.setValues(position.getRow() - 1, position.getColumn() - 2);
        if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) matAux[p.getRow()][p.getColumn()] = true;
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)) matAux[p.getRow()][p.getColumn()] = true;

        //NE-up
        p.setValues(position.getRow() - 2, position.getColumn() + 1);
        if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) matAux[p.getRow()][p.getColumn()] = true;
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)) matAux[p.getRow()][p.getColumn()] = true;

        //NE-down
        p.setValues(position.getRow() - 1, position.getColumn() + 2);
        if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) matAux[p.getRow()][p.getColumn()] = true;
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)) matAux[p.getRow()][p.getColumn()] = true;

        //SW-down
        p.setValues(position.getRow() + 2, position.getColumn() - 1);
        if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) matAux[p.getRow()][p.getColumn()] = true;
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)) matAux[p.getRow()][p.getColumn()] = true;

        //SW-up
        p.setValues(position.getRow() + 1, position.getColumn() - 2);
        if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) matAux[p.getRow()][p.getColumn()] = true;
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)) matAux[p.getRow()][p.getColumn()] = true;

        //SW-down
        p.setValues(position.getRow() + 2, position.getColumn() + 1);
        if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) matAux[p.getRow()][p.getColumn()] = true;
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)) matAux[p.getRow()][p.getColumn()] = true;

        //SE-down
        p.setValues(position.getRow() + 1, position.getColumn() + 2);
        if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) matAux[p.getRow()][p.getColumn()] = true;
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)) matAux[p.getRow()][p.getColumn()] = true;

        return matAux;
    }
}
