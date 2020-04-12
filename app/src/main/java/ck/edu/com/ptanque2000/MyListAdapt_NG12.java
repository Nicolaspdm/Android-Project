package ck.edu.com.ptanque2000;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class MyListAdapt_NG12 extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] vainqueur;
    private final String[] score ;

    public MyListAdapt_NG12(Activity context, String[] vainqueur, String[] score){
        super(context, R.layout.custom_listview_ng12, vainqueur);

        this.context = context ;
        this.vainqueur = vainqueur;
        this.score = score;

    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.custom_listview_ng12, null,true);

        TextView winnerText = rowView.findViewById(R.id.vainqueur_nom);
        TextView scoreText = rowView.findViewById(R.id.score_nb);

        winnerText.setText(vainqueur[position]);
        scoreText.setText(score[position]);

        return rowView ;

    }


}
