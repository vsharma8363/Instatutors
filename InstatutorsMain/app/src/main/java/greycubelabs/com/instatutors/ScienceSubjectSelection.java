package greycubelabs.com.instatutors;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ScienceSubjectSelection extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_science_subject_selection);
    }

    public void physicsSelection(View view){
        //Intent i = new Intent(this, MathSubjectSelection.class);
        //startActivity(i);
    }

    public void chemistrySelection(View view){
        //Intent i = new Intent(this, MathSubjectSelection.class);
        //startActivity(i);
    }

    public void biologySelection(View view){
        //Intent i = new Intent(this, MathSubjectSelection.class);
        //startActivity(i);
    }

    public void csSelection(View view){
        //Intent i = new Intent(this, MathSubjectSelection.class);
        //startActivity(i);
    }
}
