package greycubelabs.com.instatutors;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LiberalArtsSubjectSelection extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liberal_arts_subject_selection);
    }

    public void usHistorySelection(View view){
        //Intent i = new Intent(this, MathSubjectSelection.class);
        //startActivity(i);
    }

    public void worldHistorySelection(View view) {
        //Intent i = new Intent(this, ScienceSubjectSelection.class);
        //sstartActivity(i);
    }

    public void litSelection(View view) {
        //Intent i = new Intent(this, ScienceSubjectSelection.class);
        //startActivity(i);
    }
}
