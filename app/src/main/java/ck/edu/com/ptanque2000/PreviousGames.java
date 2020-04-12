package ck.edu.com.ptanque2000;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class PreviousGames extends AppCompatActivity {

    ListView list;

    String[] winner_name = new String[5];
    String[] score_value = new String [5];
    String[] id_match = new String[5];


    private DatabaseManager databaseManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previous_games);


        ///DECLARATION DU FICHIER DE RECUP
        List<String> names_recupere = new ArrayList<>();
        List<String> scores_recupere = new ArrayList<>();
        List<String> id_recupere = new ArrayList<>();

        ///OUVERTURE DE LA DATABASE
        databaseManager = new DatabaseManager(PreviousGames.this);

        ///RECUPERATION DES DONNEES
        names_recupere = databaseManager.recup_name1();
        scores_recupere = databaseManager.recup_score();
        id_recupere = databaseManager.recup_id_match();

        ///INCREMENTATION VIEW
        int nb_match =0;
        String match =null;
        nb_match = names_recupere.size();
        match=String.valueOf(nb_match);
        Log.i("DATABASE match ",match);

        for(int i = 0; i<nb_match;i++){
            winner_name[i]=names_recupere.get(i);
            score_value[i]=scores_recupere.get(i);
            id_match[i]=id_recupere.get(i);
        }


        MyListAdapter adapter = new MyListAdapter(this, winner_name, score_value,id_match);
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
