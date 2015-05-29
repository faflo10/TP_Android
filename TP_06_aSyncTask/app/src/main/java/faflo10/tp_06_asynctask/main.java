package faflo10.tp_06_asynctask;

import faflo10.tp_06_asynctask.util.SystemUiHider;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class main extends Activity {
    private Button google;
    private Button html;
    private WebView web;

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
    }
}
