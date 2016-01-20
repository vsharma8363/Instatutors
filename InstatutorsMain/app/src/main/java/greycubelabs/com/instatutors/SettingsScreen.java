package greycubelabs.com.instatutors;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SettingsScreen extends AppCompatActivity {

    EditText email, school;
    Button cont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_screen);
        email = (EditText) findViewById(R.id.SettingsEmailInput);
        school = (EditText) findViewById(R.id.SettingsSchoolName);
        cont=(Button) findViewById(R.id.SettingsScreenContinueButton);
        cont.setVisibility(View.INVISIBLE);
        if(entered())
        {
            cont.setVisibility(View.VISIBLE);
        }
    }

    public void changeSubjects(View view) {
        MathSubjectSelection.settings = true;

        Intent myIntent = new Intent(this, LiberalArtsSubjectSelection.class);
        startActivity(myIntent);
    }

    private boolean entered() {
        if(email.length()>0||school.length()>0)
        {
            return true;
        }
    return false;
    }





}
