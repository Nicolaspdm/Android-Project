package ck.edu.com.ptanque2000;

import android.app.Activity;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] winner_name;
    private final String[] score_value;
    private final String[] id_match;

    public MyListAdapter (Activity context, String[] winner_name, String[] score_value, String[] id_match){
        super(context, R.layout.customlistview, winner_name);

        this.context = context ;
        this.winner_name = winner_name;
        this.score_value = score_value;
        this.id_match = id_match;

    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.customlistview, null,true);

        TextView winnerText = rowView.findViewById(R.id.winner_name);
        TextView scoreText = rowView.findViewById(R.id.score_value);
        TextView match = rowView.findViewById(R.id.id_match);

        winnerText.setText(winner_name[position]);
        scoreText.setText(score_value[position]);
        match.setText(id_match[position]);

        return rowView ;

    }

}
