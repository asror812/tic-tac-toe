package com.epam.rd.autocode.concurrenttictactoe;

public class GameFactory {

        public static TicTacToe buildGame() {
            return new TicTacToeImpl();
        }

        public static Player createPlayer(TicTacToe ticTacToe, char mark, PlayerStrategy strategy) {
            return new PlayerImpl(ticTacToe, mark, strategy);
        }

        public static void main(String[] args) {
            TicTacToe ticTacToe = buildGame();

            Player playerX = createPlayer(ticTacToe, 'X', new Strategy());
            Player playerO = createPlayer(ticTacToe, 'O', new Strategy());

            Thread threadX = new Thread(playerX);
            Thread threadO = new Thread(playerO);

            threadX.start();
            threadO.start();
        }
}
