package greycubelabs.com.instatutors;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import greycubelabs.com.instatutors.tutorcarousel.*;

public class Login extends Activity {

    EditText Email;
    EditText Password;
    TextView WarningLogin;
    TextView ForgotAccount;
    Intent Login;
    Firebase myFirebaseRef;
    TextView FailedLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        Firebase.setAndroidContext(this);
        myFirebaseRef = new Firebase("https://instatutors.firebaseio.com/");
        //Remove title bar

//Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

//set content view AFTER ABOVE sequence (to avoid crash)
        this.setContentView(R.layout.activity_login);
        Password = (EditText) findViewById(R.id.LoginPassword);
        FailedLogin = (TextView) findViewById(R.id.LoginFailLabel);
        Email = (EditText) findViewById(R.id.LoginEmail);
        WarningLogin = (TextView) findViewById(R.id.LoginWarning);
        ForgotAccount = (TextView) findViewById(R.id.LoginForgotAccount);
        TextView title = (TextView) findViewById(R.id.LoginTitle);
        TextView login = (TextView) findViewById(R.id.LoginTextDivider);
        Button b = (Button) findViewById(R.id.LoginSubmit);
        /*Typeface type = Typeface.createFromAsset(getAssets(),"Raleway.ttf");
        Password.setTypeface(type);
        WarningLogin.setTypeface(type);
        ForgotAccount.setTypeface(type);
        Email.setTypeface(type);
        title.setTypeface(type);
        login.setTypeface(type);*/
    }

    public void SubmitLogin(View view) {

        startScreen();

        myFirebaseRef.authWithPassword(Email.getText().toString(),
                Password.getText().toString(), new Firebase.AuthResultHandler() {

                    @Override
                    public void onAuthenticated(AuthData authData) {



                        Toast.makeText(Login.this, "You have been logged in",
                                Toast.LENGTH_SHORT).show();







                    }
                    @Override
                    public void onAuthenticationError(FirebaseError firebaseError) {
                        //Create alert with firebaseError.getMessage()

                        /*Toast.makeText(Login.this, "There has been a login error, please change your username and/or password",
                                Toast.LENGTH_LONG).show();

                        AlertDialog.Builder builder1 = new AlertDialog.Builder(Login.this);
                        builder1.setMessage(firebaseError.getMessage());
                        builder1.setCancelable(true);
                        builder1.setPositiveButton("Ok",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });*/
                        failedLogin();
                    }

                });
    }

    public void failedLogin() {
        FailedLogin.setVisibility(View.VISIBLE);
        Drawable d = getDrawable(R.drawable.failedborder);
        Email.setBackground(d);
        Password.setBackground(d);
    }

    public void NoAccount(View view){
        Intent i = new Intent(this, SignupJobs.class);
        startActivity(i);
    }

    public void ForgotAccount(View view){
        Intent i = new Intent(this, ForgotPassword.class);
        startActivity(i);
    }

    public void startScreen()
    {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

}
