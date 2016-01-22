package greycubelabs.com.instatutors;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

public class ForgotPassword extends Activity {

    Firebase ref;
    EditText EmailPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        EmailPass = (EditText)findViewById(R.id.ForgotPasswordEmailInput);
        ref = new Firebase("https://instatutors.firebaseio.com");
    }

    public void ResetPassword(View view){

        ref.resetPassword(EmailPass.toString(), new Firebase.ResultHandler() {
            @Override
            public void onSuccess() {

                Toast.makeText(ForgotPassword.this, "An email has been sent to you, with a password redemption link",
                        Toast.LENGTH_LONG).show();

            }
            @Override
            public void onError(FirebaseError firebaseError) {

                Toast.makeText(ForgotPassword.this, "There was an error, please try again",
                        Toast.LENGTH_LONG).show();            }
        });    }
}
