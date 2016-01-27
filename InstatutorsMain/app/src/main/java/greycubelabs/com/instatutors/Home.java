package greycubelabs.com.instatutors;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Home extends Activity {
    private String s;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Intent i = getIntent();
        s = i.getStringExtra("id");
    }

    public void startDrawer(View view) {
        Intent i = new Intent(this, NavigationDrawer.class);
        i.putExtra("id", s);
        startActivity(i);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
    }
}
