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

public class LiberalArtsSubjectSelection extends Activity {

    private boolean us = false, world = false, lit = false;
    public static boolean settings = false;
    private String id;
    Firebase firebase;
    private Button usB, worldB, litB;
    private ArrayList<String> liberalSubjects;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liberal_arts_subject_selection);

        Intent i = getIntent();
        id = i.getStringExtra("id");

        firebase = new Firebase("https://instatutors.firebaseio.com/");

        usB = (Button)findViewById(R.id.LiberalArtsSelectionUSHistoryButton);
        worldB = (Button)findViewById(R.id.LiberalArtsSelectionWorldHistoryButton);
        litB = (Button)findViewById(R.id.LiberalArtsSelectionLiteratureButton);

        liberalSubjects = new ArrayList<String>();

        if (settings) {
            firebase.child("users").child(id).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    liberalSubjects = dataSnapshot.child("liberalSubjects").getValue(ArrayList.class);
                    for (String i: liberalSubjects) {
                        if (i.equals("US History")) {
                            Drawable d = getDrawable(R.drawable.selectedbutton);
                            usB.setBackground(d);
                            us = true;
                        } else if (i.equals("World History")) {
                            Drawable d = getDrawable(R.drawable.selectedbutton);
                            worldB.setBackground(d);
                            world = true;
                        } else if (i.equals("Literature")) {
                            Drawable d = getDrawable(R.drawable.selectedbutton);
                            litB.setBackground(d);
                            lit = true;
                        }
                    }
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });
        }
    }

    public void usHistorySelection(View view){
        us = !us;
        if (us) {
            liberalSubjects.add("US History");
            Button b = (Button)view;
            Drawable d = getDrawable(R.drawable.selectedbutton);
            b.setBackground(d);
        } else {
            liberalSubjects.remove("US History");
            Button b = (Button)view;
            Drawable d = getDrawable(R.drawable.selectionbutton);
            b.setBackground(d);
        }
    }

    public void worldHistorySelection(View view) {
        world = !world;
        if (world) {
            liberalSubjects.add("World History");
            Button b = (Button)view;
            Drawable d = getDrawable(R.drawable.selectedbutton);
            b.setBackground(d);
        } else {
            liberalSubjects.remove("World History");
            Button b = (Button)view;
            Drawable d = getDrawable(R.drawable.selectionbutton);
            b.setBackground(d);
        }
    }

    public void litSelection(View view) {
        lit = !lit;
        if (lit) {
            liberalSubjects.add("Literature");
            Button b = (Button)view;
            Drawable d = getDrawable(R.drawable.selectedbutton);
            b.setBackground(d);
        } else {
            liberalSubjects.remove("Literature");
            Button b = (Button)view;
            Drawable d = getDrawable(R.drawable.selectionbutton);
            b.setBackground(d);
        }
    }

    public void nextSelection(View view) {
        saveChanges();
        Intent i = new Intent(this, ScienceSubjectSelection.class);
        i.putExtra("id", id);
        startActivity(i);
    }

    public void saveChanges() {
        firebase.child("users").child(id).child("liberalSubjects").setValue(liberalSubjects);
    }

    public void goBack(View view) {
        if (settings) {
            Intent i = new Intent(this, SettingsScreen.class);
            i.putExtra("id", id);
            startActivity(i);
        } else {
            Intent i = new Intent(this, Signup.class);
            i.putExtra("id", id);
            startActivity(i);
        }
    }
}
