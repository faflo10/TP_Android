package faflo10.projet_meteo;

import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * Created by faflo10 on 02/06/2015.
 */
public class StartMenu extends Activity {
    private Spinner spin;
    protected void onStart() {
        super.onStart();
        setContentView(R.layout.start_menu);
        initComponents();

    }

    public void initComponents() {
        spin = (Spinner) findViewById(R.id.spinner);
    }
}
