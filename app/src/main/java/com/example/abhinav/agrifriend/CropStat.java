package com.example.abhinav.agrifriend;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuInflater;
import android.widget.TextView;

/**
 * Created by abhin on 23-Nov-17.
 */

public class CropStat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cropstat);

        String val="";
        TextView yieldview = findViewById(R.id.yield);
        String all = getIntent().getStringExtra(Intent.EXTRA_TEXT);
        for (String news: all.split(",")) {
            val = val + news +"\n";
            yieldview.setText(val);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_menu,menu);
        return true;
    }


}
