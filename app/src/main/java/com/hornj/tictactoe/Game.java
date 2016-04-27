package com.hornj.tictactoe;

import android.util.Log;
import java.util.Arrays;

/**
 * Created by Jon on 4/26/16.
 */
public class Game {

    private int[] gameMoves = new int[10];
    private int currentPlayer = 1;
    private int player1Wins = 0;
    private int player2Wins = 0;

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public void playerMove(int moveNumber) {

        this.gameMoves[moveNumber] = currentPlayer;

        if (checkIfWinner() != -1) {
            Log.i("GAME OVER", "Player " + currentPlayer + " Wins");
            return;
        } else changePlayer();

    }

    private void changePlayer() {
        if (currentPlayer == 1) {
            currentPlayer = 2;
        } else currentPlayer = 1;
    }

    // Logic for determining winner
    private int checkIfWinner() {

        for (int i = 1; i < 3; i++) {
            if (this.gameMoves[1] == i) {
                if ((this.gameMoves[2] == i && this.gameMoves[3] == i) ||
                        (this.gameMoves[4] == i && this.gameMoves[7] == i) ||
                        (this.gameMoves[5] == i && this.gameMoves[9] == i))
                    return i;
            } else if (this.gameMoves[2] == i) {
                if (this.gameMoves[5] == i && this.gameMoves[8] == i) {
                    return i;
                }
            } else if (this.gameMoves[3] == i) {
                if ((this.gameMoves[6] == i && this.gameMoves[9] == i) ||
                        (this.gameMoves[5] == i && this.gameMoves[7] == i)) {
                    return i;
                }
            } else if (this.gameMoves[4] == i && this.gameMoves[5] == i && this.gameMoves[6] == i) {
                return i;
            }
            else if (this.gameMoves[7] == i && this.gameMoves[8] == i && this.gameMoves[9] == i) {
                return i;
            }
        }
        return -1;
    }

}
