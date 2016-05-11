package com.example.ttyady.dentaku;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by ttyady on 2016/05/09.
 */
public class SaveActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save);

        findViewById(R.id.button_save).setOnClickListener(buttonAddListener);
        findViewById(R.id.button_cancel).setOnClickListener(buttonCancelListener);

    }


    View.OnClickListener buttonAddListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        }
    };

    View.OnClickListener buttonCancelListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    };
}





/*
 @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textview);
        editText = (EditText) findViewById(R.id.edittext);
        button = (Button) findViewById(R.id.button_clear);
        button.setOnClickListener(buttonListener);

        findViewById(R.id.button_1).setOnClickListener(buttonNumberListener);
        findViewById(R.id.button_2).setOnClickListener(buttonNumberListener);
        findViewById(R.id.button_3).setOnClickListener(buttonNumberListener);
 */