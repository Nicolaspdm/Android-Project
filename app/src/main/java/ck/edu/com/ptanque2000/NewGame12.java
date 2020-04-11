package ck.edu.com.ptanque2000;

import androidx.appcompat.app.AppCompatActivity;

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game12);

        Intent i = getIntent();
        try{indice=i.getStringExtra("indice");}catch (Error e){Toast.makeText(NewGame12.this, "indice erreur", Toast.LENGTH_SHORT).show();}

        //si intent vient de NG11 alors on récupère les bonnes données
        //if(indice=="NG11"){
            try{player1=i.getStringExtra("p1");}catch (Error e){Toast.makeText(NewGame12.this, "player1 erreur", Toast.LENGTH_SHORT).show();}
            try{player2=i.getStringExtra("p2");}catch (Error e){Toast.makeText(NewGame12.this, "player2 erreur", Toast.LENGTH_SHORT).show();}
            try{lat=i.getStringExtra("latitude");}catch (Error e){Toast.makeText(NewGame12.this, "latitude erreur", Toast.LENGTH_SHORT).show();}
            try{longi=i.getStringExtra("longitude");}catch (Error e){Toast.makeText(NewGame12.this, "longueur erreur", Toast.LENGTH_SHORT).show();}
       // }
       // else if (indice=="NS"){
            try{winner=i.getStringExtra("winner");}catch (Error e){Toast.makeText(NewGame12.this, "winner erreur", Toast.LENGTH_SHORT).show();}
            try{score=i.getStringExtra("score");}catch (Error e){Toast.makeText(NewGame12.this, "score erreur", Toast.LENGTH_SHORT).show();}

        //}

        joueur1 = (TextView) findViewById(R.id.joueur1_12);
        joueur2 = (TextView) findViewById(R.id.joueur2_12);
        longitude = (TextView) findViewById(R.id.longitude_ng12);
        latitude = (TextView) findViewById(R.id.latitude_ng12);

        joueur1.setText(player1);
        joueur2.setText(player2);
        longitude.setText(longi);
        latitude.setText(lat);

        ajout_set = findViewById(R.id.add_set);
        ajout_set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = player1;
                String data2 = player2;

                Intent intent4 = new Intent(NewGame12.this,NewSet.class);
                intent4.putExtra("p1", data);
                intent4.putExtra("p2",data2);
                startActivity(intent4);
            }
        });



    }

}
