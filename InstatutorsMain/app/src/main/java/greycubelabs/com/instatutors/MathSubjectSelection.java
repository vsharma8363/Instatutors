package greycubelabs.com.instatutors;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;

import greycubelabs.com.instatutors.tutorcarousel.MainActivity;

public class MathSubjectSelection extends Activity {

    private boolean algebra = false, geo = false, trig = false, precalc = false, calc = false, stats = false;
    public static boolean settings=false;
    private String id;
    Firebase firebase;
    private Button algB, geoB, trigB, preB, calcB, statsB;
    private ArrayList<String> mathSubjects;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_subject_selection);

        Intent i = getIntent();
        id = i.getStringExtra("id");

        firebase = new Firebase("https://instatutors.firebaseio.com/");

        algB = (Button)findViewById(R.id.MathSelectionAlgebraButton);
        geoB = (Button)findViewById(R.id.MathSelectionGeometryButton);
        trigB = (Button)findViewById(R.id.MathSelectionTrigButton);
        preB = (Button)findViewById(R.id.MathSelectionPrecalcButton);
        calcB = (Button)findViewById(R.id.MathSelectionAPCalcButton);
        statsB = (Button)findViewById(R.id.MathSelectionAPStatsButton);

        mathSubjects = new ArrayList<String>();

        if (settings) {
            firebase.child("users").child(id).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    mathSubjects = dataSnapshot.child("mathSubjects").getValue(ArrayList.class);
                    for (String i: mathSubjects) {
                        if (i.equals("Algebra")) {
                            Drawable d = getDrawable(R.drawable.selectedbutton);
                            algB.setBackground(d);
                            algebra = true;
                        } else if (i.equals("Geometry")) {
                            Drawable d = getDrawable(R.drawable.selectedbutton);
                            geoB.setBackground(d);
                            geo = true;
                        } else if (i.equals("Trignometry")) {
                            Drawable d = getDrawable(R.drawable.selectedbutton);
                            trigB.setBackground(d);
                            trig = true;
                        } else if (i.equals("Precalculus")) {
                            Drawable d = getDrawable(R.drawable.selectedbutton);
                            preB.setBackground(d);
                            precalc = true;
                        } else if (i.equals("Calculus")) {
                            Drawable d = getDrawable(R.drawable.selectedbutton);
                            calcB.setBackground(d);
                            calc = true;
                        } else if (i.equals("Statistics")) {
                            Drawable d = getDrawable(R.drawable.selectedbutton);
                            statsB.setBackground(d);
                            stats = true;
                        }
                    }
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });
        }
    }

    public void algebraSelection(View view){
        algebra = !algebra;
        if (algebra) {
            mathSubjects.add("Algebra");
            Button b = (Button)view;
            Drawable d = getDrawable(R.drawable.selectedbutton);
            b.setBackground(d);
        } else {
            mathSubjects.remove("Algebra");
            Button b = (Button)view;
            Drawable d = getDrawable(R.drawable.selectionbutton);
            b.setBackground(d);
        }
    }

    public void geometrySelection(View view){
        geo = !geo;
        if (geo) {
            mathSubjects.add("Geometry");
            Button b = (Button)view;
            Drawable d = getDrawable(R.drawable.selectedbutton);
            b.setBackground(d);
        } else {
            mathSubjects.remove("Geometry");
            Button b = (Button)view;
            Drawable d = getDrawable(R.drawable.selectionbutton);
            b.setBackground(d);
        }
    }

    public void trigSelection(View view){
        trig = !trig;
        if (trig) {
            mathSubjects.add("Trignometry");
            Button b = (Button)view;
            Drawable d = getDrawable(R.drawable.selectedbutton);
            b.setBackground(d);
        } else {
            mathSubjects.remove("Trignometry");
            Button b = (Button)view;
            Drawable d = getDrawable(R.drawable.selectionbutton);
            b.setBackground(d);
        }
    }

    public void precalcSelection(View view){
        precalc = !precalc;
        if (precalc) {
            mathSubjects.add("Precalculus");
            Button b = (Button)view;
            Drawable d = getDrawable(R.drawable.selectedbutton);
            b.setBackground(d);
        } else {
            mathSubjects.remove("Precalculus");
            Button b = (Button)view;
            Drawable d = getDrawable(R.drawable.selectionbutton);
            b.setBackground(d);
        }
    }

    public void apCalcSelection(View view){
        calc = !calc;
        if (calc) {
            mathSubjects.add("Calculus");
            Button b = (Button)view;
            Drawable d = getDrawable(R.drawable.selectedbutton);
            b.setBackground(d);
        } else {
            mathSubjects.remove("Calculus");
            Button b = (Button)view;
            Drawable d = getDrawable(R.drawable.selectionbutton);
            b.setBackground(d);
        }
    }

    public void apStatsSelection(View view){
        stats = !stats;
        if (stats) {
            mathSubjects.add("Statistics");
            Button b = (Button)view;
            Drawable d = getDrawable(R.drawable.selectedbutton);
            b.setBackground(d);
        } else {
            mathSubjects.remove("Statistics");
            Button b = (Button)view;
            Drawable d = getDrawable(R.drawable.selectionbutton);
            b.setBackground(d);
        }
}
    public void nextSelection(View view) {
        saveChanges();
        if(settings) {
            Intent a = new Intent(this, SettingsScreen.class);
            a.putExtra("id", id);
            startActivity(a);
        }
        else{
            Intent i = new Intent(this, Login.class);
            startActivity(i);
        }
    }

    public void saveChanges() {
        firebase.child("users").child(id).child("mathSubjects").setValue(mathSubjects);
    }

    public void goBack(View view) {
        Intent i = new Intent(this, ScienceSubjectSelection.class);
        i.putExtra("id", id);
        startActivity(i);
    }
}
