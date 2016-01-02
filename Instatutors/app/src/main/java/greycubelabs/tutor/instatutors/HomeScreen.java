package greycubelabs.tutor.instatutors;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HomeScreen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
    }

    public void SignUpNav(View view){

        Intent intent = new Intent(this, Signup.class);
        startActivity(intent);

    }
    public void SignInNav(View view){
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);

    }



}
