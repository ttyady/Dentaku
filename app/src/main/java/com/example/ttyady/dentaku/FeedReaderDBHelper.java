package com.example.ttyady.dentaku;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by ttyady on 2016/05/12.
 */
public class FeedReaderDBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "FeedReader.db";

    public FeedReaderDBHelper(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db){
        db.execSQL(SQL_CREATE_ENTRIES);
    }
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db,int oldVersion,int newVersion) {
        onUpgrade(db,oldVersion,newVersion);
    }

    public static abstract class FeedEntry implements BaseColumns {
        public static final String TABLE_NAME = "entry";
        public static final String COLUMN_NAME_RESULT = "result";
        public static final String COLUMN_NAME_STORE = "store";
        public static final String COLUMN_NAME_MEMO = "memo";
    }
    private static final String TEXT_TYPE = "TEXT";
    private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE "+FeedEntry.TABLE_NAME+" ("+
                    FeedEntry._ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                    FeedEntry.COLUMN_NAME_RESULT+ TEXT_TYPE+COMMA_SEP+
                    FeedEntry.COLUMN_NAME_STORE+ TEXT_TYPE+COMMA_SEP+
                    FeedEntry.COLUMN_NAME_MEMO+ TEXT_TYPE+" )";

    private static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS" + FeedEntry.TABLE_NAME;
}
