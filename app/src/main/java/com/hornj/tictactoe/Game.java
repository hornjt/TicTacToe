package com.hornj.tictactoe;

import android.util.Log;

/**
 * Created by Jon on 4/26/16.
 */
public class Game {

    private int[] gameMoves = new int[10];
    private int currentPlayer = 1;

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public void playerMove(int boxIndex) {

        this.gameMoves[boxIndex] = currentPlayer;

        if (checkIfWinner() != -1) {
            Log.i("GAME OVER", "Player " + currentPlayer + " Wins");
            return;
        } else changePlayer();
    }

    public boolean currentBoxIsFull(int boxIndex) {
        if (gameMoves[boxIndex] != 0) {
            return true;
        } else return false;
    }

    private void changePlayer() {
        if (currentPlayer == 1) {
            currentPlayer = 2;
        } else currentPlayer = 1;
    }

    // Logic for determining winner
    private int checkIfWinner() {

        if (gameMoves[1] == currentPlayer) {
            if ((gameMoves[2] == currentPlayer && gameMoves[3] == currentPlayer) ||
                    (gameMoves[4] == currentPlayer && gameMoves[7] == currentPlayer) ||
                    (gameMoves[5] == currentPlayer && gameMoves[9] == currentPlayer))
                return currentPlayer;
        } else if (gameMoves[2] == currentPlayer) {
            if (gameMoves[5] == currentPlayer && gameMoves[8] == currentPlayer) {
                return currentPlayer;
            }
        } else if (gameMoves[3] == currentPlayer) {
            if ((gameMoves[6] == currentPlayer && gameMoves[9] == currentPlayer) ||
                    (gameMoves[5] == currentPlayer && gameMoves[7] == currentPlayer)) {
                return currentPlayer;
            }
        } else if (gameMoves[4] == currentPlayer && gameMoves[5] == currentPlayer && gameMoves[6] == currentPlayer) {
            return currentPlayer;
        }
        else if (gameMoves[7] == currentPlayer && gameMoves[8] == currentPlayer && gameMoves[9] == currentPlayer) {
            return currentPlayer;
        }
        return -1;
    }

}
