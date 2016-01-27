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

public class ScienceSubjectSelection extends Activity {

    private boolean phys = false, chem = false, bio = false, cs = false;
    private String id;
    Firebase firebase;
    private Button physB, chemB, bioB, csB;
    public static boolean settings = false;
    private ArrayList<String> scienceSubjects;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_science_subject_selection);

        Intent i = getIntent();
        id = i.getStringExtra("id");

        firebase = new Firebase("https://instatutors.firebaseio.com/");

        physB = (Button)findViewById(R.id.ScienceSelectionPhysicsButton);
        chemB = (Button)findViewById(R.id.ScienceSelectionChemistryButton);
        bioB = (Button)findViewById(R.id.ScienceSelectionBiologyButton);
        csB = (Button)findViewById(R.id.ScienceSelectionComputerScienceButton);

        scienceSubjects = new ArrayList<String>();

        if (settings) {
            firebase.child("users").child(id).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    scienceSubjects = dataSnapshot.child("scienceSubjects").getValue(ArrayList.class);
                    for (String i: scienceSubjects) {
                        if (i.equals("Physics")) {
                            Drawable d = getDrawable(R.drawable.selectedbutton);
                            physB.setBackground(d);
                            phys = true;
                        } else if (i.equals("Chemistry")) {
                            Drawable d = getDrawable(R.drawable.selectedbutton);
                            chemB.setBackground(d);
                            chem = true;
                        } else if (i.equals("Biology")) {
                            Drawable d = getDrawable(R.drawable.selectedbutton);
                            bioB.setBackground(d);
                            bio = true;
                        } else if (i.equals("Computer Science")) {
                            Drawable d = getDrawable(R.drawable.selectedbutton);
                            csB.setBackground(d);
                            cs = true;
                        }
                    }
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });
        }
    }

    public void physicsSelection(View view){
        phys = !phys;
        if (phys) {
            scienceSubjects.add("Physics");
            Button b = (Button)view;
            Drawable d = getDrawable(R.drawable.selectedbutton);
            b.setBackground(d);
        } else {
            scienceSubjects.remove("Physics");
            Button b = (Button)view;
            Drawable d = getDrawable(R.drawable.selectionbutton);
            b.setBackground(d);
        }
    }

    public void chemistrySelection(View view){
        chem = !chem;
        if (chem) {
            scienceSubjects.add("Chemistry");
            Button b = (Button)view;
            Drawable d = getDrawable(R.drawable.selectedbutton);
            b.setBackground(d);
        } else {
            scienceSubjects.remove("Chemistry");
            Button b = (Button)view;
            Drawable d = getDrawable(R.drawable.selectionbutton);
            b.setBackground(d);
        }
    }

    public void biologySelection(View view){
        bio = !bio;
        if (bio) {
            scienceSubjects.add("Biology");
            Button b = (Button)view;
            Drawable d = getDrawable(R.drawable.selectedbutton);
            b.setBackground(d);
        } else {
            scienceSubjects.remove("Biology");
            Button b = (Button)view;
            Drawable d = getDrawable(R.drawable.selectionbutton);
            b.setBackground(d);
        }
    }

    public void csSelection(View view){
        cs = !cs;
        if (cs) {
            scienceSubjects.add("Computer Science");
            Button b = (Button)view;
            Drawable d = getDrawable(R.drawable.selectedbutton);
            b.setBackground(d);
        } else {
            scienceSubjects.remove("Computer Science");
            Button b = (Button)view;
            Drawable d = getDrawable(R.drawable.selectionbutton);
            b.setBackground(d);
        }
    }

    public void saveChanges() {
        firebase.child("users").child(id).child("scienceSubjects").setValue(scienceSubjects);
    }

    public void nextSelection(View view) {
        saveChanges();
        Intent i = new Intent(this, MathSubjectSelection.class);
        i.putExtra("id", id);
        startActivity(i);
    }

    public void goBack(View view){
        Intent i = new Intent(this, LiberalArtsSubjectSelection.class);
        i.putExtra("id", id);
        startActivity(i);
    }
}
