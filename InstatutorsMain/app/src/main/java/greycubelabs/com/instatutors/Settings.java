package greycubelabs.com.instatutors;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Settings extends Activity{

    private EditText school;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

    }

    public void submitChanges(View view) {

    }
}
