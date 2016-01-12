package greycubelabs.com.instatutors;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class LiberalArtsSubjectSelection extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liberal_arts_subject_selection);
    }

    public void usHistorySelection(View view){
        Toast.makeText(this, "You have chosen US history, now choose a science subject",
                Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this, ScienceSubjectSelection.class);
        startActivity(i);

    }

    public void worldHistorySelection(View view) {
        Toast.makeText(this, "You have chosen World History, now choose a science subject",
                Toast.LENGTH_SHORT).show();

        Intent i = new Intent(this, ScienceSubjectSelection.class);
        startActivity(i);
    }

    public void litSelection(View view) {
        Toast.makeText(this, "You have chosen Literature, now choose a science subject",
                Toast.LENGTH_SHORT).show();

        Intent i = new Intent(this, ScienceSubjectSelection.class);
        startActivity(i);
    }
}
