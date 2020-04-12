package ck.edu.com.ptanque2000;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.EditText;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseManager extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "petanque.db";
    private static final int DATABASE_VERSION = 1;
    private SQLiteDatabase db;

    public DatabaseManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String  strSQL = "create table T_Game ("
                       + "   idGame integer primary key autoincrement,"
                       + " name text not null,"
                       + " score_looser text not null )";
        db.execSQL( strSQL );
        Log.i("DATABASE", "on create realised");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertScore (String nameJ1 , String numberJ ) {

        String strSQL = "insert into T_Game(name, score_looser) values ('"+ nameJ1 +"','" + numberJ + "')";
                      
        this.getWritableDatabase().execSQL( strSQL );
        Log.i("DATABASE", "Score integration");

    }

    public List<Game> read5names() {
        List<Game> games = new ArrayList<>();

        String strSQL = "SELECT * FROM T_Game order by idGame desc limit 5";

        Cursor curseur = this.getWritableDatabase().rawQuery(strSQL, null);
        curseur.moveToFirst();
        while (!curseur.isAfterLast()){
            Integer id = curseur.getInt(0);
            String J1 = curseur.getString(1);
            String J2 = "Matthieu";
            String scoreJ1 = curseur.getString(2);
            String scoreJ2 = "13";
            Game game = new Game (id, J1, J2, scoreJ1, scoreJ2);

            games.add(game);
            curseur.moveToNext();
            Log.i("DATABASE", "Read 5 Scores");
        }
        curseur.close();
        return games ;


    }


}

