package com.example.owner.wlt_feelsbook2;
/* FeelsBookActivity is the default activity process for this application as documented in the AndroidManifest.xml. It calls upon the activity_main.xml layout which contains the 6 mood buttons, the current feels log and the commentBody field. There would be a colour coded legend at the top that would indicate the number of entries matching that colour-coded emotion. This would be done using the FeelsList.count() method which would be edited to find entries with a certain mood.
 */
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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static android.widget.Toast.makeText;

public class FeelsBookActivity extends Activity {

    private static final String FILENAME = "feels_log.sav";
    private FeelsBookActivity activity = this;
    public ListView getFeelsHistory() {
        return feelsHistory;
    }
    public ListView feelsHistory;
    public Button getLoveButton() {return loveButton;}
    private Button loveButton;
    public Button getJoyButton() {return joyButton;}
    private Button joyButton;
    public Button getSurpriseButton() {return surpriseButton;}
    private Button surpriseButton;
    public Button getAngerButton() {return angerButton;}
    private Button angerButton;
    public Button getSadnessButton() {return sadnessButton;}
    private Button sadnessButton;
    public Button getFearButton() {return fearButton;}
    private Button fearButton;
    public EditText getCommentText() {
        return commentText;
    }

    private EditText commentText;


    protected ArrayList<Feel> feels = new ArrayList<>();
    private ArrayAdapter<Feel> adapter;

    /*Called when the activity is first created*/
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //this is a view
        setContentView(R.layout.activity_main); // this is a view
        commentText = (EditText) findViewById(R.id.commentBody);
        feelsHistory = findViewById(R.id.feelsHistory);
        loveButton = findViewById(R.id.loveButton);
        joyButton = findViewById(R.id.joyButton);
        surpriseButton = findViewById(R.id.surpriseButton);
        angerButton = findViewById(R.id.angerButton);
        sadnessButton = findViewById(R.id.sadnessButton);
        fearButton = findViewById(R.id.fearButton);

        loveButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                String comment = commentText.getText().toString();
                postFeel("Love",comment);
            }
        });
        joyButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                String comment = commentText.getText().toString();
                postFeel("Joy",comment);
            }
        });
        surpriseButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                String comment = commentText.getText().toString();
                postFeel("Surprise",comment);
            }
        });
        angerButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                String comment = commentText.getText().toString();
                postFeel("Anger",comment);
            }
        });
        sadnessButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                String comment = commentText.getText().toString();
                postFeel("Sadness", comment);
            }
        });
        fearButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                String comment = commentText.getText().toString();
                postFeel("Fear", comment);
            }
        });

        feelsHistory.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(activity, EditFeelActivity.class);
                startActivity(intent);
            }
        });
    }

    public void postFeel(String mood, String comment){
        Toast.makeText(this,"Adding Feel", Toast.LENGTH_SHORT).show();
        Date date = new Date();
        feels.add(new Feel(mood, date, comment));
        adapter.notifyDataSetChanged();
        saveInFile();
    }

    @Override
    protected void onStart(){
        super.onStart();
        loadFromFile(); //declared later
        adapter = new ArrayAdapter<>(this, R.layout.list_feels, feels);
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
        }
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
