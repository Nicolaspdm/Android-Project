package ck.edu.com.ptanque2000;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
    private TextView latitude;
    private TextView longitude;
    private Button ajout_set;




    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null){
            NewGame12.this.onRestoreInstanceState(savedInstanceState);
        }
        setContentView(R.layout.activity_new_game12);

        joueur1 = (TextView) findViewById(R.id.joueur1_12);
        joueur2 = (TextView) findViewById(R.id.joueur2_12);
        longitude = (TextView) findViewById(R.id.longitude_ng12);
        latitude = (TextView) findViewById(R.id.latitude_ng12);

        Intent i = getIntent();
        indice=i.getStringExtra("indice");
        player1=i.getStringExtra("p1");
        player2=i.getStringExtra("p2");
        lat=i.getStringExtra("latitude");
        longi=i.getStringExtra("longitude");
        //winner=i.getStringExtra("winner");


    /*if(savedInstanceState != null){

        ///RECUPERATION DES STATES
        player1 = savedInstanceState.getString("J1");
        player2 = savedInstanceState.getString("J2");
        lat = savedInstanceState.getString("latitude");
        longi = savedInstanceState.getString("longitude");
    }*/

            joueur1.setText(player1);
            joueur2.setText(player2);
            longitude.setText(longi);
            latitude.setText(lat);


        /// BTN AJOUT SET
        ajout_set = findViewById(R.id.add_set);
        ajout_set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = player1;
                String data2 = player2;

                ///SAVE STATE
               /* if(player1!=null && player2 != null && lat != null && longi != null) {
                    savedInstanceState.putString("J1", player1);
                    savedInstanceState.putString("J2", player2);
                    savedInstanceState.putString("latitude", lat);
                    savedInstanceState.putString("longitude", longi);
                }*/
                ///INTENT NEW SET
               // NewGame12.this.onSaveInstanceState(savedInstanceState);
                Intent intent4 = new Intent(NewGame12.this,NewSet.class);
                intent4.putExtra("p1", data);
                intent4.putExtra("p2",data2);
                startActivity(intent4);
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
