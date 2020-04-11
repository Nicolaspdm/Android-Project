package ck.edu.com.ptanque2000;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;


import androidx.appcompat.app.AppCompatActivity;


public class NewGame1 extends AppCompatActivity implements LocationListener {


    private EditText joueur1;
    private EditText joueur2;
    private EditText nb_joueurs;
    private TextView latitude;
    private TextView longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game1);

        joueur1=findViewById(R.id.nameJ1);
        joueur2=findViewById(R.id.nameJ2);
        nb_joueurs=findViewById(R.id.numberJ);
        latitude=findViewById(R.id.lati_ng1);
        longitude=findViewById(R.id.longi_ng1);

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
