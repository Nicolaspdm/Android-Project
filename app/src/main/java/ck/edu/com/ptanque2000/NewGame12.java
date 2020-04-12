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

public class NewGame12 extends AppCompatActivity {

    private String player1;
    private String player2;
    private String lat;
    private String longi;
    private String indice;
    private String winner;
    private String score;
    private TextView joueur1;
    private TextView joueur2;
    private TextView j1_ns;
    private TextView j2_ns;
    private Switch switch_ns;
    private EditText score_ns;
    private TextView latitude;
    private TextView longitude;
    private Button ajout_set;

    ListView list_ng12;

    String[] winner_name_ng12 = null;

    String[] score_value_ng12 = null;



    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null){
            NewGame12.this.onRestoreInstanceState(savedInstanceState);
        }
        setContentView(R.layout.activity_new_game12);

        MyListAdapt_NG12 adapter_ng12 = new MyListAdapt_NG12(this, winner_name_ng12, score_value_ng12);
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

        Intent i = getIntent();
        indice=i.getStringExtra("indice");
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
                if(score_ns.getText().toString().equals("")){
                    Toast.makeText(NewGame12.this,"Entrez un score svp", Toast.LENGTH_SHORT).show();
                }
                

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
