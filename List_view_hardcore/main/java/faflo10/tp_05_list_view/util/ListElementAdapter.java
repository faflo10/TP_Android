package faflo10.tp_05_list_view.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import faflo10.tp_05_list_view.R;

/**
 * Created by p1405890 on 27/05/2015.
 */
public class ListElementAdapter extends BaseAdapter {

    int[] images;
    String[] data;
    Context context;
    LayoutInflater layoutInflater;


    public ListElementAdapter(String[] data, int[] images, Context context) {
        super();
        this.images = images;
        this.data = data;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {

        return data.length;
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
        convertView= inflater.inflate(R.layout.liste_layout, null);

        TextView txt=(TextView)convertView.findViewById(R.id.album);
        ImageView img = (ImageView)convertView.findViewById(R.id.pochette);

        img.setImageResource(images[position]);
        txt.setText(data[position]);



        return convertView;
    }

}