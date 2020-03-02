package ru.mobile.calc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class SQLController {
    private MyDBHelper myDBHelper;
    private Context context;
    private SQLiteDatabase database;


    public SQLController(Context context){
        this.context = context;
    }

    public SQLController open(){
        myDBHelper = new MyDBHelper(context);
        database = myDBHelper.getWritableDatabase();
        return this;
    }

    public void close(){
        myDBHelper.close();
    }

    public void insertData(String firstname,String lastname,String height,String weight,String age){
        ContentValues cv = new ContentValues();
        cv.put(MyDBHelper.MEMBER_FIRSTNAME,firstname);
        cv.put(MyDBHelper.MEMBER_LASTNAME,lastname);
        cv.put(MyDBHelper.MEMBER_HEIGHT,height);
        cv.put(MyDBHelper.MEMBER_WEIGHT,weight);
        cv.put(MyDBHelper.MEMBER_AGE,age);
        database.insert(MyDBHelper.TABLE_MEMBER,null,cv);
    }

    public Cursor readEntry() {
        String[] allColumns = new String[] { MyDBHelper.MEMBER_ID, MyDBHelper.MEMBER_FIRSTNAME, MyDBHelper.MEMBER_LASTNAME };
        Cursor c = database.query(MyDBHelper.TABLE_MEMBER, allColumns, null, null, null, null, null);
        if (c != null) {
            c.moveToFirst();
        }
        return c;
    }

//    public void clearTable(){
//        database.execSQL("DROP DATABASE IF EXISTS MEMBER;");
//    }

}
