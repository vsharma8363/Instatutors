package com.example.sahaj.tutor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;

public class Information extends AppCompatActivity{
    private boolean isTutor;
    private boolean isTutee;
    private boolean groupStudy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
    }
    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.tutor:
                if (checked) {
                    isTutor = true;

                }
                break;
            case R.id.tutee:
                if (checked) {
                    isTutee = true;

                }
                break;
            case R.id.groupStudy:
                if (checked) {
                    groupStudy = true;

                }
                break;
        }
    }

}