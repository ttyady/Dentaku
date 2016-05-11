package com.example.ttyady.dentaku;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

/**
 * Created by ttyady on 2016/05/09.
 */
public class SaveActivity extends AppCompatActivity {
    EditText resultText,storeText,memoText;
    Double result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save);

        resultText = (EditText) findViewById(R.id.resulttext);
        storeText = (EditText) findViewById(R.id.storetext);
        memoText = (EditText) findViewById(R.id.memotext);

        findViewById(R.id.button_save).setOnClickListener(buttonAddListener);
        findViewById(R.id.button_cancel).setOnClickListener(buttonCancelListener);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        result = bundle.getDouble("result");
        resultText.setText(String.valueOf(result));

    }


    View.OnClickListener buttonAddListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            FeedReaderDBHelper mDbHelper = new FeedReaderDBHelper(getApplicationContext());
            SQLiteDatabase db = mDbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put(FeedReaderDBHelper.FeedEntry.COLUMN_NAME_RESULT,result);
            values.put(FeedReaderDBHelper.FeedEntry.COLUMN_NAME_STORE,storeText.getText().toString());
            values.put(FeedReaderDBHelper.FeedEntry.COLUMN_NAME_MEMO,memoText.getText().toString());

            long newRowId;
            newRowId = db.insert(
                    FeedReaderDBHelper.FeedEntry.TABLE_NAME,null,values
            );
            finish();
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