package greycubelabs.com.instatutors;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class StartScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);
    }

    public void StartService(View view){
        Intent i = new Intent(this, SignupJobs.class);
        startActivity(i);
    }



}
