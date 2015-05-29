package faflo10.tp_05_list_view;

import faflo10.tp_05_list_view.util.SystemUiHider;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Main extends Activity {
    private ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    protected void onStart() {
        super.onStart();
        setContentView(R.layout.activity_main);

        listview = (ListView) findViewById(R.id.listview);

        final Context cont = this;

        String[] name = new String[] {
                "OL",
                "PSG",
                "OM"
        };

        int[] flag = new int[] {
                R.drawable.ol,
                R.drawable.psg,
                R.drawable.om
        };

        final HashMap<String,String> values = new HashMap<String, String>();
        values.put("OL","Entraineur : machin\nClassement : 1er");
        values.put("PSG","Entraineur : truc\nClassement : 2eme");
        values.put("OM","Entraineur : bidule\nClassement : dernier");

        List<HashMap<String,String>> list = new ArrayList<HashMap<String, String>>();

        for(int i=0; i<3; i++) {
            HashMap<String,String> hm = new HashMap<String, String>();
            hm.put("club",name[i]);
            hm.put("flag",Integer.toString(flag[i]));
            list.add(hm);
        }

        String[] from = {"club","flag"};
        int[] to = {R.id.club,R.id.flag};

        SimpleAdapter adapter = new SimpleAdapter(this,list,R.layout.liste_layout,from,to);

        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                HashMap<String,String> res = (HashMap<String,String>) listview.getItemAtPosition(i);
                System.out.println(res.get("club"));
                AlertDialog.Builder builder = new AlertDialog.Builder(cont);
                builder.setTitle("Infos");
                builder.setMessage(values.get(res.get("club")));
                builder.setNegativeButton("Back",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.cancel();
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }

    public void createDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Infos");

    }
}
