package faflo10.projet_meteo;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import static android.support.v4.app.ActivityCompat.startActivity;

/**
 * Created by faflo10 on 03/06/2015.
 */
public class Task extends AsyncTask<Object,Void,ArrayList<Meteo>> {
    private OnTaskComplete listener;
    private ListView list;
    private TextView date;
    private TextView condition;
    private ArrayList<Meteo> prev;
    private Context context;
    private ListElementAdapter adapt;

    public Task(OnTaskComplete listener) {
        this.listener = listener;
    }

    @Override
    protected ArrayList<Meteo> doInBackground(Object... params) {
        URL urlRss = (URL) params[0];
        list = (ListView)params[1];
        date = (TextView)params[2];
        condition = (TextView)params[3];
        this.context = (Context)params[4];
        prev = new ArrayList<>();

        try {
            HttpURLConnection connect = (HttpURLConnection) urlRss.openConnection();
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser parse = factory.newPullParser();
            parse.setInput(connect.getInputStream(),"UTF-8");
            System.out.println(parse);
            int event = parse.getEventType();
            while(event != XmlPullParser.END_DOCUMENT) {
                if(event == XmlPullParser.START_TAG) {
                    if(parse.getPrefix() != null && parse.getPrefix().equals("meteo")) {
                        if(parse.getName().equals("weather")) {
                            Meteo jour = new Meteo(parse.getAttributeValue(null,"date"),
                                    new String[] {parse.getAttributeValue(null, "tempe_matin"),
                                            parse.getAttributeValue(null,"tempe_midi"),
                                            parse.getAttributeValue(null,"tempe_apmidi"),
                                            parse.getAttributeValue(null,"tempe_soir")},
                                    new String[] {parse.getAttributeValue(null,"namepictos_matin"),
                                            parse.getAttributeValue(null,"namepictos_midi"),
                                            parse.getAttributeValue(null,"namepictos_apmidi"),
                                            parse.getAttributeValue(null,"namepictos_soir")},
                                    new String[] {parse.getAttributeValue(null,"pictos_matin"),
                                            parse.getAttributeValue(null,"pictos_midi"),
                                            parse.getAttributeValue(null,"pictos_apmidi"),
                                            parse.getAttributeValue(null,"pictos_soir")});
                            prev.add(jour);
                        }
                    }
                }
                event = parse.next();
            }
            return prev;
        } catch(MalformedURLException e) {
            System.out.println(e.getMessage());
        } catch(IOException e) {
            System.out.println(e.getMessage());
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected void onPostExecute(final ArrayList<Meteo> prev) {
        if(prev.size() != 0 && prev != null) {
            adapt = new ListElementAdapter(prev,context);
            list.setAdapter(adapt);
            listener.onTaskComplete(prev);
        } else {
            System.out.println("probleme");
            System.out.println(prev.toString());
        }
    }
}
