package faflo10.tp_06_asynctask;

import android.os.AsyncTask;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by faflo10 on 29/05/2015.
 */
public class Task extends AsyncTask<Object,Void,String> {
    private TextView txt;
    @Override
    protected String doInBackground(Object... objects) {
        URL url = (URL) objects[0];
        this.txt = (TextView) objects[1];
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
            time = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        } catch(NullPointerException e) {
            System.out.println("Pas bon lecture");
        }

        urlConnection.disconnect();
        return time;
    }


    protected void onPostExecute(String res) {
        txt.setText(res);
    }


}
