package faflo10.projet_meteo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by faflo10 on 02/06/2015.
 */
public class StartMenu extends Activity {
    private Spinner spin;
    private Button go;
    private Button pref;

    protected void onStart() {
        super.onStart();
        setContentView(R.layout.start_menu);
        initComponents();

    }

    public void initComponents() {
        spin = (Spinner) findViewById(R.id.spinner);
        go = (Button)findViewById(R.id.go);
        pref = (Button)findViewById(R.id.pref);

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectivityManager connManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo mWifi = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
                NetworkInfo m3g = connManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

                if (!mWifi.isConnected()&&!m3g.isConnected()) {
                    Toast.makeText(getApplicationContext(),"No Internet Connection",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(StartMenu.this, PrevisionSemaine.class);
                    intent.putExtra("url", spin.getSelectedItem().toString());
                    startActivity(intent);
                }
            }
        });
    }
}
