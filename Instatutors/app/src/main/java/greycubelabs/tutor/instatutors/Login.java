package greycubelabs.tutor.instatutors;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

public class Login extends AppCompatActivity {

    EditText Email;
    EditText Password;
    TextView WarningLogin;
    TextView ForgotAccount;
    Intent Login;
    Firebase myFirebaseRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Firebase.setAndroidContext(this);
        myFirebaseRef = new Firebase("https://instatutors.firebaseio.com/");
        setContentView(R.layout.activity_login);
        Password = (EditText) findViewById(R.id.PasswordLogin);
        Email = (EditText) findViewById(R.id.EmailLogin);
        WarningLogin = (TextView) findViewById(R.id.WarningLogin);
        WarningLogin.setTextColor(Color.BLUE);
        ForgotAccount = (TextView) findViewById(R.id.ForgotAccount);
        ForgotAccount.setTextColor(Color.BLUE);
        Login = new Intent(this, HomeDashboard.class);
    }

    public void SubmitLogin(View view) {

        myFirebaseRef.authWithPassword(Email.getText().toString(),
                Password.getText().toString(), new Firebase.AuthResultHandler() {

                    @Override
                    public void onAuthenticated(AuthData authData) {

                        Login.putExtra("Email", Email.toString());
                        Login.putExtra("Password", Password.toString());
                        startActivity(Login);
                    }
                    @Override
                    public void onAuthenticationError(FirebaseError firebaseError) {
                        //Create alert with firebaseError.getMessage()
                        AlertDialog.Builder builder1 = new AlertDialog.Builder(Login.this);
                        builder1.setMessage(firebaseError.getMessage());
                        builder1.setCancelable(true);
                        builder1.setPositiveButton("Ok",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });
                    }

                });
    }

    public void NoAccount(View view){
        Intent i = new Intent(this, Signup.class);
        startActivity(i);
    }

    public void ForgotAccount(View view){
        Uri uri = Uri.parse("http://www.google.com"); // missing 'http://' will cause crashed
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);    }

}
