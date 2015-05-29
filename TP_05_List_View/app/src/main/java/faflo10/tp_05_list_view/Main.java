package faflo10.tp_05_list_view;

import faflo10.tp_05_list_view.util.ListElementAdapter;
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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Main extends Activity {
    private ListView listview;
    private ListElementAdapter adapter;

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

        adapter = new ListElementAdapter(name,flag,this);

        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView nom = (TextView) view.findViewById(R.id.album);
                ImageView img = (ImageView) view.findViewById(R.id.pochette);
                String inti = nom.getText().toString();

                AlertDialog.Builder builder = new AlertDialog.Builder(cont);
                builder.setTitle(inti);
                builder.setMessage("Entraineur : \nClassement : ");
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
}
