package ck.edu.com.ptanque2000;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class NewGame11 extends AppCompatActivity {

        private TextView player1;
        private TextView player2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game11);
        player1= (TextView) findViewById(R.id.nom_joueur);
        player2 = (TextView) findViewById(R.id.nom_joueur2);

        Intent i = getIntent();
        String nom = i.getStringExtra("p1");
        String nom2 = i.getStringExtra("p2");

        if(nom != null && nom2 != null){
            player1.setText(nom);
            player2.setText(nom2);
        }

    }
}
