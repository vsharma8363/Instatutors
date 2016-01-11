package greycubelabs.com.instatutors;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class BasicSubjectSelection extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_subject_selection);
    }

    public void mathSelection(View view){
        Intent i = new Intent(this, MathSubjectSelection.class);
        startActivity(i);
    }

    public void scienceSelection(View view) {
        Intent i = new Intent(this, ScienceSubjectSelection.class);
        startActivity(i);
    }

    public void liberalArtsSelection(View view) {
        Intent i = new Intent(this, LiberalArtsSubjectSelection.class);
        startActivity(i);
    }
}
