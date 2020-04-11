package ck.edu.com.ptanque2000;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class NewSet extends AppCompatActivity {

    private String player1;
    private String player2;
    private TextView joueur1;
    private TextView joueur2;
    private Button newset_btn;
    private EditText newset_cb;
    private Switch newset_switch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_set);

        newset_btn = findViewById(R.id.ns_btn);
        newset_cb =findViewById(R.id.ns_cb);
        newset_switch=findViewById(R.id.ns_swich);
        joueur1=findViewById(R.id.ns_j1);
        joueur2=findViewById(R.id.ns_j2);

        Intent i = getIntent();
        player1=i.getStringExtra("p1");
        player2=i.getStringExtra("p2");

        joueur1.setText(player1);
        joueur2.setText(player2);

        newset_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(newset_cb.getText().toString().equals("")){
                    Toast.makeText(NewSet.this,"Vous devez entrer un nombre de point",Toast.LENGTH_SHORT).show();
                } else {
                    //Recupération des variables
                    String data = player1;
                    String data2 = player2;
                    String indice = "NS"
                    int score = Integer.parseInt(newset_cb.getText().toString());
                    String winner = null;

                    if(newset_switch.isChecked()){
                        winner=player2;
                    } else {
                        winner=player1;
                    }

                    //Création de l'intent
                    Intent intent5= new Intent(NewSet.this,NewGame12.class);
                    intent5.putExtra("indice",indice);
                    intent5.putExtra("winner", winner);
                    intent5.putExtra("score", score);
                    Toast.makeText(NewSet.this,"j1:"+data+"j2:"+data2+"win:"+winner+"score:"+score+"indice : "+indice,Toast.LENGTH_SHORT).show();
                    startActivity(intent5);
                }
            }
        });

    }
}
