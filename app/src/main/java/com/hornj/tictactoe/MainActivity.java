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

public class MainActivity extends ActionBarActivity {

    private Game game;

    // This method gets the click event and passes that information to the game
    public void makeMove(View v) {
        int idOfBox = v.getId();
        String nameOfTarget = getResources().getResourceEntryName(idOfBox);

        // Find the id number of the box clicked
        String targetNumber = nameOfTarget.substring(nameOfTarget.length() - 1);
        int moveNumber = Integer.parseInt(targetNumber);

        ImageView currentTarget = (ImageView)findViewById(idOfBox);
        currentTarget.setVisibility(View.INVISIBLE);
        setIcon(moveNumber, game.getCurrentPlayer());
        game.playerMove(moveNumber);
    }

    public void newGame(View v) {
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }

    // This method is called to turn the icon on depending on the player
    // and where they clicked
    private void setIcon(int moveId, int playerNumber) {
        if (playerNumber == 1) {
            String xMove = "x" + moveId;
            buildIcon(xMove);
        } else {
            String oMove = "o" + moveId;
            buildIcon(oMove);
        }
    }

    // Helper function to setIcon() to look up the resource by id name
    private void buildIcon(String moveLocation) {
        int resId = getResources()
                .getIdentifier(moveLocation, "id", this.getPackageName());
        ImageView x = (ImageView)findViewById(resId);
        x.setVisibility(View.VISIBLE);
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
