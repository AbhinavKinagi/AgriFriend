package com.example.abhinav.agrifriend;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by abhin on 22-Nov-17.
 */

public class BuySell extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buysell);
        String all = getIntent().getStringExtra(Intent.EXTRA_TEXT);
        TextView marketview = findViewById(R.id.market);
        marketview.setText(all);
    }

}