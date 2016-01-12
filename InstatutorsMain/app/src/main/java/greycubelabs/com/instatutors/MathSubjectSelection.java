package greycubelabs.com.instatutors;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import greycubelabs.com.instatutors.tutorcarousel.MainActivity;

public class MathSubjectSelection extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_subject_selection);
    }

    public void algebraSelection(View view){
        Toast.makeText(this, "You have chosen Algebra, you will now be redirected to the login page, a tutor will contact you soon",
                Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this, Login.class);
        startActivity(i);
    }

    public void geometrySelection(View view){
        Toast.makeText(this, "You have chosen Geometry, you will now be redirected to the login page, a tutor will contact you soon",
                Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this, Login.class);
        startActivity(i);
    }

    public void trigSelection(View view){
        Toast.makeText(this, "You have chosen Trigonometry, you will now be redirected to the login page, a tutor will contact you soon",
                Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this, Login.class);
        startActivity(i);
    }

    public void precalcSelection(View view){
        Toast.makeText(this, "You have chosen Pre-Calculus, you will now be redirected to the login page, a tutor will contact you soon",
                Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this, Login.class);
        startActivity(i);
    }

    public void apCalcSelection(View view){
        Toast.makeText(this, "You have chosen AP Calculus, you will now be redirected to the login page, a tutor will contact you soon",
                Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this, Login.class);
        startActivity(i);
    }

    public void apStatsSelection(View view){
        Toast.makeText(this, "You have chosen AP Statistics, you will now be redirected to the login page, a tutor will contact you soon",
                Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this, Login.class);
        startActivity(i);
    }
}
