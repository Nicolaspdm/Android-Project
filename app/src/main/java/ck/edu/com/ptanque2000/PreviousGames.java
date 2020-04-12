package ck.edu.com.ptanque2000;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class PreviousGames extends AppCompatActivity {

    private TextView displayGames;
    private DatabaseManager databaseManager;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previous_games);

        displayGames = (TextView) findViewById(R.id.displayGames);
        databaseManager = new DatabaseManager( this );

        List<Game> games = databaseManager.read5names();
        for (Game game : games) {
            displayGames.append(game.toString() + "\n\n");
        }


        databaseManager.close();


    }

    public void sendMessage(View view) {
        Intent intent = new Intent(PreviousGames.this, MainActivity.class);
        startActivity(intent);}

    public void displayGameStats(View view) {
        Intent intent = new Intent(PreviousGames.this, GameStats.class);
        startActivity(intent);}

}
