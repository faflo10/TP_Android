package faflo10.projet_meteo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by faflo10 on 03/06/2015.
 */
public class ListElementAdapter extends BaseAdapter {
    ArrayList<Meteo> met;
    Context context;
    LayoutInflater layoutInflater;


    public ListElementAdapter(ArrayList<Meteo> met, Context context) {
        super();
        this.met = met;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return met.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView= inflater.inflate(R.layout.custom_list, null);

        TextView date = (TextView)convertView.findViewById(R.id.date);
        TextView condition = (TextView)convertView.findViewById(R.id.prevision);

        date.setText(met.get(position).getDate());
        condition.setText("Matin : " + met.get(position).getC()[0] +
                " Température : " + met.get(position).getT()[0] + "\n" +
                "Midi : " + met.get(position).getC()[1] +
                " Température : " + met.get(position).getT()[1] + "\n" +
                "Après-midi : " + met.get(position).getC()[2] +
                " Température : " + met.get(position).getT()[2] + "\n" +
                "Soir : " + met.get(position).getC()[3] +
                " Température : " + met.get(position).getT()[3] + "\n");
        /*TextView txt=(TextView)convertView.findViewById(R.id.album);
        ImageView img = (ImageView)convertView.findViewById(R.id.pochette);
        img.setImageResource(images[position]);
        txt.setText(data[position]);*/



        return convertView;
    }
}