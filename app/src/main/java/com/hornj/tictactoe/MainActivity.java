package com.hornj.tictactoe;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

    // Player 1 is Black O
    // Player 2 is Red X

    private Game game;

    public void displayIcon(View view) {
        ImageView currentBox = (ImageView)findViewById(view.getId());
        int boxIndex = Integer.parseInt(currentBox.getTag().toString());

        // Check if box has already been clicked
        if (game.currentBoxIsFull(boxIndex)) {
            Toast.makeText(getApplicationContext(), "Box has already been chosen",
                    Toast.LENGTH_LONG).show();
            return;
        }

        if (game.getCurrentPlayer() == 1) {
            currentBox.setImageResource(R.drawable.o_black);
        } else {
            currentBox.setImageResource(R.drawable.x_red);
        }
        game.playerMove(boxIndex);
    }

    public void newGame(View v) {
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        game = new Game();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
