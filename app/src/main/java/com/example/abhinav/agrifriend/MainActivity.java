package com.example.abhinav.agrifriend;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    public int flag=1;
    public int flag1=3;
    public int flag2=5;
    public String gender;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            onRestoreInstanceState(savedInstanceState);
        }


    }

    public void submitDetails(View view) {
        validateName(((EditText) findViewById(R.id.name)).getText().toString());
        validateVillage(((EditText) findViewById(R.id.village)).getText().toString());
        validateAddress(((EditText) findViewById(R.id.mobile)).getText().toString());
        if (flag == 1 & flag1 == 3 & flag2 == 5) {
            sendMessage();
        }
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
             case R.id.gender_male:
                if (checked) {
                    gender = "Male";
                    return;
                }
                return;
            case R.id.gender_female:
                if (checked) {
                    gender = "Female";
                    return;
                }
                return;
        }
    }
    View focusView=null;
    private void validateName(String name) {
        if (Pattern.matches("^[\\p{L} .'-]+$", name)) {
            flag = 1;
            return;
        }
        EditText nameView = findViewById(R.id.name);
        focusView= nameView;
        nameView.setError("Please enter a valid name");
        flag = 0;
    }

    private void validateVillage(String village) {
        if (Pattern.matches("^\\d{6}$", village)) {
            flag1 = 3;
            return;
        }
        EditText villageView = findViewById(R.id.village);
        focusView= villageView;
        villageView.setError("Please enter a valid Pincode");
        //Toast.makeText(this, "Please enter a valid Village/Town", Toast.LENGTH_SHORT).show();
        flag1 = 0;
    }

    private void validateAddress(String address) {
        if (Pattern.matches("^[\\p{L} .'-]+$", address)) {
            flag2 = 5;
            return;
        }
        EditText addressView = findViewById(R.id.mobile);
        focusView= addressView;
        addressView.setError("Please enter a valid Address");
        //Toast.makeText(this, "Please enter a valid Village/Town", Toast.LENGTH_SHORT).show();
        flag2 = 0;
    }

    public void sendMessage() {
        Intent intent = new Intent(this, PhoneAuthActivity.class);
        startActivity(intent);
    }


    public void resetDetails(View view) {
        ((EditText) findViewById(R.id.name)).setText("");
        ((EditText) findViewById(R.id.village)).setText("");
        ((EditText) findViewById(R.id.mobile)).setText("");
    }
}