package ru.mobile.calc;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBHelper extends SQLiteOpenHelper {
    public static final String TABLE_MEMBER = "member";
    public static final String MEMBER_ID = "_id";
    public static final String MEMBER_FIRSTNAME = "firstname";
    public static final String MEMBER_LASTNAME = "lastname";
    public static final String MEMBER_HEIGHT = "height";
    public static final String MEMBER_WEIGHT = "weight";
    public static final String MEMBER_AGE = "age";

    static final String DB_NAME = "MEMBER.DB";
    static final int DB_VERSION = 1;

    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_MEMBER
            + "("
            + MEMBER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + MEMBER_FIRSTNAME + " TEXT NOT NULL,"
            + MEMBER_LASTNAME + " TEXT NOT NULL,"
            + MEMBER_HEIGHT + " TEXT NOT NULL,"
            + MEMBER_WEIGHT + "TEXT,"
            + MEMBER_AGE + " TEXT NOT NULL);";


    public MyDBHelper(Context context){
        super(context,DB_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MEMBER);
    }

}
