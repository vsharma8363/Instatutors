package greycubelabs.com.instatutors;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;

import greycubelabs.com.instatutors.tutorcarousel.MainActivity;

public class NavigationDrawer extends Activity {
    private static int currentScreen = 0; //0 = home, 1 = main, 2 = settings, 3 = help
    private String id;
    private Firebase firebase;
    private LinearLayout findtutors;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_bar);

        Intent i = getIntent();
        id = i.getStringExtra("id");

        findtutors = (LinearLayout) findViewById(R.id.NavigationSearchTutorSelection);

        firebase = new Firebase("https://instatutors.firebaseio.com/");

        firebase.child("users").child(id).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.child("isTutor").getValue(Boolean.class)) {
                    findtutors.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }

    public void goHome(View view) {
        currentScreen = 0;
        Intent i = new Intent(this, Home.class);
        i.putExtra("id", id);
        startActivity(i);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }

    public void findTutors(View view) {
        currentScreen = 1;
        Intent i = new Intent(this, MainActivity.class);
        i.putExtra("id", id);
        startActivity(i);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }

    public void goSettings(View view) {
        currentScreen = 2;
        Intent i = new Intent(this, SettingsScreen.class);
        i.putExtra("id", id);
        startActivity(i);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }

    public void goHelp(View view) {
        currentScreen = 3;
        Intent i = new Intent(this, HelpScreen.class);
        i.putExtra("id", id);
        startActivity(i);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }

    public void goBack(View view) {
        if (currentScreen == 0) {
            Intent i = new Intent(this, Home.class);
            i.putExtra("id", id);
            startActivity(i);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
        } else if (currentScreen == 1) {
            Intent i = new Intent(this, MainActivity.class);
            i.putExtra("id", id);
            startActivity(i);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
        } else if (currentScreen == 2) {
            Intent i = new Intent(this, SettingsScreen.class);
            i.putExtra("id", id);
            startActivity(i);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
        } else if (currentScreen == 3) {
            Intent i = new Intent(this, HelpScreen.class);
            i.putExtra("id", id);
            startActivity(i);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
        }
    }
}
