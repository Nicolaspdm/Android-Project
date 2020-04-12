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
    private TextView latitude_GS;
    private TextView longitude_GS;
    private TextView adversaire_GS;
    private TextView score_adver_GS;
    private TextView numero_match;
    private DatabaseManager databaseManager;
    private String id_detail;


    String wname = null;
    String svalue = null;
    String latitude = null;
    String longitude = null;
    String adversaire = null;
    String score_adveresaire = null;
    String id_det = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_stats);

        numero_match = findViewById(R.id.numero_match);
        winner_name= findViewById(R.id.winner_name);
        score_value = findViewById(R.id.score_value);
        latitude_GS = findViewById(R.id.game_latitude);
        longitude_GS = findViewById(R.id.game_longitude);
        adversaire_GS = findViewById(R.id.adversaire_GS);
        score_adver_GS = findViewById(R.id.score_adversaire);

       Intent intent = getIntent();
       wname = intent.getStringExtra("winner");
       svalue = intent.getStringExtra("score_w");
       adversaire = intent.getStringExtra("adversaire");
       score_adveresaire = intent.getStringExtra("score_ad");
       latitude = intent.getStringExtra("latitude");
       longitude = intent.getStringExtra("longitude");
       id_det = intent.getStringExtra("id");


        numero_match.setText(id_det);
        winner_name.setText(wname);
        score_value.setText(svalue);
        latitude_GS.setText(latitude);
        longitude_GS.setText(longitude);
        adversaire_GS.setText(adversaire);
        score_adver_GS.setText(score_adveresaire);

    }

    public void prevGames(View view) {
        Intent intent = new Intent(GameStats.this, PreviousGames.class);
        startActivity(intent);}

    public void backMenu(View view) {
        Intent intent = new Intent(GameStats.this, MainActivity.class);
        startActivity(intent);}




}
