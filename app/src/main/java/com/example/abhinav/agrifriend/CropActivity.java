package com.example.abhinav.agrifriend;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.google.android.gms.internal.zzbco.NULL;

/**
 * Created by abhin on 20-Nov-17.
 */

public class CropActivity extends AppCompatActivity{
        private DatabaseReference mDatabase;
        private DatabaseReference mDatabase1;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.crop_list);

            final String with = getIntent().getStringExtra(Intent.EXTRA_TEXT);

            // Create a list of crops
            final ArrayList<Crop> crops = new ArrayList<Crop>();
            crops.add(new Crop("Alasande Gram", "ಅಲಸಂದೆ", R.drawable.alsande));
            crops.add(new Crop("Bengalgram", "ಕಡಲೆ ಕಾಳು", R.drawable.bengal));
            crops.add(new Crop("Blackgram", "ಉದ್ದಿನ ಬೇಳೆ", R.drawable.black));
            crops.add(new Crop("Coriander Seed", "ಕೊತ್ತಂಬರಿ ಬೀಜ", R.drawable.coriander));
            crops.add(new Crop("Cotton", "ಹತ್ತಿ", R.drawable.cotton));
            crops.add(new Crop("Dry Chillies", "ಒಣ ಮೆಣಸಿನಕಾಯಿ", R.drawable.dry));
            crops.add(new Crop("Greengram", "ಹಸಿರು ಬೇಳೆ", R.drawable.greengram));
            crops.add(new Crop("Groundnut", "ಕಡಲೆಕಾಯಿ", R.drawable.ground));
            crops.add(new Crop("Horse Gram", "ಹುರಳಿ ಕಾಳು", R.drawable.horsegram));
            crops.add(new Crop("Jowar", "ಜೋಳ", R.drawable.jowar));
            crops.add(new Crop("Maize", "ಮೆಕ್ಕೆ ಜೋಳ", R.drawable.maize));
            crops.add(new Crop("Navane", "ನವನೆ", R.drawable.navane));
            crops.add(new Crop("Onion", "ಈರುಳ್ಳಿ", R.drawable.onion));
            crops.add(new Crop("Potato", "ಆಲೂಗಡ್ಡೆ", R.drawable.potato));
            crops.add(new Crop("Ragi", "ರಾಗಿ", R.drawable.ragi));
            crops.add(new Crop("Safflower", "ಸ್ಯಾಫ್ಲವರ್", R.drawable.safflower));
            crops.add(new Crop("Sajje", "ಸಜ್ಜೆ", R.drawable.bajra));
            crops.add(new Crop("SameSavi", "ಸಾವಿ", R.drawable.seed));
            crops.add(new Crop("Soyabeen", "ಸೋಯಾಬೀನ್", R.drawable.soyabean));
            crops.add(new Crop("Sunflower", "ಸೂರ್ಯಕಾಂತಿ", R.drawable.sunflower));
            crops.add(new Crop("Tur", "ತೊಗರಿ", R.drawable.tur));
            crops.add(new Crop("Wheat", "ಗೋಧಿ", R.drawable.wheat));

            // Create an {@link CropAdapter}, whose data source is a list of {@link Crop}s. The
            // adapter knows how to create list items for each item in the list.
            CropAdapter adapter = new CropAdapter(this, crops, R.color.crops_colors);

            // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
            // There should be a {@link ListView} with the view ID called list, which is declared in the
            // word_list.xml layout file.
            ListView listView = (ListView) findViewById(R.id.list);

            // Make the {@link ListView} use the {@link CropAdapter} we created above, so that the
            // {@link ListView} will display list items for each {@link Crop} in the list.
            listView.setAdapter(adapter);

            FirebaseOptions options = new FirebaseOptions.Builder().setApplicationId("agrifriend4").setApiKey("AIzaSyCTqOOUpyjSLdWzlHs3dks1mKAv3l69O30").setDatabaseUrl("https://agrifriend4-d796d.firebaseio.com/").build(); // Required for RTDB.

            FirebaseApp.initializeApp(getApplicationContext());
            FirebaseApp primary = FirebaseApp.getInstance();
            final FirebaseDatabase primaryDatabase = FirebaseDatabase.getInstance(primary);

            FirebaseApp.initializeApp( getApplicationContext() , options,"agrifriend4-d796d");
            FirebaseApp secondary = FirebaseApp.getInstance("agrifriend4-d796d");
            final FirebaseDatabase secondaryDatabase = FirebaseDatabase.getInstance(secondary);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                    // Get the {@link Crop} object at the given position the user clicked on
                   final Crop crop = crops.get(position);


                    mDatabase1= secondaryDatabase.getReference().child(crop.getDefaultTranslation());
                    mDatabase = primaryDatabase.getReference().child(crop.getDefaultTranslation());
                    switch(with){

                        case "a":
                        mDatabase.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                String value = dataSnapshot.getValue().toString();
                                    Intent buysell = new Intent(CropActivity.this, BuySell.class);
                                    buysell.putExtra(Intent.EXTRA_TEXT, value);
                                    startActivity(buysell);
                                }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {


                            }
                        });
                        break;
                        case "b":
                        mDatabase1.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                if(dataSnapshot.exists()){
                                    String value = dataSnapshot.getValue().toString();
                                    Intent cropStat = new Intent(CropActivity.this, CropStat.class);
                                    cropStat.putExtra(Intent.EXTRA_TEXT, value);
                                    startActivity(cropStat);

                                }else {

                                    Toast.makeText(CropActivity.this,"This crop is not available for your region!",Toast.LENGTH_SHORT).show();

                                }
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {
                                int news = databaseError.getCode();
                                Toast.makeText(CropActivity.this,news,Toast.LENGTH_SHORT).show();
                            }
                        });
                        break;
                }
               }
            });
        }
    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_menu,menu);
        return true;
    }

}