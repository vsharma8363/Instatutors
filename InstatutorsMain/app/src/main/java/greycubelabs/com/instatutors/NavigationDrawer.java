package greycubelabs.com.instatutors;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import greycubelabs.com.instatutors.tutorcarousel.MainActivity;

public class NavigationDrawer extends Activity {
    private static int currentScreen = 0; //0 = home, 1 = main, 2 = settings, 3 = help
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.navigation_bar);
    }

    public void goHome(View view) {
        currentScreen = 0;
        Intent i = new Intent(this, Home.class);
        startActivity(i);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }

    public void findTutors(View view) {
        currentScreen = 1;
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }

    public void goSettings(View view) {
        currentScreen = 2;
        Intent i = new Intent(this, SettingsScreen.class);
        startActivity(i);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }

    public void goHelp(View view) {
        currentScreen = 3;
        Intent i = new Intent(this, HelpScreen.class);
        startActivity(i);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }

    public void goBack(View view) {
        if (currentScreen == 0) {
            Intent i = new Intent(this, Home.class);
            startActivity(i);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
        } else if (currentScreen == 1) {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
        } else if (currentScreen == 2) {
            Intent i = new Intent(this, SettingsScreen.class);
            startActivity(i);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
        } else if (currentScreen == 3) {
            Intent i = new Intent(this, HelpScreen.class);
            startActivity(i);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
        }
    }
}
