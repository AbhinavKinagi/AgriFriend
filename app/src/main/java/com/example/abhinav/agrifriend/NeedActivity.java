package com.example.abhinav.agrifriend;

/**
 * Created by abhinav on 28/10/17.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.TextView;

public class NeedActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_need);

        TextView buy =  findViewById(R.id.buy);

        TextView sell =  findViewById(R.id.sell);

        TextView help = findViewById(R.id.help);

        buy.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                Intent buyIntent = new Intent(NeedActivity.this, CropActivity.class);
               String value = "a";
               buyIntent.putExtra(Intent.EXTRA_TEXT,value);
                // Start the new activity
                startActivity(buyIntent);
            }
        });

        sell.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {

                Intent sellIntent = new Intent(NeedActivity.this, CropActivity.class);
                String value = "a";
                sellIntent.putExtra(Intent.EXTRA_TEXT,value);

                // Start the new activity
                startActivity(sellIntent);
            }
        });

        help.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link NumbersActivity}
                Intent cropIntent = new Intent(NeedActivity.this, CropActivity.class);
                String value = "b";
                cropIntent.putExtra(Intent.EXTRA_TEXT,value);

                // Start the new activity
                startActivity(cropIntent);
            }
        });
    }
}