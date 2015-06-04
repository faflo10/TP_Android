package faflo10.projet_meteo;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by faflo10 on 03/06/2015.
 */
public class ZoomJour extends Activity {
    private ListView list;
    private Button ok;
    private TextView jour;
    private Context context;
    private DayAdapter adapter;

    protected void onStart() {
        super.onStart();
        setContentView(R.layout.zoom_jour);

        initComponents();
    }

    public void initComponents() {
        list = (ListView)findViewById(R.id.list);
        ok = (Button)findViewById(R.id.ok);
        jour = (TextView)findViewById(R.id.jour);
        context = this;
        adapter = new DayAdapter(
                getIntent().getStringArrayExtra("t"),
                getIntent().getStringArrayExtra("xml"),
                context);

        list.setAdapter(adapter);

        jour.setText(getIntent().getStringExtra("day"));

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
