package greycubelabs.com.instatutors;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import greycubelabs.com.instatutors.tutorcarousel.MainActivity;


public class Signup extends Activity implements AdapterView.OnItemSelectedListener {

    EditText FirstName, LastName;
    EditText Password;
    EditText ConfirmPassword;
    EditText Email;
    Firebase myFirebaseRef;
    String userID, school;
    Spinner dropdown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Firebase.setAndroidContext(this);
        myFirebaseRef = new Firebase("https://instatutors.firebaseio.com/");
        setContentView(R.layout.activity_signup);
        Password = (EditText) findViewById(R.id.SignUpPasswordInput);
        ConfirmPassword = (EditText) findViewById(R.id.SignUpPasswordConfirm);
        FirstName = (EditText) findViewById(R.id.SignUpFirstNameInput);
        LastName = (EditText) findViewById(R.id.SignUpLastNameInput);
        Email = (EditText) findViewById(R.id.SignUpEmailInput);
        dropdown = (Spinner)findViewById(R.id.SignUpHighSchool);
        String[] items = new String[]{"Select from Available High Schools", "Homestead High School"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);
    }

    public void nextScreen() {
        Intent i = new Intent(this, LiberalArtsSubjectSelection.class);
        i.putExtra("id", userID);
        startActivity(i);
    }

    public void SubmitSignup(View view) {
            if (!valid() && Password.getText().toString().equals(ConfirmPassword.getText().toString())) {
                MakeAUser();
            } else {
                Toast.makeText(Signup.this, "All text fields must be full, " +
                                "Passwords must match as well",
                        Toast.LENGTH_SHORT).show();

                Password.setText(null);
                ConfirmPassword.setText(null);
            }
    }

    public void HaveAnAccount(View view) {
        Intent i = new Intent(this, Login.class);
        startActivity(i);
    }
    public void MakeAUser() {
        myFirebaseRef.createUser(Email.getText().toString(),
                Password.getText().toString(), new Firebase.ResultHandler() {
                    @Override
                    public void onSuccess() {
                        myFirebaseRef.authWithPassword(Email.getText().toString(),
                                Password.getText().toString(), new Firebase.AuthResultHandler() {
                                    @Override
                                    public void onAuthenticated(AuthData authData) {

                                        myFirebaseRef.child("users").child(authData.getUid()).child("full_name")
                                                .setValue(FirstName.getText().toString() + " " + LastName.getText().toString());
                                        myFirebaseRef.child("users").child(authData.getUid()).child("email")
                                                .setValue(Email.getText().toString());
                                        myFirebaseRef.child("users").child(authData.getUid()).child("school")
                                                .setValue(Email.getText().toString());

                                        Toast.makeText(Signup.this, "Success, your account was made!",
                                                Toast.LENGTH_SHORT).show();

                                        userID = authData.getUid();

                                        nextScreen();
                                    }
                                    @Override
                                    public void onAuthenticationError(FirebaseError firebaseError) {
                                        //Auth Error
                                        Toast.makeText(Signup.this, firebaseError.getMessage(), Toast.LENGTH_SHORT).show();
                                    }
                                });
                    }
                    @Override
                    public void onError(FirebaseError firebaseError) {

                        Toast.makeText(Signup.this, firebaseError.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
    private boolean valid() {
        if (Email.getText().length() == 0 || FirstName.getText().length() == 0 || LastName.getText().length() == 0 || Password.getText().length() == 0)
            return true;

        String first = FirstName.getText().toString();
        String last = LastName.getText().toString();
        String pass = Password.getText().toString();

        for (int i = 0; i < FirstName.getText().length(); i++) {
            if (!(first.charAt(i) >= 65 && first.charAt(i) <= 90 || first.charAt(i) >= 97 && first.charAt(i) <= 122)) {
                return true;
            }
        }

        for (int i = 0; i < LastName.getText().length(); i++) {
            if (!(last.charAt(i) >= 65 && last.charAt(i) <= 90 || last.charAt(i) >= 97 && last.charAt(i) <= 122)) {
                return true;
            }
        }

        for (int i = 0; i < Password.getText().length(); i++) {
            if (!(pass.charAt(i) >= 65 && pass.charAt(i) <= 90 || pass.charAt(i) >= 97 && pass.charAt(i) <= 122)) {
                return true;
            }
        }

        return false;
    }

    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
        if (position > 0) {
            school = parent.getItemAtPosition(position).toString();
        }
    }

    public void onNothingSelected(AdapterView<?> arg0) {

    }
}