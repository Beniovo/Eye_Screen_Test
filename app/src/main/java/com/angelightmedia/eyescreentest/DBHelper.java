package com.angelightmedia.eyescreentest;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

    public static final int DB_VERSION = 1;
    private static final String DB_NAME = "eyetestquiz.db";
    public SQLiteDatabase myDatabase;
    private final Context mycontext;
    private static final String DB_PATH = "/data/data/com.angelightmedia.eyescreentest/databases/";


    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DB_NAME, factory, DB_VERSION);
        this.mycontext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    private boolean checkDatabase(){
        try {
            final String mPath = DB_PATH + DB_NAME;
            final File file = new File(mPath);
            if (file.exists())
                return true;
            else
                return false;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    private void copyDatabase() throws IOException {
        try{
            InputStream myInput = this.mycontext.getAssets().open(DB_NAME);
            //InputStream myInput = mycontext.getResources().openRawResource(R.raw.uniesdb);
            String outFname = DB_PATH + DB_NAME;
            OutputStream myOut = new FileOutputStream(outFname);
            byte[] mBuffer = new byte[1024];
            int mLength;
            while ((mLength = myInput.read(mBuffer)) > 0) {
                myOut.write(mBuffer, 0, mLength);
            }
            myOut.flush();
            myOut.close();
            myInput.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        Log.d("Copied dbase",  "DBASE COPIED");
    }

    public void createDatabase() throws IOException {
        boolean mDatabaseExist = checkDatabase();
        if(!mDatabaseExist){
            this.getReadableDatabase();
            this.close();


            try{
                copyDatabase(); //seems i copy the database everytime
            }catch (IOException mIoexception){
                mIoexception.printStackTrace();
                throw new Error("Error copying");
            }finally {
                {
                    this.close();
                }
            }
        }
    }

    @Override
    public synchronized void close() {
        if(myDatabase != null)
            myDatabase.close();
        SQLiteDatabase.releaseMemory();
        super.close();
    }

    public List<Question> getAllQuestions(){

        try{
            createDatabase();
        }catch (IOException e){
            throw new Error("can do it");
        }
        List<Question> s = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();


        Cursor c = db.rawQuery("select * from Questions", null);

        while(c.moveToNext()){
            Question question = new Question();
            question.setId(c.getInt(0));
            question.setQuestion(c.getString(1));
            question.setAnswer(c.getString(2));
            question.setType(c.getString(3));
            question.setFeedback(c.getString(4));
            question.setOption1(c.getString(5));
            question.setOption2(c.getString(6));
            question.setOption3(c.getString(7));
            question.setOption4(c.getString(8));
            question.setOption5(c.getString(9));
            question.setOption6(c.getString(10));
            question.setOption7(c.getString(11));
            question.setOption8(c.getString(12));
            question.setOption9(c.getString(13));
            s.add(question);
        }
        c.close();
        db.close();

        return s;
    }

    public ArrayList<String> getGeozones(){

        try{
            createDatabase();
        }catch (IOException e){
            throw new Error("can do it");
        }
        ArrayList<String> t = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();



        Cursor d = db.rawQuery("select distinct geozone from Institution", null);

        while(d.moveToNext()){
            t.add(d.getString(0));
        }
        d.close();
        db.close();

        return t;
    }


    public ArrayList<String> getallSchools() {

        try {
            createDatabase();
        } catch (IOException e) {
            throw new Error("can do it");
        }
        ArrayList<String> t = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();

        Cursor d = null;
        d = db.rawQuery("select  name from Institution", null);

        while (true) {
            assert d != null;
            if (!d.moveToNext()) break;
            t.add(d.getString(0));
        }

        d.close();
        db.close();
        return t;
    }
}