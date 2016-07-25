package com.sakusai.application8429;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

public class knowledge extends AppCompatActivity {

    String c = "0";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_knowledge);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // parent = 事件發生的母體 spinner_items
                // position = 被選擇的項目index = parent.getSelectedItemPosition()
                // id = row id，通常給資料庫使用
                c = getResources().getStringArray(R.array.vdieoaddress)[position];
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    public void rehome(View v){
        Intent intent = new Intent();
        intent.setClass(knowledge.this, home.class);
        startActivity(intent);    //觸發換頁
    }


//    String c ="<html><body><iframe width='320' height='315' src='https://www.youtube.com/embed/E3f0V0jsZ8E?list=PLHLvahYr6PMh9EPrBnZydqtMuQtli0b6m' frameborder='0' allowfullscreen></iframe></body></html>";
    public void tovideo(View v){
        Intent intent = new Intent();
        intent.setClass(knowledge.this, webview.class);
        Bundle bundle = new Bundle();
        bundle.putString("ad", c);//傳遞String
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void tosearch(View v){
        Intent intent = new Intent();
        intent.setClass(knowledge.this , search.class);
        startActivity(intent);
    }

}

