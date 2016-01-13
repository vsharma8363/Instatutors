package greycubelabs.com.instatutors.tutorcarousel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.firebase.client.Firebase;

import java.net.URL;

import greycubelabs.com.instatutors.R;

public class MyFragment extends Fragment {
	
	public static Fragment newInstance(MainActivity context, int pos, 
			float scale)
	{
		Bundle b = new Bundle();
		b.putInt("pos", pos);
		b.putFloat("scale", scale);
		return Fragment.instantiate(context, MyFragment.class.getName(), b);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		if (container == null) {
			return null;
		}
		
		LinearLayout l = (LinearLayout) 
				inflater.inflate(R.layout.mf, container, false);
		
		int pos = this.getArguments().getInt("pos");
		TextView tv = (TextView) l.findViewById(R.id.text);
		TextView Content = (TextView) l.findViewById(R.id.TextViewTutor);
		ImageButton Button = (ImageButton) l.findViewById(R.id.content);

		if(pos == 0){
			tv.setText("Bryce Rausch");
			Glide.with(this).load("http://www.greycubelabs.com/instatutors/person1/img.png").into(Button);
			Content.setText("Hi, my name's Bryce, I'm a junior at Homestead High School in California. I teach Computer Programming, and Physics. Tap on my face to send me an email, and get in touch with me.");
			Button.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					// Perform action on click



					// currentContext.startActivity(activityChangeIntent);

				}
			});

		}

		if(pos == 1){
			tv.setText("Sahaj Putcha");
			Glide.with(this).load("http://www.greycubelabs.com/instatutors/person2/img.png").into(Button);
			Content.setText("Hi, my name's Sahaj, I'm a sophmore at Homestead High School in California. I teach Computer Programming, and Physics. Tap on my face to send me an email, and get in touch with me.");
			Button.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					// Perform action on click


					// currentContext.startActivity(activityChangeIntent);

				}
			});

	}

		if(pos == 2){
			tv.setText("Nishant Yadav");
					Glide.with(this).load("http://www.greycubelabs.com/instatutors/person3/img.png").into(Button);
					Content.setText("Hi, my name's Nishant, I'm a sophmore at Homestead High School in California. I teach Spanish and Math. Tap on my face to send me an email, and get in touch with me.");
					Button.setOnClickListener(new View.OnClickListener() {
						public void onClick(View v) {



				}
			});

		}

		if(pos == 3){
			tv.setText("Michael Chen");
			Glide.with(this).load("http://www.greycubelabs.com/instatutors/person4/img.png").into(Button);
			Content.setText("Hi, my name's Michael, I'm a sophmore at Homestead High School in California. I teach Computer Science and Math. Tap on my face to send me an email, and get in touch with me.");
			Button.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {


				}

			});


		}
		MyLinearLayout root = (MyLinearLayout) l.findViewById(R.id.root);
		float scale = this.getArguments().getFloat("scale");
		root.setScaleBoth(scale);
		
		return l;
	}
}
