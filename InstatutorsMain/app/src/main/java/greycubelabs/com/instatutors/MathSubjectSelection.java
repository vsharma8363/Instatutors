package greycubelabs.com.instatutors;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import greycubelabs.com.instatutors.tutorcarousel.MainActivity;

public class MathSubjectSelection extends Activity {

    private boolean algebra = false, geo = false, trig = false, precalc = false, calc = false, stats = false;
    public static boolean settings=false;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_subject_selection);
        Bundle bundle = getIntent().getExtras();

    }

    public void algebraSelection(View view){
        algebra = !algebra;
        if (algebra) {
            Button b = (Button)view;
            Drawable d = getDrawable(R.drawable.selectedbutton);
            b.setBackground(d);
        } else {
            Button b = (Button)view;
            Drawable d = getDrawable(R.drawable.selectionbutton);
            b.setBackground(d);
        }
    }

    public void geometrySelection(View view){
        geo = !geo;
        if (geo) {
            Button b = (Button)view;
            Drawable d = getDrawable(R.drawable.selectedbutton);
            b.setBackground(d);
        } else {
            Button b = (Button)view;
            Drawable d = getDrawable(R.drawable.selectionbutton);
            b.setBackground(d);
        }
    }

    public void trigSelection(View view){
        trig = !trig;
        if (trig) {
            Button b = (Button)view;
            Drawable d = getDrawable(R.drawable.selectedbutton);
            b.setBackground(d);
        } else {
            Button b = (Button)view;
            Drawable d = getDrawable(R.drawable.selectionbutton);
            b.setBackground(d);
        }
    }

    public void precalcSelection(View view){
        precalc = !precalc;
        if (precalc) {
            Button b = (Button)view;
            Drawable d = getDrawable(R.drawable.selectedbutton);
            b.setBackground(d);
        } else {
            Button b = (Button)view;
            Drawable d = getDrawable(R.drawable.selectionbutton);
            b.setBackground(d);
        }
    }

    public void apCalcSelection(View view){
        calc = !calc;
        if (calc) {
            Button b = (Button)view;
            Drawable d = getDrawable(R.drawable.selectedbutton);
            b.setBackground(d);
        } else {
            Button b = (Button)view;
            Drawable d = getDrawable(R.drawable.selectionbutton);
            b.setBackground(d);
        }
    }

    public void apStatsSelection(View view){
        stats = !stats;
        if (stats) {
            Button b = (Button)view;
            Drawable d = getDrawable(R.drawable.selectedbutton);
            b.setBackground(d);
        } else {
            Button b = (Button)view;
            Drawable d = getDrawable(R.drawable.selectionbutton);
            b.setBackground(d);
        }
}

    public void nextSelection(View view) {

        if(settings)
        {
            Intent a = new Intent(this, SettingsScreen.class);
            startActivity(a);
        }
        else{
            Intent i = new Intent(this, Login.class);
            startActivity(i);
        }
    }
}
