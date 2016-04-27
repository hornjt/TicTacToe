package com.hornj.tictactoe;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends ActionBarActivity {

    Game game = new Game();

//    public void makeMove(View v) {
//        game.makeMove(v);
//    }


    // This method gets the click event and passes that information to the game
    public void makeMove(View v) {
        int idOfBox = v.getId();
        String nameOfTarget = getResources().getResourceEntryName(idOfBox);
        ImageView currentTarget = (ImageView)findViewById(idOfBox);
        currentTarget.setVisibility(View.INVISIBLE);
        game.makeMove(nameOfTarget);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    public boolean onTouchEvent(MotionEvent e)
    {
        int xpos=(int) e.getX();
        int ypos=(int) e.getY();
        switch (e.getAction())
        {
            case MotionEvent.ACTION_DOWN:
//                Log.d("DEBUG", "On touch (down)" + String.valueOf(xpos) + String.valueOf(ypos));
                Log.d("DEBUG", "X: " + String.valueOf(xpos));
                Log.d("DEBUG", "Y: " + String.valueOf(ypos));

//            case MotionEvent.ACTION_UP:
//                Log.d("DEBUG", "On touch (up)" + String.valueOf(xpos) + String.valueOf(ypos));
//            case MotionEvent.ACTION_MOVE:
//                Log.d("DEBUG", "On touch (move)" + String.valueOf(xpos) + String.valueOf(ypos));
//                break;
        }
        return true;

    }
}
