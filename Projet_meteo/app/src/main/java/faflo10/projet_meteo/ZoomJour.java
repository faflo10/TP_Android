package faflo10.projet_meteo;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

/**
 * Created by faflo10 on 03/06/2015.
 */
public class ZoomJour extends Activity {
    private ListView list;
    private Button ok;

    protected void onStart() {
        super.onStart();
        setContentView(R.layout.zoom_jour);

        initComponents();
    }

    public void initComponents() {
        list = (ListView)findViewById(R.id.list);
        ok = (Button)findViewById(R.id.ok);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
