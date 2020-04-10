package ck.edu.com.ptanque2000;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class GameStats extends AppCompatActivity {

    private TextView winner_name;
    private TextView score_value;
    private TextView match_duration;
    private TextView game_localisation;

    String wname = "Louis";
    String svalue = "14";
    String mduration = "30:57";
    String Glocation = "Paris";

    //commm
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_stats);
        winner_name= findViewById(R.id.winner_name);
        score_value = findViewById(R.id.score_value);
        match_duration = findViewById(R.id.match_duration);
        game_localisation = findViewById(R.id.game_localisation);

        winner_name.setText(wname);
        score_value.setText(svalue);
        match_duration.setText(mduration);
        game_localisation.setText(Glocation);

    }

    public void prevGames(View view) {
        Intent intent = new Intent(GameStats.this, PreviousGames.class);
        startActivity(intent);}

    public void backMenu(View view) {
        Intent intent = new Intent(GameStats.this, MainActivity.class);
        startActivity(intent);}




}
