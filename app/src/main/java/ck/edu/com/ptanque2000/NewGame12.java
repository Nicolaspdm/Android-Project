package ck.edu.com.ptanque2000;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class NewGame12 extends AppCompatActivity {

    private String player1;
    private String player2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game12);

        Intent i = getIntent();
        player1=i.getStringExtra("p1");
        player2=i.getStringExtra("p2");


    }
}
