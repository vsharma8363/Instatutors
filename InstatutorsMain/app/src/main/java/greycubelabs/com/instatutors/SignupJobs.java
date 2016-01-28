package greycubelabs.com.instatutors;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;



public class SignupJobs extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_job_selection);
    }

    public void BeATutor(View view){
        Intent i = new Intent(this, Signup.class);
        i.putExtra("tutor", true);
        startActivity(i);
    }
    public void BeATutee(View view){
        Intent i = new Intent(this, Signup.class);
        i.putExtra("tutor", false);
        startActivity(i);

    }
}
