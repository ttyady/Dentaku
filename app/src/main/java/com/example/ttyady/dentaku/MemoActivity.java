package com.example.ttyady.dentaku;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

/**
 * Created by ttyady on 2016/05/12.
 */
public class MemoActivity extends MainActivity {
    ListView myListView;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.memo);
        FeedReaderDBHelper mDbHelper = new FeedReaderDBHelper(getApplicationContext());
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        String[] projection = {
                FeedReaderDBHelper.FeedEntry._ID,
                FeedReaderDBHelper.FeedEntry.COLUMN_NAME_RESULT,
                FeedReaderDBHelper.FeedEntry.COLUMN_NAME_STORE,
                FeedReaderDBHelper.FeedEntry.COLUMN_NAME_MEMO
        };

        String sortOrder = FeedReaderDBHelper.FeedEntry._ID+" DESC";

        Cursor c = db.query(
                FeedReaderDBHelper.FeedEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                sortOrder
        );

        c.moveToFirst();
        long itemId = c.getLong(
                c.getColumnIndexOrThrow(FeedReaderDBHelper.FeedEntry._ID)
        );

        myListView = (ListView)findViewById(R.id.itemListView);

        String[] from = {"result","store","memo"};
        int[] to = {android.R.id.text1,android.R.id.text2};
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,android.R.layout.simple_list_item_2,c,from,to,0);
        myListView.setAdapter(adapter);
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
                String s1 = ((TextView)view.findViewById(android.R.id.text1)).getText().toString();
                String s2 = ((TextView)view.findViewById(android.R.id.text2)).getText().toString();
            }

        });




    }

}
