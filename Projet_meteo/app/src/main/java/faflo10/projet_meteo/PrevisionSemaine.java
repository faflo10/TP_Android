package faflo10.projet_meteo;

import android.app.Activity;
import android.content.Context;
import android.widget.ListView;
import android.widget.TextView;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by faflo10 on 03/06/2015.
 */
public class PrevisionSemaine extends Activity {
    private ListView list;
    private TextView date;
    private TextView condition;
    private TextView ville;
    private ListElementAdapter adapter;
    private Context context;
    private String url_str;
    private URL url;
    private Task task;

    protected void onStart() {
        super.onStart();
        setContentView(R.layout.prevision_semaine);

        initComponents();

        try {
            url = new URL(url_str);
            task.execute(url,list,date,condition,context);
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
        task = new Task();

    }
}
