package ck.edu.com.ptanque2000;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

=======
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn_NewGame ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_NewGame = (Button) findViewById(R.id.btn_NewGame);
        btn_NewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewGam();
            }
        });

    }

    private void openNewGam (){
        Intent intent = new Intent(this,NewGame1.class);
        startActivity(intent);
    }


    public void sendMessage(View view) {
        Intent intent = new Intent(MainActivity.this, PreviousGames.class);
        startActivity(intent);
    }
}
