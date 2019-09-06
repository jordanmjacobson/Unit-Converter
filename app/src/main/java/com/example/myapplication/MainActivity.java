package com.example.myapplication;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final android.widget.TextView result = findViewById(R.id.result);
        final EditText input = findViewById(R.id.input);
        String userInput = input.getText().toString(); //extracts value from user input
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Convert to Celcius", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                //insert fucntion call here
                // int converted = celcius(userInput);
                int converted = celcius(input.getText().toString());
                // result.setVisibility();
                result.setText("In Celcius: " + converted);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    // @Override
    public int celcius(String str){
        int inputVal = Integer.parseInt(str);
        return ((inputVal-32) * 5) /9; //formula to convert farenheit to celcius
    }
    // @Override
    public float meters(String str){
        int inputVal = Integer.parseInt(str); //feet
        return (float) (inputVal/3.281);
    }
}
