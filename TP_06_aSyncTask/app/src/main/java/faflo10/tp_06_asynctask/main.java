package faflo10.tp_06_asynctask;

import faflo10.tp_06_asynctask.util.SystemUiHider;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class main extends Activity {
    private Button google;
    private Button html;
    private Button heure;
    private Button raw;
    private Button meteo;
    private TextView text;
    private WebView web;
    private Task task;
    private Task_weather task_weather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
    }

    protected void onStart() {
        super.onStart();
        setContentView(R.layout.activity_main);

        initComponents();
    }

    public void initComponents() {
        google = (Button) findViewById(R.id.google);
        html = (Button) findViewById(R.id.html);
        heure = (Button) findViewById(R.id.heure);
        raw = (Button) findViewById(R.id.raw);
        meteo = (Button) findViewById(R.id.meteo);
        text = (TextView) findViewById(R.id.text);
        web = (WebView) findViewById(R.id.web);

        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                web.loadUrl("http://www.google.fr/");
            }
        });

        html.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String req = "<html><body><b>Ceci est un texte HTML</b><br>qui s'affiche" +
                        " simplement.</body></html>";
                web.loadData(req,"text/html; charset=utf-8", "UTF-8");
            }
        });

        web.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

        heure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    task = new Task();
                    URL url = new URL("http://www.timeapi.org/utc/now");
                    task.execute(url, text);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        });

        raw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                web.loadUrl("http://api.meteorologic.net/forecarss?p=Lyon");
            }
        });

        meteo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    task_weather = new Task_weather();
                    URL url = new URL("http://api.meteorologic.net/forecarss?p=Lyon");
                    task_weather.execute(url,web);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch(NullPointerException e) {
                    System.out.println("Pas bon pointeur");
                }
            }
        });
    }
}
