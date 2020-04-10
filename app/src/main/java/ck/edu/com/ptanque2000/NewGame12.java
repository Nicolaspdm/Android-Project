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
    private TextView joueur1;
    private TextView joueur2;
    private Button ajout_set;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game12);

        Intent i = getIntent();
        try{player1=i.getStringExtra("p1");}catch (Error e){Toast.makeText(NewGame12.this, "player1 erreur", Toast.LENGTH_SHORT).show();}
        try{player2=i.getStringExtra("p2");}catch (Error e){Toast.makeText(NewGame12.this, "player2 erreur", Toast.LENGTH_SHORT).show();}
        //player2=i.getStringExtra("p2");

        joueur1 = (TextView) findViewById(R.id.joueur1_12);
        joueur2 = (TextView) findViewById(R.id.joueur2_12);

        joueur1.setText(player1);
        joueur2.setText(player2);

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
