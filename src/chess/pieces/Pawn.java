package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

import java.util.Objects;

public class Pawn extends ChessPiece {
    private ChessMatch match;

    public Pawn(Board board, Color color, ChessMatch match) {
        super(board, color);
        this.match = match;
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

            //specialmove en passant white
            if (position.getRow() == 3) {
                Position left = new Position(position.getRow(), position.getColumn() - 1);
                if (getBoard().positionExists(left) && getBoard().thereIsAPiece(left) && getBoard().piece(left) == match.getEnPassantVulnerable()) {
                    movements[position.getRow() - 1][position.getColumn() - 1]= true;
                }
                Position right = new Position(position.getRow(), position.getColumn() + 1);
                if (getBoard().positionExists(right) && getBoard().thereIsAPiece(right) && getBoard().piece(right) == match.getEnPassantVulnerable()) {
                    movements[position.getRow() - 1][position.getColumn() + 1] = true;
                }
            }
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

            //specialmove en passant black
            if (position.getRow() == 4) {
                Position left = new Position(position.getRow(), position.getColumn() - 1);
                if (getBoard().positionExists(left) && getBoard().thereIsAPiece(left) && getBoard().piece(left) == match.getEnPassantVulnerable()) {
                    movements[position.getRow() + 1][position.getColumn() - 1]= true;
                }
                Position right = new Position(position.getRow(), position.getColumn() + 1);
                if (getBoard().positionExists(right) && getBoard().thereIsAPiece(right) && getBoard().piece(right) == match.getEnPassantVulnerable()) {
                    movements[position.getRow() + 1][position.getColumn() + 1] = true;
                }
            }
        }

        return movements;
    }
}
