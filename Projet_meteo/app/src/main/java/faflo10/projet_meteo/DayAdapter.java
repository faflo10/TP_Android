package faflo10.projet_meteo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by faflo10 on 04/06/2015.
 */
public class DayAdapter extends BaseAdapter {
    private HashMap<String,Integer> hm;
    private LayoutInflater layoutInflater;
    private Context context;
    private String T[];
    private String C[];
    private String[] momentT;

    public DayAdapter(String[] t, String[] c, Context context) {
        super();
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        this.T = t;
        this.C = c;

        hm = new HashMap<>();
        hm.put("averse",R.drawable.averse);
        hm.put("averseneige",R.drawable.averseneige);
        hm.put("brouillard",R.drawable.brouillard);
        hm.put("brouillardgivrant",R.drawable.brouillardgivrant);
        hm.put("couvert",R.drawable.couvert);
        hm.put("lune",R.drawable.lune);
        hm.put("luneaverse",R.drawable.luneaverse);
        hm.put("luneaverseneige",R.drawable.luneaverseneige);
        hm.put("lunenuageux",R.drawable.lunenuageux);
        hm.put("lunevoile",R.drawable.lunevoile);
        hm.put("neifefaible",R.drawable.neifefaible);
        hm.put("neigeforte",R.drawable.neigeforte);
        hm.put("neigemoderer",R.drawable.neigemoderer);
        hm.put("nuageux",R.drawable.nuageux);
        hm.put("oragefort",R.drawable.oragefort);
        hm.put("orageloc",R.drawable.orageloc);
        hm.put("pluiefaible",R.drawable.pluiefaible);
        hm.put("pluieforte",R.drawable.pluieforte);
        hm.put("pluiemoderer",R.drawable.pluiemoderer);
        hm.put("soleil",R.drawable.soleil);
        hm.put("verglas",R.drawable.verglas);
        hm.put("voile",R.drawable.voile);

        momentT = new String[] {"Matin","Midi","Après-midi","Soirée"};
    }

    @Override
    public int getCount() {
        return T.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView= inflater.inflate(R.layout.detail_jour, null);

        TextView moment = (TextView)convertView.findViewById(R.id.moment);
        ImageView image = (ImageView)convertView.findViewById(R.id.image);
        TextView temp = (TextView)convertView.findViewById(R.id.temp);

        moment.setText(momentT[position]);

        if(C[position] != null) {
            image.setImageResource(hm.get(C[position]));
        }
        
        if(T[position] != null) {
            temp.setText("T : " + T[position] + "°C");
        } else {
            temp.setText("Pas de données");
        }

        return convertView;
    }
}
