package ck.edu.com.ptanque2000;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class NewGame1 extends AppCompatActivity {


    private EditText joueur1;
    private EditText joueur2;
    private EditText nb_joueurs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game1);

        joueur1=findViewById(R.id.nameJ1);
        joueur2=findViewById(R.id.nameJ2);
        nb_joueurs=findViewById(R.id.numberJ);

        Button button_start = findViewById(R.id.btn_start);
        button_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(joueur1.getText().toString().equals("") || joueur2.getText().toString().equals("")){
                    Toast.makeText(NewGame1.this,"Entrez le nom des joueurs svp", Toast.LENGTH_SHORT).show();
                }
                else {
                    String data = joueur1.getText().toString();
                    String data2 = joueur2.getText().toString();

                    Intent intent2 = new Intent(NewGame1.this, NewGame11.class);
                    intent2.putExtra("p1",data);
                    intent2.putExtra("p2",data2);
                    startActivity(intent2);
                }

                }

        });
    }


}
