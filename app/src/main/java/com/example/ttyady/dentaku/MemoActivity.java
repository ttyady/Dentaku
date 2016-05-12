package com.example.ttyady.dentaku;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by ttyady on 2016/05/12.
 */
public class MemoActivity extends MainActivity {

    protected Cursor cursor;
    protected ListAdapter adapter;
    protected ListView memoList;
    @Override
    public void onCreate(Bundle savedInstanceState){
        Log.e("part","part");
        //findViewById(R.id.button_cancel2).setOnClickListener(buttonCancelListener);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo);

        FeedReaderDBHelper mDbHelper = new FeedReaderDBHelper(getApplicationContext());
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        /*db.execSQL("insert into entry(store,memo) values ('koko','soko');")*/;

       // String text = "";
        Log.e("part1","part1");
        StringBuilder text;
        try {
            Cursor c = db.query(FeedReaderDBHelper.FeedEntry.TABLE_NAME, null, null, null, null, null, null);
            text = new StringBuilder();
            while(c.moveToNext()){
                text.append(cursor.getInt(0));
                text.append("," + cursor.getString(1));
                text.append("," + cursor.getString(2));
                text.append("," + cursor.getString(3));
                text.append("\n");Log.e("part2","part2");
            }
        }finally {
            db.close();
        }
        TextView textView1 = (TextView)findViewById(R.id.textView1);
        textView1.setText(text);
        /*boolean isEof = c.moveToFirst();

        while(isEof){
            text += c.getDouble(0)+c.getString(1)+c.getString(2);
            isEof=c.moveToNext();
        }
        TextView textView1 = (TextView)findViewById(R.id.textView1);
        textView1.setText(text);
        */
       /* StringBuilder viewview = new StringBuilder();

        while (c.moveToNext()){
            viewview.append(c.getInt(0));
            viewview.append(","+c.getDouble(1));
            viewview.append(","+c.getString(2));
            viewview.append(","+c.getString(3));
            viewview.append("\n");
        }

*/
        //memoList.setAdapter(new SimpleCursorAdapter(this,R.layout.memo,
        //        c,
        //       new String[]{FeedReaderDBHelper.FeedEntry.COLUMN_NAME_RESULT, FeedReaderDBHelper.FeedEntry.COLUMN_NAME_STORE, FeedReaderDBHelper.FeedEntry.COLUMN_NAME_MEMO},
        //     new int[]{R.id.result,R.id.store,R.id.memo}));

    }
    View.OnClickListener buttonCancelListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    };
}
