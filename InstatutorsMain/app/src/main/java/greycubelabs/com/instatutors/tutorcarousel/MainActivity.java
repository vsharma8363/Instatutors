package greycubelabs.com.instatutors.tutorcarousel;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import greycubelabs.com.instatutors.MathSubjectSelection;
import greycubelabs.com.instatutors.NavigationDrawer;
import greycubelabs.com.instatutors.R;
import greycubelabs.com.instatutors.ScienceSubjectSelection;


public class MainActivity extends FragmentActivity{


	public final static int PAGES = 6;

	// more than 1000 times just in order to test your "infinite" ViewPager :D
	public final static int LOOPS = 1000; 
	public final static int FIRST_PAGE = PAGES * LOOPS / 2;
	public final static float BIG_SCALE = 1.0f;
	public final static float SMALL_SCALE = 0.7f;
	public final static float DIFF_SCALE = BIG_SCALE - SMALL_SCALE;
	
	public MyPagerAdapter adapter;
	public ViewPager pager;

	private Firebase firebase;
	private String id, highSchool;
	private ArrayList<String> mathSubjects;
	private ArrayList<String> scienceSubjects;
	private ArrayList<String> liberalSubjects;

	public void onCreate(Bundle savedInstanceState) {
		Firebase.setAndroidContext(this);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Intent i = getIntent();
		id = i.getStringExtra("id");

		firebase = new Firebase("https://instatutors.firebaseio.com/");

		firebase.child("users").child(id).addValueEventListener(new ValueEventListener() {
			@Override
			public void onDataChange(DataSnapshot dataSnapshot) {
				mathSubjects = dataSnapshot.child("mathSubjects").getValue(ArrayList.class);
				scienceSubjects = dataSnapshot.child("scienceSubjects").getValue(ArrayList.class);
				liberalSubjects = dataSnapshot.child("liberalSubjects").getValue(ArrayList.class);
				highSchool = dataSnapshot.child("school").getValue().toString();
			}
			@Override
			public void onCancelled(FirebaseError firebaseError) {

			}
		});

		findTutors();
		Collections.sort(tutors, new Comparator<String[]>() {
			public int compare(String[] first, String[] second) {
				return Integer.compare(Integer.parseInt(first[1]), Integer.parseInt(second[1]));
			}
		});

		pager = (ViewPager) findViewById(R.id.myviewpager);

		adapter = new MyPagerAdapter(this, this.getSupportFragmentManager(), tutors);
		pager.setAdapter(adapter);
		pager.setOnPageChangeListener(adapter);
		
		
		// Set current item to the middle page so we can fling to both
		// directions left and right
		pager.setCurrentItem(FIRST_PAGE);
		
		// Necessary or the pager will only have one extra page to show
		// make this at least however many pages you can see
		pager.setOffscreenPageLimit(3);
		
		// Set margin for pages as a negative number, so a part of next and 
		// previous pages will be showed
		pager.setPageMargin(-200);
	}

	public void startDrawer(View view) {
		Intent i = new Intent(this, NavigationDrawer.class);
		startActivity(i);
		overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right );
	}

	ArrayList<String[]> tutors = new ArrayList<String[]>();

	public void findTutors() {
		firebase.child("users").addValueEventListener(new ValueEventListener() {
			@Override
			public void onDataChange(DataSnapshot dataSnapshot) {
				ArrayList<String> possible = dataSnapshot.getValue(ArrayList.class);
				for (String id : possible) {
					findNumOfMatches(id);
					if (tempCount > 0) {
						String[] temp = {id, tempCount + ""};
						tutors.add(temp);
					}
				}
			}

			@Override
			public void onCancelled(FirebaseError firebaseError) {

			}
		});
	}

	public int tempCount = 0;

	public void findNumOfMatches(String id) {
		firebase.child("users").child(id).addValueEventListener(new ValueEventListener() {
			@Override
			public void onDataChange(DataSnapshot dataSnapshot) {
				ArrayList<String> tutorMath = dataSnapshot.child("mathSubjects").getValue(ArrayList.class);
				ArrayList<String> tutorScience = dataSnapshot.child("scienceSubjects").getValue(ArrayList.class);
				ArrayList<String> tutorLiberal = dataSnapshot.child("liberalSubjects").getValue(ArrayList.class);
				for (String s: mathSubjects) {
					if (tutorMath.contains(s)) {
						tempCount++;
					}
				}
				for (String s: scienceSubjects) {
					if (tutorScience.contains(s)) {
						tempCount++;
					}
				}
				for (String s: liberalSubjects) {
					if (tutorLiberal.contains(s)) {
						tempCount++;
					}
				}
			}

			@Override
			public void onCancelled(FirebaseError firebaseError) {

			}
		});
	}
}

