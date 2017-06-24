package com.acadgild.siddharth.preferencesassignment121;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    public static final String mypreference="mypref";
    public static final String Password="nameKey";
    TextView mtv,nn;
    Button b,b2;
    EditText et2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mtv = (TextView) findViewById(R.id.password);
        b = (Button)findViewById(R.id.button);
        b2 = (Button) findViewById(R.id.button2);
        et2 = (EditText) findViewById(R.id.editText);
        sharedPreferences = getSharedPreferences(mypreference,Context.MODE_PRIVATE);
        if(sharedPreferences.contains(Password))
        {

        }
        mtv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et2.setVisibility(View.VISIBLE);


            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n = et2.getText().toString();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(Password, n);
                editor.commit();
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPreferences = getSharedPreferences(mypreference,Context.MODE_PRIVATE);
                if(sharedPreferences.contains(Password))
                {
                    Toast.makeText(MainActivity.this,"Password is: "+sharedPreferences.getString(Password,""),Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
