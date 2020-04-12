package ck.edu.com.ptanque2000;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DatabaseManager extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Petanque.db";
    private static final int DATABASE_VERSION = 1 ;

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
}
