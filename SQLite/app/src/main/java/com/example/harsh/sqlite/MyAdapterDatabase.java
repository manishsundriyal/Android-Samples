package com.example.harsh.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by harsh on 10/20/17.
 */


public class MyAdapterDatabase {
    MyHelper myHelper;

    MyAdapterDatabase(Context context){
        myHelper= new MyHelper(context);


    }
    public long insertData(String name, String password){

        SQLiteDatabase sqLiteDatabase=myHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        //variables are all private and I can access
        //them from the outer class
        //without showing them to the world
        contentValues.put(MyHelper.NAME,name);
        contentValues.put(MyHelper.PASSWORD,password);

        long id=sqLiteDatabase.insert(MyHelper.TABLE_NAME,null,contentValues);


        return id;
        //we can put more fields here


    }

    public String getAllData(){
        SQLiteDatabase database=myHelper.getWritableDatabase();
        String[] columns={MyHelper.UID,MyHelper.NAME,MyHelper.PASSWORD};

        Cursor cursor=database.query(MyHelper.TABLE_NAME,columns,null,null,null,null,null);

        StringBuffer buffer=new StringBuffer();
        while (cursor.moveToNext()){

            int index1=cursor.getColumnIndex(MyHelper.UID);
            int cid=cursor.getInt(index1);

            String name=cursor.getString(cursor.getColumnIndex(MyHelper.NAME));
            String password=cursor.getString(cursor.getColumnIndex(MyHelper.PASSWORD));

            buffer.append(cid + " "+name+" "+password+"\n");

        }
        return buffer.toString();
    }

    public String getData(String n,String p){
        //select name, password from temptavle where name='ABCD';

        SQLiteDatabase database=myHelper.getWritableDatabase();
        String[] columns={MyHelper.UID};

        String[] selectionArgs={n,p};
        Cursor cursor=database.query(MyHelper.TABLE_NAME,columns,MyHelper.NAME+ " =? AND "+MyHelper.PASSWORD+" =?",selectionArgs,null,null,null);

        StringBuffer buffer=new StringBuffer();
        while (cursor.moveToNext()){
            int index0=cursor.getColumnIndex(MyHelper.UID);


            int personId=cursor.getInt(index0);

            buffer.append(personId+"\n");

        }
        return buffer.toString();

    }


    public int updateName(String oldName,String newName){
        SQLiteDatabase database=myHelper.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(MyHelper.NAME,newName);

        String[] whereArgs= {oldName};
        int count=database.update(MyHelper.TABLE_NAME,contentValues,
                MyHelper.NAME+" =?",whereArgs);

        return count;
    }

    public int deleteRow(String n){
        SQLiteDatabase database=myHelper.getWritableDatabase();
        String[] whereArgs={n};
        int count=database.delete(MyHelper.TABLE_NAME,MyHelper.NAME + " =?",whereArgs);
        return count;
    }

    //principle of least privelage
    //If this is a normal class
    //it can access outer class's non static members
    //Also a non static class will exist for
    //every instance of the outer class's object
    static class MyHelper extends SQLiteOpenHelper {

        Context context;
        private static final String DATABASE_NAME = "tempbase";
        private static final String TABLE_NAME = "temptable";
        private static final int DATABASE_VERSION = 1;
        private static final String UID = "_id";
        private static final String NAME = "Name";
        private static final String PASSWORD="Password";
        private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" + UID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME + " VARCHAR(255), " +PASSWORD+" VARCHAR(255));";

        private static final String DROP_TABLE = "DROP TABLE IF EXISTS "+TABLE_NAME;

        public MyHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            this.context = context;
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            try {
                sqLiteDatabase.execSQL(CREATE_TABLE);
            } catch (SQLException e) {
//            e.printStackTrace();
                Message.message(context, e.toString());
            }

        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            try {
                sqLiteDatabase.execSQL(DROP_TABLE);

                onCreate(sqLiteDatabase);
            } catch (Exception e) {
//            e.printStackTrace();
                Message.message(context, e.toString());

            }


        }
    }

}