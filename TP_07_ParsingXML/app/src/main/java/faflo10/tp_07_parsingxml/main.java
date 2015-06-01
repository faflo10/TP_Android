package faflo10.tp_07_parsingxml;

import faflo10.tp_07_parsingxml.util.SystemUiHider;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class main extends Activity {
    private ArrayList<Meteo> prev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
    }

    protected void onStart() {
        super.onStart();
        setContentView(R.layout.activity_main);

        prev = new ArrayList<>();

        try {
            URL rssUrl = new URL("http://api.meteorologic.net/forecarss?p=Bourg-en-Bresse");
            HttpURLConnection connect = (HttpURLConnection) rssUrl.openConnection();
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser parse = factory.newPullParser();
            parse.setInput(connect.getInputStream(),"UTF-8");
            while(parse.getEventType() != XmlPullParser.END_DOCUMENT) {
                if(parse.getEventType() == XmlPullParser.START_TAG) {
                    if(parse.getPrefix().equals("meteo")) {
                        if(parse.getName().equals("weather")) {
                            Meteo jour = new Meteo(parse.getAttributeValue(null,"date"),
                                    parse.getAttributeValue(null,"namepictos_matin"),
                                    Double.parseDouble(parse.getAttributeValue(null, "tempe_matin")),
                                    parse.getAttributeValue(null,"namepictos_midi"),
                                    Double.parseDouble(parse.getAttributeValue(null,"tempe_midi")),
                                    parse.getAttributeValue(null,"namepictos_apmidi"),
                                    Double.parseDouble(parse.getAttributeValue(null,"tempe_apmidi")),
                                    parse.getAttributeValue(null,"namepictos_soir"),
                                    Double.parseDouble(parse.getAttributeValue(null,"tempe_soir")));
                            prev.add(jour);
                        }
                    }
                }
            }
        } catch(MalformedURLException e) {
            System.out.println(e.getMessage());
        } catch(IOException e) {
            System.out.println(e.getMessage());
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }

        if(prev.size() != 0) {

        } else {
            System.out.println("probleme");
        }

    }
}
