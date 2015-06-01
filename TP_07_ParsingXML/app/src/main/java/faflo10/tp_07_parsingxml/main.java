package faflo10.tp_07_parsingxml;

import faflo10.tp_07_parsingxml.util.SystemUiHider;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class main extends Activity {
    private Task task;
    private ArrayList<Meteo> prev;
    private ListElementAdapter adapt;
    private ListView list;
    private TextView date;
    private TextView condition;
    private Button go;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
    }

    protected void onStart() {
        super.onStart();
        setContentView(R.layout.activity_main);

        list = (ListView)findViewById(R.id.list);
        date = (TextView) findViewById(R.id.date);
        condition = (TextView) findViewById(R.id.prevision);
        go = (Button)findViewById(R.id.go);
        final Context context = this;

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Toast.makeText(getApplicationContext(),"Coucou",Toast.LENGTH_SHORT).show();
                    task = new Task();
                    URL rssUrl = new URL("http://api.meteorologic.net/forecarss?p=Bourg-en-Bresse");
                    task.execute(rssUrl,list,date,condition,context);

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
