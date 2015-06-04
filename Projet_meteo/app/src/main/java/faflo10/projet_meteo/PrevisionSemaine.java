package faflo10.projet_meteo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import static android.support.v4.app.ActivityCompat.startActivity;

/**
 * Created by faflo10 on 03/06/2015.
 */
public class PrevisionSemaine extends Activity{
    private ListView list;
    private TextView date;
    private TextView condition;
    private TextView ville;
    private ListElementAdapter adapter;
    private Context context;
    private String url_str;
    private URL url;
    private Task task;
    private ArrayList<Meteo> prev;

    protected void onStart() {
        super.onStart();
        setContentView(R.layout.prevision_semaine);

        initComponents();

        try {
            url = new URL(url_str);
            task.execute(url,list,date,condition,context);
            initListListener();
        } catch(MalformedURLException e) {
            e.getMessage();
        }
    }

    public void initComponents() {
        list = (ListView) findViewById(R.id.list);
        date = (TextView)findViewById(R.id.date);
        condition = (TextView)findViewById(R.id.prevision);
        ville = (TextView) findViewById(R.id.ville);
        context = this;
        url_str = getIntent().getStringExtra("url");
        ville.setText(url_str);
        url_str = "http://api.meteorologic.net/forecarss?p="+url_str;
        task = new Task(new OnTaskComplete() {
            @Override
            public void onTaskComplete(Object o) {
                prev = (ArrayList<Meteo>) o;
            }
        });
    }

    public void initListListener() {
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent zoom = new Intent(context,ZoomJour.class);
                zoom.putExtra("day",prev.get(position).getDate());
                zoom.putExtra("t",prev.get(position).getT());
                zoom.putExtra("xml",prev.get(position).getXML());
                startActivity(zoom);
            }
        });
    }
}
