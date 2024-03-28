package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

import java.util.Objects;

public class Pawn extends ChessPiece {
    public Pawn(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "P";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] movements = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position movePosition = new Position(0, 0);

        if (getColor() == Color.WHITE) {
            movePosition.setValues(position.getRow() - 1, position.getColumn());
            if (getBoard().positionExists(movePosition) && !getBoard().thereIsAPiece(movePosition))
                movements[movePosition.getRow()][movePosition.getColumn()] = true;
            movePosition.setValues(position.getRow() - 2, position.getColumn());
            Position auxPosition = new Position(position.getRow() - 1, position.getColumn());
            if (getBoard().positionExists(movePosition) && !getBoard().thereIsAPiece(movePosition) && getBoard().positionExists(auxPosition) && !getBoard().thereIsAPiece(auxPosition) && getMoveCount() == 0)
                movements[movePosition.getRow()][movePosition.getColumn()] = true;
            movePosition.setValues(position.getRow() - 1, position.getColumn() - 1);
            if (getBoard().positionExists(movePosition) && isThereOpponentPiece(movePosition))
                movements[movePosition.getRow()][movePosition.getColumn()] = true;
            movePosition.setValues(position.getRow() - 1, position.getColumn() + 1);
            if (getBoard().positionExists(movePosition) && isThereOpponentPiece(movePosition))
                movements[movePosition.getRow()][movePosition.getColumn()] = true;
        } else {
            movePosition.setValues(position.getRow() + 1, position.getColumn());
            if (getBoard().positionExists(movePosition) && !getBoard().thereIsAPiece(movePosition))
                movements[movePosition.getRow()][movePosition.getColumn()] = true;
            movePosition.setValues(position.getRow() + 2, position.getColumn());
            Position p2 = new Position(position.getRow() + 1, position.getColumn());
            if (getBoard().positionExists(movePosition) && !getBoard().thereIsAPiece(movePosition) && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) && getMoveCount() == 0)
                movements[movePosition.getRow()][movePosition.getColumn()] = true;
            movePosition.setValues(position.getRow() + 1, position.getColumn() - 1);
            if (getBoard().positionExists(movePosition) && isThereOpponentPiece(movePosition))
                movements[movePosition.getRow()][movePosition.getColumn()] = true;
            movePosition.setValues(position.getRow() + 1, position.getColumn() + 1);
            if (getBoard().positionExists(movePosition) && isThereOpponentPiece(movePosition))
                movements[movePosition.getRow()][movePosition.getColumn()] = true;
        }

        return movements;
    }
}
