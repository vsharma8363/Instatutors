package greycubelabs.tutor.instatutors;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class HomeScreen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);

//Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_home_screen);
    }

    public void SignUpNav(View view){
        Intent intent = new Intent(this, JobSelection.class);
        startActivity(intent);
    }
    public void SignInNav(View view){
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }



}
