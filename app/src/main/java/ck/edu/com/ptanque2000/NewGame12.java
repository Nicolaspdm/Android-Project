package ck.edu.com.ptanque2000;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class NewGame12 extends AppCompatActivity {

    private String player1;
    private String player2;
    private String lat;
    private String longi;
    private TextView joueur1;
    private TextView joueur2;
    private TextView j1_ns;
    private TextView j2_ns;
    private Switch switch_ns;
    private EditText score_ns;
    private TextView latitude;
    private TextView longitude;
    private Button ajout_set;
    private TextView numero_set;
    private TextView score_j1;
    private TextView score_j2;
    private Button btn_finir;
    private DatabaseManager databaseManager;


    ListView list_ng12;
    String[] winner_name_ng12 = new String [10];
    String[] score_value_ng12 = new String[10];

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null){
            NewGame12.this.onRestoreInstanceState(savedInstanceState);
        }
        setContentView(R.layout.activity_new_game12);

        int joueur1_score=0;
        int joueur2_score=0;

        final MyListAdapt_NG12 adapter_ng12 = new MyListAdapt_NG12(this, winner_name_ng12, score_value_ng12);
        list_ng12 = findViewById(R.id.list_ng12);
        list_ng12.setAdapter(adapter_ng12);

        joueur1 = (TextView) findViewById(R.id.joueur1_12);
        j1_ns = (TextView)findViewById(R.id.ns_j1);
        j2_ns = (TextView) findViewById(R.id.ns_j2);
        switch_ns = (Switch) findViewById(R.id.ns_swich);
        joueur2 = (TextView) findViewById(R.id.joueur2_12);
        longitude = (TextView) findViewById(R.id.longitude_ng12);
        latitude = (TextView) findViewById(R.id.latitude_ng12);
        score_ns = (EditText) findViewById(R.id.nvx_score);
        numero_set = (TextView)findViewById(R.id.numero_set);
        score_j1 = (TextView) findViewById(R.id.score_j1);
        score_j2 = (TextView) findViewById(R.id.score_j2);
        btn_finir=(Button) findViewById(R.id.btn_fin);



        Intent i = getIntent();
        player1=i.getStringExtra("p1");
        player2=i.getStringExtra("p2");
        lat=i.getStringExtra("latitude");
        longi=i.getStringExtra("longitude");

            joueur1.setText(player1);
            joueur2.setText(player2);
            j1_ns.setText(player1);
            j2_ns.setText(player2);
            longitude.setText(longi);
            latitude.setText(lat);

        /// BTN AJOUT SET
        ajout_set = findViewById(R.id.add_set);
        ajout_set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (score_ns.getText().toString().equals("")) {
                    Toast.makeText(NewGame12.this, "Entrez un score svp", Toast.LENGTH_SHORT).show();
                } else {

                    String return_i = null;
                    String return_score = null;
                    int ancin_score = 0;
                    String ancien_j1;
                    String ancien_j2;
                    int retour_score = 0;
                    int score_fait = 0;
                    int it = Integer.parseInt(numero_set.getText().toString());
                    //nvx score
                    score_fait = Integer.parseInt(score_ns.getText().toString());

                    //set score

                    score_value_ng12[it] = score_ns.getText().toString();

                    if (switch_ns.isChecked()) {

                        winner_name_ng12[it] = j2_ns.getText().toString();
                        ancien_j2 = score_j2.getText().toString();
                        ancin_score = Integer.parseInt(ancien_j2);
                        retour_score = score_fait + ancin_score;
                    } else if (!switch_ns.isChecked()) {
                        winner_name_ng12[it] = j1_ns.getText().toString();
                        ancien_j1 = score_j1.getText().toString();
                        ancin_score = Integer.parseInt(ancien_j1);
                        retour_score = score_fait + ancin_score;
                    }
                    it++;

                    return_i = String.valueOf(it);
                    numero_set.setText(return_i);

                    if (switch_ns.isChecked()) {
                        score_j2.setText(String.valueOf(retour_score));
                    } else if (!switch_ns.isChecked()) {
                        score_j1.setText(String.valueOf(retour_score));
                    }
                    list_ng12.setAdapter(adapter_ng12);

                }
            }
        });

        btn_finir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nom_j1=null;
                String nom_j2=null;
                String score_jo2=null;
                String score_jo1=null;
                String latit=null;
                String longit=null;

                nom_j1=joueur1.getText().toString();
                nom_j2=joueur2.getText().toString();
                score_jo2=score_j2.getText().toString();
                score_jo1=score_j1.getText().toString();
                latit=latitude.getText().toString();
                longit=longitude.getText().toString();

                databaseManager = new DatabaseManager(NewGame12.this);
                if (Integer.parseInt(score_jo1)>Integer.parseInt(score_jo2)){
                    databaseManager.insertScore(nom_j1,nom_j2,score_jo1,score_jo2,latit,longit);
                }
                else if(Integer.parseInt(score_jo2)>Integer.parseInt(score_jo1)){
                    databaseManager.insertScore(nom_j2,nom_j1,score_jo2,score_jo1,latit,longit);
                }
                else{
                    databaseManager.insertScore("egalité",nom_j1,score_jo1,score_jo2,latit,longit);
                }
                databaseManager.close();

                Intent intent5 = new Intent(NewGame12.this,PreviousGames.class);
                startActivity(intent5);

            }
        });






    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("J1", player1);
        savedInstanceState.putString("J2", player2);
        savedInstanceState.putString("latitude", lat);
        savedInstanceState.putString("longitude", longi);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        player1 = savedInstanceState.getString("J1");
        joueur1.setText(player1);
        player2 = savedInstanceState.getString("J2");
        joueur2.setText(player2);
        lat = savedInstanceState.getString("latitude");
        latitude.setText(lat);
        longi = savedInstanceState.getString("longitude");
        longitude.setText(longi);

    }


}
