package greycubelabs.com.instatutors;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class HelpScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_screen);
    }
    public void EmailSomeone(){
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto", "instatutors@gmail.com", null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Suggestions for the app");
        startActivity(Intent.createChooser(emailIntent, "I have Suggestions/Problems with the Instatutors app."));
    }

    public void startDrawer(View view) {
        Intent i = new Intent(this, NavigationDrawer.class);
        startActivity(i);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
    }
}
