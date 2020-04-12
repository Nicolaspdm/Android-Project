package ck.edu.com.ptanque2000;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseManager extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Petanque.db";
    private static final int DATABASE_VERSION =1 ;

    public DatabaseManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String strSQl = "create table T_Match ("
                + " idMatch integer primary key autoincrement,"
                + " name1 text not null,"
                + " name2 text not null,"
                + " score1 text not null,"
                + " score2 text not null,"
                + " lat text not null,"
                + " lon text not null)";
        db.execSQL( strSQl );
        Log.i("DATABASE", "Table created");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertScore (String name1, String name2, String score1, String score2, String lat, String lon){
        String strSQL = "insert into T_Match (name1, name2, score1, score2, lat, lon) values"
                + "('"+name1+"', '"+name2+"', '"+score1+"', '"+score2+"','"+lat+"', '"+lon+"')";
        this.getWritableDatabase().execSQL(strSQL);
        Log.i("DATABASE", "Database insered" );
    }

    public List<String> recup_name1 (){
        List<String> names_j1 = new ArrayList<>();

        String strSQL_name1 = "SELECT name1 FROM T_Match order by idMatch DESC limit 5";
        Cursor curseur = this.getReadableDatabase().rawQuery(strSQL_name1,null);
        curseur.moveToFirst();
        //int i= 0;
        while (!curseur.isAfterLast()){

            String string = curseur.getString(0);
            names_j1.add(string);
            curseur.moveToNext();
            //i++;
            Log.i("DATABASE","on a recup noms1");
        }

        return names_j1;
    }

    public List<String> recup_score (){
        List<String> scores = new ArrayList<>();

        String strSQL_score = "SELECT score2 FROM T_Match order by idMatch DESC limit 5";
        Cursor curseur = this.getReadableDatabase().rawQuery(strSQL_score,null);
        curseur.moveToFirst();
        //int i= 0;
        while (!curseur.isAfterLast()){

            String string = curseur.getString(0);
            scores.add(string);
            curseur.moveToNext();
            //i++;
            Log.i("DATABASE","on a recup les scores");
        }

        return scores;
    }

    public List<String> recup_id_match (){
        List<String> id = new ArrayList<>();

        String strSQL_id = "SELECT idMatch FROM T_Match order by idMatch DESC limit 5";
        Cursor curseur = this.getReadableDatabase().rawQuery(strSQL_id,null);
        curseur.moveToFirst();
        //int i= 0;
        while (!curseur.isAfterLast()){

            String string = curseur.getString(0);
            id.add(string);
            curseur.moveToNext();
            //i++;
            Log.i("DATABASE","on a recup les id");
        }

        return id;
    }

    public String recup_winner_byid (String id_str){
        String winner = null;


        String strSQL_winner = "SELECT name1 FROM T_Match WHERE idMatch="+id_str;
        Cursor curseur = this.getReadableDatabase().rawQuery(strSQL_winner,null);
        curseur.moveToFirst();
        //int i= 0;
        while (!curseur.isAfterLast()){

            String string = curseur.getString(0);
            id_str = string ;
            curseur.moveToNext();
            //i++;
            Log.i("DATABASE","on a recup les id");
        }

        return id_str;
    }

    public String recup_adver_byid (String id_str){
        String adversaire = null;


        String strSQL_adv = "SELECT name2 FROM T_Match WHERE idMatch="+id_str;
        Cursor curseur = this.getReadableDatabase().rawQuery(strSQL_adv,null);
        curseur.moveToFirst();
        //int i= 0;
        while (!curseur.isAfterLast()){

            String string = curseur.getString(0);
            adversaire = string ;
            curseur.moveToNext();
            //i++;
            Log.i("DATABASE","on a recup les id");
        }

        return adversaire;
    }

    public String recup_score_byid (String id_str){
        String score = null;


        String strSQL_score = "SELECT score1 FROM T_Match WHERE idMatch="+id_str;
        Cursor curseur = this.getReadableDatabase().rawQuery(strSQL_score,null);
        curseur.moveToFirst();
        //int i= 0;
        while (!curseur.isAfterLast()){

            String string = curseur.getString(0);
            score = string ;
            curseur.moveToNext();
            //i++;
            Log.i("DATABASE","on a recup les id");
        }

        return score;
    }

    public String recup_scoread_byid (String id_str){
        String score = null;


        String strSQL_score = "SELECT score2 FROM T_Match WHERE idMatch="+id_str;
        Cursor curseur = this.getReadableDatabase().rawQuery(strSQL_score,null);
        curseur.moveToFirst();
        //int i= 0;
        while (!curseur.isAfterLast()){

            String string = curseur.getString(0);
            score = string ;
            curseur.moveToNext();
            //i++;
            Log.i("DATABASE","on a recup les id");
        }

        return score;
    }

    public String recup_latitude_byid (String id_str){
        String latitude = null;


        String strSQL_score = "SELECT lat FROM T_Match WHERE idMatch="+id_str;
        Cursor curseur = this.getReadableDatabase().rawQuery(strSQL_score,null);
        curseur.moveToFirst();
        //int i= 0;
        while (!curseur.isAfterLast()){

            String string = curseur.getString(0);
            latitude = string ;
            curseur.moveToNext();
            //i++;
            Log.i("DATABASE","on a recup les id");
        }

        return latitude;
    }

    public String recup_longitude_byid (String id_str){
        String longitude = null;


        String strSQL_score = "SELECT lon FROM T_Match WHERE idMatch="+id_str;
        Cursor curseur = this.getReadableDatabase().rawQuery(strSQL_score,null);
        curseur.moveToFirst();
        //int i= 0;
        while (!curseur.isAfterLast()){

            String string = curseur.getString(0);
            longitude = string ;
            curseur.moveToNext();
            //i++;
            Log.i("DATABASE","on a recup les id");
        }

        return longitude;
    }


}
