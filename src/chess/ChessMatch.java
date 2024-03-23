package chess;

import boardgame.Board;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {
    private static Board board;

    public ChessMatch() {
        board = new Board(8, 8);
        initialSetup();
    }

    public static ChessPiece[][] getPieces() {
        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColumns(); j++) {
                mat[i][j] = (ChessPiece) board.piece(i, j);
            }
        }
        return mat;
    }

    private void placeNewPiece(char column, int row, ChessPiece piece) {
        if (column < 'a' || column > 'h' || row < 1 || row > 8) throw new ChessException("Error: the position must be between a1 and h8.");
        board.placePiece(piece, new ChessPosition(column, row).toPosition());
    }

    private void initialSetup() {
        placeNewPiece('a', 8, new Rook(board, Color.WHITE));
        placeNewPiece('b', 6, new King(board, Color.BLACK));
    }
}
