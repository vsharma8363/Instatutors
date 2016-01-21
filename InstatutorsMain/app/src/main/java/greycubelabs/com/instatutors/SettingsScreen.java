package greycubelabs.com.instatutors;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import greycubelabs.com.instatutors.tutorcarousel.MainActivity;

public class SettingsScreen extends AppCompatActivity {

    EditText email, school;
    Button cont;
    boolean displayButton = false;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_screen);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        email = (EditText) findViewById(R.id.SettingsEmailInput);
        school = (EditText) findViewById(R.id.SettingsSchoolName);
        cont=(Button) findViewById(R.id.SettingsScreenContinueButton);
        cont.setVisibility(View.INVISIBLE);
        handler.postDelayed(updateButton, 0);
    }

    public void changeSubjects(View view) {
        MathSubjectSelection.settings = true;
        LiberalArtsSubjectSelection.settings = true;
        Intent myIntent = new Intent(this, LiberalArtsSubjectSelection.class);
        startActivity(myIntent);
    }

    public void displayButton() {
        displayButton = true;
        cont.setVisibility(View.VISIBLE);
    }

    public void submitChanges(View view) {
        Intent myIntent = new Intent(this, MainActivity.class);
        startActivity(myIntent);

    }

    private Runnable updateButton = new Runnable() {
        @Override
        public void run() {
            if (email.getText().toString().length() > 0 || school.getText().toString().length() > 0) {
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
}
