package greycubelabs.tutor.instatutors;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

public class Credentials extends AppCompatActivity {

    Firebase ref;
    EditText EmailUser;
    EditText Old;
    EditText New;
    EditText NewConf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        EmailUser = (EditText)findViewById(R.id.EmailChoosePass);
        Old = (EditText)findViewById(R.id.OldPassword);
        Old = (EditText)findViewById(R.id.OldPassword);
        New = (EditText)findViewById(R.id.NewPassword);
        NewConf = (EditText)findViewById(R.id.NewPasswordConfirm);
        Firebase ref = new Firebase("https://instatutors.firebaseio.com");
    }

    public void ChangingTheFuture(View view){


        ref.changePassword(EmailUser.toString(), Old.toString(), New.toString(), new Firebase.ResultHandler() {
            @Override
            public void onSuccess() {

                Toast.makeText(Credentials.this, "You have changed your password",
                        Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Credentials.this, Login.class);
                startActivity(intent);

            }
            @Override
            public void onError(FirebaseError firebaseError) {

                Toast.makeText(Credentials.this, "There was an error, please try again",
                        Toast.LENGTH_LONG).show();

            }
        });

    }

}
