package com.example.owner.wlt_feelsbook2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static android.widget.Toast.makeText;

public class FeelsBookActivity extends Activity {

    private static final String FILENAME = "feels_log.sav";
    private FeelsBookActivity activity = this;
    public Button getAddButton() {
        return addButton;
    }

    private Button addButton;

    public ListView getFeelsHistory() {
        return feelsHistory;
    }

    public ListView feelsHistory;

    protected ArrayList<Feel> feels = new ArrayList<>();
    private ArrayAdapter<Feel> adapter;

    /*Called when the activity is first created*/
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //this is a view
        setContentView(R.layout.activity_main); // this is a view

        addButton = findViewById(R.id.addButton);
        feelsHistory = findViewById(R.id.feelsHistory);

        addButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(FeelsBookActivity.this, AddFeel.class);
                startActivity(intent);
                saveInFile(); //declared later
            }
        });
    }

    public void addFeel(MenuItem menu) {
        Toast.makeText(this, "Adding Feel", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(FeelsBookActivity.this, AddFeel.class);
        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    protected void onStart(){
        super.onStart();
        loadFromFile(); //declared later
        adapter = new ArrayAdapter<Feel>(this, R.layout.activity_main, feels);
        feelsHistory.setAdapter(adapter);
    }

    private void loadFromFile(){
        try {
            FileInputStream fis = openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));
            Gson gson = new Gson();
            Type listType = new TypeToken<ArrayList<Feel>>() {}.getType();
            feels = gson.fromJson(in, listType);
        } catch (FileNotFoundException e){
            feels = new ArrayList<>();
        } /*catch (IOException e) {
            throw new RuntimeException(e);
        }*/
    }

    private void saveInFile(){
        try {
            FileOutputStream fos = openFileOutput(FILENAME, 0);
            OutputStreamWriter writer = new OutputStreamWriter(fos);
            Gson gson = new Gson();
            gson.toJson(feels, writer);
            writer.flush();
            fos.close();
        } catch (FileNotFoundException e){
            throw new RuntimeException(e);
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }

}
