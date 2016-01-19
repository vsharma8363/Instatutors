package greycubelabs.com.instatutors;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class SettingsScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_screen);


    }

    public void changeSubjects(View view)
    {
       Intent myIntent = new Intent(this, LiberalArtsSubjectSelection.class);
        String identifier=null;
        myIntent.putExtra("strName","Settings");
        startActivity(myIntent);
    }
}
