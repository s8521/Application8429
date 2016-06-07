package com.sakusai.application8429;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Photocomparison extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photocomparison);
    }

    public void rehome(View v){
        Intent intent = new Intent();
        intent.setClass(Photocomparison.this , home.class);
        startActivity(intent);
        finish();
    }
}
