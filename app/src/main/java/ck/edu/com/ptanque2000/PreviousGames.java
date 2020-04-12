package ck.edu.com.ptanque2000;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class PreviousGames extends AppCompatActivity {

    ListView list;

    String[] winner_name = new String[4];
    String[] score_value = new String [4];


    private DatabaseManager databaseManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previous_games);

        int nb_march =2;
        nb_march++;
        ///DECLARATION DU FICHIER DE RECUP
        List<String> names_recupere = new ArrayList<>();
        List<String> names2_recupere = new ArrayList<>();

        ///OUVERTURE DE LA DATABASE
        databaseManager = new DatabaseManager(PreviousGames.this);

        ///RECUPERATION DES DONNEES
        names_recupere = databaseManager.recup_name1();

        ///INCREMENTATION VIEW
        for(int i = 0; i<nb_march;i++){
            winner_name[i]=names_recupere.get(i);
        }


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
