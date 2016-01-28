package greycubelabs.com.instatutors.tutorcarousel;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.net.URL;
import java.util.ArrayList;

import greycubelabs.com.instatutors.R;

public class MyFragment extends Fragment {
	public static Fragment newInstance(MainActivity context, int pos,
									   float scale, ArrayList<String> tutors)
	{
		Bundle b = new Bundle();
		b.putInt("pos", pos);
		b.putFloat("scale", scale);
		b.putStringArrayList("tutors", tutors);
		return Fragment.instantiate(context, MyFragment.class.getName(), b);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		if (container == null) {
			return null;
		}

		Firebase firebase = new Firebase("https://instatutors.firebaseio.com/");

		final LinearLayout l = (LinearLayout)
				inflater.inflate(R.layout.mf, container, false);

		/*TextView tv = (TextView) l.findViewById(R.id.text);
		TextView Content = (TextView) l.findViewById(R.id.TextViewTutor);
		ImageButton Button = (ImageButton) l.findViewById(R.id.content);
		int pos = this.getArguments().getInt("pos");*/
		
		int pos = this.getArguments().getInt("pos");
		ArrayList<String> tutors = this.getArguments().getStringArrayList("tutors");

		String currentID = tutors.get(pos);

		firebase.child("users").child(currentID).addValueEventListener(new ValueEventListener() {
			@Override
			public void onDataChange(DataSnapshot dataSnapshot) {
				TextView tv = (TextView) l.findViewById(R.id.text);
				TextView Content = (TextView) l.findViewById(R.id.TextViewTutor);
				ImageButton Button = (ImageButton) l.findViewById(R.id.content);
				tv.setText(dataSnapshot.child("full_name").getValue(String.class));
				Content.setText("Hi, my name's Bryce, I'm a junior at Homestead High School in California. I teach Computer Programming, and Physics. Tap on my face to send me an email, and get in touch with me.");
				Button.setImageResource(R.drawable.goku);
				Button.setOnClickListener(new View.OnClickListener() {
					public void onClick(View v) {
						EmailSomeone();
					}
				});
			}
			@Override
			public void onCancelled(FirebaseError firebaseError) {

			}
		});


		/*if(pos == 0){
			tv.setText("Bryce Rausch");
		Button.setImageResource(R.drawable.goku);
			Content.setText("Hi, my name's Bryce, I'm a junior at Homestead High School in California. I teach Computer Programming, and Physics. Tap on my face to send me an email, and get in touch with me.");
			Button.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					EmailSomeone();
				}
			});
		}
		if(pos == 1){
			tv.setText("Sahaj Putcha");
		Button.setImageResource(R.drawable.mario);
			Content.setText("Hi, my name's Sahaj, I'm a sophmore at Homestead High School in California. I teach Computer Programming, and Physics. Tap on my face to send me an email, and get in touch with me.");
			Button.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					EmailSomeone();
				}
			});
		}
		if(pos == 2){
			tv.setText("Nishant Yadav");
		Button.setImageResource(R.drawable.fett);
					Content.setText("Hi, my name's Nishant, I'm a sophmore at Homestead High School in California. I teach Spanish and Math. Tap on my face to send me an email, and get in touch with me.");
					Button.setOnClickListener(new View.OnClickListener() {
						public void onClick(View v) {
							EmailSomeone();
				}
			});
		}
		if(pos == 3){
			tv.setText("Michael Chen");
		Button.setImageResource(R.drawable.goku);
			Content.setText("Hi, my name's Michael, I'm a sophmore at Homestead High School in California. I teach Computer Science and Math. Tap on my face to send me an email, and get in touch with me.");
			Button.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					EmailSomeone();
				}
			});
		}
		if(pos == 4){
			tv.setText("Jonathan Abigyan");
			Button.setImageResource(R.drawable.fett);
			Content.setText("Hi, my name's John, I'm a sophmore at Homestead High School in California. I teach Computer Algorithms and Science. Tap on my face to send me an email, and get in touch with me.");
			Button.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					EmailSomeone();
				}
			});
		}
		if(pos == 5){
			tv.setText("Bruce Wayne");
			Button.setImageResource(R.drawable.mario);
			Content.setText("Hi, my name's Bruce, I'm a Senior at Homestead High School in California. I teach Computer Science and Martial Arts. Tap on my face to send me an email, and get in touch with me.");
			Button.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					EmailSomeone();
				}
			});
		}*/
		MyLinearLayout root = (MyLinearLayout) l.findViewById(R.id.root);
		float scale = this.getArguments().getFloat("scale");
		root.setScaleBoth(scale);
		
		return l;
	}

	public void EmailSomeone(){
		Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
				"mailto", "viksurf@gmail.com", null));
		emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Someone wants you as a tutor");
		startActivity(Intent.createChooser(emailIntent, "send email and email when you are free to tutor him, he wants to be a tutor"));

		Context context = getContext();
		CharSequence text = "An email message has been sent to this tutor with your contact information, they will get in touch within a few days";
		int duration = Toast.LENGTH_LONG;

		Toast toast = Toast.makeText(context, text, duration);
		toast.show();

	}


}
