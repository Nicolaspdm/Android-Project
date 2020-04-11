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
import androidx.core.app.ActivityCompat;


public class NewGame1 extends AppCompatActivity implements LocationListener {


    private EditText joueur1;
    private EditText joueur2;
    private EditText nb_joueurs;
    private TextView latitude;
    private TextView longitude;
    private String provider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game1);

        joueur1 = findViewById(R.id.nameJ1);
        joueur2 = findViewById(R.id.nameJ2);
        nb_joueurs = findViewById(R.id.numberJ);
        latitude = findViewById(R.id.lati_ng1);
        longitude = findViewById(R.id.longi_ng1);

        LocationManager locationManager = null;
        locationManager = (LocationManager) getSystemService(NewGame1.this.LOCATION_SERVICE);

        Criteria criteria = new Criteria();
        criteria.setAccuracy(Criteria.ACCURACY_COARSE);


        provider = locationManager.getBestProvider(criteria, false);

        if (provider == null) {
            latitude.setText("Provider null");
        } else {

            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            Location location = locationManager.getLastKnownLocation(provider);


            if (location != null) {
                System.out.println("Provider : " + provider + "nous a permis d'avoir la localisation");
                double lat = 0;
                double longi = 0;
                lat = location.getLatitude();
                longi = location.getLongitude();

                String lati_str = String.valueOf(lat);
                String longi_str = String.valueOf(longi);

                latitude.setText(lati_str);
                longitude.setText(longi_str);
            } else {
                latitude.setText("Acces refuse");
                longitude.setText("Acces refuse");
            }

        }


            Button button_start = findViewById(R.id.btn_start);
        button_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(joueur1.getText().toString().equals("") || joueur2.getText().toString().equals("")){
                    Toast.makeText(NewGame1.this,"Entrez le nom des joueurs svp", Toast.LENGTH_SHORT).show();
                }
                else if( (latitude.getText().toString().equals("Provider null")||latitude.getText().toString().equals("Acces refuse"))&&longitude.getText().toString().equals("Acces refuse")){
                    Toast.makeText(NewGame1.this,"Pas de localisation lat :" +latitude.getText().toString()+"Long : "+longitude.getText().toString(),Toast.LENGTH_SHORT).show();
                }
                else {
                    String data = joueur1.getText().toString();
                    String data2 = joueur2.getText().toString();
                    String latitude_ng1 =latitude.getText().toString();
                    String longitude_ng1 = longitude.getText().toString();

                    Intent intent2 = new Intent(NewGame1.this, NewGame11.class);
                    intent2.putExtra("p1",data);
                    intent2.putExtra("p2",data2);
                    intent2.putExtra("latitude",latitude_ng1);
                    intent2.putExtra("longitude",longitude_ng1);
                    startActivity(intent2);
                }

                
                }

        });
    }


    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
