package faflo10.tp_06_asynctask;

import android.os.AsyncTask;
import android.text.Html;
import android.webkit.WebView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by faflo10 on 29/05/2015.
 */
public class Task_weather extends AsyncTask<Object,Void,String> {
    private WebView txt;
    @Override
    protected String doInBackground(Object... objects) {
        URL url = (URL) objects[0];
        this.txt = (WebView) objects[1];
        HttpURLConnection urlConnection = null;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        } catch(NullPointerException e) {
            System.out.println("Pas bon");
        }
        System.out.println(urlConnection);
        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        } catch(NullPointerException e) {
            System.out.println("Pas bon recup");
        }
        System.out.println(in);

        String time = null;
        try {
            String full = "";
            while((time = in.readLine()) != null) {
                full += time;
            }
            urlConnection.disconnect();
            return full;
        } catch (IOException e) {
            e.printStackTrace();
        } catch(NullPointerException e) {
            System.out.println("Pas bon lecture");
        }

        urlConnection.disconnect();
        return null;
    }


    protected void onPostExecute(String res) {
        txt.loadData(res,"text/html; charset=utf-8", "UTF-8");
    }
}
