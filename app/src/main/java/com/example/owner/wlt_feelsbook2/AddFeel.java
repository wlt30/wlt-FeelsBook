package com.example.owner.wlt_feelsbook2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static android.widget.Toast.makeText;

public class AddFeel extends Activity  {
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

    public ArrayList<Feel> feels = new ArrayList<Feel>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_mood);
        loveButton = findViewById(R.id.loveButton);
        joyButton = findViewById(R.id.joyButton);
        surpriseButton = findViewById(R.id.surpriseButton);
        angerButton = findViewById(R.id.angerButton);
        sadnessButton = findViewById(R.id.sadnessButton);
        fearButton = findViewById(R.id.fearButton);

        loveButton.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v) {
                    postFeel("Love");
                }
        });
        joyButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                postFeel("Joy");
            }
        });
        surpriseButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                postFeel("Surprise");
            }
        });
        angerButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                postFeel("Anger");
            }
        });
        sadnessButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                postFeel("Sadness");
            }
        });
        fearButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                postFeel("Fear");
            }
        });
    }

    public void postFeel(String mood){
        View commentID = findViewById(R.id.commentBody);
        String comment = commentID.toString();
        Date date = Calendar.getInstance().getTime();
        feels.add(new Feel(mood, date, comment));
        Intent intent = new Intent(AddFeel.this, FeelsBookActivity.class);
        startActivity(intent);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.add_feel, menu);
        return true;
    }

    /*public void enterLove(View v) {
        Toast.makeText(this, "Adding Loving Feeling", Toast.LENGTH_SHORT).show();
        View commentID = findViewById(R.id.commentBody);
        String comment = commentID.toString();
        String mood = "Love";
        Date date = Calendar.getInstance().getTime();
        feels.add(new Feel(mood, date, comment));
        feels.notifyAll();
        Intent intent = new Intent(AddFeel.this, FeelsBookActivity.class);
        startActivity(intent);
    }

    public void enterJoy() {
        makeText(this, "Adding Joyful Feeling", Toast.LENGTH_SHORT).show();
        View commentID = findViewById(R.id.commentBody);
        String comment = commentID.toString();
        String mood = "Joy";
        Date date = Calendar.getInstance().getTime();
        feels.add(new Feel(mood, date, comment));
        feels.notifyAll();
        Intent intent = new Intent(AddFeel.this, FeelsBookActivity.class);
        startActivity(intent);
    }

    public void enterSurprise() {
        makeText(this, "Adding Surprised Feeling", Toast.LENGTH_SHORT).show();
        View commentID = findViewById(R.id.commentBody);
        String comment = commentID.toString();
        String mood = "Surprise";
        Date date = Calendar.getInstance().getTime();
        feels.add(new Feel(mood, date, comment));
        feels.notifyAll();
        Intent intent = new Intent(AddFeel.this, FeelsBookActivity.class);
        startActivity(intent);
    }

    public void enterAnger() {
        makeText(this, "Adding Angry Feeling", Toast.LENGTH_SHORT).show();
        View commentID = findViewById(R.id.commentBody);
        String comment = commentID.toString();
        String mood = "Anger";
        Date date = Calendar.getInstance().getTime();
        feels.add(new Feel(mood, date, comment));
        feels.notifyAll();
        Intent intent = new Intent(AddFeel.this, FeelsBookActivity.class);
        startActivity(intent);
    }

    public void enterSadness() {
        makeText(this, "Adding Sad Feeling", Toast.LENGTH_SHORT).show();
        View commentID = findViewById(R.id.commentBody);
        String comment = commentID.toString();
        String mood = "Sadness";
        Date date = Calendar.getInstance().getTime();
        feels.add(new Feel(mood, date, comment));
        feels.notifyAll();
        Intent intent = new Intent(AddFeel.this, FeelsBookActivity.class);
        startActivity(intent);
    }

    public void enterFear() {
        makeText(this, "Adding Fearful Feeling", Toast.LENGTH_SHORT).show();
        View commentID = findViewById(R.id.commentBody);
        String comment = commentID.toString();
        String mood = "Fear";
        Date date = Calendar.getInstance().getTime();
        feels.add(new Feel(mood, date, comment));
        feels.notifyAll();
        Intent intent = new Intent(AddFeel.this, FeelsBookActivity.class);
        startActivity(intent);
    }*/


}
