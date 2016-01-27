package greycubelabs.com.instatutors;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.firebase.client.Firebase;

import greycubelabs.com.instatutors.tutorcarousel.MainActivity;

public class SettingsScreen extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText email;
    Button cont;
    boolean displayButton = false;
    private Handler handler = new Handler();
    private String id;
    Firebase firebase;
    Spinner dropdown;
    private String school = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_screen);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        email = (EditText) findViewById(R.id.SettingsEmailInput);
        cont=(Button) findViewById(R.id.SettingsScreenContinueButton);
        cont.setVisibility(View.INVISIBLE);
        handler.postDelayed(updateButton, 0);
        dropdown = (Spinner)findViewById(R.id.SettingsChangeHighSchool);
        String[] items = new String[]{"Select from Available High Schools", "Homestead High School"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);

        Intent i = getIntent();
        id = i.getStringExtra("id");

        firebase = new Firebase("https://instatutors.firebaseio.com/");
    }

    public void changeSubjects(View view) {
        MathSubjectSelection.settings = true;
        LiberalArtsSubjectSelection.settings = true;
        ScienceSubjectSelection.settings = true;
        Intent myIntent = new Intent(this, LiberalArtsSubjectSelection.class);
        myIntent.putExtra("id", id);
        startActivity(myIntent);
    }

    public void displayButton() {
        displayButton = true;
        cont.setVisibility(View.VISIBLE);
    }

    public void submitChanges(View view) {
        String s = email.getText().toString();
        if (s.isEmpty() == false) {
            firebase.child("users").child(id).child("email").setValue(s);
        }
        if (school.length() > 0) {
            firebase.child("users").child(id).child("school").setValue(school);
        }
        Intent myIntent = new Intent(this, MainActivity.class);
        startActivity(myIntent);
    }

    private Runnable updateButton = new Runnable() {
        @Override
        public void run() {
            if (email.getText().toString().length() > 0 || school.length() > 0) {
                displayButton();
                return;
            }
            handler.postDelayed(this, 0);
        }
    };

    public void startDrawer(View view) {
        Intent i = new Intent(this, NavigationDrawer.class);
        startActivity(i);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right );
    }

    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
        if (position > 0) {
            school = parent.getItemAtPosition(position).toString();
        }
    }

    public void onNothingSelected(AdapterView<?> arg0) {

    }

}
