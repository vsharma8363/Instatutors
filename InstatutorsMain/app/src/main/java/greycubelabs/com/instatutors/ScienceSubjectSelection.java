package greycubelabs.com.instatutors;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ScienceSubjectSelection extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_science_subject_selection);
    }

    public void physicsSelection(View view){
        Toast.makeText(this, "You have chosen Physics, now choose a math subject",
                Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this, MathSubjectSelection.class);
        startActivity(i);
    }

    public void chemistrySelection(View view){
        Toast.makeText(this, "You have chosen Chemistry, now choose a math subject",
                Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this, MathSubjectSelection.class);
        startActivity(i);
    }

    public void biologySelection(View view){
        Toast.makeText(this, "You have chosen Biology, now choose a math subject",
                Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this, MathSubjectSelection.class);
        startActivity(i);
    }

    public void csSelection(View view){
        Toast.makeText(this, "You have chosen Computer Science, now choose a math subject",
                Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this, MathSubjectSelection.class);
        startActivity(i);
    }
}
