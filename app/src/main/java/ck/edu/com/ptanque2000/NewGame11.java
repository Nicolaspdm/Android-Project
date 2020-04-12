package ck.edu.com.ptanque2000;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class NewGame11 extends AppCompatActivity {

        private TextView player1;
        private TextView player2;
    private TextView latitude;
    private TextView longitude;
        private Button next;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game11);
        player1= (TextView) findViewById(R.id.nom_joueur);
        player2 = (TextView) findViewById(R.id.nom_joueur2);
        next = (Button) findViewById(R.id.suivant);
        latitude = (TextView)findViewById(R.id.latitude_ng11);
        longitude = (TextView) findViewById(R.id.longitude_ng11);

        String nom=null;
        String nom2=null;
        String lat=null;
        String log=null;

        Intent i = getIntent();
        try{ nom =i.getStringExtra("p1");}catch (Error e){
            Toast.makeText(NewGame11.this, "player1 erreur", Toast.LENGTH_SHORT).show();}
        try{ nom2 =i.getStringExtra("p2");}catch (Error e){
            Toast.makeText(NewGame11.this, "player2 erreur", Toast.LENGTH_SHORT).show();}
        try{ lat =i.getStringExtra("latitude"); }catch (Error e){
            Toast.makeText(NewGame11.this, "latitude erreur", Toast.LENGTH_SHORT).show();}
        try{ log =i.getStringExtra("longitude");}catch (Error e){
            Toast.makeText(NewGame11.this, "longitude erreur", Toast.LENGTH_SHORT).show();}



        if(nom != null && nom2 != null){
            player1.setText(nom);
            player2.setText(nom2);
        }
        //else if (lat != null && log != null){
            latitude.setText(lat);
            longitude.setText(log);
        //}

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = player1.getText().toString();
                String data2 = player2.getText().toString();
                String datalt = latitude.getText().toString();
                String datalg = longitude.getText().toString();
                String indice = "NG11";

                Intent intent3 = new Intent(NewGame11.this,NewGame12.class);
                intent3.putExtra("indice",indice);
                intent3.putExtra("p1",data);
                intent3.putExtra("p2", data2);
                intent3.putExtra("latitude",datalt);
                intent3.putExtra("longitude",datalg);
                startActivity(intent3);

            }
        });

    }
}
