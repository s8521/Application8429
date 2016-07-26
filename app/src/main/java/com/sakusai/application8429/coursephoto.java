package com.sakusai.application8429;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class coursephoto extends AppCompatActivity {

    String f = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coursephoto);
    }
    EditText editText13 = (EditText)findViewById(R.id.editText13);
    int x =Integer.parseInt(editText13.getText().toString());

    public void toCourseresults(View v){
        Intent intent = new Intent();
        intent.setClass(coursephoto.this, Courseresults.class);
        Bundle bundle = new Bundle();
        bundle.putInt("ac", x);//傳遞Int
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
