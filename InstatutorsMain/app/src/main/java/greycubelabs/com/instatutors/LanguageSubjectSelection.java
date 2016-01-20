package greycubelabs.com.instatutors;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LanguageSubjectSelection extends AppCompatActivity {
    private boolean spanish= false, french = false, chinese = false,japanese;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language_subject_selection);
    }
    public void spanishSelection(View view){
        spanish = !spanish;
        if (spanish) {
            Button b = (Button)view;
            Drawable d = getDrawable(R.drawable.selectedbutton);
            b.setBackground(d);
        } else {
            Button b = (Button)view;
            Drawable d = getDrawable(R.drawable.selectionbutton);
            b.setBackground(d);
        }
    }

    public void chineseSelection(View view) {
        chinese = !chinese;
        if (chinese) {
            Button b = (Button)view;
            Drawable d = getDrawable(R.drawable.selectedbutton);
            b.setBackground(d);
        } else {
            Button b = (Button)view;
            Drawable d = getDrawable(R.drawable.selectionbutton);
            b.setBackground(d);
        }
    }

    public void frenchSelection(View view) {
        french = !french;
        if (french) {
            Button b = (Button)view;
            Drawable d = getDrawable(R.drawable.selectedbutton);
            b.setBackground(d);
        } else {
            Button b = (Button)view;
            Drawable d = getDrawable(R.drawable.selectionbutton);
            b.setBackground(d);
        }
    }
    public void japaneseSelection(View view) {
        japanese = !japanese;
        if (japanese) {
            Button b = (Button)view;
            Drawable d = getDrawable(R.drawable.selectedbutton);
            b.setBackground(d);
        } else {
            Button b = (Button)view;
            Drawable d = getDrawable(R.drawable.selectionbutton);
            b.setBackground(d);
        }
    }
}
