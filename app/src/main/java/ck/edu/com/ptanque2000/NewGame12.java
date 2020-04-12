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

        Toast.makeText(NewGame12.this,"score j2 "+String.valueOf(joueur2_score)+" et score j1"+String.valueOf(joueur1_score),Toast.LENGTH_SHORT).show();

        if(joueur2_score >=13){
            Toast.makeText(NewGame12.this,"Le joueur "+ player2+ " a remporter le match! ", Toast.LENGTH_SHORT).show();
        }
        else if (joueur1_score >=13){
            Toast.makeText(NewGame12.this,"Le joueur "+ player1+ " a remporter le match! ", Toast.LENGTH_SHORT).show();
        }

        /// BTN AJOUT SET
        ajout_set = findViewById(R.id.add_set);
        ajout_set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(score_ns.getText().toString().equals("")){
                    Toast.makeText(NewGame12.this,"Entrez un score svp", Toast.LENGTH_SHORT).show();
                }

                String return_i = null;
                String return_score=null;
                int ancin_score=0;
                String ancien_j1;
                String ancien_j2;
                int retour_score=0;
                int score_fait=0;
                int it = Integer.parseInt(numero_set.getText().toString());
                //nvx score
                score_fait=Integer.parseInt(score_ns.getText().toString());

                //set score

                    score_value_ng12[it]=score_ns.getText().toString();

                if(switch_ns.isChecked()){

                    winner_name_ng12[it]=j2_ns.getText().toString();
                    ancien_j2=score_j2.getText().toString();
                    ancin_score = Integer.parseInt(ancien_j2);
                    retour_score=score_fait+ancin_score;
                }
                else if(!switch_ns.isChecked()) {
                    winner_name_ng12[it]=j1_ns.getText().toString();
                    ancien_j1 =score_j1.getText().toString();
                    ancin_score = Integer.parseInt(ancien_j1);
                    retour_score=score_fait+ancin_score;
                }
                it++;

                return_i=String.valueOf(it);
                numero_set.setText(return_i);

                if(switch_ns.isChecked()){
                    score_j2.setText(String.valueOf(retour_score));
                }
                else if (!switch_ns.isChecked()){
                    score_j1.setText(String.valueOf(retour_score));
                }
                list_ng12.setAdapter(adapter_ng12);

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
