package com.hornj.tictactoe;

import android.util.Log;

/**
 * Created by Jon on 4/26/16.
 */
public class Game {

    private int[] gameMoves = new int[10];
    private int currentPlayer = 1;

    public void newGame() {
        this.gameMoves = new int[10];
        this.currentPlayer = 1;
    }

    public void makeMove(String fieldId) {
        System.out.println(fieldId);
        // Find the id of the box clicked and pass that to the player
        String targetNumber = fieldId.substring(fieldId.length() - 1);
        int moveNumber = Integer.parseInt(targetNumber);

//        this.currentPlayer.addPlayerMove(moveNumber);

        if (this.currentPlayer == 1) {
            this.gameMoves[moveNumber] = 1;
            if (checkIfWinner() == 1) {
                Log.i("GAME OVER", "Player 1 Wins");
                return;
            }
//            currentPlayer = 2;
        } else {
            this.gameMoves[moveNumber] = 2;
            if (checkIfWinner() == 1) {
                Log.i("GAME OVER", "Player 1 Wins");
                return;
            }
            currentPlayer = 1;
        }
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
