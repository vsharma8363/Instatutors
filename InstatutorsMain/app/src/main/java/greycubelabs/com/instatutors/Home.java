package greycubelabs.com.instatutors;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;

public class Home extends Activity {
    private String s;
    private Firebase firebase;
    private TextView name, school;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Intent i = getIntent();
        s = i.getStringExtra("id");

        name = (TextView) findViewById(R.id.HomeName);
        school = (TextView) findViewById(R.id.HomeSchool);

        firebase = new Firebase("https://instatutors.firebaseio.com/");

        firebase.child("users").child(s).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                name.setText(dataSnapshot.child("full_name").getValue(String.class));
                school.setText(dataSnapshot.child("school").getValue(String.class));
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }

    public void startDrawer(View view) {
        Intent i = new Intent(this, NavigationDrawer.class);
        i.putExtra("id", s);
        startActivity(i);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
    }
}
