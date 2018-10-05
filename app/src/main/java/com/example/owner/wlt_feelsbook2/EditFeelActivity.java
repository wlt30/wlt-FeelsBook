package com.example.owner.wlt_feelsbook2;
/* The EditFeelActivity is to be called when an entry in the FeelsLogs is selected. The layout would then be changed to activity_edit_feel.xml which would have a Calendar widget that would be used to manipulate the date of the Feel entry, as well as a EditText field for editing or adding a comment up to a maximum of 100 characters. There would be a Save button that would update the FeelsLog, notify all observers, then call the main FeelsBookActivity activity.
 */
import android.app.Activity;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


class EditFeelActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_feel);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_edit_feel,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id == R.id.action_settings){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
