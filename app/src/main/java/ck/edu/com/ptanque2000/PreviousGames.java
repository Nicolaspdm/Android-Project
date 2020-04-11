package ck.edu.com.ptanque2000;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


public class PreviousGames extends AppCompatActivity {

    ListView list;

    String[] winner_name = {
            "Arnaud", "Henri", "Jade",
            "Seb", "Nico",
    };

    String[] score_value ={
            "10", "12", "5",
            "7", "0",
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previous_games);


        MyListAdapter adapter = new MyListAdapter(this, winner_name, score_value);
        list = findViewById(R.id.list);
        list.setAdapter(adapter);
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(PreviousGames.this, MainActivity.class);
        startActivity(intent);}

    public void displayGameStats(View view) {
        Intent intent = new Intent(PreviousGames.this, GameStats.class);
        startActivity(intent);}

}
